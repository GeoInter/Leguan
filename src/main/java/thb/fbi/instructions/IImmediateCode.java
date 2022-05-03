package thb.fbi.instructions;

import thb.fbi.Register;

public interface IImmediateCode {
    public abstract void simulate(int alu_immediate, Register Rn, Register Rd);
}
