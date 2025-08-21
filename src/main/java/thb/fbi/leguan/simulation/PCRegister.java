package thb.fbi.leguan.simulation;

import thb.fbi.leguan.instructions.Instruction;

/**
 * class for special register PC (Program Count)
 */
public class PCRegister extends IntegerRegister {

    public PCRegister(String name, long value, int id) {
        super("PC", id);
        this.value = value;
    }

    /**
     * increase the program count by Instruction.INSTRUCTION_LENGTH
     */
    public void increase() {
        setValue(value + Instruction.INSTRUCTION_LENGTH);
    }

    /** 
     * when value of pc register changes update shown value in UI (in UI multiple of instruction length)
     */
    @Override
    public synchronized void setValue(long value) {
        this.value = value;

        this.observer.update(getShownValueAsString(value, numberFormat));
    }

    /** 
     * when NumberFormat changes update the shown value in UI 
     */
    @Override
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
    }
}