package thb.fbi.leguan.simulation;

/**
 * \brief class reprenting a register
 * 
 * class for representing a register for the simulation as well a model for UI
 */
public class IntegerRegister extends Register {
    /** value in the register, Property instead of primitive for easier updating UI */
    protected long value;
    /** format of value to be shown can be either binary, decimal or hexadecimal */
    protected Base numberFormat = Base.DEC;

    protected IntegerRegisterObserver observer;

    public IntegerRegister(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public String getValueAsString() {
        return this.getShownValueAsString(value, numberFormat);
    }

    /** 
     * when value of register changes update shown value in UI 
     */
    public synchronized void setValue(long value) {
        this.value = value;

        this.observer.update(getShownValueAsString(value, numberFormat));
    }

    @Override
    public synchronized void reset() {
        this.value = 0;

        this.observer.update(getShownValueAsString(value, numberFormat));
    }

    public Base getNumberFormat() {
        return numberFormat;
    }

    /** 
     * when NumberFormat changes update the shown value in UI 
     */
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
    }

    public void setObserver(IntegerRegisterObserver observer) {
        this.observer = observer;
    }
}
