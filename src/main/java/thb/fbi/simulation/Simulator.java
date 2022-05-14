package thb.fbi.simulation;

import thb.fbi.instructions.Instruction;
import thb.fbi.instructions.InstructionSet;

/** 
 * class for simulating a processor and instruction execution
 * defines an instructionset and registers
 */
public class Simulator {
    /** used set of instruction for this simulator instance */
    private InstructionSet instructionSet = new InstructionSet();
    /** accessible regsiters */
    private Register[] registers = new Register[16];
    /** programm counter */
    private long pc = 0;
    /** register of processor flags */
    private FlagRegister flagRegister = new FlagRegister();
    /** program to execute */
    private ARMProgram program;

    public Simulator() {
        instructionSet.populate();
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register("R"+i, 0, i);
            registers[i].setNumberFormat(Base.DEC);
        }
        registers[0].setValue(Long.MAX_VALUE);
        registers[1].setValue(1);
        registers[2].setValue(2058766);


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
        ProgramStatement statement = program.getProgramStatement((int)pc / 2);
        while(statement != null) {
            System.out.println("* pc: " + pc + " - line " + statement.getSourceLine());
            Instruction instruction = statement.getInstruction();
            instruction.simulate(statement.getArguments(), flagRegister, pc);

            System.out.println("R0: " + registers[0].getValue());
            System.out.println("R1: " + registers[1].getValue());
            System.out.println("R2: " + registers[2].getValue());
            System.out.println("R3: " + registers[3].getValue());
            System.out.println("--------------");

            pc += Instruction.INSTRUCTION_LENGTH;
            // get next statement, pointed by pc 
            statement = program.getProgramStatement((int)pc / 2);
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

    public void testAdd() {
        this.program = new ARMProgram("Simple Test");
        updateShownRegisters();
        
        Instruction instruction = instructionSet.findInstructionByMnemonic("ADDS");
        InstructionArguments argument = new InstructionArguments();
        argument.setRn(registers[0]);
        argument.setRm(registers[1]);
        argument.setRd(registers[2]);
        instruction.simulate(argument, flagRegister, pc);
        
        // simulate();

        System.out.println("=== done ===");
    }

    public void testSub() {
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
        Instruction instruction = instructionSet.findInstructionByMnemonic("SUB");
        InstructionArguments argument = new InstructionArguments();
        argument.setRm(registers[1]);
        argument.setRn(registers[2]);
        // argument.setRd(registers[0]);
        argument.setRd(registers[2]);
        instruction.simulate(argument, flagRegister, pc);
        System.out.println("--------------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
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
     * gets the list of all registers (R0 - R31)
     * @return List of registers
     */
    public Register[] getRegisters() {
        return this.registers;
    }

    public FlagRegister getFlagRegister() {
        return this.flagRegister;
    }

    public InstructionSet getInstructionSet() {
        return this.instructionSet;
    }
}
