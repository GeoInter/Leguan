package thb.fbi.instructions;

/**
 * Superclass for defining an instruction
 */
public abstract class Instruction {
    /** mnemonic of instruction/ name of the instruction  */
    protected String mnemonic;
    /** brief description of the instruction */
    protected String description;

    public String getMnemonic() {
        return this.mnemonic;
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public abstract void simulate(ProgramStatement argument);

    @Override
    public int hashCode() {
        final int prime = 67;
        int result = 1;
        result = prime * result + mnemonic.hashCode();
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
        if (this.mnemonic.equals(other.mnemonic)) 
            return true;
        return false;
    }
}
