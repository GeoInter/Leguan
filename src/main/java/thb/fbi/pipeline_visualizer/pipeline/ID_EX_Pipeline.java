/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ID_EX_Pipeline implements Serializable {
    /** indicates if register Rd will be used as destination, otherwise Rt */
    public boolean RegDest;
    /** indicates if offset value will be forwarded to the ALU or a register */
    public boolean ALUSrc;
    /** AluOp indicates the operation which will be executed in the ALU */
    public int ALUOp;
    /** MemoryAccess stage */
    public MEM MEM;
    /** WriteBack stage */
    public WB  WB;
    /** PC of the next instruction */
    public int PC;
    /** register operand index */
    public int rn;
    /** register operand value */
    public int rnValue;
    /** register operand index */
    public int rt;
    /** register operand value */
    public int rtValue;
    /** destination register index */
    public int rd;
    /** non-extended offset */
    public int Offset;
    /** extended offset (32bit) */
    public int i32Offset;
    /** opcode of the instruction */
    public short opcode;
    /** unedited line of code belonging to this instruction */
    public String codeString;


    public String bitString;

    //// helper fields (not part of actual specification) ////
    /** number of bytes to access from memory (load/store) */
    public byte byteSizeMemoryAccess;
    /** mnemonic of the instruction */
    public String mnemonic;
    /** indicates if instruction is LXDR or STXR */
    public boolean memoryAccessExclusive;
    /** indicates if instruction can set flags */
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
        this.codeString = "NOP";
        this.PC = -1;
    }
}
