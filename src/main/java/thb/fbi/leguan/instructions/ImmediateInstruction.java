package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;

/**
 * Subclass for immediate instructions.
 */
public class ImmediateInstruction extends Instruction {
    private IImmediateCode immediateCode;

    public ImmediateInstruction(String opcode, String description, IImmediateCode immediateCode) {
        setMnemonic(opcode);
        setDescription(description);
        setImmediateCode(immediateCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        int alu_immediate = argument.getAlu_Immediate();
        Register Rn = argument.getRn();
        Register Rd = argument.getRd();
        this.immediateCode.simulate(alu_immediate, Rn, Rd);
        pc.increase();
        registerPaneController.updateRegisterHighlighting(Rd.getID());
    }

    public IImmediateCode getImmediateCode() {
        return immediateCode;
    }

    private void setImmediateCode(IImmediateCode immediateCode) {
        this.immediateCode = immediateCode;
    }
}
