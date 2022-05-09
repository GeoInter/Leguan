package thb.fbi.simulation;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * \brief class reprenting a register
 * 
 * class for representing a register for the simulation as well a model for UI
 */
public class Register {
    /** name of the register */
    private String name;
    /** value in the register, Property instead of primitive for easier updating UI */
    private long value;
    /** Property for indicating if register is in use or can be grayed out in UI */
    private SimpleBooleanProperty isUsed = new SimpleBooleanProperty(true);
    /** value and format as to be seen in UI */
    private SimpleStringProperty shownValue = new SimpleStringProperty("0");
    /** format of value to be shown can be either binary, decimal or hexadecimal */
    private Base numberFormat = Base.DEC;

    public Register(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public void updateShownValue() {
        switch(numberFormat) {
            case BIN: // binary
                this.shownValue.set("0b" + Long.toBinaryString(this.value));
                break;
            case DEC: // decimal
                this.shownValue.set("" + this.value);
                break;
            case HEX: // hexadecimal
                this.shownValue.set("0x" + Long.toHexString(this.value));
                break;
        }
    }

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }

    public SimpleBooleanProperty getIsUsed() {
        return isUsed;
    }

    public SimpleStringProperty getShownValue() {
        return shownValue;
    }

    public Base getNumberFormat() {
        return numberFormat;
    }

    /** when value of register changes update shown value in UI */
    public void setValue(long value) {
        this.value = value;
        updateShownValue();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsUsed(SimpleBooleanProperty isUsed) {
        this.isUsed = isUsed;
    }

    public void setShownValue(SimpleStringProperty shownValue) {
        this.shownValue = shownValue;
    }

    /** when NumberFormat changes update the shown value in UI */
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
        updateShownValue();
    }
}
