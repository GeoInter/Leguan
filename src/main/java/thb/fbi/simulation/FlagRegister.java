package thb.fbi.simulation;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * \brief class representing processor flags
 * 
 * class for representing flags for the simulation as well a model for UI
 */
public class FlagRegister {
    /** Negativ condition flag, Observable for UI */
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
