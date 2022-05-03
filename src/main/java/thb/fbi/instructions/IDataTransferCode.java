package thb.fbi.instructions;

import thb.fbi.Register;

public interface IDataTransferCode {
    public abstract void simulate(int dt_adress, String opcode2, Register Rn, Register Rt);
}
