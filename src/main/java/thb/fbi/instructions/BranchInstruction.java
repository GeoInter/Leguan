package thb.fbi.instructions;

import thb.fbi.simulation.InstructionArguments;
import thb.fbi.simulation.PCRegister;

/**
 * Subclass for (unconditional) branch instructions.
 */
public class BranchInstruction extends Instruction {
    private IBranchCode branchCode;

    public BranchInstruction(String opcode, String description, IBranchCode branchCode) {
        setMnemonic(opcode);
        setDescription(description);
        setBranchCode(branchCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        int br_address = argument.getBr_Address();
        this.branchCode.simulate(br_address, pc);
    }

    public IBranchCode getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(IBranchCode branchCode) {
        this.branchCode = branchCode;
    }
}
