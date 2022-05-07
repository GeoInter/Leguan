package thb.fbi.instructions;

import thb.fbi.Register;

/**
 * Subclass for immediate instructions.
 */
public class ImmediateInstruction extends Instruction {
    private IImmediateCode immediateCode;

    public ImmediateInstruction(String opcode, String description, IImmediateCode iImmediateCode) {
        setMnemonic(opcode);
        setDescription(description);
        setImmediateCode(immediateCode);
    }

    @Override
    public void simulate(ProgramStatement argument) {
        int alu_immediate = argument.getAlu_Immediate();
        Register Rn = argument.getRn();
        Register Rd = argument.getRd();
        this.immediateCode.simulate(alu_immediate, Rn, Rd);
    }

    public IImmediateCode getImmediateCode() {
        return immediateCode;
    }

    private void setImmediateCode(IImmediateCode immediateCode) {
        this.immediateCode = immediateCode;
    }
}
