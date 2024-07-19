package thb.fbi.leguan.data;

import thb.fbi.leguan.instructions.Instruction;

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
    /** address of the statement in memory */
    private int address;

    public ProgramStatement(Instruction instruction, InstructionArguments arguments, String source, int sourceLine) {
        this.setInstruction(instruction);
        this.setArguments(arguments);
        this.setSource(source);
        this.setSourceLine(sourceLine);
    }

    public String getMachineCodeString() {
        return this.instruction.getMachineCodeString(this.arguments);
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(int sourceLine) {
        this.sourceLine = sourceLine;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public InstructionArguments getArguments() {
        return arguments;
    }

    public void setArguments(InstructionArguments arguments) {
        this.arguments = arguments;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}
