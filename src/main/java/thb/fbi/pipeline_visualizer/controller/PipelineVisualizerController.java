package thb.fbi.pipeline_visualizer.controller;

import javax.swing.SwingUtilities;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import thb.fbi.pipeline_visualizer.pipeline.PipelineSimulator;

public class PipelineVisualizerController {

    private PipelineSimulator pipelineSimulator;
    private PipelinePanel pipelinePanel;

    private String code = "ADDI X0, X0, 1;\n" +
            "ADDI X7, X7, 20;\n" +
            "ADDI X12, X12, 0;\n" +
            "loop: STUR X1, [X12, 0];\n" +
            "ADD X2, X0, X1;\n" +
            "ADDI X0, X1, 0;\n" +
            "ADDI X1, X2, 0;\n" +
            "ADDI X5, X5, 1; // counter\n" +
            "ADDI X12, X12, 8; // storing address\n" +
            "SUB X8, X7, X5;\n" +
            "CBNZ X8, loop;\n" +
            "ADDI X10, X10, 420;\n";

    @FXML
    SwingNode pipelineSwingNode;
    @FXML
    SwingNode statsSwingNode;
    @FXML
    SwingNode hazardSwingNode;
    @FXML
    SwingNode tableSwingNode;

    @FXML
    public void initialize() {
        pipelineSimulator = new PipelineSimulator();
        createAndSetSwingContent(pipelineSwingNode, statsSwingNode, hazardSwingNode, tableSwingNode);
    }

    private void createAndSetSwingContent(final SwingNode pipelineSwingNode, final SwingNode statsSwingNode, final SwingNode hazardSwingNode, final SwingNode tableSwingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TwoBitPredictorPanel twoBitPredictorPanel = new TwoBitPredictorPanel();
                StatsPanel statsPanel = new StatsPanel();
                pipelinePanel = new PipelinePanel(pipelineSimulator);
                pipelinePanel.setTwoBitPredictorPanel(twoBitPredictorPanel);
                HazardOptionsPanel hazardOptionsPanel = new HazardOptionsPanel(pipelineSimulator, pipelinePanel,
                        statsPanel);

                pipelinePanel.updateMFrames(pipelineSimulator.execute(code));
                statsPanel.updateStats(pipelineSimulator.clockCycleCounter, pipelineSimulator.instructionCounter,
                        pipelineSimulator.dataHazardCounter, pipelineSimulator.controlHazardCounter,
                        pipelineSimulator.cpi,
                        pipelineSimulator.sf);

                pipelineSwingNode.setContent(pipelinePanel);
                statsSwingNode.setContent(statsPanel);
                hazardSwingNode.setContent(hazardOptionsPanel);
                tableSwingNode.setContent(twoBitPredictorPanel);
            }
        });
    }

    public void updateCode(String code) {
        pipelinePanel.updateMFrames(pipelineSimulator.execute(code));
    }
}
