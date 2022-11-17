package thb.fbi.simulation;

import thb.fbi.instructions.Instruction;

/**
 * class for special register PC (Program Count)
 */
public class PCRegister extends Register {

    public PCRegister(String name, long value, int id) {
        super("PC", 0, -1);
    }

    /**
     * increase the program count by Instruction.INSTRUCTION_LENGTH
     */
    public void increase() {
        setValue(value + 1);
    }

    /** 
     * when value of pc register changes update shown value in UI (in UI multiple of instruction length)
     */
    @Override
    public void setValue(long value) {
        this.value = value;
        super.updateShownValue(value * Instruction.INSTRUCTION_LENGTH);
    }

    /** 
     * when NumberFormat changes update the shown value in UI 
     */
    @Override
    public void setNumberFormat(Base format) {
        this.numberFormat = format;
        updateShownValue(value * Instruction.INSTRUCTION_LENGTH);
    }
}