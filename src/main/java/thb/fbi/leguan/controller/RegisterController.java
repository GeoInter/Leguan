package thb.fbi.leguan.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import thb.fbi.leguan.simulation.Register;

public abstract class RegisterController<R extends Register> {
    /**
     * Adds a register and button to this Controller instance.
     * Binds value so it updates for every change and hides element when unused
     * 
     * @param register
     * @param showAllRegisters
     */
    public abstract void setProperties(R register, BooleanProperty showAllRegisters, BooleanProperty displayUnsigned);

    /**
     * returns if the register should be displayed or not (is in use)
     * @return
     */
    public abstract SimpleBooleanProperty getIsVisible();

    public abstract void setHighlighting();

    public abstract void clearHighlighting();

    /**
     * value inputted by the user via UI
     */
    protected String inputValue;
}
