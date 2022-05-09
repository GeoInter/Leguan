package thb.fbi.instructions;

import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.ProgramStatement;
import thb.fbi.simulation.Register;

/**
 * Subclass for arithmetic instructions.
 */
public class ArithmeticInstruction extends Instruction {
    private IArithmeticCode arithmeticCode;

    public ArithmeticInstruction(String opcode, String description, IArithmeticCode arithmeticCode) {
        setMnemonic(opcode);
        setDescription(description);
        setArithmeticCode(arithmeticCode);
    }

    @Override
    public void simulate(ProgramStatement argument, FlagRegister F, long pc) {
        Register Rm = argument.getRm();
        int shamt = argument.getShamt();
        Register Rn = argument.getRn();
        Register Rd = argument.getRd();
        this.arithmeticCode.simulate(Rm, shamt, Rn, Rd, F);
    }

    public IArithmeticCode getArithmeticCode() {
        return arithmeticCode;
    }

    private void setArithmeticCode(IArithmeticCode arithmeticCode) {
        this.arithmeticCode = arithmeticCode;
    }
}
