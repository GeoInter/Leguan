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

    int process(int A, int B, short opcode, int ALUOp, boolean setsFlag) {
        if (ALUOp == 0) { // (00) add for loads and stores
            return A + B;
        } else if (ALUOp == 1) { // (01) pass inbut b for CBZ
            return A;
        } else if (ALUOp == 2) { // (10) operation determined by opcode field
            int result = 0;
            switch (opcode) {
                case 1691: // 0x69B LSL (11bit)
                    result = A << B;
                    break;
                case 1690: // 0x69A LSR (11bit)
                    result = A >>> B;
                    break;
                case 1240: // 0x4D8 MUL (11bit)
                    result = A * B;
                    break;
                case 1112: // 0x458 ADD (11bit)
                case 580: // 0x488 ADDI (10bit)
                case 1368: // 0x558 ADDS (11bit)
                case 708: // 0x588 ADDIS (10bit)
                    result = A + B;
                    break;
                case 1624: // 0x658 SUB (11bit)
                case 836: // 0x688 SUBI (10bit)
                case 1880: // 0x758 SUBS (11bit)
                case 964: // 0x788 SUBIS (10bit)
                    result = A - B;
                    break;
                case 1104: // 0x450 AND (11bit)
                case 584: // 0x490 ANDI (10bit)
                case 1872: // 0x750 ANDS (11bit)
                case 968: // 0x790 ANDIS (10bit)
                    result = A & B;
                    break;
                case 1360: // 0x550 ORR (11bit)
                case 712: // 0x590 ORRI (10bit)
                    result = A | B;
                    break;
                case 1616: // 0x650 EOR (11bit)
                case 840: // 0x690 EORI (10bit)
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
