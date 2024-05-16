package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;

/**
 * Subclass for (unconditional) branch instructions.
 */
public class BranchInstruction extends Instruction {
    private IBranchCode branchCode;

    public BranchInstruction(String mnemonic, String opcode, String description, IBranchCode branchCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setBranchCode(branchCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        registerPaneController.clearFlagHighlighting();
        int br_address = argument.getBr_Address();
        this.branchCode.simulate(br_address, pc);
        registerPaneController.updateRegisterHighlighting(-1);
        memoryController.clearMemoryHighlighting();
    }

    public IBranchCode getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(IBranchCode branchCode) {
        this.branchCode = branchCode;
    }
}
