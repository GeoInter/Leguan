package thb.fbi;

import thb.fbi.instructions.Instruction;
import thb.fbi.instructions.ProgramStatement;
import thb.fbi.instructions.InstructionSet;

/** 
 * class for simulating a processor and instruction execution
 * defines an instructionset and registers
 */
public class Simulator {
    private InstructionSet instructionSet = new InstructionSet();
    private Register[] registers = new Register[16];

    public Simulator() {
        instructionSet.populate();
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register("R"+i, 0);
            registers[i].setNumberFormat(Base.DEC);
        }
        registers[0].setValue(0);
        registers[1].setValue(8);;
        registers[2].setValue(16);;
    }

    public void testAdd() {
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
        Instruction instruction = instructionSet.findInstructionByMnemonic("ADD");
        ProgramStatement argument = new ProgramStatement();
        argument.setRm(registers[1]);
        argument.setRn(registers[2]);
        // argument.setRd(registers[0]);
        argument.setRd(registers[2]);
        instruction.simulate(argument);
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
        ProgramStatement argument = new ProgramStatement();
        argument.setRm(registers[1]);
        argument.setRn(registers[2]);
        // argument.setRd(registers[0]);
        argument.setRd(registers[2]);
        instruction.simulate(argument);
        System.out.println("--------------");
        System.out.println("R0: " + registers[0].getValue());
        System.out.println("R1: " + registers[1].getValue());
        System.out.println("R2: " + registers[2].getValue());
    }

    public void UpdateRegisterValueFormat(Base format, int index) {
        this.registers[index].setNumberFormat(format);
    }

    public Register[] getRegisters() {
        return this.registers;
    }
}
