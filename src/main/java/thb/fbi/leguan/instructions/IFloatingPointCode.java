package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.FPRegister;

public interface IFloatingPointCode {
    public abstract void simulate(FPRegister Rm, int shamt, FPRegister Rn, FPRegister Rd);
}
