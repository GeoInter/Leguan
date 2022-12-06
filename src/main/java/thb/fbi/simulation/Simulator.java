package thb.fbi.simulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import thb.fbi.instructions.Instruction;
import thb.fbi.instructions.InstructionSet;
import thb.fbi.parser.ParsingError;
import thb.fbi.parser.ProgramParser;
import thb.fbi.parser.SyntaxErrorListener;
import thb.fbi.parser.antlr.LegV8Lexer;
import thb.fbi.parser.antlr.LegV8Parser;
import thb.fbi.utility.ExecutorServiceProvider;

/** 
 * class for simulating a processor and instruction execution
 * defines an instructionset and registers
 */
public class Simulator {
    /** used set of instruction for this simulator instance */
    private InstructionSet instructionSet = new InstructionSet();
    /** number of registers */
    public final int registerNr = 32;
    /** array of accessible regsiters */
    private Register[] registers;
    /** programm counter */
    private PCRegister pc = new PCRegister("PC", 0, -1);
    /** register of processor flags */
    private FlagRegister flagRegister = new FlagRegister();
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
    /** boolean indicating wheter code is changed (and unparsed) */
    private SimpleBooleanProperty isCodeChanged = new SimpleBooleanProperty(true);
    /** boolean indicating code is correct and parse */
    private SimpleBooleanProperty isCodeParsed = new SimpleBooleanProperty(false);;

    public Simulator() {
        registers = new Register[registerNr];
        instructionSet.populate();
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register("R"+i, 0, i);
            registers[i].setNumberFormat(Base.DEC);
        }
        pc.setValue(0);
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

        isCodeParsed.addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                isCodeChanged.set(false);
            }
            
        });
    }

    /**
     * updates the isUsed Property foreach Register
     * set register which not appear in program usedRegister list to false
     */
    public void updateShownRegisters() {
        for (Register r : registers) {
            if(! program.getUsedRegisters().contains(r)) {
                r.setIsUsed(false);
            } else {
                r.setIsUsed(true);
            }
        }
    }

    public ArrayList<ParsingError> forwardStep(String code) {
        // if not prior parsed - do it now
        if(parse(code)) {
            ProgramStatement statement = program.getProgramStatement((int) pc.getValue());
            if(statement != null) {
                Instruction instruction = statement.getInstruction();
                if(instruction != null) {
                    instruction.simulate(statement.getArguments(), pc);
                }
            }
        } else {
            if(! syntaxErrorListener.syntaxErrors.isEmpty()) {
                return syntaxErrorListener.syntaxErrors;
            } else if(! programParser.semanticErrors.isEmpty()) {
                return programParser.semanticErrors;
            }
        }
        return null;
    }

    /**
     * parses and executes the whole written code 
     * @param code written text to parse
     */
    public ArrayList<ParsingError> run(String code) {
        if(parse(code)) {
            executor.execute(new Runnable() {
            
                @Override
                public void run() {
                    runCode();
                }

            });
        } else {
            if(! syntaxErrorListener.syntaxErrors.isEmpty()) {
                return syntaxErrorListener.syntaxErrors;
            } else if(! programParser.semanticErrors.isEmpty()) {
                return programParser.semanticErrors;
            }
        }
        return null;
    }

    /**
     * executes whole parsed program 
     * has hidden failsafe mechnism - preventing endless loops
     */
    public void runCode() {
        isRunning.set(true);
        int failsafe = 0;

        while(isRunning.get() && failsafe < 50000) {
            failsafe++;
            ProgramStatement statement = program.getProgramStatement((int) pc.getValue());
            if(statement != null) {
                Instruction instruction = statement.getInstruction();
                if(instruction != null) {
                    instruction.simulate(statement.getArguments(), pc);
                } 
            } else {
                isRunning.set(false);
            }
        }
    }

    /**
     * parses the code when changes in code detected
     * @param code code to parse
     * @return boolean indicating if parsing was successful
     */
    public boolean parse(String code) {
        if(isCodeChanged.get()) {
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
     * changes the numberformat of a specified register
     * @param format numberformat to be displayed
     * @param index index of the register to change its numberformat
     */
    public void UpdateRegisterValueFormat(Base format, int index) {
        this.registers[index].setNumberFormat(format);
    }

    /**
     * resets all register values and pc to 0
     */
    public void reset() {
        for (Register register : registers) {
            register.setValue(0);
        }
        pc.setValue(0);
        syntaxErrorListener.clearSyntaxErrors();
        stopThread();
    }

    /**
     * stops all running threads and restantiate executorService
     */
    public void stopThread() {
        isRunning.set(false);
    }

    /**
     * gets the list of all registers (R0 - R31)
     * @return List of registers
     */
    public Register[] getRegisters() {
        return this.registers;
    }

    public FlagRegister getFlagRegister() {
        return this.flagRegister;
    }

    public ARMProgram getArmProgram() {
        return this.program;
    }

    public PCRegister getPC() {
        return this.pc;
    }

    public long getPCValue() {
        return this.pc.getValue();
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
}
