package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.Register;

/**
 * Interface for definining and executing code of immediate instructions
 */
public interface IImmediateCode {
    public abstract void simulate(int alu_immediate, Register Rn, Register Rd);
}
