package thb.fbi.leguan.instructions.integer;

import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * Interface for definining and executing code of arithmetic instructions
 */
public interface IArithmeticCode {
    public abstract void simulate(IntegerRegister Rm, int shamt, IntegerRegister Rn, IntegerRegister Rd);
}
