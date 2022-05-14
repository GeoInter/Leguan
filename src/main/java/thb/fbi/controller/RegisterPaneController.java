package thb.fbi.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import thb.fbi.simulation.Base;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;

/**
 * UI Controller for the Register Sidepanel
 */
public class RegisterPaneController {

    /** boolean if checkbox is checked to show all registers */
    public static SimpleBooleanProperty showAllRegisters = new SimpleBooleanProperty();

    @FXML VBox RegisterPane;
    @FXML Label register0Value;
    @FXML Label register1Value;
    @FXML Label register2Value;
    @FXML Label register3Value;

    @FXML Label NFlagValue;
    @FXML Label ZFlagValue;
    @FXML Label CFlagValue;
    @FXML Label VFlagValue;

    @FXML Button r0DecButton;
    @FXML Button r0BinButton;
    @FXML Button r0HexButton;
    @FXML Button r1DecButton;
    @FXML Button r1BinButton;
    @FXML Button r1HexButton;
    @FXML Button r2DecButton;
    @FXML Button r2BinButton;
    @FXML Button r2HexButton;
    @FXML Button r3DecButton;
    @FXML Button r3BinButton;
    @FXML Button r3HexButton;

    @FXML HBox r4Box;
    @FXML HBox r5Box;
    @FXML HBox r6Box;
    @FXML HBox r7Box;
    @FXML HBox r8Box;

    private Simulator simulator = SimulatorSingleton.getSimulator();

    /**
     * initializes all UI components and binds values of the register side pane
     */
    @FXML
    public void initialize() {
        register0Value.textProperty().bind(simulator.getRegisters()[0].getShownValue());
        register1Value.textProperty().bind(simulator.getRegisters()[1].getShownValue());
        register2Value.textProperty().bind(simulator.getRegisters()[2].getShownValue());
        register3Value.textProperty().bind(simulator.getRegisters()[3].getShownValue());

        // set On Action Event foreach Button
        // when Button clicked change register value to specified numberformat
        r0DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 0));
        r0BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 0));
        r0HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 0));
        r1DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 1));
        r1BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 1));
        r1HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 1));
        r2DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 2));
        r2BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 2));
        r2HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 2));
        r3DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 3));
        r3BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 3));
        r3HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 3));

        // bind value of flags to flag labels
        NFlagValue.textProperty().bind(simulator.getFlagRegister().getNFlagProperty().asString());
        ZFlagValue.textProperty().bind(simulator.getFlagRegister().getZFlagProperty().asString());
        CFlagValue.textProperty().bind(simulator.getFlagRegister().getCFlagProperty().asString());
        VFlagValue.textProperty().bind(simulator.getFlagRegister().getVFlagProperty().asString());

        /**** this are bindings for making the register boxes invisible ****/ 
        // make the boxes invisble so they do not appear when not used
        // make the boxes unmanaged so the sidepanel resizes making room for the rest
        r4Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[4].getIsUsed()));
        r4Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[4].getIsUsed()));
        r5Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[5].getIsUsed()));
        r5Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[5].getIsUsed()));
        r6Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[6].getIsUsed()));
        r6Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[6].getIsUsed()));
        r7Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[7].getIsUsed()));
        r7Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[7].getIsUsed()));
        r8Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[8].getIsUsed()));
        r8Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[8].getIsUsed()));
    }

    /**
     * 
     * @param format numberformat 
     * @param index index of the register in array 
     */
    private void UpdateRegisterValueFormat(Base format, int index) {
        simulator.UpdateRegisterValueFormat(format, index);
    }

    public Simulator getSimulator() {
        return simulator;
    }
    
}
