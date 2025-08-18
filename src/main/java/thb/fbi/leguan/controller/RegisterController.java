package thb.fbi.leguan.controller;

import javafx.beans.property.SimpleBooleanProperty;

public abstract class RegisterController {

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
