/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ID_EX_Pipeline implements Serializable {
    
    public boolean RegDest;
    public boolean ALUSrc;
    public int ALUOp;
    public MEM MEM;
    public WB  WB;
    public int PC;
    public int rs;
    public int rsValue;
    public int rt;
    public int rtValue;
    public int rd;
    public short Offset;
    public int i32Offset;
    public int function;
    public String iString;
    public String bitString;
    public byte byteSizeMemoryAccess;
    public String branchCheck;
    public boolean memoryAccessExclusive;
    public boolean setsFlag;
        
    public void Flush()
    {
        this.ALUSrc = false;
        this.RegDest = false;
        this.WB.MemToReg = false;
        this.WB.RegWrite = false;
        this.MEM.MemRead = false;
        this.MEM.MemWrite = false;
        this.MEM.branch = false;
        this.ALUOp = -1;
        this.iString = "NOP";
        this.PC = -1;
    }
}
