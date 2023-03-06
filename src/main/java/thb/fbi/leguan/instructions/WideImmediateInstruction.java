package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;

/**
 * Subclass for wide immediate instructions
 */
public class WideImmediateInstruction extends Instruction {
    private IWideImmediateCode wideImmediateCode;

    

    public WideImmediateInstruction(String mnemonic, String description, IWideImmediateCode wideImmediateCode) {
        setMnemonic(mnemonic);
        setDescription(description);
        setWideImmediateCode(wideImmediateCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        registerPaneController.clearFlagHighlighting();
        Register Rd = argument.getRd();
        int immediate = argument.getAlu_Immediate();
        int shamt = argument.getShamt();
        this.wideImmediateCode.simulate(Rd, immediate, shamt);
        pc.increase();
        registerPaneController.updateRegisterHighlighting(Rd.getID());
        memoryController.clearMemoryHighlighting();
    }
    
    public IWideImmediateCode getWideImmediateCode() {
        return wideImmediateCode;
    }

    public void setWideImmediateCode(IWideImmediateCode wideImmediateCode) {
        this.wideImmediateCode = wideImmediateCode;
    }
}
