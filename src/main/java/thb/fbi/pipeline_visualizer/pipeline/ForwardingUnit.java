/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ForwardingUnit implements Serializable {

    public int rs;
    public int rt;
    public int RegWriteExMemAdd; // destination register from EX/MEM Pipe
    public int RegWriteExMemValue;
    public int RegWriteMemWbAdd; // destination register from MEM/WB Pipe
    public int RegWriteMemWbValue;
    public int rsValue;
    public int rtValue;
    public boolean RegWriteExMemFlag = false;
    public boolean RegWriteMemWbFlag = false;
    public boolean isForwardingEnabled = true;

    ForwardingUnit(boolean isForwardingEnabled) {
        rs = -2;
        rt = -2;

        RegWriteExMemAdd = -1;
        RegWriteMemWbAdd = -1;
        RegWriteMemWbValue = 0;
        RegWriteExMemValue = 0;
        RegWriteExMemFlag = false;
        RegWriteMemWbFlag = false;
        this.isForwardingEnabled = isForwardingEnabled;
    }

    // returns MUX A output signal
    public int valueMuxA() {
        if(!isForwardingEnabled) return rsValue;

        if (rs == RegWriteExMemAdd && RegWriteExMemFlag) {
            return RegWriteExMemValue;
        } else if (rs == RegWriteMemWbAdd && RegWriteMemWbFlag) {
            return RegWriteMemWbValue;
        } else {
            return rsValue;
        }
    }

    // returns MUX B output signal
    public int valueMuxB() {
        if(!isForwardingEnabled) return rtValue;

        if (rt == RegWriteExMemAdd && RegWriteExMemFlag) {
            return RegWriteExMemValue;
        } else if (rt == RegWriteMemWbAdd && RegWriteMemWbFlag) {
            return RegWriteMemWbValue;
        } else {
            return rtValue;
        }
    }

    // returns MUX A control signal
    public int selectMuxA() {
        if(!isForwardingEnabled) return 0;

        if (rs == RegWriteExMemAdd && RegWriteExMemFlag) {
            return 2;
        } else if (rs == RegWriteMemWbAdd && RegWriteMemWbFlag) {
            return 1;
        } else {
            return 0;
        }
    }

    // returns MUX B control signal
    public int selectMuxB() {
        if(!isForwardingEnabled) return 0;

        if (rt == RegWriteExMemAdd && RegWriteExMemFlag) {
            return 2;
        } else if (rt == RegWriteMemWbAdd && RegWriteMemWbFlag) {
            return 1;
        } else {
            return 0;
        }
    }
}
