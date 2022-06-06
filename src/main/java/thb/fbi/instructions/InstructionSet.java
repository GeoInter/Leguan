package thb.fbi.instructions;

import java.util.HashSet;

import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.Memory;
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
            new ConditionalBranchInstruction("CBNZ",
                "Compare and Branch if not Zero",
                new IConditionalBranchCode() {
                    @Override
                    public void simulate(int cond_br_address, Register Rt, Register pc) {
                        long op = Rt.getValue();
                        if(op != 0) {
                            pc.setValue(cond_br_address);
                        }
                    }
                })
        );

        instructionSet.add(
            new DataTransferInstruction("LDUR", 
            "Load a double word from memory to register", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    long value = Memory.loadDWord(address);
                    Rt.setValue(value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("LDURB", 
            "Load a Byte from memory to register", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    long value = Memory.loadByte(address);
                    Rt.setValue(value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("LDURH", 
            "Load a half word from memory to register", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    long value = Memory.loadHalfword(address);
                    Rt.setValue(value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("LDURSW", 
            "Load a word from memory to register", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    long value = Memory.loadWord(address);
                    Rt.setValue(value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("STUR", 
            "Store a double word from register into memory", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    long value = Rt.getValue();
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    Memory.storeDWord(address, value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("STURB", 
            "Store a Byte from register into memory", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    byte value = (byte) Rt.getValue();
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    Memory.storeByte(address, value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("STURH", 
            "Store a half word from register into memory", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    short value = (short) Rt.getValue();
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    Memory.storeHalfword(address, value);
                }
            })
        );

        instructionSet.add(
            new DataTransferInstruction("STURH", 
            "Store a word from register into memory", 
            new IDataTransferCode() {
                @Override
                public void simulate(int dt_address, String opcode2, Register Rn, Register Rt) {
                    int value = (int) Rt.getValue();
                    long op1 = Rn.getValue();
                    long address = op1 + dt_address;
                    Memory.storeWord(address, value);
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
        return null;
    }
    
}
