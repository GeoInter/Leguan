/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class Instruction implements Serializable {

    char type; // instruction format
    int rn; // first register
    int rt; // second register or if rd is not specified, then this is the destination
            // register
    int rd; // destination register
    int shamt; // shift amount
    short offsetIJ; // immediate
    String codeString; // original line of code (for debugging, see console output)

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    String mnemonic;
    private short opcode;

    public Instruction() {
        type = 'U';
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

    public char getType() {
        return type;
    }

    public void setType(char c) {
        this.type = c;
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

    public short getOffsetIJ() {
        return offsetIJ;
    }

    public void setOffsetIJ(short k) {
        this.offsetIJ = k;
    }

    public String getCodeString() {
        return this.codeString;
    }

    public void setString(String s) {
        this.codeString = s;
    }

    public String getBitString() {
        String str = "";
        if (this.type == 'R') {

            str = giveBinaryString(26, 32, "" + this.opcode);
            str += giveBinaryString(27, 32, "" + this.rn);
            str += giveBinaryString(27, 32, "" + this.rt);
            str += giveBinaryString(27, 32, "" + this.rd);
            str += giveBinaryString(27, 32, "" + this.shamt);

        } else if (this.type == 'I') {

            str = giveBinaryString(26, 32, "" + this.opcode);
            str += giveBinaryString(27, 32, "" + this.rn);
            str += giveBinaryString(27, 32, "" + this.rt);
            str += giveBinaryString(16, 32, "" + this.offsetIJ);

        } else {
            // return "INVALID INSTRUCTION";
        }

        return str;
    }

    private String giveBinaryString(int l, int r, String str) {
        int num = Integer.parseInt(str);
        int lZeros = Integer.numberOfLeadingZeros(num);
        String s = "";
        for (int i = 0; i < lZeros; i++) {
            s += "0";
        }
        s += Integer.toBinaryString(num);
        s = s.substring(l, r);

        return s;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getMnemonic() {
        return mnemonic;
    }

}
