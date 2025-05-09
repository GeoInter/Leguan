package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for (unconditional) branch instructions.
 */
public class BranchInstruction extends Instruction {
    private IBranchCode branchCode;

    public BranchInstruction(String mnemonic, int opcode, String description, IBranchCode branchCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setBranchCode(branchCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        int br_address = argument.getBr_Address();
        this.branchCode.simulate(br_address, pc);
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(6b), br_address(26b)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 6);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getBr_Address(), 26);
        return s;
    }

    public IBranchCode getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(IBranchCode branchCode) {
        this.branchCode = branchCode;
    }
}
