package thb.fbi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
    @FXML TableColumn<Map.Entry<Long, Byte>, Long> addressColumn;
    @FXML TableColumn<Map.Entry<Long, Byte>, Byte> contentColumn;

    @FXML TextField startAddressTextField;
    @FXML TextField endAddressTextField;

    private Map<Long, Byte> data;

    @FXML
    public void initialize() {
        
        addressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, Long>, ObservableValue<Long>>() {

            @Override
            public ObservableValue<Long> call(CellDataFeatures<Map.Entry<Long, Byte>, Long> arg) {
                return new SimpleObjectProperty<Long>(arg.getValue().getKey());
            }
            
        });

        contentColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, Byte>, ObservableValue<Byte>>() {

            @Override
            public ObservableValue<Byte> call(CellDataFeatures<Entry<Long, Byte>, Byte> arg) {
                return new SimpleObjectProperty<Byte>(arg.getValue().getValue());
            }

        });

        // filter for allowing number input only
        UnaryOperator<Change> integerFilter = change -> {
            if(change.getText().matches("\\d*")) {
                return change;
            } 
            return null;
        };
        
        startAddressTextField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        endAddressTextField.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));
        
        Memory.setObserver(this);
        
    }

    /**
     * when Memory changes, update the tableView
     * @param data
     */
    @Override
    public void update(HashMap<Long, Byte> data) {
        this.data = data;
        updateTable(data);
    }

    /**
     * filter table depending on entered value in textfields
     * 
     * can filter from only a start, only an end or an interval of both addresses
     */
    @FXML
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

        System.out.println(filteredData.toString());
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
