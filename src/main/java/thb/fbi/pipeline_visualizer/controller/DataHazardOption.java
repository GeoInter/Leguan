package thb.fbi.pipeline_visualizer.controller;

public enum DataHazardOption {
    Forwarding("Forwarding"),
    Detect_Stall("Detect & Stall");

    private String label;

    private DataHazardOption(String label) {
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
