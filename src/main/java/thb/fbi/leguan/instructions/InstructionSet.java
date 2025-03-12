package thb.fbi.leguan.instructions;

import java.math.BigInteger;
import java.util.Formatter;
import java.util.TreeSet;

import thb.fbi.leguan.simulation.FlagRegister;
import thb.fbi.leguan.simulation.Memory;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;

/**
 * List of usable LEGv8 Instructions.
 */
public class InstructionSet {
    /** unique List of all usable instructions */
    private TreeSet<Instruction> instructionSet;

    public InstructionSet() {
        instructionSet = new TreeSet<Instruction>();
    }

    public void populate() {

        instructionSet.add(
                new ArithmeticInstruction("NOP",
                        0b0,
                        "it is just empty",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {

                            }
                        }));

        //// Core Instruction Set ////

        instructionSet.add(
                new ArithmeticInstruction("ADD",
                        0b10001011000,
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
                        }));

        instructionSet.add(
                new ImmediateInstruction("ADDI",
                        0b1001000100,
                        "Adds value of Registers Rm and a constant and puts result in Rd without flags",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 + alu_immediate;
                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("ADDIS",
                        0b1011000100,
                        "Adds value of Registers Rm and a constant and puts result in Rd with flags",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 + alu_immediate;

                                FlagRegister.setAllFlags(op1, alu_immediate, result);

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("ADDS",
                        0b10101011000,
                        "Adds value of Registers Rm and Rn and puts result in Rd with flags",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                // simple addition
                                long op1 = Rm.getValue();
                                long op2 = Rn.getValue();
                                long result = op1 + op2;

                                FlagRegister.setAllFlags(op1, op2, result);

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("AND",
                        0b10001010000,
                        "AND",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rm.getValue();
                                long op2 = Rn.getValue();
                                long result = op1 & op2;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("ANDI",
                        0b1001001000,
                        "AND Immediate",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 & alu_immediate;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("ANDIS",
                        0b1111001000,
                        "AND Immediate and Flags",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 & alu_immediate;

                                FlagRegister.setAllFlags(op1, alu_immediate, result);

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("ANDS",
                        0b11101010000,
                        "AND with Flags",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rm.getValue();
                                long op2 = Rn.getValue();
                                long result = op1 & op2;

                                FlagRegister.setAllFlags(op1, op2, result);

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new BranchInstruction("B",
                        0b000101,
                        "Branch",
                        new IBranchCode() {
                            @Override
                            public void simulate(int br_address, PCRegister pc) {
                                pc.setValue(br_address);
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.EQ",
                        0b0,
                        "Branch Signed Equals",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test Z == 1
                                if (FlagRegister.getZFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.NE",
                        0b0,
                        "Branch Signed Not Equals",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test Z == 0
                                if (!FlagRegister.getZFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.LT",
                        0b0,
                        "Branch Signed Less Than",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test N != V
                                if (FlagRegister.getNFlag() != FlagRegister.getVFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.LE",
                        0b0,
                        "Branch Signed Less Equals",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test ! (Z == 0 && N == V)
                                if (!(!FlagRegister.getZFlag() && FlagRegister.getNFlag() == FlagRegister.getVFlag())) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.GT",
                        0b0,
                        "Branch Signed Greater Than",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test (Z == 0 && N == V)
                                if (!FlagRegister.getZFlag() && FlagRegister.getNFlag() == FlagRegister.getVFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.GE",
                        0b0,
                        "Branch Signed Greater Equals",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test N == V
                                if (FlagRegister.getNFlag() == FlagRegister.getVFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.MI",
                        0b0,
                        "Branch on Minus",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test N == 1
                                if (FlagRegister.getNFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.PL",
                        0b0,
                        "Branch on Plus",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test N == 0
                                if (!FlagRegister.getNFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.VS",
                        0b0,
                        "Branch on Overflow set",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test V == 1
                                if (FlagRegister.getVFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("B.VC",
                        0b0,
                        "Branch on Overflow clear",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                // test V == 0
                                if (!FlagRegister.getVFlag()) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new BranchInstruction("BL",
                        0b100101,
                        "Branch with Link",
                        new IBranchCode() {
                            @Override
                            public void simulate(int br_address, PCRegister pc) {
                                Simulator simulator = SimulatorSingleton.getSimulator();
                                Register R30 = simulator.getRegisters()[30];
                                R30.setValue((pc.getValue() + 1) * 4); // internal pc value is not multiplied by 4
                                pc.setValue(br_address);
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("BR",
                        0b11010110000,
                        "Branch to register",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                long address = Rt.getValue();
                                address /= 4; // pc shows multiple of 4, but internally uses one quarter of shownValue
                                pc.setValue(address);
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("CBNZ",
                        0b10110101,
                        "Compare and Branch if not Zero",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                long op = Rt.getValue();
                                if (op != 0) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ConditionalBranchInstruction("CBZ",
                        0b10110100,
                        "Compare and Branch if Zero",
                        new IConditionalBranchCode() {
                            @Override
                            public void simulate(int cond_br_address, Register Rt, PCRegister pc) {
                                long op = Rt.getValue();
                                if (op == 0) {
                                    pc.setValue(cond_br_address);
                                } else {
                                    pc.increase();
                                }
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("EOR",
                        0b11001010000,
                        "Exclusive OR between two Registers",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rm.getValue();
                                long op2 = Rn.getValue();
                                long result = op1 ^ op2; // equals !=

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("EORI",
                        0b1101001000,
                        "Exclusive OR between Register and Immediate",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 ^ alu_immediate; // equals !=

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("LDUR",
                        0b11111000010,
                        "Load a double word from memory to register",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                long value = Memory.loadDWord(address);
                                Rt.setValue(value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("LDURB",
                        0b00111000010,
                        "Load a Byte from memory to register",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                long value = Memory.loadByte(address);
                                Rt.setValue(value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("LDURH",
                        0b01111000010,
                        "Load a half word from memory to register",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                long value = Memory.loadHalfword(address);
                                Rt.setValue(value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("LDURSW",
                        0b10111000100,
                        "Load a word from memory to register",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                long value = Memory.loadWord(address);
                                Rt.setValue(value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("LDXR",
                        0b11001000010,
                        "Exclusive load a word from memory to register",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                long value = Memory.loadExclusive(address);
                                Rt.setValue(value);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("LSL",
                        0b11010011011,
                        "Logical Shift Left",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 << shamt;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("LSR",
                        0b11010011010,
                        "Logical Shift Right",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 >>> shamt; // unsigned shift = shifts a zero into the leftmost
                                                             // position

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new WideImmediateInstruction("MOVK",
                        0b111100101,
                        "Move wide with keep",
                        new IWideImmediateCode() {
                            @Override
                            public void simulate(Register Rd, long immediate, int shamt) {
                                long oldValue = Rd.getValue();
                                long result = immediate << shamt;
                                result += oldValue;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new WideImmediateInstruction("MOVZ",
                        0b110100101,
                        "Move wide with zeroes",
                        new IWideImmediateCode() {
                            @Override
                            public void simulate(Register Rd, long immediate, int shamt) {
                                long result = immediate << shamt;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("ORR",
                        0b10101010000,
                        "Inclusive OR between two Registers",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rm.getValue();
                                long op2 = Rn.getValue();
                                long result = op1 | op2;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("ORRI",
                        0b1011001000,
                        "Inclusive OR between Register and Immediate",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 | alu_immediate;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("STUR",
                        0b11111000000,
                        "Store a double word from register into memory",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                long value = Rt.getValue();
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                Memory.storeDWord(address, value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("STURB",
                        0b00111000000,
                        "Store a Byte from register into memory",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                byte value = (byte) Rt.getValue();
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                Memory.storeByte(address, value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("STURH",
                        0b01111000000,
                        "Store a half word from register into memory",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                short value = (short) Rt.getValue();
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                Memory.storeHalfword(address, value);
                            }
                        }));

        instructionSet.add(
                new DataTransferInstruction("STURW",
                        0b10111000000,
                        "Store a word from register into memory",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                int value = (int) Rt.getValue();
                                long op1 = Rn.getValue();
                                long address = op1 + dt_address;
                                Memory.storeWord(address, value);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("STXR",
                        0b11001000000,
                        "Exclusive Store a word from register into memory",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                int value = (int) Rd.getValue();
                                if (Memory.storeExclusive(Rm.getValue(), value)) {
                                    Rn.setValue(0);
                                } else {
                                    Rn.setValue(1);
                                }
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("SUB",
                        0b11001011000,
                        "Subtracts value of Registers Rm and Rn and puts result in Rd without flags",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                // simple subtraction
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();
                                Rd.setValue(op1 - op2);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("SUBI",
                        0b1101000100,
                        "Subtracts value of Registers Rm and a constant and puts result in Rd without flags",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 - alu_immediate;
                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ImmediateInstruction("SUBIS",
                        0b1111000100,
                        "Subtracts value of Registers Rm and a constant and puts result in Rd without flags",
                        new IImmediateCode() {
                            @Override
                            public void simulate(int alu_immediate, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long result = op1 - alu_immediate;

                                FlagRegister.setAllFlags(op1, -1 * alu_immediate, result); // the only difference to
                                                                                           // ADDS

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("SUBS",
                        0b11101011000,
                        "Subtracts value of Registers Rm and Rn and puts result in Rd with flags",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                // simple subtraction
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();
                                long result = op1 - op2;

                                FlagRegister.setAllFlags(op1, -1 * op2, result); // the only difference to ADDS

                                Rd.setValue(result);
                            }
                        }));

        //// Arithmetic Core Instruction Set ////
        
        instructionSet.add(
                new ArithmeticInstruction("MUL",
                        0b10011011000,
                        "Multiplies two registers (only integers)",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();
                                long result = op1 * op2;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("SDIV",
                        0b10011010110,
                        "Multiplies two registers (only integers)",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();
                                long result = op1 / op2;

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("SMULH",
                        0b10011011010,
                        "Multiplies two registers (only integers)",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();

                                // Put result into BigInteger (for numbers exceeding 64bit)
                                BigInteger bigInteger = BigInteger.valueOf(op1).multiply(BigInteger.valueOf(op2));
                                // Cut off the lower 64 bit leaving bits 65-128
                                bigInteger = bigInteger.shiftRight(64);
                                // Put the higher 64 bit into a long
                                long result = bigInteger.longValue();

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("UDIV",
                        0b10011010110,
                        "Unsigned Division",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();
                                long result = Long.divideUnsigned(op1, op2);

                                Rd.setValue(result);
                            }
                        }));

        instructionSet.add(
                new ArithmeticInstruction("UMULH",
                        0b10011011110,
                        "Unsigned Multiplication",
                        new IArithmeticCode() {
                            @Override
                            public void simulate(Register Rm, int shamt, Register Rn, Register Rd) {
                                long op1 = Rn.getValue();
                                long op2 = Rm.getValue();

                                // Put result into BigInteger (for numbers exceeding 64bit)
                                BigInteger bigInteger = BigInteger.valueOf(op1).multiply(BigInteger.valueOf(op2));
                                // Cut off the lower 64 bit leaving bits 65-128
                                bigInteger = bigInteger.shiftRight(64);
                                // Put the higher 64 bit into a long
                                long result = bigInteger.longValue();

                                Rd.setValue(result);
                            }
                        }));

        //// Other Instructions ////

        instructionSet.add(
                new DataTransferInstruction("LDR",
                        0b11111000010, // opcode from LDUR
                        "Loads a program-relative or register-relative address into a register",
                        new IDataTransferCode() {
                            @Override
                            public void simulate(long dt_address, Register Rn, Register Rt) {
                                Rt.setValue(dt_address);
                            }
                        }));
    }

    public Instruction findInstructionByMnemonic(String mnemonic) {
        for (Instruction instruction : instructionSet) {
            if (instruction.getMnemonic().equalsIgnoreCase(mnemonic)) {
                return instruction;
            }
        }
        return null;
    }

    public String toString() {
        if (instructionSet == null)
            return null;

        // int LEGv8InstrNr = 36;
        try (Formatter formatter = new Formatter()) {
            // formatter.format("\nSize: %d / %d\n\n", instructionSet.size(), LEGv8InstrNr);
            formatter.format("%-15s %-30s %-15s\n", "Name", "Format", "Description");
            for (Instruction ins : instructionSet) {
                formatter.format("%-7s %-30s %-60s\n", ins.getMnemonic(), ins.getClass().getSimpleName(),
                        ins.getDescription());
            }
            return formatter.toString();
        }
    }

}
