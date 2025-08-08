package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for wide immediate instructions
 */
public class WideImmediateInstruction extends Instruction {
    private IWideImmediateCode wideImmediateCode;

    

    public WideImmediateInstruction(String mnemonic, int opcode, String description, IWideImmediateCode wideImmediateCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setWideImmediateCode(wideImmediateCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        IntegerRegister Rd = (IntegerRegister) argument.getRd();
        int immediate = argument.getAlu_Immediate();
        int shamt = argument.getShamt();
        this.wideImmediateCode.simulate(Rd, immediate, shamt);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(11bit), mov_immediate(16bit), Rd(5bit)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 11);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getAlu_Immediate(), 16);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getId(), 5);
        return s;
    }
    
    public IWideImmediateCode getWideImmediateCode() {
        return wideImmediateCode;
    }

    public void setWideImmediateCode(IWideImmediateCode wideImmediateCode) {
        this.wideImmediateCode = wideImmediateCode;
    }
}
