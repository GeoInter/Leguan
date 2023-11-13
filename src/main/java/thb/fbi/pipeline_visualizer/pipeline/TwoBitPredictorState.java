package thb.fbi.pipeline_visualizer.pipeline;

/**
 * implementation of dynamic 2 bit branch predictor states
 */
public enum TwoBitPredictorState {
    NotTaken(0),
    LikelyNotTaken(1),
    LikelyTaken(2),
    Taken(3);

    private int value;

    private TwoBitPredictorState(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        switch(value) {
            case 0: return "NotTaken";
            case 1: return "Likely NotTaken";
            case 2: return "Likely Taken";
            case 3: return "Taken";
            default: return "Unknown State";
        }
    }
}
