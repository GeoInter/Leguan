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

    public Simulator() {
        instructionSet.populate();
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register("R"+i, 0, i);
            registers[i].setNumberFormat(Base.DEC);
        }
        registers[0].setValue(0);
        registers[1].setValue(Long.MAX_VALUE-1);;
        registers[2].setValue(16);;
    }

    public void simulate() {
        // get first statement
        InstructionArguments statement = null;
        while(statement != null) {

            pc += Instruction.INSTRUCTION_LENGTH;
            // get next statement, pointed by pc 
        }
    }

    public void testAdd() {
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
        Instruction instruction = instructionSet.findInstructionByMnemonic("ADDIS");
        InstructionArguments argument = new InstructionArguments();
        argument.setRm(registers[1]);
        argument.setRn(registers[1]);
        // argument.setRd(registers[0]);
        argument.setRd(registers[2]);
        argument.setAlu_Immediate(1);
        instruction.simulate(argument, flagRegister, pc);
        System.out.println("--------------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
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
}
