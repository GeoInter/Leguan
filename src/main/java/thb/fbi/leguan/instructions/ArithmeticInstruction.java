package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for arithmetic instructions.
 */
public class ArithmeticInstruction extends Instruction {
    private IArithmeticCode arithmeticCode;

    public ArithmeticInstruction(String mnemonic, int opcode, String description, IArithmeticCode arithmeticCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setArithmeticCode(arithmeticCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        IntegerRegister Rm = argument.getRm();
        int shamt = argument.getShamt();
        IntegerRegister Rn = argument.getRn();
        IntegerRegister Rd = argument.getRd();
        this.arithmeticCode.simulate(Rm, shamt, Rn, Rd);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(11bit), Rm(5bit), shamt(6bit), Rn(5bit), Rd(5bit)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 11);
        if(args.getRm() != null) {
            s += " " + MachineCodeTranslator.convertToMachineCode(args.getRm().getId(), 5);
        } else {
            s += " 11111";
        }
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getShamt(), 6);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getId(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getId(), 5);
        return s;
    }

    public IArithmeticCode getArithmeticCode() {
        return arithmeticCode;
    }

    private void setArithmeticCode(IArithmeticCode arithmeticCode) {
        this.arithmeticCode = arithmeticCode;
    }
}
