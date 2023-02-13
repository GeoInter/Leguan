package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;

/**
 * Subclass for conditional branch instructions.
 */
public class ConditionalBranchInstruction extends Instruction {
    private IConditionalBranchCode conditionalBranchCode;

    public ConditionalBranchInstruction(String opcode, String description, IConditionalBranchCode conditionalBranchCode) {
        setMnemonic(opcode);
        setDescription(description);
        setConditionalBranchCode(conditionalBranchCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        int cond_br_address = argument.getCond_Br_Address();
        Register Rt = argument.getRt();
        this.conditionalBranchCode.simulate(cond_br_address, Rt, pc);
    }

    public IConditionalBranchCode getConditionalBranchCode() {
        return conditionalBranchCode;
    }

    public void setConditionalBranchCode(IConditionalBranchCode conditionalBranchCode) {
        this.conditionalBranchCode = conditionalBranchCode;
    }
    
}
