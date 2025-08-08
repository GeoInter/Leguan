package thb.fbi.leguan.data;

import thb.fbi.leguan.simulation.Register;

/**
 * Class for holding all kinds of arguments for all instruction formats.
 * Each instruction class takes certain attributs from this class for execution.
 */
public class InstructionArguments {
    /** already translated arguments; can be directly used by an instruction */
    private Register Rm;
    private Register Rn; // TODO: Use index instead? Currently problematic with LDURD and LDURS having their own parameters
    private Register Rd;
    private Register Rt;
    private int shamt; // 6bit
    private int alu_immediate; // 12bit 
    /**
     * Address for instruction to jump to or to load from memory
     */
    private long address;
    // mov_immediate

    public InstructionArguments() {
        Rm = null;
        Rn = null;
        Rd = null;
        Rt = null;
    }

    public Register getRm() {
        return Rm;
    }

    public Register getRn() {
        return Rn;
    }

    public Register getRd() {
        return Rd;
    }

    public Register getRt() {
        return Rt;
    }

    public int getShamt() {
        return shamt;
    }

    public int getAlu_Immediate() {
        return alu_immediate;
    }

    public long getAddress() {
        return address;
    }

    public void setRn(Register rn) {
        this.Rn = rn;
    }

    public void setRm(Register rm) {
        this.Rm = rm;
    }

    public void setRd(Register rd) {
        this.Rd = rd;
    }

    public void setRt(Register rt) {
        this.Rt = rt;
    }

    public void setShamt(int shamt) {
        this.shamt = shamt;
    }

    public void setAlu_Immediate(int alu_immediate) {
        this.alu_immediate = alu_immediate;
    }

    public void setAddress(long address) {
        this.address = address;
    }
}
