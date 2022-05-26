package thb.fbi.simulation;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * \brief class representing processor flags
 * 
 * class for representing flags for the simulation as well a model for UI
 */
public class FlagRegister {
    /** Negative condition flag, Observable for UI */
    private static SimpleBooleanProperty n = new SimpleBooleanProperty(false);
    /** Zero condition flag, Observable for UI */
    private static SimpleBooleanProperty z = new SimpleBooleanProperty(false);
    /** Carry condition flag, Observable for UI */
    private static SimpleBooleanProperty c = new SimpleBooleanProperty(false);
    /** Overflow condition flag, Observable for UI */
    private static SimpleBooleanProperty v = new SimpleBooleanProperty(false);

    /**
     * resets all flags back to false
     */
    public static void reset() {
        FlagRegister.n.set(false);
        FlagRegister.z.set(false);
        FlagRegister.c.set(false);
        FlagRegister.v.set(false);
    }

    /**
     * gets the Negative condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getNFlag() {
        return n.get();
    }

    /**
     * gets the Zero condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getZFlag() {
        return z.get();
    }

    /**
     * gets the Carry condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getCFlag() {
        return c.get();
    }

    /**
     * gets the Overflow condition flag
     * @return boolean representing if flag is set
     */
    public static boolean getVFlag() {
        return v.get();
    }

    /**
     * sets the Negative condition flag
     * @param n boolean to change the flag to
     */
    public static void setNFlag(boolean n) {
        FlagRegister.n.set(n);
    }

    /**
     * sets the Zero condition flag
     * @param z boolean to change the flag to
     */
    public static void setZFlag(boolean z) {
        FlagRegister.z.set(z);
    }

    /**
     * sets the Carry condition flag
     * @param c boolean to change the flag to
     */
    public static void setCFlag(boolean c) {
        FlagRegister.c.set(c);
    }

    /**
     * sets the Overflow condition flag
     * @param v boolean to change the flag to
     */
    public static void setVFlag(boolean v) {
        FlagRegister.v.set(v);
    }

    /**
     * checks if number is negative
     * checks by comparing with 0 
     * (for this simulator all register values are signed, so no bitmask required)
     * @param value number to check if negative
     */
    public static void checkAndSetNFlag(long value) {
        FlagRegister.n.set(value < 0);
    }

    /**
     * checks if number is zero
     * 
     * @param value number to compare with 0
     */
    public static void checkAndSetZFlag(long value) {
        FlagRegister.z.set(value == 0);
    }

    /**
     * checks if addition/ subtraction of two values would result
     * in a carry over and sets carry flag accordingly
     * Splits long value into two int values and then check carry for each half
     * @param op1 first operand
     * @param op2 second operand
     */
    public static void checkAndSetCFlag(long op1, long op2) {
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
 
            FlagRegister.c.set(carryHigher);
        } else {
            FlagRegister.c.set(carryLower);
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
    public static void checkAndSetVFlag(long op1, long op2, long result) {
        if(op1 > 0 && op2 > 0 && result < 0) {
            FlagRegister.v.set(true);
        } else if (op1 < 0 && op2 < 0 && result > 0) {
            FlagRegister.v.set(true);
        }
    }

    public static SimpleBooleanProperty getNFlagProperty() {
        return n;
    }

    public static SimpleBooleanProperty getZFlagProperty() {
        return z;
    }

    public static SimpleBooleanProperty getCFlagProperty() {
        return c;
    }

    public static SimpleBooleanProperty getVFlagProperty() {
        return v;
    }
}
