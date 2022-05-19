package thb.fbi.simulation;

import java.text.NumberFormat;

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
    /** number/ id/ index of the register */
    private int id;
    /** value in the register, Property instead of primitive for easier updating UI */
    private long value;
    /** Property for indicating if register is in use or can be grayed out in UI */
    private SimpleBooleanProperty isUsed = new SimpleBooleanProperty(true);
    /** value and format as to be seen in UI */
    private SimpleStringProperty shownValue = new SimpleStringProperty("0");
    /** format of value to be shown can be either binary, decimal or hexadecimal */
    private Base numberFormat = Base.DEC;

    public Register(String name, long value, int id) {
        this.name = name;
        this.value = value;
        this.id = id;
    }

    public void updateShownValue() {
        StringBuilder str;
        switch(numberFormat) {
            case BIN: // binary (space delimited in pairs of 4)
                String bin = Long.toBinaryString(this.value);
                str = new StringBuilder(bin);
                for(int i = bin.length()-4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }
                str.insert(0, "0b");
                this.shownValue.set(str.toString());
                break;
            case HEX: // hexadecimal (space delimited in pairs of 4)
                String hex = Long.toHexString(this.value).toUpperCase();
                str = new StringBuilder(hex);
                for(int i = hex.length()-4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }
                str.insert(0, "0x");
                this.shownValue.set(str.toString());
                break;
            case DEC: // decimal
            default:
                NumberFormat nf = NumberFormat.getInstance();
                this.shownValue.set("" + nf.format(this.value));
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
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

    public void setIsUsed(Boolean isUsed) {
        this.isUsed.set(isUsed);
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
