package thb.fbi.leguan.instructions.integer;

import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * Interface for definining and executing code of DataTransfer instructions
 */
public interface IWideImmediateCode {
    public abstract void simulate(IntegerRegister Rd, long immediate, int shamt );
}
