/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class ForwardingUnit implements Serializable {
    /** register operand index */
    public int rn;
    /** register operand value */
    public long rnValue;
    /** register operand index */
    public int rt;
    /** register operand value */
    public long rtValue;
    /** destination register index from EX/MEM Pipeline */
    public int RegWriteExMemAdd;
    /** destination register value from EX/MEM Pipeline */
    public long RegWriteExMemValue;
    /** destination register index from MEM/WB Pipeline */
    public int RegWriteMemWbAdd; // destination register from MEM/WB Pipe
    /** destination register value from MEM/WB Pipeline */
    public long RegWriteMemWbValue;
    /** RegWriteFlag from EX/MEM Pipeline */
    public boolean RegWriteExMemFlag = false;
    /** RegWriteFlag from MEM/WB Pipeline */
    public boolean RegWriteMemWbFlag = false;
    /** is Forwarding in EX stage enabled */
    public boolean isForwardingEnabled = true;

    ForwardingUnit(boolean isForwardingEnabled) {
        rn = -2;
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
    public long valueMuxA() {
        if(!isForwardingEnabled) return rnValue;

        if (rn == RegWriteExMemAdd && RegWriteExMemFlag) {
            return RegWriteExMemValue;
        } else if (rn == RegWriteMemWbAdd && RegWriteMemWbFlag) {
            return RegWriteMemWbValue;
        } else {
            return rnValue;
        }
    }

    // returns MUX B output signal
    public long valueMuxB() {
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

        if (rn == RegWriteExMemAdd && RegWriteExMemFlag) {
            return 2;
        } else if (rn == RegWriteMemWbAdd && RegWriteMemWbFlag) {
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
