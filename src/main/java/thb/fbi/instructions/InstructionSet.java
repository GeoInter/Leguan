package thb.fbi.instructions;

import java.util.HashSet;

import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.Register;

/**
 * List of usable ARMv8 Thumb Instructions.
 * Instructions of formats Arithmetic(R), Immediate(I) and DataTransfer(D).
 *
 */
public class InstructionSet {
    /** unique List of all usable instructions */
    private HashSet<Instruction> instructionSet;

    public InstructionSet() {
        instructionSet = new HashSet<Instruction>();
    }

    public void populate() {

        instructionSet.add(
            new ArithmeticInstruction("NULL", 
                "it is just empty",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        System.out.println("I'm Error - nice to meet you");
                    }
                })
        );

        instructionSet.add(
            new ArithmeticInstruction("ADD",
                "Adds value of Registers Rm and Rn and puts result in Rd without flags",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        // simple addition
                        long op1 = Rm.getValue();
                        long op2 = Rn.getValue();
                        long result = op1 + op2;
                        Rd.setValue(result);
                    }
                })
        );

        instructionSet.add(
            new ImmediateInstruction("ADDI",
                "Adds value of Registers Rm and a constant and puts result in Rd without flags",
                new IImmediateCode() {
                    @Override
                    public void simulate(int alu_immediate, Register Rn, Register Rd) {
                        long op1 = Rn.getValue();
                        long result = op1 + alu_immediate;
                        Rd.setValue(result);
                    }
                })
        );

        instructionSet.add(
            new ImmediateInstruction("ADDIS",
                "Adds value of Registers Rm and a constant and puts result in Rd with flags",
                new IImmediateCode() {
                    @Override
                    public void simulate(int alu_immediate, Register Rn, Register Rd) {
                        long op1 = Rn.getValue();
                        long result = op1 + alu_immediate;

                        // overflow check
                        FlagRegister.checkAndSetVFlag(op1, alu_immediate, result);
                        
                        Rd.setValue(result);
                    }
                })
        );

        instructionSet.add(
            new ArithmeticInstruction("ADDS",
                "Adds value of Registers Rm and Rn and puts result in Rd with flags",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        // simple addition
                        long op1 = Rm.getValue();
                        long op2 = Rn.getValue();
                        long result = op1 + op2;

                        // carry check
                        FlagRegister.checkAndSetCFlag(op1, op2);

                        // overflow check
                        FlagRegister.checkAndSetVFlag(op1, op2, result);

                        Rd.setValue(result);
                    }
                })
        );

        instructionSet.add(
            new DataTransferInstruction("LDUR", 
            "Load memory to register", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    // TODO: access memory address to load its content into target register
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    System.out.println("Not yet implemented but address is: " + address);
                    //Rt.setValue(0);
                }
            })
        );

        instructionSet.add(
            new ArithmeticInstruction("SUB",
                "Subtracts value of Registers Rm and Rn and puts result in Rd without flags",
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

        instructionSet.add(
            new ImmediateInstruction("SUBI",
                "Subtracts value of Registers Rm and a constant and puts result in Rd without flags",
                new IImmediateCode() {
                    @Override
                    public void simulate(int alu_immediate, Register Rn, Register Rd) {
                        long op1 = Rn.getValue();
                        long result = op1 - alu_immediate;
                        Rd.setValue(result);
                    }
                })
        );

        instructionSet.add(
            new ArithmeticInstruction("SUBS",
                "Subtracts value of Registers Rm and Rn and puts result in Rd with flags",
                new IArithmeticCode() {
                    @Override
                    public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                        // simple subtraction
                        long op1 = Rn.getValue();
                        long op2 = Rm.getValue();
                        long result = op1 - op2;

                        // carry check
                        FlagRegister.checkAndSetCFlag(op1, -1*op2); // the only difference to ADDS

                        // overflow check
                        FlagRegister.checkAndSetVFlag(op1, op2, result);

                        Rd.setValue(result);
                    }
                })
        );
    }

    public Instruction findInstructionByMnemonic (String mnemonic) {
        for (Instruction instruction : instructionSet) {
            if(instruction.getMnemonic().equalsIgnoreCase(mnemonic)) {
                return instruction;
            }
        }
        // get the 'NULL' Instruction, prevents critical runtime error
        return (Instruction) instructionSet.toArray()[0];
    }
    
}
