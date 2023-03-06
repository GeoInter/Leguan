package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.Register;

/**
 * Interface for definining and executing code of DataTransfer instructions
 */
public interface IWideImmediateCode {
    public abstract void simulate(Register Rd, long immediate, int shamt );
}
