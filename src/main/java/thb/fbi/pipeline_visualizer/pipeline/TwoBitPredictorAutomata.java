package thb.fbi.pipeline_visualizer.pipeline;

/**
 * implementation of dynamic 2 bit branch predictor automata
 */
public class TwoBitPredictorAutomata {
    
    public static TwoBitPredictorState getNextPrediction(TwoBitPredictorState lastState, boolean isTaken) {
        switch(lastState) {
            case NotTaken:
                if(isTaken) return TwoBitPredictorState.LikelyNotTaken;
                return TwoBitPredictorState.NotTaken;
            case LikelyNotTaken:
                if(isTaken) return TwoBitPredictorState.LikelyTaken;
                return TwoBitPredictorState.NotTaken;
            case LikelyTaken:
                if(isTaken) return TwoBitPredictorState.Taken;
                return TwoBitPredictorState.LikelyNotTaken;
            case Taken:
                if(isTaken) return TwoBitPredictorState.Taken;
                return TwoBitPredictorState.LikelyTaken;
            default:
                return lastState;
        }
    }
}
