package thb.fbi.instructions;

/**
 * Superclass for defining an instruction
 */
public abstract class Instruction {
    protected String opcode;

    //TODO: add description 

    public String getOpcode() {
        return this.opcode;
    }
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public abstract void simulate(ProgramStatement argument);

    @Override
    public int hashCode() {
        final int prime = 67;
        int result = 1;
        result = prime * result + opcode.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Instruction other = (Instruction) obj;
        if (this.opcode.equals(other.opcode)) 
            return true;
        return false;
    }
}
