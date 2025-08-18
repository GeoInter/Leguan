package thb.fbi.leguan.simulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import thb.fbi.leguan.controller.MemoryController;
import thb.fbi.leguan.controller.RegisterPaneController;
import thb.fbi.leguan.data.ARMProgram;
import thb.fbi.leguan.data.InstructionPosition;
import thb.fbi.leguan.data.ProgramStatement;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.instructions.InstructionSet;
import thb.fbi.leguan.parser.ParsingError;
import thb.fbi.leguan.parser.ProgramParser;
import thb.fbi.leguan.parser.SyntaxErrorListener;
import thb.fbi.leguan.parser.antlr.LegV8Lexer;
import thb.fbi.leguan.parser.antlr.LegV8Parser;
import thb.fbi.leguan.service.ExecutorServiceProvider;

/** 
 * class for simulating a processor and instruction execution
 * defines an instructionset and registers
 */
public class Simulator {
    /** used set of instruction for this simulator instance */
    private InstructionSet instructionSet = new InstructionSet();
    /** program to execute */
    private ARMProgram program;
    /** Listener for Syntax Errors */
    private SyntaxErrorListener syntaxErrorListener;
    /** Visitor for Syntax Tree */
    private ProgramParser programParser;
    /** Executor for delegating threads */
    private ExecutorService executor;
    /** boolean for endless loop when running all code */
    private SimpleBooleanProperty isRunning = new SimpleBooleanProperty(false);
    /** boolean indicating code is changed (and unparsed) */
    private SimpleBooleanProperty isCodeChanged = new SimpleBooleanProperty(true);
    /** boolean indicating code is correct and parse */
    private SimpleBooleanProperty isCodeParsed = new SimpleBooleanProperty(false);;

    protected static RegisterPaneController registerPaneController;

    protected static MemoryController memoryController;

    public Simulator() {
        RegisterFile.initRegisterFile();
        instructionSet.populate();
        this.program = new ARMProgram();
        syntaxErrorListener = new SyntaxErrorListener();
        programParser = new ProgramParser();
        executor = ExecutorServiceProvider.getExecutorService();

        isCodeChanged.addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    isCodeParsed.set(false);
                }
            }
            
        });
    }

    /**
     * updates the isUsed Property foreach Register
     * set register which not appear in program usedRegister list to false
     */
    public void updateShownRegisters() {
        RegisterFile.updateShownRegisters(program);
    }

    /**
     * executes exactly one instruction
     */
    public InstructionPosition forwardStep() {
        runNextInstruction();

        // get source line of next instruction
        ProgramStatement nextStatement = program.getProgramStatement((int) RegisterFile.getPCValue());
        if(nextStatement != null) {
            return nextStatement.getLinePosition();
        }
        return null;
    }

    /**
     * parses and executes the whole written code
     */
    public void runAllInstructions() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                runCode();
            }
        });
    }

    /**
     * executes whole parsed program 
     * has hidden failsafe mechnism - preventing endless loops
     */
    private void runCode() {
        isRunning.set(true);
        int failsafe = 0;

        while(isRunning.get() && failsafe < 50000) {
            failsafe++;
            if(! runNextInstruction()) {
                isRunning.set(false);
            }
        }
    }

    /**
     * run the next assembly instruction point to by the Program Counter
     * @return boolean indicating if an instruction was executed or not (statement/ instruction was null)
     */
    private boolean runNextInstruction() {
        ProgramStatement statement = program.getProgramStatement((int) RegisterFile.getPCValue());
        if(statement != null) {
            Instruction instruction = statement.getInstruction();
            if(instruction != null) {
                // update UI Highlighting
                registerPaneController.clearFlagHighlighting();
                memoryController.clearMemoryHighlighting();

                instruction.simulate(statement.getArguments(), RegisterFile.getPC());

                // set highlighting for specific a specific registerbox
                if(statement.getArguments().getRd() != null) {
                    registerPaneController.updateRegisterHighlighting(statement.getArguments().getRd().getId());
                } else if(statement.getArguments().getRt() != null) {
                    registerPaneController.updateRegisterHighlighting(statement.getArguments().getRt().getId());
                } else {
                    registerPaneController.updateRegisterHighlighting(-1);
                }
                return true;
            } 
        }
        return false;
    }

    /**
     * parses the code when changes in code detected
     * @param code code to parse
     * @return boolean indicating if parsing was successful
     */
    public boolean parse(String code) {
        if(isCodeChanged.get()) {
            isCodeChanged.set(false);

            LegV8Parser parser = getParser(code);

            // parse form start symbol 'main'
            ParseTree antlrTree = parser.main();
            
            if(syntaxErrorListener.syntaxErrors.isEmpty()) {
                // clear visitor/ program parser
                programParser.clear();
                this.program = programParser.visit(antlrTree);

                if(programParser.semanticErrors.isEmpty()) {
                    isCodeParsed.set(true);
                    updateShownRegisters();
                    reset();
                } else {
                    isCodeParsed.set(false);
                }
            } else {
                isCodeParsed.set(false);
            }
        }
        return isCodeParsed.get();
    }

    /*
     * Types of Parser and Lexer are specific to the name of the used grammar
     * 
     */
    private LegV8Parser getParser(String code) {
        LegV8Parser parser = null;

        CharStream input = CharStreams.fromString(code);
        LegV8Lexer lexer = new LegV8Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new LegV8Parser(tokens);

        // syntax error handling
        syntaxErrorListener.clearSyntaxErrors();
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorListener);

        return parser;
    }

    /**
     * get list of errors (syntactic or semantic)
     * @return list of occured errors while parsing
     */
    public ArrayList<ParsingError> getErrors() {
        if(! syntaxErrorListener.syntaxErrors.isEmpty()) {
            return syntaxErrorListener.syntaxErrors;
        } else if(! programParser.semanticErrors.isEmpty()) {
            return programParser.semanticErrors;
        }
        return null;
    }

    /**
     * resets all register values and pc to 0
     */
    public void reset() {
        Memory.storeDataSegment(this.program.getDataSegment());
        RegisterFile.reset();
        stopThread();
    }

    /**
     * stops all running threads and restantiate executorService
     */
    public void stopThread() {
        isRunning.set(false);
    }

    public ARMProgram getArmProgram() {
        return this.program;
    }

    public InstructionSet getInstructionSet() {
        return this.instructionSet;
    }

    public SimpleBooleanProperty getIsRunning() {
        return this.isRunning;
    }

    public SimpleBooleanProperty getIsCodeChanged() {
        return isCodeChanged;
    }

    public static void setRegisterPaneController(RegisterPaneController registerPaneController) {
        Simulator.registerPaneController = registerPaneController;
    }

    public static void setMemoryController(MemoryController memoryController) {
        Simulator.memoryController = memoryController;
    }   
}
