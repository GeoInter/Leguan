package thb.fbi.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;

/**
 * UI Controller of the app
 * includes all UI controls
 * 
 */
public class SimulatorController {

    @FXML RegisterPaneController registerPaneController;
    @FXML Parent registerPane;

    @FXML StackPane codeStackPane;

    @FXML CheckBox showUnusedRegisterButton;

    Simulator simulator = SimulatorSingleton.getSimulator();

    @FXML
    public void initialize() {
        
        showUnusedRegisterButton.selectedProperty().bindBidirectional(RegisterPaneController.showAllRegisters);
        // CodeArea codeArea = new CodeArea();
        // codeStackPane.getChildren().addAll(codeArea);
    }

    @FXML
    private void runCode() {
        simulator.testAdd();
    }

    @FXML
    private void reset() {
        simulator.testSub();
    }

    @FXML
    private void stepForward() {
        System.out.println("step forward");
    }

    @FXML
    private void stepBackward() {
        System.out.println("step backward");
    }    
}