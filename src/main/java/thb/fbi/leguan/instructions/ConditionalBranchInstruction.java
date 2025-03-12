package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for conditional branch instructions.
 */
public class ConditionalBranchInstruction extends Instruction {
    private IConditionalBranchCode conditionalBranchCode;

    public ConditionalBranchInstruction(String mnemonic, int opcode, String description, IConditionalBranchCode conditionalBranchCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setConditionalBranchCode(conditionalBranchCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        int cond_br_address = argument.getCond_Br_Address();
        Register Rt = argument.getRt();
        this.conditionalBranchCode.simulate(cond_br_address, Rt, pc);
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(8b), cond_br_address(19b), Rt(5b)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertToMachineCode(opcode, 8);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getCond_Br_Address(), 19);
        if (args.getRt() == null) { // instructions that not use RT but condition codes like B.EQ, B.LT
            s += " " + getMachineCodeForConditionCode(this.mnemonic);
        } else { // instructions that use RT like CBNZ, CBZ
            s += " " + MachineCodeTranslator.convertToMachineCode(args.getRt().getID(), 5);
        }
        return s;
    }


    private String getMachineCodeForConditionCode(String mnemonic) {
        mnemonic = mnemonic.substring(2); // get actual condition
        String s = "";
        switch (mnemonic) {
            case "EQ":
                s = "00000";
                break;
            case "NE":
                s = "00001";
                break;
            case "LT":
                s = "01011";
                break;
            case "LE":
                s = "01101";
                break;
            case "GT":
                s = "01100";
                break;
            case "GE":
                s = "01010";
                break;
            case "MI":
                s = "00100";
                break;
            case "PL":
                s = "00101";
                break;
            case "VS":
                s = "00110";
                break;
            case "VC":
                s = "00111";
                break;
        }
        return s;
    }

    public IConditionalBranchCode getConditionalBranchCode() {
        return conditionalBranchCode;
    }

    public void setConditionalBranchCode(IConditionalBranchCode conditionalBranchCode) {
        this.conditionalBranchCode = conditionalBranchCode;
    }
    
}
