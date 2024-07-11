package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.Register;

/**
 * Interface for definining and executing code of DataTransfer instructions
 */
public interface IDataTransferCode {
    public abstract void simulate(long dt_address, Register Rn, Register Rt);
}
