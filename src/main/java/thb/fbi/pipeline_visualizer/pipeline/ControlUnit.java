/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ControlUnit implements Serializable {
    /** opcode of the instruction */
    public int opcode;
    /** WriteBack stage */
    public WB WB;
    /** MemoryAccess stage */
    public MEM MEM;
    /** AluOp indicates the operation which will be executed in the ALU */
    public int ALUOp;
    /**
     * if flag is set use constant (sign extended) value otherwise use value from
     * second register
     */
    public boolean ALUSource;
    /** if flsg is set value will be written into destination register */
    public boolean RegDest;

    // helper fields (could not find actual specification)
    public byte byteSizeMemoryAccess; // number of bytes to access from memory (load/store)
    public boolean memoryAccessExclusive; // indicates if instruction is LXDR, STXR
    public boolean setsFlag;

    ControlUnit(Instruction instruction) {
        this.opcode = instruction.getOpcode();
        this.WB = new WB();
        this.MEM = new MEM();
        this.byteSizeMemoryAccess = -1;
        this.memoryAccessExclusive = false;
        this.setsFlag = false;

        if (instruction.getMnemonic().equals("NOP")) {
            this.ALUOp = -1;
            this.ALUSource = false;
            this.RegDest = false;
        } else {
            switch (instruction.getType()) {
                case 'R':
                    setFlagsForArithmetic();
                    if (instruction.getMnemonic().endsWith("S")) {
                        this.setsFlag = true;
                    }
                    break;
                case 'B':
                    setFlagsForBranch();
                    break;
                case 'C':
                    setFlagsForCondBranch();
                    break;
                case 'D':
                    switch (instruction.getMnemonic()) {
                        case "LDUR":
                            setFlagsForDatatransfer_Load();
                            this.byteSizeMemoryAccess = (byte) 8;
                            break;
                        case "LDURB":
                            setFlagsForDatatransfer_Load();
                            this.byteSizeMemoryAccess = (byte) 1;
                            break;
                        case "LDURH":
                            setFlagsForDatatransfer_Load();
                            this.byteSizeMemoryAccess = (byte) 2;
                            break;
                        case "LDURSW":
                            setFlagsForDatatransfer_Load();
                            this.byteSizeMemoryAccess = (byte) 4;
                            break;
                        case "LDXR":
                            setFlagsForDatatransfer_Load();
                            this.byteSizeMemoryAccess = (byte) 8;
                            this.memoryAccessExclusive = true;
                            break;
                        case "STUR":
                            setFlagsForDatatransfer_Store();
                            this.byteSizeMemoryAccess = (byte) 8;
                            break;
                        case "STURB":
                            setFlagsForDatatransfer_Store();
                            this.byteSizeMemoryAccess = (byte) 1;
                            break;
                        case "STURH":
                            setFlagsForDatatransfer_Store();
                            this.byteSizeMemoryAccess = (byte) 2;
                            break;
                        case "STURW":
                            setFlagsForDatatransfer_Store();
                            this.byteSizeMemoryAccess = (byte) 4;
                            break;
                        case "STXR":
                            setFlagsForDatatransfer_Store();
                            this.byteSizeMemoryAccess = (byte) 8;
                            this.memoryAccessExclusive = true;
                            break;
                        case "LDR":
                            setFlagsForDatatransfer_Load();
                            this.WB.MemToReg = false; // override since address directly is needed
                            this.byteSizeMemoryAccess = (byte) 8;
                            break;
                    }
                    break;
                case 'I':
                    setFlagsForImmediate();
                    if (instruction.getMnemonic().endsWith("S")) {
                        this.setsFlag = true;
                    }
                    break;
                case 'W':
                    setFlagsForWideImmediate();
                    break;
            }

        }
    }

    private void setFlagsForArithmetic() {
        this.WB.RegWrite = true;
        this.WB.MemToReg = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = false;
        this.MEM.branch = false;
        this.ALUOp = 2;
        this.ALUSource = false;
        this.RegDest = true;
    }

    private void setFlagsForBranch() {
        this.WB.RegWrite = false;
        this.WB.MemToReg = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = false;
        this.MEM.branch = true;
        this.ALUOp = 1;
        this.ALUSource = false;
        this.RegDest = true;
    }

    private void setFlagsForCondBranch() {
        this.WB.RegWrite = false;
        this.WB.MemToReg = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = false;
        this.MEM.branch = true;
        this.ALUOp = 1;
        this.ALUSource = false;
        this.RegDest = true;
    }

    private void setFlagsForDatatransfer_Load() {
        this.WB.RegWrite = true;
        this.WB.MemToReg = true;
        this.MEM.MemRead = true;
        this.MEM.MemWrite = false;
        this.MEM.branch = false;
        this.ALUOp = 0;
        this.ALUSource = true;
        this.RegDest = false;
    }

    private void setFlagsForDatatransfer_Store() {
        this.WB.RegWrite = false;
        this.WB.MemToReg = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = true;
        this.MEM.branch = false;
        this.ALUOp = 0;
        this.ALUSource = true;
        this.RegDest = false;
    }

    private void setFlagsForImmediate() {
        this.WB.RegWrite = true;
        this.WB.MemToReg = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = false;
        this.MEM.branch = false;
        this.ALUOp = 2;
        this.ALUSource = true;
        this.RegDest = true;
    }

    private void setFlagsForWideImmediate() {
        this.WB.RegWrite = true;
        this.WB.MemToReg = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = false;
        this.MEM.branch = false;
        this.ALUOp = 2;
        this.ALUSource = true;
        this.RegDest = true;
    }

    public String toString(int mode) {
        String str = "";
        if (ALUOp == 2 && mode == 2) {
            str += "10, ";
        } else {
            str += ALUOp + ", ";
        }

        if (mode == 1) {
            if (ALUSource) {
                str = "True, ";
            } else {
                str = "False, ";
            }
        } else if (mode == 2) {
            if (ALUSource) {
                str = "1, ";
            } else {
                str = "0, ";
            }
        }

        if (mode == 1) {
            if (RegDest) {
                str += "True";
            } else {
                str += "False";
            }
        } else if (mode == 2) {
            if (RegDest) {
                str += "1";
            } else {
                str += "0";
            }
        }

        if (mode == 3) {
            return "";
        }
        return str;
    }
}
