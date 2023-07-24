/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class Instruction implements Serializable {

    char type; // instruction format
    int op;
    int rs; // first register
    int rt; // second register or if rd is not specified, then this is the destination
            // register
    int rd; // destination register
    int shamt; // shift amount
    int function; // ALU operation
    short offsetIJ; // immediate
    String iString; // original line of code (for debugging, see console output)
    byte byteSizeMemoryAccess; // number of bytes to access from memory (load/store)
    String branchCheck; // What to check for Branching
    boolean memoryAccessExclusive; // indicates if instruction is LXDR, STXR
    boolean setsFlag;

    public Instruction() {
        type = 'U';
        op = -1;
        rs = 31;
        rt = 31;
        rd = 31;
        shamt = -1;
        function = -1;
        offsetIJ = -1;
        this.iString = "UNKNOWN";
        byteSizeMemoryAccess = -1;
        branchCheck = "NONE";
        memoryAccessExclusive = false;
        setsFlag = false;
    }

    public void printInstruction() {
        String msg = "Instruction Not Set";

        if (this.type == 'R')
            msg = "Op: " + this.getOp() + " rs: " + this.getRs() +
                    " rt: " + this.getRt() + " rd: " + this.getRd() +
                    " \tshamt: " + this.getShamt() + " \tfunction: " +
                    this.getFunction();
        else if (this.type == 'I' || this.type == 'D')
            msg = "Op: " + this.getOp() + " rs: " + this.getRs() +
                    " rt: " + this.getRt() + " \toffset/constant: "
                    + this.getOffsetIJ();
        else if (this.type == 'B' || this.type == 'C')
            msg = "Op: " + this.getOp() + " rs: " + this.getRs() +  " rd: " + this.getRd() + " JMP Address: " + this.getOffsetIJ();
        else if (this.type == 'N')
            msg = "NOP";

        System.out.println(msg);
    }

    public char getType() {
        return type;
    }

    public void setType(char c) {
        this.type = c;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int k) {
        if (k < 64 && k > -1)
            this.op = k;
        else
            System.out.println("Op not Set");
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int k) {
        if (k < 32 && k > -1)
            this.rs = k;
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

    public int getFunction() {
        return function;
    }

    public void setFunction(int k) {
        this.function = k;
    }

    public short getOffsetIJ() {
        return offsetIJ;
    }

    public void setOffsetIJ(short k) {
        this.offsetIJ = k;
    }

    public String getiString() {
        return this.iString;
    }

    public void setString(String s) {
        this.iString = s;
    }

    public byte getByteSizeMemoryAccess() {
        return byteSizeMemoryAccess;
    }

    public void setByteSizeMemoryAccess(byte byteSizeMemoryAccess) {
        this.byteSizeMemoryAccess = byteSizeMemoryAccess;
    }

    public String getBranchCheck() {
        return branchCheck;
    }

    public void setBranchCheck(String branchCheck) {
        this.branchCheck = branchCheck;
    }

    public boolean isMemoryAccessExclusive() {
        return memoryAccessExclusive;
    }

    public void setMemoryAccessExclusive(boolean memoryAccessExclusive) {
        this.memoryAccessExclusive = memoryAccessExclusive;
    }

    public boolean isSetsFlag() {
        return setsFlag;
    }

    public void setSetsFlag(boolean setsFlag) {
        this.setsFlag = setsFlag;
    }

    public String getBitString() {
        String str = "";
        if (this.type == 'R') {

            str = giveBinaryString(26, 32, "" + this.op);
            str += giveBinaryString(27, 32, "" + this.rs);
            str += giveBinaryString(27, 32, "" + this.rt);
            str += giveBinaryString(27, 32, "" + this.rd);
            str += giveBinaryString(27, 32, "" + this.shamt);
            str += giveBinaryString(26, 32, "" + this.function);

        } else if (this.type == 'I') {

            str = giveBinaryString(26, 32, "" + this.op);
            str += giveBinaryString(27, 32, "" + this.rs);
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

}
