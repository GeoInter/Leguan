package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;
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
        Register Rm = argument.getRm();
        int shamt = argument.getShamt();
        Register Rn = argument.getRn();
        Register Rd = argument.getRd();
        this.arithmeticCode.simulate(Rm, shamt, Rn, Rd);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(11b), Rm(5b), shamt(6b), Rn(5b), Rd(5b)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertToMachineCode(opcode, 11);
        if(args.getRm() != null) {
            s += " " + MachineCodeTranslator.convertToMachineCode(args.getRm().getID(), 5);
        } else {
            s += " 11111";
        }
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getShamt(), 6);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getID(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getID(), 5);
        return s;
    }

    public IArithmeticCode getArithmeticCode() {
        return arithmeticCode;
    }

    private void setArithmeticCode(IArithmeticCode arithmeticCode) {
        this.arithmeticCode = arithmeticCode;
    }
}
