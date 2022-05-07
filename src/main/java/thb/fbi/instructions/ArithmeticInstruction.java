package thb.fbi.instructions;

import thb.fbi.Register;

/**
 * Subclass for arithmetic instructions.
 */
public class ArithmeticInstruction extends Instruction {
    private IArithmeticCode arithmeticCode;

    public ArithmeticInstruction(String opcode, IArithmeticCode arithmeticCode) {
        setMnemonic(opcode);
        setArithmeticCode(arithmeticCode);
    }

    @Override
    public void simulate(ProgramStatement argument) {
        Register Rm = argument.getRm();
        int shamt = argument.getShamt();
        Register Rn = argument.getRn();
        Register Rd = argument.getRd();
        this.arithmeticCode.simulate(Rm, shamt, Rn, Rd);
    }

    public IArithmeticCode getArithmeticCode() {
        return arithmeticCode;
    }

    public void setArithmeticCode(IArithmeticCode arithmeticCode) {
        this.arithmeticCode = arithmeticCode;
    }
}
