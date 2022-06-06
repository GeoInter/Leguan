package thb.fbi.instructions;

import thb.fbi.simulation.Register;

/**
 * Interface for definining and executing code of unconditional branch instructions
 */
public interface IBranchCode {
    public abstract void simulate(int br_address, Register pc);
}
