package thb.fbi.leguan.simulation;

import thb.fbi.leguan.instructions.Instruction;

/**
 * class for special register PC (Program Count)
 */
public class PCRegister extends IntegerRegister {

    public PCRegister(String name, long value, int id) {
        super("PC", value, id);
    }

    /**
     * increase the program count by Instruction.INSTRUCTION_LENGTH
     */
    public void increase() {
        setValue(valueProperty.get() + Instruction.INSTRUCTION_LENGTH);
    }

    /** 
     * when value of pc register changes update shown value in UI (in UI multiple of instruction length)
     */
    @Override
    public synchronized void setValue(long value) {
        valueProperty.set(value);
        this.shownValue.set(getShownValueAsString(value, this.numberFormat));
    }

    /** 
     * when NumberFormat changes update the shown value in UI 
     */
    @Override
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
        this.shownValue.set(getShownValueAsString(valueProperty.get(), this.numberFormat));
    }
}