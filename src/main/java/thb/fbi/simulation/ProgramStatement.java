package thb.fbi.simulation;

import thb.fbi.instructions.Instruction;

/**
 * Models a line from the written source code
 */
public class ProgramStatement {
    /** translated instruction */
    private Instruction instruction;
    /** translated arguments of the used instruction */
    private InstructionArguments arguments;
    /** original line of code */
    private String source;
    /** line number of the source code */
    private int sourceLine;
}
