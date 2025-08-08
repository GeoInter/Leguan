package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

/**
 * entry of 2 bit prediction table
 */
public class TwoBitPrecitionEntry implements Serializable {
    
    private String code;
    private TwoBitPredictorState state;
    private Long targetPC; // PC to branch to, if taken

    public TwoBitPrecitionEntry(Long targetPC, TwoBitPredictorState state, String code) {
        this.targetPC = targetPC;
        this.state = state;
        this.code = code;
    }

    public Long getTargetPC() {
        return targetPC;
    }

    public void setTargetPC(Long targetPC) {
        this.targetPC = targetPC;
    }

    public TwoBitPredictorState getState() {
        return state;
    }

    public void setState(TwoBitPredictorState state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
