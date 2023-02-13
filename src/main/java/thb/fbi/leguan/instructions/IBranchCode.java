package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.PCRegister;

/**
 * Interface for definining and executing code of unconditional branch instructions
 */
public interface IBranchCode {
    public abstract void simulate(int br_address, PCRegister pc);
}
