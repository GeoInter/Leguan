package thb.fbi.leguan.instructions.integer;

import thb.fbi.leguan.simulation.PCRegister;

/**
 * Interface for definining and executing code of unconditional branch instructions
 */
public interface IBranchCode {
    public abstract void simulate(long br_address, PCRegister pc);
}
