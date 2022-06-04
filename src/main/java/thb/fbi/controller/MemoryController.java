package thb.fbi.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

    @FXML Button DecValueButton;
    @FXML Button ASCIIValueButton;
    @FXML Button DecAddressButton;
    @FXML Button HexAddressButton;
    @FXML Button memoryByteButton;
    @FXML Button memoryDWordButton;

    private Map<Long, Byte> data = new HashMap<Long, Byte>();

    /** specifies amount of digits allowed in textfield. 
     * If maximum is reached no new input will be accepted besides backspace. 
     * */
    private int maxLengthOfTextFields = 6;

    /** determines if values of memory should be displayed as ASCII chars */
    private boolean displayValueAsASCII = false;

    /** dertemines if address of memory should be displayed as hex values */
    private boolean displayAddressAsHex = false;

    /** dertemines if entries of memory should be displayed as double words (8 Byte) */
    private boolean displayMemoryAsDWord = false;

    @FXML
    public void initialize() {
        
        addressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Map.Entry<Long, Byte>, String> arg) {
                if(displayAddressAsHex) {
                    StringBuilder str = new StringBuilder(Long.toHexString(arg.getValue().getKey()).toUpperCase());
                    str.insert(0, "0x");
                    return new SimpleStringProperty(str.toString());
                } else {
                    return new SimpleStringProperty(arg.getValue().getKey().toString());
                }
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
     * switches displayed address to decimal values
     */
    @FXML
    public void switchAddressToDec() {
        displayAddressAsHex = false;
        HexAddressButton.setDisable(false);
        DecAddressButton.setDisable(true);
        // force refresh so each cell is updated by cellValueFactory
        memoryTable.refresh();
    }

    /**
     * switches displayed address to hex values
     */
    @FXML
    public void switchAddressToHex() {
        displayAddressAsHex = true;
        HexAddressButton.setDisable(true);
        DecAddressButton.setDisable(false);
        // force refresh so each cell is updated by cellValueFactory
        memoryTable.refresh();
    }

    /**
     * switches displayed memory entries to DWords (8 Byte)
     */
    @FXML
    public void switchMemoryToDWord() {
        memoryByteButton.setDisable(false);
        memoryDWordButton.setDisable(true);
        // get all used keys
        Set<Long> keys = data.keySet();

        // map available keys to multiple of 8 (address space of DWords)
        Set<Long> addressSet = new HashSet<Long>();
        for (Long addressTemp : keys) {
            addressSet.add((addressTemp / 8) * 8);
        }

        // build new HashMap from Dword address space
        Map<Long, Long> dwordData = new HashMap<>();
        for (Long address : addressSet) {
            dwordData.put(address, Memory.loadDWord(address));
        }
        displayMemoryAsDWord = true;
        // update UI
    }

    /**
     * switches displayed memory entries to Byte
     */
    @FXML
    public void switchMemoryToByte() {
        memoryByteButton.setDisable(true);
        memoryDWordButton.setDisable(false);
        displayMemoryAsDWord = false;
        // update UI
    }

    /**
     * display content row as ASCII chars
     */
    @FXML
    public void switchValueToASCII() {
        displayValueAsASCII = true;
        ASCIIValueButton.setDisable(true);
        DecValueButton.setDisable(false);
        // force refresh so each cell is updated by cellValueFactory
        memoryTable.refresh();
    }

    /**
     * display content row as decimal numbers
     */
    @FXML
    public void switchValueToDec() {
        displayValueAsASCII = false;
        ASCIIValueButton.setDisable(false);
        DecValueButton.setDisable(true);
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
