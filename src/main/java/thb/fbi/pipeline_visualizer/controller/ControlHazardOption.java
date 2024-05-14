package thb.fbi.pipeline_visualizer.controller;

public enum ControlHazardOption {
    Predict_NotTaken("Predict Not Taken"),
    TwoBitPredictor("2 bit Predictor");

    private String label;

    private ControlHazardOption(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
