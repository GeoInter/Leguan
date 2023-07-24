package thb.fbi.pipeline_visualizer.controller;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import thb.fbi.pipeline_visualizer.pipeline.TwoBitPrecitionEntry;

public class TwoBitPredictorPanel extends JPanel {

    private JTable predictionTable;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Code", "Prediction", "Target Address"};

    public TwoBitPredictorPanel() {
        predictionTable = new JTable(null, columnNames);
        scrollPane = new JScrollPane(predictionTable);
        predictionTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
        predictionTable.setFillsViewportHeight(true);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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
