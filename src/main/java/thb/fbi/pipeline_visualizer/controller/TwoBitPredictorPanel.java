package thb.fbi.pipeline_visualizer.controller;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import thb.fbi.pipeline_visualizer.pipeline.TwoBitPrecitionEntry;

public class TwoBitPredictorPanel extends JPanel {

    private JCheckBox showTableCheckBox;
    private JTable predictionTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Code", "Prediction", "Target Address"};

    public TwoBitPredictorPanel() {
        showTableCheckBox = new JCheckBox("show predictor table");
        showTableCheckBox.setSelected(true);
        showTableCheckBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                scrollPane.setVisible(e.getStateChange() == 1);
                System.out.println(scrollPane.isVisible());
            }
            
        });

        predictionTable = new JTable(null, columnNames);
        predictionTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
        predictionTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(predictionTable);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "2 Bit Predictor Table",
                TitledBorder.LEFT, TitledBorder.TOP));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(showTableCheckBox);
        this.add(scrollPane);
    }

    public void update(HashMap<Integer, TwoBitPrecitionEntry> twoBitPredictionTable) {
        Object[][] dataTable = new Object[twoBitPredictionTable.size()][];
        int tableIndex = 0;
        for (Integer index : twoBitPredictionTable.keySet()) {
            TwoBitPrecitionEntry entry = twoBitPredictionTable.get(index);
            Object[] dataEntry = new Object[3];
            dataEntry[0] = entry.getCode();
            dataEntry[1] = entry.getState().toString();
            dataEntry[2] = entry.getTargetPC();
            dataTable[tableIndex++] = dataEntry;
        }
        DefaultTableModel updatedModel = new DefaultTableModel(dataTable, columnNames);
        predictionTable.setModel(updatedModel);
    }

    public void clearTable() {
        DefaultTableModel updatedModel = new DefaultTableModel(null, columnNames);
        predictionTable.setModel(updatedModel);
    }
    
}
