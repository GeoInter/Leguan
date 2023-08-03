package thb.fbi.pipeline_visualizer.controller;

import javax.swing.SwingUtilities;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import thb.fbi.pipeline_visualizer.pipeline.PipelineSimulator;

public class PipelineVisualizerController {

    private PipelineSimulator pipelineSimulator;
    private PipelinePanel pipelinePanel;
    private StatsPanel statsPanel;
    private CodePanel codePanel;

    @FXML
    SwingNode pipelineSwingNode;
    @FXML
    SwingNode statsSwingNode;
    @FXML
    SwingNode hazardSwingNode;
    @FXML
    SwingNode tableSwingNode;
    @FXML
    SwingNode codeSwingNode;
    @FXML
    SwingNode topBarSwingNode;

    @FXML
    public void initialize() {
        pipelineSimulator = new PipelineSimulator();
        statsPanel = new StatsPanel();
        codePanel = new CodePanel();
        createAndSetSwingContent(pipelineSwingNode, statsSwingNode, hazardSwingNode, tableSwingNode);
    }

    private void createAndSetSwingContent(final SwingNode pipelineSwingNode, final SwingNode statsSwingNode,
            final SwingNode hazardSwingNode, final SwingNode tableSwingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TwoBitPredictorPanel twoBitPredictorPanel = new TwoBitPredictorPanel();
                pipelinePanel = new PipelinePanel();
                pipelinePanel.setTwoBitPredictorPanel(twoBitPredictorPanel);
                HazardOptionsPanel hazardOptionsPanel = new HazardOptionsPanel(pipelineSimulator, pipelinePanel,
                        statsPanel);
                TopBarPanel topBarPanel = new TopBarPanel(pipelinePanel);

                pipelinePanel.updateMFrames(pipelineSimulator.execute(""));

                topBarSwingNode.setContent(topBarPanel);
                pipelineSwingNode.setContent(pipelinePanel);
                statsSwingNode.setContent(statsPanel);
                hazardSwingNode.setContent(hazardOptionsPanel);
                tableSwingNode.setContent(twoBitPredictorPanel);
                codeSwingNode.setContent(codePanel);
            }
        });
    }

    public void updateCode(String code) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pipelinePanel.updateMFrames(pipelineSimulator.execute(code));
                statsPanel.updateStats(pipelineSimulator.clockCycleCounter, pipelineSimulator.instructionCounter,
                        pipelineSimulator.dataHazardCounter, pipelineSimulator.controlHazardCounter,
                        pipelineSimulator.cpi,
                        pipelineSimulator.sf);
                codePanel.updateCodeTextArea(code);
            }
        });
    }
}
