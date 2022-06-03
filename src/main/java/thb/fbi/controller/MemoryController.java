package thb.fbi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import thb.fbi.simulation.Memory;
import thb.fbi.simulation.MemoryObserver;

public class MemoryController implements MemoryObserver {

    @FXML TableView<Map.Entry<Long, Byte>> memoryTable;
    @FXML TableColumn<Map.Entry<Long, Byte>, String> addressColumn;
    @FXML TableColumn<Map.Entry<Long, Byte>, String> contentColumn;

    @FXML TextField startAddressTextField;
    @FXML TextField endAddressTextField;

    @FXML Button ASCIIButton;
    @FXML Button DecButton;

    private Map<Long, Byte> data = new HashMap<Long, Byte>();

    /** specifies amount of digits allowed in textfield. 
     * If maximum is reached no new input will be accepted besides backspace. 
     * */
    private int maxLengthOfTextFields = 6;

    private boolean displayValueAsASCII = false;

    @FXML
    public void initialize() {
        
        addressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Map.Entry<Long, Byte>, String> arg) {
                return new SimpleStringProperty(arg.getValue().getKey().toString());
            }
            
        });

        contentColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Entry<Long, Byte>, String> arg) {
                if(displayValueAsASCII) {
                    char c = (char) arg.getValue().getValue().byteValue();
                    return new SimpleStringProperty(Character.toString(c));
                } else {
                    return new SimpleStringProperty(arg.getValue().getValue().toString());
                }
            }

        });

        // filter for allowing number input only
        UnaryOperator<Change> integerFilter = change -> {
            if(change.getControlNewText().length() <= maxLengthOfTextFields) {
                if(change.getText().matches("\\d*")) {
                    return change;
                } 
            }
            return null;
        };
        
        startAddressTextField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        endAddressTextField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        
        Memory.setObserver(this);
        
    }

    /**
     * when Memory changes, update the tableView
     * also applies filter - so that filter persist even when updated
     * @param data new HashMap from Memory
     */
    @Override
    public void update(HashMap<Long, Byte> data) {
        this.data = data;
        updateTable(data);
        filterMemoryTable();
    }

    /**
     * function called when filter button pressed
     */
    @FXML
    public void filterButtonFired() {
        filterMemoryTable();
    }

    /**
     * display content row as ASCII chars
     */
    @FXML
    public void switchToASCII() {
        displayValueAsASCII = true;
        ASCIIButton.setDisable(true);
        DecButton.setDisable(false);
        // force refresh so each cell is updated by cellValueFactory
        memoryTable.refresh();
    }

    /**
     * display content row as decimal numbers
     */
    @FXML
    public void switchToDec() {
        displayValueAsASCII = false;
        ASCIIButton.setDisable(false);
        DecButton.setDisable(true);
        // force refresh so each cell is updated by cellValueFactory
        memoryTable.refresh(); 
    }

    /**
     * filter table depending on entered value in textfields
     * 
     * can filter from only a start, only an end or an interval of both addresses
     */
    public void filterMemoryTable() {
        Map<Long, Byte> filteredData;
        if(startAddressTextField.getText().isBlank() && endAddressTextField.getText().isBlank()) {
            filteredData = data;
        } else if(startAddressTextField.getText().isBlank()) {
            filteredData = data.entrySet().stream()
                .filter(map -> map.getKey() <= Integer.parseInt(endAddressTextField.getText()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        } else if(endAddressTextField.getText().isBlank()) {
            filteredData = data.entrySet().stream()
                .filter(map -> map.getKey() >= Integer.parseInt(startAddressTextField.getText()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        } else {
            filteredData = data.entrySet().stream()
                .filter(map -> map.getKey() >= Integer.parseInt(startAddressTextField.getText()) && map.getKey() <= Integer.parseInt(endAddressTextField.getText()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        }
        updateTable(filteredData);
    }

    /**
     * update the tableview
     * @param data new hashmap to be inserted into the table
     */
    private void updateTable(Map<Long, Byte> data) {
        ObservableList<Map.Entry<Long, Byte>> items = FXCollections.observableArrayList(data.entrySet());
        memoryTable.setItems(items);
    }
    
}
