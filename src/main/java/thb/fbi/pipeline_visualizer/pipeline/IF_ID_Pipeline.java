/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class IF_ID_Pipeline implements Serializable {

    public Instruction instruction;
    public int PC;
    public String iString;
    
    IF_ID_Pipeline(Instruction instruction, int pc)
    {
        this.instruction = instruction;
        this.PC = pc;
        this.iString = instruction.getCodeString();
    }
}
