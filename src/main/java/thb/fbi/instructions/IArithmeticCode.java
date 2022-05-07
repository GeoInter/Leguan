package thb.fbi.instructions;

import thb.fbi.Register;

/**
 * Interface for definining and executing code of arithmetic instructions
 */
public interface IArithmeticCode {
    public abstract void simulate(Register Rm, int shamt, Register Rn, Register Rd);
}
