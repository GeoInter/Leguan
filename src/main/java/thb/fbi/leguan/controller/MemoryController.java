package thb.fbi.leguan.controller;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
import thb.fbi.leguan.simulation.Memory;
import thb.fbi.leguan.simulation.MemoryObserver;
import thb.fbi.leguan.utility.NumberComparator;

public class MemoryController implements MemoryObserver {

    @FXML TableView<Map.Entry<Long, Long>> memoryTable;
    @FXML TableColumn<Map.Entry<Long, Long>, String> addressColumn;
    @FXML TableColumn<Map.Entry<Long, Long>, String> contentColumn;

    @FXML TextField startAddressTextField;
    @FXML TextField endAddressTextField;

    @FXML Button DecValueButton;
    @FXML Button ASCIIValueButton;
    @FXML Button DecAddressButton;
    @FXML Button HexAddressButton;
    @FXML Button memoryByteButton;
    @FXML Button memoryDWordButton;

    private TreeMap<Long, Long> data = new TreeMap<Long, Long>();

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
        
        addressColumn.setComparator(new NumberComparator());
        addressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long, Long>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Map.Entry<Long, Long>, String> arg) {
                if(displayAddressAsHex) {
                    StringBuilder str = new StringBuilder(Long.toHexString(arg.getValue().getKey()).toUpperCase());
                    str.insert(0, "0x");
                    return new SimpleStringProperty(str.toString());
                } else {
                    return new SimpleStringProperty(arg.getValue().getKey().toString());
                }
            }
            
        });

        contentColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long, Long>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Entry<Long, Long>, String> arg) {
                if(displayValueAsASCII) {
                    long l = arg.getValue().getValue();
                    String s = "";
                    // for single byte
                    if(l <= 127 && l >= -128) {
                        byte b = (byte) l;
                        s = byteToString(b) + "";
                        return new SimpleStringProperty(s);
                    }

                    // for long (dword)
                    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
                    buffer.clear();
                    buffer.putLong(l);
                    byte[] array = buffer.array();
                    for (byte b : array) {
                        s += byteToString(b) + " ";
                    }
                    buffer.clear();
                    return new SimpleStringProperty(s);
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
     * gets a proper (ASCII) String from a byte
     * @param b byte to turn into String
     * @return escaped String for correct display of an ASCII char
     */
    private String byteToString(byte b) {
        char ch = (char) (b & 0xFF);
        String display = "";

        if(Character.isWhitespace(ch)) {
            switch(ch) {
                case '\r':
                    display = "\\r";  
                    break;  
                case '\t':  
                    display = "\\t";  
                    break;  
                case '\n':  
                    display = "\\n";  
                    break;  
                case '\f':  
                    display = "\\f";  
                    break;  
                case ' ':  
                    display = "[space]";  
                    break;  
                default:  
                    display = "[whitespace]";  
                    break;
            }

        } else if (Character.isISOControl(ch)) { // detect characters that are control chars
            display = "[control]";
        } else { // all other chars
            display = Character.toString(ch);
        }
        return display;
    }
    

    /**
     * when Memory changes, update the tableView
     * also applies filter - so that filter persist even when updated
     * @param newData new TreeMap from Memory
     */
    @Override
    public void update(TreeMap<Long, Byte> newData) {
        this.data.clear();
        for(Map.Entry<Long, Byte> entry : newData.entrySet()) {
            this.data.put(entry.getKey(), (long) entry.getValue());
        }
        updateTable();
    }

    /**
     * function called when filter button is pressed
     */
    @FXML
    public void filterButtonFired() {
        updateTable();
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
     * function called when DWord button is pressed
     */
    @FXML
    public void DWordButtonFired() {
        memoryByteButton.setDisable(false);
        memoryDWordButton.setDisable(true);
        displayMemoryAsDWord = true;
        updateTable();
    }

    /**
     * switches displayed memory entries to Byte
     */
    @FXML
    public void switchMemoryToByte() {
        memoryByteButton.setDisable(true);
        memoryDWordButton.setDisable(false);
        displayMemoryAsDWord = false;
        updateTable();
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
     * returns a filtered map depending on entered values in textfields (or the unfiltered parameter map)
     * can filter from only a start, only an end or an interval of both addresses
     * @param data map to be filtered
     * @return filtered map 
     */
    public TreeMap<Long, Long> getFilteredMap(TreeMap<Long, Long> data) {
        TreeMap<Long, Long> filteredData;
        if(startAddressTextField.getText().isBlank() && endAddressTextField.getText().isBlank()) {
            return data;
        } 
        else if(startAddressTextField.getText().isBlank()) {
            filteredData = data.entrySet().stream()
                .filter(map -> map.getKey() <= Long.parseLong(endAddressTextField.getText()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue(), Math::addExact, TreeMap::new));
        } else if(endAddressTextField.getText().isBlank()) {
            filteredData = data.entrySet().stream()
                .filter(map -> map.getKey() >= Long.parseLong(startAddressTextField.getText()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue(), Math::addExact, TreeMap::new));
        } else {
            filteredData = data.entrySet().stream()
                .filter(map -> map.getKey() >= Long.parseLong(startAddressTextField.getText()) && map.getKey() <= Long.parseLong(endAddressTextField.getText()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue(), Math::addExact, TreeMap::new));
        }
        return filteredData;
    }

    /**
     * returns a map with DWords (8 Byte) as its values
     * @param data map to turn into dword map
     * @return new dword map
     */
    public TreeMap<Long, Long> getDWordMap(TreeMap<Long, Long> data) {
        // get all used keys
        Set<Long> keys = data.keySet();
        // map available keys to multiple of 8 (address space of DWords)
        Set<Long> addressSet = new HashSet<Long>();
        for (Long addressTemp : keys) {
            addressSet.add((addressTemp / 8) * 8);
        }

        // build new HashMap from Dword address space
        TreeMap<Long, Long> dwordData = new TreeMap<>();
        for (Long address : addressSet) {
            dwordData.put(address, Memory.loadDWord(address));
        }
        return dwordData;
    }

    /**
     * update the tableview
     */
    private void updateTable() {
        TreeMap<Long, Long> newData = this.data;
        if(displayMemoryAsDWord) {
            newData = getDWordMap(newData);
        }
        newData = getFilteredMap(newData);
        
        ObservableList<Map.Entry<Long, Long>> items = FXCollections.observableArrayList(newData.entrySet());
        memoryTable.setItems(items);
    }
}
