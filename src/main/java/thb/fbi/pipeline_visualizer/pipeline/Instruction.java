/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class Instruction implements Serializable {

    /** Instruction Format */
    private InstructionFormat format;
    /** first register operand Rn */
    private int rn;
    /** second register operand Rt/Rm */
    private int rt;
    /** destination register */
    private int rd;
    /** shift amount */
    private int shamt;
    /** offset (can be address, immediate, etc.) */
    private long offsetIJ; 
    /** original line of code */
    private String codeString;
    /** instruction in binary representation */
    private String binaryCodeString;
    /** mnemonic of the instruction */
    private String mnemonic;
    /** opcode of the instruction */
    private short opcode;

    public Instruction() {
        format = InstructionFormat.Unknown;
        rn = 31;
        rt = 31;
        rd = 31;
        shamt = -1;
        offsetIJ = -1;
        codeString = "UNKNOWN";
        opcode = Short.parseShort("0", 2);
    }

    public String getBinaryCodeString() {
        return binaryCodeString;
    }

    public void setBinaryCodeString(String binaryCodeString) {
        this.binaryCodeString = binaryCodeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public short getOpcode() {
        return this.opcode;
    }

    public InstructionFormat getFormat() {
        return format;
    }

    public void setFormat(InstructionFormat format) {
        this.format = format;
    }

    public void setOpcode(short opcode) {
        this.opcode = opcode;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int k) {
        if (k < 32 && k > -1)
            this.rn = k;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int k) {
        if (k < 32 && k > -1)
            this.rt = k;
    }

    public int getRd() {
        return rd;
    }

    public void setRd(int k) {
        if (k < 32 && k > -1)
            this.rd = k;
    }

    public int getShamt() {
        return shamt;
    }

    public void setShamt(int k) {
        this.shamt = k;
    }

    public long getOffsetIJ() {
        return offsetIJ;
    }

    public void setOffsetIJ(long offset) {
        this.offsetIJ = offset;
    }

    public String getCodeString() {
        return this.codeString;
    }

    public void setString(String s) {
        this.codeString = s;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getMnemonic() {
        return mnemonic;
    }

}
