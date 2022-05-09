package thb.fbi.instructions;

import thb.fbi.simulation.Register;

/**
 * Interface for definining and executing code of DataTransfer instructions
 */
public interface IDataTransferCode {
    public abstract void simulate(int dt_address, String opcode2, Register Rn, Register Rt);
}
