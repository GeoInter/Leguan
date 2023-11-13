package thb.fbi.pipeline_visualizer.controller;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class CodePanel extends JPanel {

    private JTextArea codeTextArea;

    public CodePanel() {
        String initText = "No Code assembled";
        codeTextArea = new JTextArea(initText, 25, 1);
        codeTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(codeTextArea);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Assembly Code",
                TitledBorder.LEFT, TitledBorder.TOP));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(scrollPane);
    }

    public void updateCodeTextArea(String code) {
        codeTextArea.setText(code);
    }

}
