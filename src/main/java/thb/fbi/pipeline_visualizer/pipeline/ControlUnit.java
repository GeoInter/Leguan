/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ControlUnit implements Serializable {
    public int op;
    public WB WB;
    public MEM MEM;
    public int ALUOp;
    public boolean ALUSource;
    public boolean RegDest;

    ControlUnit(int x) {
        this.op = x;
        this.WB = new WB();
        this.MEM = new MEM();

        if (this.op == -1) { // NOP
            this.ALUOp = -1;
            this.ALUSource = false;
            this.RegDest = false;
        } else if (this.op == 0) { // R type :)
            this.WB.RegWrite = true;
            this.WB.MemToReg = false;
            this.MEM.MemRead = false;
            this.MEM.MemWrite = false;
            this.MEM.branch = false;
            this.ALUOp = 2;
            this.ALUSource = false;
            this.RegDest = true;
        } else if (op > 0) { // I/j type :)
            if (op == 4) { // used for beq - Branch if equals
                this.WB.RegWrite = false;
                this.WB.MemToReg = false;
                this.MEM.MemRead = false;
                this.MEM.MemWrite = false;
                this.MEM.branch = true;
                this.ALUOp = 1;
                this.ALUSource = false;
                this.RegDest = true;
            } else if (op == 34) { // used for BL only
                this.WB.RegWrite = true;
                this.WB.MemToReg = false;
                this.MEM.MemRead = false;
                this.MEM.MemWrite = false;
                this.MEM.branch = true;
                this.ALUOp = 1;
                this.ALUSource = false;
                this.RegDest = true;
            } else if (op == 35) { // load
                this.WB.RegWrite = true;
                this.WB.MemToReg = true;
                this.MEM.MemRead = true;
                this.MEM.MemWrite = false;
                this.MEM.branch = false;
                this.ALUOp = 0;
                this.ALUSource = true;
                this.RegDest = false;
            } else if (op == 43) { // Store
                this.WB.RegWrite = false;
                this.WB.MemToReg = false;
                this.MEM.MemRead = false;
                this.MEM.MemWrite = true;
                this.MEM.branch = false;
                this.ALUOp = 0;
                this.ALUSource = true;
                this.RegDest = false;
            } else if (op == 3) { // immediate
                this.WB.RegWrite = true;
                this.WB.MemToReg = false;
                this.MEM.MemRead = false;
                this.MEM.MemWrite = false;
                this.MEM.branch = false;
                this.ALUOp = 2;
                this.ALUSource = true;
                this.RegDest = true;
            } else if(op == 5) { //shift 
                this.WB.RegWrite = true;
                this.WB.MemToReg = false;
                this.MEM.MemRead = false;
                this.MEM.MemWrite = false;
                this.MEM.branch = false;
                this.ALUOp = 2;
                this.ALUSource = true;
                this.RegDest = true;
            } else if(op == 6) { // exclusive Store
                this.WB.RegWrite = false;
                this.WB.MemToReg = false;
                this.MEM.MemRead = false;
                this.MEM.MemWrite = true;
                this.MEM.branch = false;
                this.ALUOp = 1;
                this.ALUSource = true;
                this.RegDest = true;
            }
        }
    }

    public String toString(int mode) {
        String str = "";
        if (ALUOp == 2 && mode == 2) {
            str += "10, ";
        } else {
            str += ALUOp + ", ";
        }

        if (mode == 1) {
            if (ALUSource) {
                str = "True, ";
            } else {
                str = "False, ";
            }
        } else if (mode == 2) {
            if (ALUSource) {
                str = "1, ";
            } else {
                str = "0, ";
            }
        }

        if (mode == 1) {
            if (RegDest) {
                str += "True";
            } else {
                str += "False";
            }
        } else if (mode == 2) {
            if (RegDest) {
                str += "1";
            } else {
                str += "0";
            }
        }

        if (mode == 3) {
            return "";
        }
        return str;
    }
}
