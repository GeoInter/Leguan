package thb.fbi.instructions;

import thb.fbi.FlagRegister;
import thb.fbi.Register;

/**
 * Interface for definining and executing code of immediate instructions
 */
public interface IImmediateCode {
    public abstract void simulate(int alu_immediate, Register Rn, Register Rd,
        FlagRegister F);
}
