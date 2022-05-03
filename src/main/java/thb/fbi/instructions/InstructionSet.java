package thb.fbi.instructions;

import java.util.ArrayList;

import thb.fbi.Register;

/**
 * List of usable ARMv8 Thumb Instructions.
 * Instructions of formats Arithmetic(R), Immediate(I) and DataTransfer(D).
 *
 */
public class InstructionSet {
    private ArrayList<Instruction> instructionList;

    public InstructionSet() {
        instructionList = new ArrayList<Instruction>();
    }

    public void populate() {

        instructionList.add(
            new ArithmeticInstruction("NULL", 
                null)
        );

        instructionList.add(
            new ArithmeticInstruction("ADD",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        // simple addition
                        Rd.setValue(Rm.getValue() + Rn.getValue());
                    }
                })
        );

        instructionList.add(
            new ArithmeticInstruction("SUB",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        // simple addition
                        Rd.setValue(Rn.getValue() - Rm.getValue());
                    }
                })
        );
    }

    public Instruction findInstructionByOpcode (String opcode) {
        for (Instruction instruction : instructionList) {
            if(instruction.getOpcode().equalsIgnoreCase(opcode)) {
                return instruction;
            }
        }
        return null;
    }
    
}
