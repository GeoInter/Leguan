/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class EX_MEM_Pipeline implements Serializable {

    public WB WB;
    public MEM MEM;
    public int PCBranch;
    public int ALU_result;
    public boolean ALU_zero;
    public int MemDataWrite;
    public int destReg;
    public String iString;
    public byte byteSizeMemoryAccess;
    public String branchCheck;
    public boolean memoryAccessExclusive;
    public int exclusiveCheckRegister; // register for putting result of STXR (indicates if operation was succesful)
    public int PC; // for branch prediction needed

    void Flush() {
        WB.MemToReg = false;
        WB.RegWrite = false;
        MEM.MemRead = false;
        MEM.MemWrite = false;
        MEM.branch = false;
        iString = "NOP";
        PC = -1;
    }
}
