/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class IF_ID_Pipeline implements Serializable {

    public Instruction Instruction;
    public int PC;
    public String iString;
    
    IF_ID_Pipeline(Instruction i, int p)
    {
        this.Instruction = i;
        this.PC = p;
        this.iString = i.iString;
    }
}
