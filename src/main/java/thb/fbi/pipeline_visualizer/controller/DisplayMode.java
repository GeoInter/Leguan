package thb.fbi.pipeline_visualizer.controller;

public enum DisplayMode {
    Decimal("Decimal"),
    Binary("Binary"), 
    Help("Help");
    
    private String label;
    
    private DisplayMode(final String label) {
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
