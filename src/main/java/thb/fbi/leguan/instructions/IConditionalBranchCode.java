package thb.fbi.leguan.instructions;

import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * Interface for definining and executing code of conditional branch instructions
 */
public interface IConditionalBranchCode {
    public abstract void simulate(int cond_br_address, IntegerRegister Rt, PCRegister pc);
}
