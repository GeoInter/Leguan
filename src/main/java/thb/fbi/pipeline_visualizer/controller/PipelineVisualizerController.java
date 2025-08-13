package thb.fbi.pipeline_visualizer.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.util.Callback;
import thb.fbi.leguan.data.ARMProgram;
import thb.fbi.pipeline_visualizer.pipeline.MFrame;
import thb.fbi.pipeline_visualizer.pipeline.PipelineSimulator;
import thb.fbi.pipeline_visualizer.predictor.TwoBitPrecitionEntry;

public class PipelineVisualizerController {

    private PipelineSimulator pipelineSimulator;
    private PipelinePanel pipelinePanel;

    @FXML
    SwingNode pipelineSwingNode;
    @FXML
    ChoiceBox<DisplayMode> modeChoiceBox;
    @FXML
    ChoiceBox<DataHazardOption> dataHazardOption;
    @FXML
    ChoiceBox<ControlHazardOption> controlHazardOption;

    @FXML
    TableView<Map.Entry<Long, TwoBitPrecitionEntry>> twoBitPredictorTable;
    @FXML
    TableColumn<Map.Entry<Integer, TwoBitPrecitionEntry>, String> codeColumn;
    @FXML
    TableColumn<Map.Entry<Integer, TwoBitPrecitionEntry>, String> predictionColumn;
    @FXML
    TableColumn<Map.Entry<Integer, TwoBitPrecitionEntry>, String> addressColumn;

    @FXML
    Label clockCycleCounter;
    @FXML
    Label instructionCounter;
    @FXML
    Label dataHazardCounter;
    @FXML
    Label controlHazardCounter;
    @FXML
    Label cpiValue;
    @FXML
    Label sfValue;
    @FXML
    TextArea codeTextArea;
    @FXML
    TitledPane twoBitPredictorPane;

    @FXML
    public void initialize() {
        pipelineSimulator = new PipelineSimulator();
        pipelinePanel = new PipelinePanel();

        modeChoiceBox.setItems(FXCollections.observableArrayList(DisplayMode.values()));
        modeChoiceBox.getSelectionModel().selectFirst();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MFrame frames[]= new MFrame[1];
                MFrame emptyFrame = new MFrame(false, false);
                frames[0] = emptyFrame;
                pipelinePanel.updateMFrames(frames);
                pipelineSwingNode.setContent(pipelinePanel);
            }
        });

        dataHazardOption.setItems(FXCollections.observableArrayList(DataHazardOption.values()));
        dataHazardOption.getSelectionModel().selectFirst();

        controlHazardOption.setItems(FXCollections.observableArrayList(ControlHazardOption.values()));
        controlHazardOption.getSelectionModel().selectFirst();

        codeColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, TwoBitPrecitionEntry>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Entry<Integer, TwoBitPrecitionEntry>, String> arg) {
                        return new SimpleStringProperty(arg.getValue().getValue().getCode());
                    }

                });
        predictionColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, TwoBitPrecitionEntry>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Entry<Integer, TwoBitPrecitionEntry>, String> arg) {
                        return new SimpleStringProperty(arg.getValue().getValue().getState().name());
                    }

                });
        addressColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, TwoBitPrecitionEntry>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Entry<Integer, TwoBitPrecitionEntry>, String> arg) {
                        return new SimpleStringProperty(arg.getValue().getValue().getTargetPC().toString());
                    }

                });
    }

    public void updateCode(ARMProgram program, String code) {
        pipelineSimulator.setProgram(program);
        MFrame frames[] = pipelineSimulator.execute();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pipelinePanel.updateMFrames(frames);
                clearTwoBitPredictorTable();

                updateStatistics();

                codeTextArea.setText(code);
            }
        });
    }

    /**
     * Update Overlay Mode for displaying values when hovering over the pipeline
     * view
     */
    public void updateMode() {
        switch (modeChoiceBox.getValue()) {
            case Decimal:
                pipelinePanel.setMode(1);
                break;
            case Binary:
                pipelinePanel.setMode(2);
                break;
            case Help:
                pipelinePanel.setMode(3);
                break;
        }
    }

    private void updateStatistics() {
        // this could be troublesome when called within the SwingUtilities function
        Platform.runLater(() -> {
            clockCycleCounter.setText(String.valueOf(pipelineSimulator.clockCycleCounter));
            instructionCounter.setText(String.valueOf(pipelineSimulator.instructionCounter));
            dataHazardCounter.setText(String.valueOf(pipelineSimulator.dataHazardCounter));
            controlHazardCounter.setText(String.valueOf(pipelineSimulator.controlHazardCounter));
            cpiValue.setText(String.format("%.2f", pipelineSimulator.cpi)); // display 2 decimal places
            sfValue.setText(String.format("%.2f", pipelineSimulator.sf)); // display 2 decimal places
        });
    }

    /**
     * steps forward to the next clock pulse
     */
    public void forwardClockPulse() {
        pipelinePanel.nextClockPulse();
        updateTwoBitPredictorTable(pipelinePanel.currentFrame.twoBitPredictionTable);
    }

    /**
     * steps backward to the previous clock pulse
     */
    public void backwardClockPulse() {
        pipelinePanel.previousClockPulse();
        updateTwoBitPredictorTable(pipelinePanel.currentFrame.twoBitPredictionTable);
    }

    /**
     * updates the 2 bit predictor table
     * 
     * @param table new table to be inserted
     */
    private void updateTwoBitPredictorTable(HashMap<Long, TwoBitPrecitionEntry> table) {
        ObservableList<Map.Entry<Long, TwoBitPrecitionEntry>> items = FXCollections
                .observableArrayList(table.entrySet());
        this.twoBitPredictorTable.setItems(items);
        this.twoBitPredictorTable.refresh();
    }

    /**
     * clear the predictor table
     */
    private void clearTwoBitPredictorTable() {
        twoBitPredictorTable.getItems().clear();
    }

    /**
     * updates the selected data hazard option
     */
    public void updateDataHazardOption() {
        MFrame frames[] = null;
        clearTwoBitPredictorTable();
        switch (dataHazardOption.getValue()) {
            case Forwarding:
                frames = pipelineSimulator.setForwardingEnabled(true);
                break;
            case Detect_Stall:
                frames = pipelineSimulator.setForwardingEnabled(false);
                break;
        }
        pipelinePanel.updateMFrames(frames);
        updateStatistics();
    }

    /**
     * updates the selected control hazard option
     */
    public void updateControlHazardOption() {
        MFrame frames[] = null;
        clearTwoBitPredictorTable();
        switch (controlHazardOption.getValue()) {
            case Predict_NotTaken:
                frames = pipelineSimulator.setIs2BitPredictorEnabled(false);
                twoBitPredictorPane.expandedProperty().set(false);
                break;
            case TwoBitPredictor:
                frames = pipelineSimulator.setIs2BitPredictorEnabled(true);
                twoBitPredictorPane.expandedProperty().set(true);
                break;
        }
        pipelinePanel.updateMFrames(frames);
        updateStatistics();
    }

}
