/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class HazardDetectionUnit implements Serializable {

    public boolean idExRegWrite; // register write in EX stage
    public boolean exMemRegWrite; // register write in MEM stage
    public boolean idExMemRead;
    public int ifIdRn;
    public int ifIdRt;
    public int idExRd;
    public int exMemRd;
    public boolean ALUzero;
    public boolean branch;
    public int branchAddress;

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
