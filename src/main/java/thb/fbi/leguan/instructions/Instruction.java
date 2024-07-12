package thb.fbi.leguan.instructions;

import thb.fbi.leguan.controller.RegisterPaneController;
import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;

/**
 * Superclass for defining an instruction
 */
public abstract class Instruction implements Comparable<Instruction> {
    /** mnemonic of instruction/ name of the instruction  */
    protected String mnemonic;
    /** brief description of the instruction */
    protected String description;

    public static final short INSTRUCTION_LENGTH = 4;

    protected static RegisterPaneController registerPaneController;

    
    public String getMnemonic() {
        return this.mnemonic;
    }
    protected void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    public String getDescription() {
        return this.description;
    }
    protected void setDescription(String description) {
        this.description = description;
    }

    public abstract void simulate(InstructionArguments argument, PCRegister pc);

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

    public int compareTo(Instruction i) {
        return mnemonic.compareTo(i.getMnemonic());
    }

    public static void setRegisterPaneController(RegisterPaneController registerPaneController) {
        Instruction.registerPaneController = registerPaneController;
    }  
}
