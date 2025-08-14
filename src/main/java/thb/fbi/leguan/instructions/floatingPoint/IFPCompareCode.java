package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.simulation.FPRegister;

public interface IFPCompareCode {
    public abstract void simulate(FPRegister Rn, FPRegister Rm);
}
