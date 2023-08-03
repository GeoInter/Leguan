package thb.fbi.pipeline_visualizer.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import thb.fbi.pipeline_visualizer.pipeline.MFrame;
import thb.fbi.pipeline_visualizer.pipeline.PipelineSimulator;

public class HazardOptionsPanel extends JPanel {

    private JLabel dataHazardLabel;
    private JLabel controlHazardLabel;

    private JComboBox<String> dataHazardComboBox;
    private JComboBox<String> controlHazardComboBox;

    private PipelinePanel pipelinePanel;
    private StatsPanel statsPanel;
    private TwoBitPredictorPanel twoBitPredictorPanel;

    private PipelineSimulator simulator;

    public HazardOptionsPanel(PipelineSimulator simulator, PipelinePanel pipelinePanel, StatsPanel statsPanel) {
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Hazards",
                TitledBorder.LEFT, TitledBorder.TOP));

        this.pipelinePanel = pipelinePanel;
        this.statsPanel = statsPanel;
        this.simulator = simulator;

        this.dataHazardLabel = new JLabel("Data Hazard Option");
        this.controlHazardLabel = new JLabel("Control Hazard Option");

        String dataHazardOptions[] = { "Forwarding", "Detect and Stall" };
        String controlHazardOptions[] = { "Predict Not Taken", "2 bit Predictor" };

        this.dataHazardComboBox = new JComboBox<String>(dataHazardOptions);
        this.controlHazardComboBox = new JComboBox<String>(controlHazardOptions);

        this.dataHazardComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                MFrame frames[];
                switch (dataHazardComboBox.getSelectedIndex()) {
                    case 0: // Forwarding
                        frames = simulator.setForwardingEnabled(true);
                        pipelinePanel.updateMFrames(frames);
                        statsPanel.updateStats(simulator.clockCycleCounter, simulator.instructionCounter,
                                simulator.dataHazardCounter, simulator.controlHazardCounter, simulator.cpi,
                                simulator.sf);
                        break;
                    case 1: // Detect and Stall
                        frames = simulator.setForwardingEnabled(false);
                        pipelinePanel.updateMFrames(frames);
                        statsPanel.updateStats(simulator.clockCycleCounter, simulator.instructionCounter,
                                simulator.dataHazardCounter, simulator.controlHazardCounter, simulator.cpi,
                                simulator.sf);
                        break;
                }
            }

        });

        this.controlHazardComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                MFrame frames[];
                switch (controlHazardComboBox.getSelectedIndex()) {
                    case 0: // Predict Not Taken
                        frames = simulator.setIs2BitPredictorEnabled(false);
                        pipelinePanel.updateMFrames(frames);
                        statsPanel.updateStats(simulator.clockCycleCounter, simulator.instructionCounter,
                                simulator.dataHazardCounter, simulator.controlHazardCounter, simulator.cpi,
                                simulator.sf);
                        if(twoBitPredictorPanel != null) {
                            twoBitPredictorPanel.setVisible(false);
                        }
                        break;
                    case 1: // 2 bit Predictor
                        frames = simulator.setIs2BitPredictorEnabled(true);
                        pipelinePanel.updateMFrames(frames);
                        statsPanel.updateStats(simulator.clockCycleCounter, simulator.instructionCounter,
                                simulator.dataHazardCounter, simulator.controlHazardCounter, simulator.cpi,
                                simulator.sf);
                        if(twoBitPredictorPanel != null) {
                            twoBitPredictorPanel.setVisible(true);
                        }
                        break;
                }
            }

        });

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(dataHazardLabel);
        this.add(dataHazardComboBox);
        this.add(controlHazardLabel);
        this.add(controlHazardComboBox);
    }

    public void setTwoBitPredictorPanel(TwoBitPredictorPanel twoBitPredictorPanel) {
        this.twoBitPredictorPanel = twoBitPredictorPanel;
    }
    
}
