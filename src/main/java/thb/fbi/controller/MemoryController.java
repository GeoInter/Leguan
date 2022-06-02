package thb.fbi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import thb.fbi.simulation.Memory;
import thb.fbi.simulation.MemoryObserver;

public class MemoryController implements MemoryObserver {



    @FXML TableView<Map.Entry<Long, Byte>> memoryTable;
    @FXML TableColumn<Map.Entry<Long, Byte>, Long> addressColumn;
    @FXML TableColumn<Map.Entry<Long, Byte>, Byte> contentColumn;

    @FXML
    public void initialize() {
        
        addressColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, Long>, ObservableValue<Long>>() {

            @Override
            public ObservableValue<Long> call(CellDataFeatures<Map.Entry<Long, Byte>, Long> arg) {
                // this callback returns property for just one cell, you can't use a loop here
                // for first column we use key
                return new SimpleObjectProperty<Long>(arg.getValue().getKey());
            }
            
        });

        contentColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Long,Byte>, Byte>, ObservableValue<Byte>>() {

            @Override
            public ObservableValue<Byte> call(CellDataFeatures<Entry<Long, Byte>, Byte> arg) {
                // TODO Auto-generated method stub
                return new SimpleObjectProperty<Byte>(arg.getValue().getValue());
            }

        });
        
        Memory.setObserver(this);
        
    }

    @Override
    public void update(HashMap<Long, Byte> data) {
        ObservableList<Map.Entry<Long, Byte>> items = FXCollections.observableArrayList(data.entrySet());
        memoryTable.setItems(items);
    }
    
}
