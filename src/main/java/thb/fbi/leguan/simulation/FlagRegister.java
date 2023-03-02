package thb.fbi.leguan.simulation;

/**
 * \brief class representing processor flags
 * 
 * class for representing flags for the simulation as well a model for UI
 */
public class FlagRegister {
    /** observer to notify when flags are changing */
    private static FlagRegisterObserver observer;
    /** Negative condition flag, Observable for UI */
    private static boolean n = false;
    /** Zero condition flag, Observable for UI */
    private static boolean z = false;
    /** Carry condition flag, Observable for UI */
    private static boolean c = false;
    /** Overflow condition flag, Observable for UI */
    private static boolean v = false;

    /**
     * set Controller as observer
     * @param observer controller class that implements the MemoryObserver
     */
    public static void setObserver(FlagRegisterObserver observer) {
        FlagRegister.observer = observer;
    }

    /**
     * resets all flags back to false
     */
    public static void reset() {
        n = false;
        z = false;
        c = false;
        v = false;
    }

    /**
     * gets the Negative condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getNFlag() {
        return n;
    }

    /**
     * gets the Zero condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getZFlag() {
        return z;
    }

    /**
     * gets the Carry condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getCFlag() {
        return c;
    }

    /**
     * gets the Overflow condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getVFlag() {
        return v;
    }

    /**
     * sets the Negative condition flag
     * @param n boolean to change the flag to
     */
    private static void setNFlag(boolean n) {
        FlagRegister.n = n;
    }

    /**
     * sets the Zero condition flag
     * @param z boolean to change the flag to
     */
    private static void setZFlag(boolean z) {
        FlagRegister.z = z;
    }

    /**
     * sets the Carry condition flag
     * @param c boolean to change the flag to
     */
    private static void setCFlag(boolean c) {
        FlagRegister.c = c;
    }

    /**
     * sets the Overflow condition flag
     * @param v boolean to change the flag to
     */
    private static void setVFlag(boolean v) {
        FlagRegister.v = v;
    }

    public static void setAllFlags(long op1, long op2, long result) {
        checkAndSetNFlag(result);
        checkAndSetZFlag(result);
        checkAndSetCFlag(op1, op2);
        checkAndSetVFlag(op1, op2, result);
        observer.update(n, z, c, v);
    }

    /**
     * checks if number is negative
     * checks by comparing with 0 
     * (for this simulator all register values are signed, so no bitmask required)
     * @param value number to check if negative
     */
    private static void checkAndSetNFlag(long value) {
        FlagRegister.setNFlag(value < 0);
    }

    /**
     * checks if number is zero
     * 
     * @param value number to compare with 0
     */
    private static void checkAndSetZFlag(long value) {
        FlagRegister.setZFlag(value == 0);
    }

    /**
     * checks if addition/ subtraction of two values would result
     * in a carry over and sets carry flag accordingly
     * Splits long value into two int values and then check carry for each half
     * @param op1 first operand
     * @param op2 second operand
     */
    private static void checkAndSetCFlag(long op1, long op2) {
        long op1Lower = (int) op1;// op1 << 32;
        long op2Lower = (int) op2;// op2 << 32;
        
        op1Lower &= 0xFFFFFFFFL;
        op2Lower &= 0xFFFFFFFFL;
        
        boolean carryLower = 0 < (op1Lower + op2Lower)>>32;

        if(carryLower) { // if there is no carry for the lower half, no need to check upper half
            long op1Higher = (int) (op1 >> 32); // does not included sign bit
            long op2Higher = (int) (op2 >> 32);
            op1Higher &= 0xFFFFFFFFL;
            op2Higher &= 0xFFFFFFFFL;

            // include previous carry from lower half (carryLower just as helper, when lower half carry can affect upper half)
            boolean carryHigher = 0 < (op1Higher + op2Higher + (carryLower ? 1 : 0))>>32;
 
            FlagRegister.setCFlag(carryHigher);
        } else {
            FlagRegister.setCFlag(carryLower);
        }
    }

    /**
     * checks the parameters for over-/underflow
     * 
     * if both operands are positiv and the result is negativ: overflow
     * if both operands are negativ and the result is positiv: underflow
     * @param op1 first operand
     * @param op2 second operand
     * @param result result of both operands
     */
    private static void checkAndSetVFlag(long op1, long op2, long result) {
        if(op1 >= 0 && op2 >= 0 && result < 0) {
            FlagRegister.setVFlag(true);
        } else if (op1 < 0 && op2 < 0 && result >= 0) {
            FlagRegister.setVFlag(true);
        } else {
            FlagRegister.setVFlag(false);
        }
    }
}
