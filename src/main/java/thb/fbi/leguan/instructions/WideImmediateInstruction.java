package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for wide immediate instructions
 */
public class WideImmediateInstruction extends Instruction {
    private IWideImmediateCode wideImmediateCode;

    

    public WideImmediateInstruction(String mnemonic, String opcode, String description, IWideImmediateCode wideImmediateCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setWideImmediateCode(wideImmediateCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        Register Rd = argument.getRd();
        int immediate = argument.getAlu_Immediate();
        int shamt = argument.getShamt();
        this.wideImmediateCode.simulate(Rd, immediate, shamt);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(11b), mov_immediate(16b), Rd(5b)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertToMachineCode(opcode, 11);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getAlu_Immediate(), 16);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getID(), 5);
        return s;
    }
    
    public IWideImmediateCode getWideImmediateCode() {
        return wideImmediateCode;
    }

    public void setWideImmediateCode(IWideImmediateCode wideImmediateCode) {
        this.wideImmediateCode = wideImmediateCode;
    }
}
