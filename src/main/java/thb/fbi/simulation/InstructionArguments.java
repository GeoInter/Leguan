package thb.fbi.simulation;

/**
 * Class for holding all kinds of arguments for all instruction formats.
 * Each instruction class takes certain attributs from this class for execution.
 */
public class InstructionArguments {
    /** already translated arguments; can be directly used by an instruction */
    private Register Rm;
    private Register Rn;
    private Register Rd;
    private Register Rt;
    private int shamt; // 6bit
    private int alu_immediate; // 12bit
    private int dt_address; // 9bit
    private int br_address;
    private int cond_br_address;
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

    public int getDt_Address() {
        return dt_address;
    }

    public int getBr_Address() {
        return br_address;
    }

    public int getCond_Br_Address() {
        return cond_br_address;
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

    public void setDt_Address(int dt_address) {
        this.dt_address = dt_address;
    }

    public void setBr_Address(int br_address) {
        this.br_address = br_address;
    }

    public void setCond_Br_Address(int cond_br_address) {
        this.cond_br_address = cond_br_address;
    }
}
