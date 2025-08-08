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
    public long PCBranch;
    /** result of ALU operation */
    public long ALU_result;
    /** flag indicating if ALU result was zero */
    public boolean ALU_zero;
    /** data to store into memory */
    public long MemDataWrite;
    /** destination register index */
    public int destReg;
    /** PC of the next instruction */
    public long PC;
    /** unedited line of code belonging to this instruction */
    public String codeString;
    /** mnemonic of the instruction */
    public String mnemonic;

    //// helper fields (not part of actual specification) ////
    /** number of bytes to access from memory (load/store) */
    public byte byteSizeMemoryAccess;
    /** indicates if instruction is LXDR or STXR */
    public boolean memoryAccessExclusive;
    /** register for putting result of STXR (indicates if operation was succesful) */
    public int exclusiveCheckRegister;
    

    void Flush() {
        WB.MemToReg = false;
        WB.RegWrite = false;
        MEM.MemRead = false;
        MEM.MemWrite = false;
        MEM.branch = false;
        codeString = "NOP";
        PC = -1;
    }
}
