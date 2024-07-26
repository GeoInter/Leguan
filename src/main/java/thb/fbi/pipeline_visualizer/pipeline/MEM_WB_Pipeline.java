/**
 * @author 'SIN
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class MEM_WB_Pipeline implements Serializable{
    /** WriteBack stage */
    public WB  WB;
    /** result from the ALU */
    public int ALU_result;
    /** data loaded from memory */
    public int memoryData;
    /** destination register index */
    public int destReg;
    /** mnemonic of the instruction */
    public String mnemonic;
    /** original line of code/instruction */
    public String codeString;
    /** PC of the next instruction */
    public int PC; // for branch prediction needed
    
}
