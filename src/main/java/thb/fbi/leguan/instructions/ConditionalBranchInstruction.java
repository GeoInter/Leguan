package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;

/**
 * Subclass for conditional branch instructions.
 */
public class ConditionalBranchInstruction extends Instruction {
    private IConditionalBranchCode conditionalBranchCode;

    public ConditionalBranchInstruction(String mnemonic, String opcode, String description, IConditionalBranchCode conditionalBranchCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setConditionalBranchCode(conditionalBranchCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        registerPaneController.clearFlagHighlighting();
        int cond_br_address = argument.getCond_Br_Address();
        Register Rt = argument.getRt();
        this.conditionalBranchCode.simulate(cond_br_address, Rt, pc);
        registerPaneController.updateRegisterHighlighting(-1);
        memoryController.clearMemoryHighlighting();
    }

    public IConditionalBranchCode getConditionalBranchCode() {
        return conditionalBranchCode;
    }

    public void setConditionalBranchCode(IConditionalBranchCode conditionalBranchCode) {
        this.conditionalBranchCode = conditionalBranchCode;
    }
    
}
