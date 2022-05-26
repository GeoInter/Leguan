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
    private Register[] registers = new Register[32];
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
        registers[0].setValue(-1);
        registers[1].setValue(0);
        registers[2].setValue(5);
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
            instruction.simulate(statement.getArguments(), pc);

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

    public void testMemory() {
        this.program = new ARMProgram("Simple Test");
        updateShownRegisters();

        System.out.println("-------Start-------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R2: " + registers[2].getValue());
        
        Instruction instruction = instructionSet.findInstructionByMnemonic("STURB");
        InstructionArguments argument = new InstructionArguments();
        argument.setRt(registers[0]);
        argument.setRn(registers[2]);
        argument.setDt_Address(0);
        instruction.simulate(argument, pc);

        System.out.println("-------Store-------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R2: " + registers[2].getValue());

        Instruction instruction2 = instructionSet.findInstructionByMnemonic("LDUR");
        InstructionArguments argument2 = new InstructionArguments();
        argument2.setRt(registers[0]);
        argument2.setRn(registers[2]);
        argument2.setDt_Address(0);
        instruction2.simulate(argument2, pc);

        System.out.println("-------Load-------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R2: " + registers[2].getValue());

        Instruction instruction3 = instructionSet.findInstructionByMnemonic("STUR");
        InstructionArguments argument3 = new InstructionArguments();
        argument3.setRt(registers[0]);
        argument3.setRn(registers[2]);
        argument3.setDt_Address(0);
        instruction3.simulate(argument3, pc);

        System.out.println("-------Store-------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R2: " + registers[2].getValue());

        Instruction instruction4 = instructionSet.findInstructionByMnemonic("LDURB");
        InstructionArguments argument4 = new InstructionArguments();
        argument4.setRt(registers[0]);
        argument4.setRn(registers[2]);
        argument4.setDt_Address(0);
        instruction4.simulate(argument4, pc);

        System.out.println("-------Load-------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R2: " + registers[2].getValue());
    }

    public void testSub() {
        this.program = new ARMProgram("Simple Test");
        updateShownRegisters();
        
        Instruction instruction = instructionSet.findInstructionByMnemonic("SUBS");
        InstructionArguments argument = new InstructionArguments();
        argument.setRn(registers[0]);
        argument.setRm(registers[1]);
        argument.setRd(registers[2]);
        instruction.simulate(argument, pc);
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

    public long getPC() {
        return this.pc;
    }

    public InstructionSet getInstructionSet() {
        return this.instructionSet;
    }
}
