package thb.fbi.leguan.simulation;

import java.text.NumberFormat;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * \brief class reprenting a register
 * 
 * class for representing a register for the simulation as well a model for UI
 */
public class Register {
    /** name of the register */
    protected String name;
    /** number/ id/ index of the register */
    protected int id;
    /** value in the register, Property instead of primitive for easier updating UI */
    protected SimpleLongProperty valueProperty = new SimpleLongProperty(0);
    /** Property for indicating if register is in use or can be grayed out in UI */
    private SimpleBooleanProperty isUsed = new SimpleBooleanProperty(true);
    /** value and format as to be seen in UI */
    protected SimpleStringProperty shownValue = new SimpleStringProperty("0");
    /** format of value to be shown can be either binary, decimal or hexadecimal */
    protected Base numberFormat = Base.DEC;

    public Register(String name, long value, int id) {
        this.name = name;
        this.id = id;
        valueProperty.set(value);
    }

    /**
     * Updates the shown value in UI
     */
    public void updateShownValue() {
        updateShownValue(this.valueProperty.get());
    }

    /**
     * Updates the shown value in UI
     * delimites binary and hex number in pairs of 4
     * formats decimal with set Locale (points/ commas)
     * @param value to show in UI
     */
    protected void updateShownValue(long value) {
        StringBuilder str;
        switch(numberFormat) {
            case BIN: // binary (space delimited in pairs of 4)
                String bin = Long.toBinaryString(value);
                str = new StringBuilder(bin);
                for(int i = bin.length()-4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }
                str.insert(0, "0b");
                this.shownValue.set(str.toString());
                break;
            case HEX: // hexadecimal (space delimited in pairs of 4)
                String hex = Long.toHexString(value).toUpperCase();
                str = new StringBuilder(hex);
                for(int i = hex.length()-4; i > 0; i-= 4) {
                    str.insert(i, " ");
                }
                str.insert(0, "0x");
                this.shownValue.set(str.toString());
                break;
            case uDEC: // unsigned decimal (point delimited in pairs of 3)
                String unsigned = Long.toUnsignedString(value);
                str = new StringBuilder(unsigned);
                for(int i = unsigned.length()-3; i > 0; i-= 3) {
                    str.insert(i, ".");
                }
                str.insert(0, "u ");
                this.shownValue.set(str.toString());
                break;
            case DEC: // signed decimal
            default:
                NumberFormat nf = NumberFormat.getInstance();
                this.shownValue.set("" + nf.format(value));
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public SimpleLongProperty getValueProperty() {
        return valueProperty;
    }

    public long getValue() {
        return valueProperty.get();
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

    /** 
     * when value of register changes update shown value in UI 
     */
    public void setValue(long value) {
        valueProperty.set(value);
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

    /** 
     * when NumberFormat changes update the shown value in UI 
     */
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
        updateShownValue();
    }
}
