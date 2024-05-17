package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for immediate instructions.
 */
public class ImmediateInstruction extends Instruction {
    private IImmediateCode immediateCode;

    public ImmediateInstruction(String mnemonic, String opcode, String description, IImmediateCode immediateCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setImmediateCode(immediateCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        registerPaneController.clearFlagHighlighting();
        int alu_immediate = argument.getAlu_Immediate();
        Register Rn = argument.getRn();
        Register Rd = argument.getRd();
        this.immediateCode.simulate(alu_immediate, Rn, Rd);
        pc.increase();
        registerPaneController.updateRegisterHighlighting(Rd.getID());
        memoryController.clearMemoryHighlighting();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(10b), immediate(12b), Rn(5b), Rd(5b)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertToMachineCode(opcode, 10);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getAlu_Immediate(), 12);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getID(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getID(), 5);
        return s;
    }

    public IImmediateCode getImmediateCode() {
        return immediateCode;
    }

    private void setImmediateCode(IImmediateCode immediateCode) {
        this.immediateCode = immediateCode;
    }
}
