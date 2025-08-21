package thb.fbi.leguan.instructions.integer;

import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * Interface for definining and executing code of DataTransfer instructions
 */
public interface IDataTransferCode {
    public abstract void simulate(long dt_address, IntegerRegister Rn, IntegerRegister Rt);
}
