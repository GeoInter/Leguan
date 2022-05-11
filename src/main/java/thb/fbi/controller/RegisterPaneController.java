package thb.fbi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import thb.fbi.simulation.Base;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorFactory;

/**
 * UI Controller for the Register Sidepanel
 */
public class RegisterPaneController {

    @FXML VBox RegisterPane;
    @FXML Label register0Value;
    @FXML Label register1Value;
    @FXML Label register2Value;

    @FXML Button r1DecButton;
    @FXML Button r1BinButton;
    @FXML Button r1HexButton;

    private Simulator simulator = SimulatorFactory.getSimulator();

    @FXML
    public void initialize() {
        register0Value.textProperty().bind(simulator.getRegisters()[0].getShownValue());
        register1Value.textProperty().bind(simulator.getRegisters()[1].getShownValue());
        register2Value.textProperty().bind(simulator.getRegisters()[2].getShownValue());

        // set On Action Event foreach Button
        // when Button clicked change register value to specified numberformat
        r1DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 1));
        r1BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 1));
        r1HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 1));
    }

    private void UpdateRegisterValueFormat(Base format, int index) {
        simulator.UpdateRegisterValueFormat(format, index);
    }

    public Simulator getSimulator() {
        return simulator;
    }
    
}
