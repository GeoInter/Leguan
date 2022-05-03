package thb.fbi.instructions;

/**
 * Superclass for defining an instruction
 */
public abstract class Instruction {
    protected String opcode;

    public String getOpcode() {
        return this.opcode;
    }
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public abstract void simulate(ProgramStatement argument);
}
