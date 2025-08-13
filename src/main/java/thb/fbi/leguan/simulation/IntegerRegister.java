package thb.fbi.leguan.simulation;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * \brief class reprenting a register
 * 
 * class for representing a register for the simulation as well a model for UI
 */
public class IntegerRegister extends Register {
    /** value in the register, Property instead of primitive for easier updating UI */
    protected SimpleLongProperty valueProperty = new SimpleLongProperty(0);
    /** value and format as to be seen in UI */
    protected SimpleStringProperty shownValue = new SimpleStringProperty("0");
    /** format of value to be shown can be either binary, decimal or hexadecimal */
    protected Base numberFormat = Base.DEC;

    public IntegerRegister(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Updates the shown value in UI
     */
    public void updateShownValue() {
        this.shownValue.set(getShownValueAsString(this.valueProperty.get(), this.numberFormat));
    }

    public SimpleLongProperty getValueProperty() {
        return valueProperty;
    }

    public long getValue() {
        return valueProperty.get();
    }

    public SimpleStringProperty getShownValue() {
        return shownValue;
    }

    /** 
     * when value of register changes update shown value in UI 
     */
    public synchronized void setValue(long value) {
        valueProperty.set(value);
        updateShownValue();
    }

    public void setShownValue(SimpleStringProperty shownValue) {
        this.shownValue = shownValue;
    }

    public Base getNumberFormat() {
        return numberFormat;
    }

    /** 
     * when NumberFormat changes update the shown value in UI 
     */
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
        updateShownValue();
    }
}
