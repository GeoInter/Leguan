package thb.fbi.instructions;

import java.util.HashSet;

import thb.fbi.Register;

/**
 * List of usable ARMv8 Thumb Instructions.
 * Instructions of formats Arithmetic(R), Immediate(I) and DataTransfer(D).
 *
 */
public class InstructionSet {
    /** unique List of all usable instructions */
    private HashSet<Instruction> instructionList;

    public InstructionSet() {
        instructionList = new HashSet<Instruction>();
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
                        long op1 = Rm.getValue();
                        long op2 = Rn.getValue();
                        Rd.setValue(op1 + op2);
                    }
                })
        );

        instructionList.add(
            new ArithmeticInstruction("SUB",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        // simple subtraction
                        long op1 = Rn.getValue();
                        long op2 = Rm.getValue();
                        Rd.setValue(op1 - op2);
                    }
                })
        );
    }

    public Instruction findInstructionByMnemonic (String mnemonic) {
        for (Instruction instruction : instructionList) {
            if(instruction.getMnemonic().equalsIgnoreCase(mnemonic)) {
                return instruction;
            }
        }
        return null;
    }
    
}
