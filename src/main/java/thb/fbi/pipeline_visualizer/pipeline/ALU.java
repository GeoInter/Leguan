/**
 * @author 
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ALU implements Serializable {

    /** negative flag */
    public boolean nFlag = false;
    /** zero flag */
    public boolean zFlag = false;
    /** carry flag */
    public boolean cFlag = false;
    /** overflow flag */
    public boolean vFlag = false;

    ALU() {
    }

    long process(long A, long B, short opcode, int ALUOp, boolean setsFlag) {
        if (ALUOp == 0) { // (00) add for loads and stores
            return A + B;
        } else if (ALUOp == 1) { // (01) pass inbut b for CBZ
            return A;
        } else if (ALUOp == 2) { // (10) operation determined by opcode field
            long result = 0;
            switch (opcode) {
                case 0x69B: // 1691 (decimal) LSL (11bit)
                    result = A << B;
                    break;
                case 0x69A: // 1690 (decimal) LSR (11bit)
                    result = A >>> B;
                    break;
                case 0x4D8: // 1240 (decimal) MUL (11bit)
                    result = A * B;
                    break;
                case 0x458: // 1112 (decimal) ADD (11bit)
                case 0x488: // 580 (decimal) ADDI (10bit)
                case 0x558: // 1368 (decimal) ADDS (11bit)
                case 0x588: // 708 (decimal) ADDIS (10bit)
                    result = A + B;
                    break;
                case 0x658: // 1624 (decimal) SUB (11bit)
                case 0x688: // 836 (decimal) SUBI (10bit)
                case 0x758: // 1880 (decimal) SUBS (11bit)
                case 0x788: // 964 (decimal) SUBIS (10bit)
                    result = A - B;
                    break;
                case 0x450: // 1104 (decimal) AND (11bit)
                case 0x490: // 584 (decimal) ANDI (10bit)
                case 0x750: // 1872 (decimal) ANDS (11bit)
                case 0x790: // 968 (decimal) ANDIS (10bit)
                    result = A & B;
                    break;
                case 0x550: // 1360 (decimal) ORR (11bit)
                case 0x590: // 712 (decimal) ORRI (10bit)
                    result = A | B;
                    break;
                case 0x650: // 1616 (decimal) EOR (11bit)
                case 0x690: // 840 (decimal) EORI (10bit)
                    result = A ^ B;
                    break;
            }

            if (setsFlag) {
                setNFlag(result);
                setZFlag(result);
                if (opcode == 1624 || opcode == 1672 || opcode == 1880 || opcode == 1928) {
                    setCFlag(A, -1 * B);
                    setVFlag(A, -1 * B, result); // second operand needs to be negative for subtraction
                } else {
                    setCFlag(A, B);
                    setVFlag(A, B, result);
                }
            }

            return result;
        }
        return 0;
    }

    /**
     * checks if branching condition is met; used for setting ALU_zero
     * 
     * @param mnemonic   of the instruction in the EX stage
     * @param operand2   used in the ALU
     * @param ALU_result result of the ALU operation
     * @return boolean indicating if branch condition is met (if true then ALU_zero
     *         is true)
     */
    public boolean checkBranchCondition(String mnemonic, long operand2, long ALU_result) {
        switch (mnemonic) {
            case "CBZ":
                return (operand2 == 0);
            case "CBNZ":
                return (operand2 != 0);
            case "B.EQ":
                return this.zFlag;
            case "B.NE":
                return !this.zFlag;
            case "B.LT":
                return this.nFlag != this.vFlag;
            case "B.LE":
                return !(!this.zFlag && this.nFlag == this.vFlag);
            case "B.GT":
                return !this.zFlag && this.nFlag == this.vFlag;
            case "B.GE":
                return this.nFlag == this.vFlag;
            case "B.MI":
                return this.nFlag;
            case "B.PL":
                return !this.nFlag;
            case "B.VS":
                return this.vFlag;
            case "B.VC":
                return !this.vFlag;
            case "BR":
                return true;
            default:
                return (ALU_result == 0);
        }
    }

    private void setNFlag(long result) {
        nFlag = (result < 0);
    }

    private void setZFlag(long result) {
        zFlag = (result == 0);
    }

    private void setCFlag(long op1, long op2) {
        long op1Lower = (int) op1;// op1 << 32;
        long op2Lower = (int) op2;// op2 << 32;

        op1Lower &= 0xFFFFFFFFL;
        op2Lower &= 0xFFFFFFFFL;

        boolean carryLower = 0 < (op1Lower + op2Lower) >> 32;

        if (carryLower) { // if there is no carry for the lower half, no need to check upper half
            long op1Higher = (int) (op1 >> 32); // does not included sign bit
            long op2Higher = (int) (op2 >> 32);
            op1Higher &= 0xFFFFFFFFL;
            op2Higher &= 0xFFFFFFFFL;

            // include previous carry from lower half (carryLower just as helper, when lower
            // half carry can affect upper half)
            boolean carryHigher = 0 < (op1Higher + op2Higher + (carryLower ? 1 : 0)) >> 32;

            cFlag = carryHigher;
        } else {
            cFlag = carryLower;
        }
    }

    private void setVFlag(long op1, long op2, long result) {
        if (op1 >= 0 && op2 >= 0 && result < 0) {
            vFlag = true;
        } else if (op1 < 0 && op2 < 0 && result >= 0) {
            vFlag = true;
        } else {
            vFlag = false;
        }
    }
}
