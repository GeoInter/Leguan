/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class Instruction implements Serializable {

    InstructionFormat format; // instruction format
    int rn; // first register
    int rt; // second register or if rd is not specified, then this is the destination
            // register
    int rd; // destination register
    int shamt; // shift amount
    int offsetIJ; // immediate
    String codeString; // original line of code (for debugging, see console output)
    String binaryCodeString;

    public String getBinaryCodeString() {
        return binaryCodeString;
    }

    public void setBinaryCodeString(String binaryCodeString) {
        this.binaryCodeString = binaryCodeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    String mnemonic;
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
        else
            System.out.println("Rs not Set");
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int k) {

        if (k < 32 && k > -1)
            this.rt = k;
        else
            System.out.println("Rt not Set");

    }

    public int getRd() {
        return rd;
    }

    public void setRd(int k) {

        if (k < 32 && k > -1)
            this.rd = k;
        else
            System.out.println("Rd not Set");
    }

    public int getShamt() {
        return shamt;
    }

    public void setShamt(int k) {
        this.shamt = k;
    }

    public int getOffsetIJ() {
        return offsetIJ;
    }

    public void setOffsetIJ(int offset) {
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
