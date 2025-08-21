/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class HazardDetectionUnit implements Serializable {
    /** indicates if a register will be written; value from ID/EX Pipeline */
    public boolean idExRegWrite;
    /** indicates if a register will be written; value from EX/MEM Pipeline */
    public boolean exMemRegWrite;
    /** indicates if memory will be read; value from ID/EX Pipeline */
    public boolean idExMemRead;
    /** Register Rn from IF/ID Pipeline */
    public int ifIdRn;
    /** Register Rt/Rm from IF/ID Pipeline */
    public int ifIdRt;
    /** Register Rd from IF/ID Pipeline */
    public int idExRd;
    /** Register Rd from EX/MEM Pipeline */
    public int exMemRd;
    /** indicates if result of ALU was zero */
    public boolean ALUzero;
    /** indictaes wheter instruction can branch to an address */
    public boolean branch;
    /** address to branch to */
    public long branchAddress;

    HazardDetectionUnit() {
        idExRegWrite = false;
        exMemRegWrite = false;
        idExMemRead = false;
        ifIdRn = -10;
        ifIdRt = -11;
        idExRd = -12;
        exMemRd = -13;
        ALUzero = false;
        branch = false;
        branchAddress = -1;
    }

    /*
     * checks for Data Hazard, when Forwarding is disabled
     * check for both EX and MEM stage
     * returns true if it needs to be stalled
     * returns false if not
     */
    public boolean checkUnforwardedDataHazard() {
        if (idExRegWrite) {
            if ((ifIdRn == idExRd || ifIdRt == idExRd) && idExRd != 31) {
                return true;
            }
        } 
        if (exMemRegWrite) {
            if ((ifIdRn == exMemRd || ifIdRt == exMemRd) && exMemRd != 31) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDataHazard() {
        if (idExMemRead) {
            if (ifIdRn == idExRd && idExRd != 31 || ifIdRt == exMemRd && exMemRd != 31) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBranchHazard() {
        if (ALUzero && branch) {
            return true;
        } else {
            return false;
        }
    }
}
