/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class IF_ID_Pipeline implements Serializable {
    /** instruction */
    public Instruction instruction;
    /** PC of the next instruction */
    public int PC;
    /** original line of code/instruction */
    public String codeString;
    
    IF_ID_Pipeline(Instruction instruction, int pc)
    {
        this.instruction = instruction;
        this.PC = pc;
        this.codeString = instruction.getCodeString();
    }
}
