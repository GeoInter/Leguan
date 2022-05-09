package thb.fbi;

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
}
