package thb.fbi.instructions;

import thb.fbi.Register;

public interface IArithmeticCode {
    public abstract void simulate(Register Rm, int shamt, Register Rn, Register Rd);
}
