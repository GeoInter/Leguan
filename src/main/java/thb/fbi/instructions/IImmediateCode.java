package thb.fbi.instructions;

import thb.fbi.Register;

/**
 * Interface for execution of immediate instructions
 */
public interface IImmediateCode {
    public abstract void simulate(int alu_immediate, Register Rn, Register Rd);
}
