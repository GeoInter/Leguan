package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.simulation.FPRegister;

public interface IFPArithmeticCode {
    public abstract void simulate(FPRegister Rm, int shamt, FPRegister Rn, FPRegister Rd);
}
