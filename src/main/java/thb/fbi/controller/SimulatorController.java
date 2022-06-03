package thb.fbi.controller;

import org.fxmisc.richtext.CodeArea;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.Memory;
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
    @FXML SplitPane splitPane;
    @FXML AnchorPane rightSideAnchorPane;
    @FXML TabPane tabPane;
    @FXML ScrollPane codeScrollPane;
    @FXML CodeArea codeArea;

    @FXML CheckBox showUnusedRegisterButton;

    Simulator simulator = SimulatorSingleton.getSimulator();

    @FXML
    public void initialize() {
        
        showUnusedRegisterButton.selectedProperty().bindBidirectional(RegisterPaneController.showAllRegisters);
        codeArea.prefHeightProperty().bind(codeScrollPane.heightProperty().subtract(10)); 
        codeArea.prefWidthProperty().bind(codeScrollPane.widthProperty().subtract(15)); // size of scrollbar

        // prevent rightside to resize (change divider position) when maximazing
        SplitPane.setResizableWithParent(rightSideAnchorPane, false);

    }

    @FXML
    private void runCode() {
        simulator.testMemory();
    }

    /**
     * resets the simulator including memory and flags
     */
    @FXML
    private void reset() {
        Memory.reset();
        FlagRegister.reset();
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