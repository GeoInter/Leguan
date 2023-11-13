/**
 * @author 'SIN
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class MEM_WB_Pipeline implements Serializable{
    
    public WB  WB;
    public int ALU_result;
    public int Mdata;
    public int destReg;
    public String branchCheck;
    public String iString;
    public int PC; // for branch prediction needed
    
}
