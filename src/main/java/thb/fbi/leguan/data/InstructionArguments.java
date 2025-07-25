package thb.fbi.leguan.data;

import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * Class for holding all kinds of arguments for all instruction formats.
 * Each instruction class takes certain attributs from this class for execution.
 */
public class InstructionArguments {
    /** already translated arguments; can be directly used by an instruction */
    private IntegerRegister Rm;
    private IntegerRegister Rn;
    private IntegerRegister Rd;
    private IntegerRegister Rt;
    private int shamt; // 6bit
    private int alu_immediate; // 12bit
    private long dt_address; // 9bit
    private int br_address;
    private int cond_br_address;
    // mov_immediate
    


    public InstructionArguments() {
        Rm = null;
        Rn = null;
        Rd = null;
        Rt = null;
    }

    public IntegerRegister getRm() {
        return Rm;
    }

    public IntegerRegister getRn() {
        return Rn;
    }

    public IntegerRegister getRd() {
        return Rd;
    }

    public IntegerRegister getRt() {
        return Rt;
    }

    public int getShamt() {
        return shamt;
    }

    public int getAlu_Immediate() {
        return alu_immediate;
    }

    public long getDt_Address() {
        return dt_address;
    }

    public int getBr_Address() {
        return br_address;
    }

    public int getCond_Br_Address() {
        return cond_br_address;
    }

    public void setRn(IntegerRegister rn) {
        this.Rn = rn;
    }

    public void setRm(IntegerRegister rm) {
        this.Rm = rm;
    }

    public void setRd(IntegerRegister rd) {
        this.Rd = rd;
    }

    public void setRt(IntegerRegister rt) {
        this.Rt = rt;
    }

    public void setShamt(int shamt) {
        this.shamt = shamt;
    }

    public void setAlu_Immediate(int alu_immediate) {
        this.alu_immediate = alu_immediate;
    }

    public void setDt_Address(long dt_address) {
        this.dt_address = dt_address;
    }

    public void setBr_Address(int br_address) {
        this.br_address = br_address;
    }

    public void setCond_Br_Address(int cond_br_address) {
        this.cond_br_address = cond_br_address;
    }
}
