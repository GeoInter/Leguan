package thb.fbi.pipeline_visualizer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        this.add(comboBox);

        JButton nBtn = new JButton("Next Clock Pulse >");
        nBtn.setBounds(20, 480, 140, 30);
        nBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pipelinePanel.nextClockPulse();
            }
            
        });
        this.add(nBtn);

        JButton pBtn = new JButton("< Previous Clock Pulse");
        pBtn.setBounds(20, 520, 140, 30);
        pBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pipelinePanel.previousClockPulse();
            }
            
        });
        this.add(pBtn);


        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(modeLabel);
        this.add(comboBox);
        this.add(nBtn);
        this.add(pBtn);
    }
    
}
