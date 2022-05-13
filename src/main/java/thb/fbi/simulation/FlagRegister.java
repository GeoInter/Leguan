package thb.fbi.simulation;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * \brief class representing processor flags
 * 
 * class for representing flags for the simulation as well a model for UI
 */
public class FlagRegister {
    /** Negative condition flag, Observable for UI */
    private SimpleBooleanProperty n = new SimpleBooleanProperty(false);
    /** Zero condition flag, Observable for UI */
    private SimpleBooleanProperty z = new SimpleBooleanProperty(false);
    /** Carry condition flag, Observable for UI */
    private SimpleBooleanProperty c = new SimpleBooleanProperty(false);
    /** Overflow condition flag, Observable for UI */
    private SimpleBooleanProperty v = new SimpleBooleanProperty(false);

    public FlagRegister() {
        this.n.set(false);
        this.z.set(false);
        this.c.set(false);
        this.v.set(false);
    }

    /**
     * gets the Negative condition flag
     * @return boolean representing if flag is set
     */
    public boolean getNFlag() {
        return n.get();
    }

    /**
     * gets the Zero condition flag
     * @return boolean representing if flag is set
     */
    public boolean getZFlag() {
        return z.get();
    }

    /**
     * gets the Carry condition flag
     * @return boolean representing if flag is set
     */
    public boolean getCFlag() {
        return c.get();
    }

    /**
     * gets the Overflow condition flag
     * @return boolean representing if flag is set
     */
    public boolean getVFlag() {
        return v.get();
    }

    /**
     * sets the Negative condition flag
     * @param n boolean to change the flag to
     */
    public void setNFlag(boolean n) {
        this.n.set(n);
    }

    /**
     * sets the Zero condition flag
     * @param z boolean to change the flag to
     */
    public void setZFlag(boolean z) {
        this.z.set(z);
    }

    /**
     * sets the Carry condition flag
     * @param c boolean to change the flag to
     */
    public void setCFlag(boolean c) {
        this.c.set(c);
    }

    /**
     * sets the Overflow condition flag
     * @param v boolean to change the flag to
     */
    public void setVFlag(boolean v) {
        this.v.set(v);
    }

    /**
     * checks if number is negative
     * checks by comparing with 0 
     * (for this simulator all register values are signed, so no bitmask required)
     * @param value number to check if negative
     */
    public void checkAndSetNFlag(long value) {
        this.n.set(value < 0);
    }

    /**
     * checks if number is zero
     * 
     * @param value number to compare with 0
     */
    public void checkAndSetZFlag(long value) {
        this.z.set(value == 0);
    }

    public void checkAndSetCFlag() {
        //TODO: add check for carry flag
        // zuerst unteren 16 bit, dann obere -> Übertrag aufaddieren
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
    public void checkAndSetVFlag(long op1, long op2, long result) {
        if(op1 > 0 && op2 > 0 && result < 0) {
            this.v.set(true);
        } else if (op1 < 0 && op2 < 0 && result > 0) {
            this.v.set(true);
        }
    }

    public SimpleBooleanProperty getNFlagProperty() {
        return n;
    }

    public SimpleBooleanProperty getZFlagProperty() {
        return z;
    }

    public SimpleBooleanProperty getCFlagProperty() {
        return c;
    }

    public SimpleBooleanProperty getVFlagProperty() {
        return v;
    }
}
