package thb.fbi.instructions;

/**
 * Subclass for immediate instructions.
 */
public class ImmediateInstruction extends Instruction {
    private IImmediateCode immediateCode;

    @Override
    public void simulate(ProgramStatement argument) {
        // TODO Auto-generated method stub
        
    }

    public ImmediateInstruction(String opcode, IImmediateCode iImmediateCode) {
        setOpcode(opcode);
        setImmediateCode(immediateCode);
    }

    public IImmediateCode getImmediateCode() {
        return immediateCode;
    }

    public void setImmediateCode(IImmediateCode immediateCode) {
        this.immediateCode = immediateCode;
    }

    
}
