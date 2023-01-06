package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.Register;

/**
 * Interface for definining and executing code of arithmetic instructions
 */
public interface IArithmeticCode {
    public abstract void simulate(Register Rm, int shamt, Register Rn, Register Rd);
}
