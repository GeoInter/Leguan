package thb.fbi.simulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import thb.fbi.instructions.Instruction;
import thb.fbi.instructions.InstructionSet;
import thb.fbi.parser.ParsingError;
import thb.fbi.parser.ProgramParser;
import thb.fbi.parser.SyntaxErrorListener;
import thb.fbi.parser.antlr.LegV8Lexer;
import thb.fbi.parser.antlr.LegV8Parser;

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

    private ExecutorService executor;

    public Simulator() {
        registers = new Register[registerNr];
        instructionSet.populate();
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register("R"+i, 0, i);
            registers[i].setNumberFormat(Base.DEC);
        }
        pc.setValue(-1);
        /* 
        registers[0].setValue(12);
        registers[1].setValue(-2);
        registers[2].setValue(7);
        */
        syntaxErrorListener = new SyntaxErrorListener();
        executor = Executors.newSingleThreadExecutor();
    }

    /** 
     * executes the program
     */
    public void simulate() {
        this.program = new ARMProgram("Simple Test");
        updateShownRegisters();

        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
        System.out.println("R3: " + registers[3].getValue());
        System.out.println("--------------");

        // get first statement
        ProgramStatement statement = program.getProgramStatement((int)pc.getValue() / 2);
        while(statement != null) {
            System.out.println("* pc: " + pc + " - line " + statement.getSourceLine());
            Instruction instruction = statement.getInstruction();
            instruction.simulate(statement.getArguments(), pc);

            System.out.println("R0: " + registers[0].getValue());
            System.out.println("R1: " + registers[1].getValue());
            System.out.println("R2: " + registers[2].getValue());
            System.out.println("R3: " + registers[3].getValue());
            System.out.println("--------------");

            pc.setValue(pc.getValue() + Instruction.INSTRUCTION_LENGTH);
            // get next statement, pointed by pc 
            statement = program.getProgramStatement((int)pc.getValue() / 2);
        }
    }

    public void simulateStep() {
        if(pc.getValue() <= 0) {
             // for presentation purpose; needs to be moved later
            this.program = new ARMProgram("Fibonacci Test");
            updateShownRegisters();
        }
        ProgramStatement statement = program.getProgramStatement((int)pc.getValue() / Instruction.INSTRUCTION_LENGTH);
        if(statement != null) {
            Instruction instruction = statement.getInstruction();
            if(instruction != null) {
                instruction.simulate(statement.getArguments(), pc);
                pc.setValue(pc.getValue() + Instruction.INSTRUCTION_LENGTH);
            }
        }
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

    public void forwardStep(String code) {
        // TODO: fix this dirty mock up code (determine changes in program)
        // TODO: add error check (ref. parse()/run() method)
        if(pc.getValue() <= -1) {
            LegV8Parser parser = getParser(code);

            // parse form start symbol 'main'
            ParseTree antlTree = parser.main();
            // create visitor
            ProgramParser progVisitor = new ProgramParser();
            this.program = progVisitor.visit(antlTree);
            updateShownRegisters();
            pc.setValue(0);
        }
        ProgramStatement statement = program.getProgramStatement((int) pc.getValue());
        if(statement != null) {
            Instruction instruction = statement.getInstruction();
            if(instruction != null) {
                instruction.simulate(statement.getArguments(), pc);
            }
        }
    }

    /**
     * parses and executes the whole written code 
     * @param code written text to parse
     */
    public ArrayList<ParsingError> run(String code) {
        LegV8Parser parser = getParser(code);

        // parse form start symbol 'main'
        ParseTree antlrTree = parser.main();
        
        if(syntaxErrorListener.syntaxErrors.isEmpty()) {
            // create visitor
            ProgramParser progVisitor = new ProgramParser();
            this.program = progVisitor.visit(antlrTree);

            if(progVisitor.semanticErrors.isEmpty()) {
                updateShownRegisters();
                 
                executor.submit(new Runnable() {

                    @Override
                    public void run() {
                        Memory.storeByte(420, (byte)1938);
                        // runCode();
                    }

                });
                
            } else {
                return progVisitor.semanticErrors;
            }
        } else {
            return syntaxErrorListener.syntaxErrors;
        }
        return null;
    }

    /**
     * executes whole parsed program 
     */
    public void runCode() {
        
        boolean running = true;

        // TODO: remove when forwardStep is fixed
        pc.setValue(0);

        while(running) {
            ProgramStatement statement = program.getProgramStatement((int) pc.getValue());
            if(statement != null) {
                Instruction instruction = statement.getInstruction();
                if(instruction != null) {
                    instruction.simulate(statement.getArguments(), pc);
                } 
            } else {
                running = false;
            }
        }
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
        executor.shutdownNow();
        executor = Executors.newSingleThreadExecutor();
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

    public PCRegister getPC() {
        return this.pc;
    }

    public long getPCValue() {
        return this.pc.getValue();
    }

    public InstructionSet getInstructionSet() {
        return this.instructionSet;
    }
}
