package thb.fbi.pipeline_visualizer.controller;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import thb.fbi.pipeline_visualizer.pipeline.PipelineSimulator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 'SIN
 */
public class PipelineFrame extends JFrame{

    PipelinePanel pp;
    StatsPanel sp;
    HazardOptionsPanel hp;
    TwoBitPredictorPanel twoBitPredictorPanel;

    public PipelineFrame(String ins, PipelineSimulator simulator)
    {
        super("Pipeline Visualizer");
        sp = new StatsPanel();
        twoBitPredictorPanel = new TwoBitPredictorPanel();
        pp = new PipelinePanel(ins, simulator, twoBitPredictorPanel);
        hp = new HazardOptionsPanel(simulator, pp, sp);
        pp.updateMFrames(simulator.execute(ins));
        sp.updateStats(simulator.clockCycleCounter, simulator.instructionCounter,
                                simulator.dataHazardCounter, simulator.controlHazardCounter, simulator.cpi,
                                simulator.sf);
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridBagLayout()); // prevents components being stretched by BorderLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        sidePanel.add(sp, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        sidePanel.add(hp, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1; // last element in side panel needs weight for filling the side, thus placing it in the upper corner
        sidePanel.add(twoBitPredictorPanel, gbc);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(pp.getWidth()+300,pp.getHeight() + 10);
        this.setVisible(true);
        this.add(pp, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.WEST);
        this.setBounds(100,50,this.getWidth(),this.getHeight());
        this.setResizable(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}
