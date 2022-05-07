package thb.fbi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * UI Controller of the app
 * includes all UI controls
 * 
 * TODO: Spli up in more controller classes and fxml files
 */
public class SimulatorController {

    @FXML
    StackPane codeStackPane;
    @FXML
    Label register0Label;
    @FXML
    Label register1Label;
    @FXML
    Label register2Label;

    Simulator simulator = new Simulator();

    @FXML
    public void initialize() {
        register0Label.textProperty().bind(simulator.getRegisters()[0].getShownValue());
        register1Label.textProperty().bind(simulator.getRegisters()[1].getShownValue());
        register2Label.textProperty().bind(simulator.getRegisters()[2].getShownValue());

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

    @FXML
    private void reg0Hex() {
        UpdateRegisterValueFormat(Base.HEX, 0);
    }

    @FXML
    private void reg0Dec() {
        UpdateRegisterValueFormat(Base.DEC, 0);
    }

    @FXML
    private void reg0Bin() {
        UpdateRegisterValueFormat(Base.BIN, 0);
    }

    @FXML
    private void reg1Hex() {
        UpdateRegisterValueFormat(Base.HEX, 1);
    }

    @FXML
    private void reg1Dec() {
        UpdateRegisterValueFormat(Base.DEC, 1);
    }

    @FXML
    private void reg1Bin() {
        UpdateRegisterValueFormat(Base.BIN, 1);
    }

    @FXML
    private void reg2Hex() {
        UpdateRegisterValueFormat(Base.HEX, 2);
    }

    @FXML
    private void reg2Dec() {
        UpdateRegisterValueFormat(Base.DEC, 2);
    }

    @FXML
    private void reg2Bin() {
        UpdateRegisterValueFormat(Base.BIN, 2);
    }

    private void UpdateRegisterValueFormat(Base format, int index) {
        simulator.UpdateRegisterValueFormat(format, index);
    }
    
}