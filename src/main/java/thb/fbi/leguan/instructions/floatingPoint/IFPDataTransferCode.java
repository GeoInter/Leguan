package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.IntegerRegister;

public interface IFPDataTransferCode {
    public abstract void simulate(long dt_address, IntegerRegister Rn, FPRegister Rt);
}
