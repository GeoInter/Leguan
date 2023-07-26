package thb.fbi.pipeline_visualizer.controller;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
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
    StackPane stackPane;
    @FXML
    SwingNode swingNode;

    @FXML
    public void initialize() {
        pipelineSimulator = new PipelineSimulator();
        pipelinePanel = new PipelinePanel(pipelineSimulator);
        createAndSetSwingContent(swingNode);
    }

    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { 
                JPanel mainPanel = new JPanel();
                JPanel sidePanel = new JPanel();
                JPanel centerPanel = new JPanel();

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

                // add to sidePanel
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.NORTHWEST;
                gbc.gridx = 0;
                gbc.gridy = 0;
                sidePanel.add(statsPanel, gbc);
                gbc.gridx = 0;
                gbc.gridy = 1;
                sidePanel.add(hazardOptionsPanel, gbc);
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weightx = 1;
                gbc.weighty = 1; // last element in side panel needs weight for filling the side, thus placing it
                                 // in the upper corner
                sidePanel.add(twoBitPredictorPanel, gbc);

                // add to centerPanel
                centerPanel.add(pipelinePanel);

                // add center and side panel to main panel
                //mainPanel.add(sidePanel, BorderLayout.WEST);
                mainPanel.add(centerPanel, BorderLayout.CENTER);

                swingNode.setContent(pipelinePanel);
            }
        });
    }

    public void updateCode(String code) {
        pipelinePanel.updateMFrames(pipelineSimulator.execute(code));
    }
}
