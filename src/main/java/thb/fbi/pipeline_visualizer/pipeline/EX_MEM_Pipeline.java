/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class EX_MEM_Pipeline implements Serializable {

    /** WriteBack stage */
    public WB WB;
    /** MemoryAccess stage */
    public MEM MEM;
    /** address to branch to */
    public int PCBranch;
    /** result of ALU operation */
    public int ALU_result;
    /** flag indicating if ALU result was zero */
    public boolean ALU_zero;
    /** */
    public int MemDataWrite;
    /** destination register index */
    public int destReg;
    /** pc value of this specific instruction (needed for branch predictions) */
    public int PC;
    /** unedited line of code belonging to this instruction */
    public String iString;

    public byte byteSizeMemoryAccess;
    public String mnemonic;
    public boolean memoryAccessExclusive;
    public int exclusiveCheckRegister; // register for putting result of STXR (indicates if operation was succesful)
    

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
