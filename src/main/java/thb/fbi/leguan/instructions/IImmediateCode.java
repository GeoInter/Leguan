package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * Interface for definining and executing code of immediate instructions
 */
public interface IImmediateCode {
    public abstract void simulate(long alu_immediate, IntegerRegister Rn, IntegerRegister Rd);
}
