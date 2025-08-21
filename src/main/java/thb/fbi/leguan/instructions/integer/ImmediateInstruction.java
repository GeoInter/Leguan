package thb.fbi.leguan.instructions.integer;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for immediate instructions.
 */
public class ImmediateInstruction extends Instruction {
    private IImmediateCode immediateCode;

    public ImmediateInstruction(String mnemonic, int opcode, String description, IImmediateCode immediateCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setImmediateCode(immediateCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        long alu_immediate = argument.getImmediate();
        IntegerRegister Rn = (IntegerRegister) argument.getRn();
        IntegerRegister Rd = (IntegerRegister) argument.getRd();
        this.immediateCode.simulate(alu_immediate, Rn, Rd);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(10bit), immediate(12bit), Rn(5bit), Rd(5bit)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 10);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getImmediate(), 12);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getId(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getId(), 5);
        return s;
    }

    public IImmediateCode getImmediateCode() {
        return immediateCode;
    }

    private void setImmediateCode(IImmediateCode immediateCode) {
        this.immediateCode = immediateCode;
    }
}
