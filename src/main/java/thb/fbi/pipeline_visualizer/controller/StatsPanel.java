package thb.fbi.pipeline_visualizer.controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class StatsPanel extends JPanel {

    // text Labels
    private JLabel clockCycleTextLabel;
    private JLabel instructionTextLabel;
    private JLabel dataHazardTextLabel;
    private JLabel controlHazardTextLabel;
    private JLabel cpiTextLabel;
    private JLabel sfTextLabel;

    // counter Labels
    private JLabel clockCycleCounterLabel;
    private JLabel instructionCounterLabel;
    private JLabel dataHazardCounterLabel;
    private JLabel controlHazardCounterLabel;
    private JLabel cpiLabel;
    private JLabel sfLabel;

    public StatsPanel() {
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Statistics",
                TitledBorder.LEFT, TitledBorder.TOP));

        // construct labels
        clockCycleTextLabel = new JLabel("Clock Cycles");
        instructionTextLabel = new JLabel("Ins Count");
        dataHazardTextLabel = new JLabel("Data Hazards");
        controlHazardTextLabel = new JLabel("Control Hazards");
        cpiTextLabel = new JLabel("CPI");
        sfTextLabel = new JLabel("SF");

        clockCycleCounterLabel = new JLabel("0");
        instructionCounterLabel = new JLabel("0");
        dataHazardCounterLabel = new JLabel("0");
        controlHazardCounterLabel = new JLabel("0");
        cpiLabel = new JLabel("0.00");
        sfLabel = new JLabel("0.00");

        // this.setBounds(1000, 0, 600, 800); // depends on PipelinePanel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(1, 1, 1, 5);
        c.anchor = GridBagConstraints.NORTHWEST;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(clockCycleTextLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(instructionTextLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        this.add(cpiTextLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        // TODO add Tooltips for Stat Labels
        this.add(clockCycleCounterLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(instructionCounterLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        this.add(cpiLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        this.add(dataHazardTextLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        this.add(controlHazardTextLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        this.add(sfTextLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        this.add(dataHazardCounterLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        this.add(controlHazardCounterLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        this.add(sfLabel, c);
    }

    public void updateStats(int clockCycleCount, int instructionCount, int dataHazardCount, int controlHazardCount,
            double cpi, double sf) {

        clockCycleCounterLabel.setText(String.valueOf(clockCycleCount));
        instructionCounterLabel.setText(String.valueOf(instructionCount));
        dataHazardCounterLabel.setText(String.valueOf(dataHazardCount));
        controlHazardCounterLabel.setText(String.valueOf(controlHazardCount));
        cpiLabel.setText(String.format("%.2f", cpi)); // display 2 decimal places
        sfLabel.setText(String.format("%.2f", sf)); // display 2 decimal places
    }

}
