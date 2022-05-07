package thb.fbi.instructions;

import thb.fbi.Register;

/**
 * Interface for definining and executing code of DataTransfer instructions
 */
public interface IDataTransferCode {
    public abstract void simulate(int dt_adress, String opcode2, Register Rn, Register Rt);
}
