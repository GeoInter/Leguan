package thb.fbi.pipeline_visualizer.controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;

public class TopBarPanel extends JPanel {

    private PipelinePanel pipelinePanel;
    private String comboText[] = { " Decimal", " Binary", " Help" };

    public TopBarPanel(PipelinePanel pipelinePanel) {
        this.pipelinePanel = pipelinePanel;

        JLabel modeLabel = new JLabel("Mode");

        JComboBox<String> comboBox = new JComboBox<String>(comboText);
        comboBox.setBounds(79, 560, 80, 30);
        comboBox.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            pipelinePanel.setMode(comboBox.getSelectedIndex() + 1);
                        }
                    }
                });

        JButton nBtn = new JButton("Next Clock Pulse >");
        nBtn.setBounds(20, 480, 140, 30);
        nBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pipelinePanel.nextClockPulse();
            }
            
        });

        JButton pBtn = new JButton("< Previous Clock Pulse");
        pBtn.setBounds(20, 520, 140, 30);
        pBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pipelinePanel.previousClockPulse();
            }
            
        });

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 1, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        this.add(modeLabel, c);
        c.insets = new Insets(5, 1, 5, 15);
        c.gridx = 1;
        c.gridy = 0;
        this.add(comboBox, c);
        c.insets = new Insets(5, 1, 5, 5);
        c.gridx = 2;
        c.gridy = 0;
        this.add(pBtn, c);
        c.gridx = 3;
        c.gridy = 0;
        this.add(nBtn, c);
    }
    
}
