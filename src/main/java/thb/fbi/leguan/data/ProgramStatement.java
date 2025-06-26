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
    /** line number/ position in editor */
    private InstructionPosition linePosition;

    public ProgramStatement(Instruction instruction, InstructionArguments arguments, String source, int startingLineNumber, int endingLineNumber) {
        this.setInstruction(instruction);
        this.setArguments(arguments);
        this.setSource(source);
        this.setLinePosition(new InstructionPosition(startingLineNumber, endingLineNumber));
    }

    public String getMachineCodeString() {
        return this.instruction.getMachineCodeString(this.arguments);
    }

    public InstructionPosition getLinePosition() {
        return linePosition;
    }

    public void setLinePosition(InstructionPosition linePosition) {
        this.linePosition = linePosition;
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
