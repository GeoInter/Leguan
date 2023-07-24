/**
 * @author 
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ALU implements Serializable {

    public boolean nFlag = false;
    public boolean zFlag = false;
    public boolean cFlag = false;
    public boolean vFlag = false;

    ALU() {
    }

    int process(int A, int B, int function, int ALUOp, boolean setsFlag) {
        if (ALUOp == 0) {
            return A + B;
        } else if (ALUOp == 1) {
            return A;
        } else if (ALUOp == 2) {
            int result = 0;
            switch (function) {
                case 0:
                    result = A << B;
                    break;
                case 2:
                    result = A >>> B;
                    break;
                case 24:
                    result = A * B;
                    break;
                case 26:
                    result = A / B;
                    break;
                case 32:
                    result = A + B;
                    break;
                case 34:
                    result = A - B;
                    break;
                case 36:
                    result = A & B;
                    break;
                case 37:
                    result = A | B;
                    break;
                case 39:
                    result = ~(A | B);
                    break;
                case 40:
                    result = A ^ B;
                    break;
                case 42:
                    if (A < B) {
                        result = 1;
                    } else {
                        result = 0;
                    }
            }

            if (setsFlag) {
                setNFlag(result);
                setZFlag(result);
                if (function == 34) {
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
