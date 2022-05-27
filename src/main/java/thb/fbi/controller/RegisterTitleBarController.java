package thb.fbi.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import thb.fbi.simulation.Base;
import thb.fbi.simulation.Register;

public class RegisterTitleBarController {

    private Register register;

    @FXML Label registerTitle;
    @FXML Label registerValue;
    @FXML Button decButton;
    @FXML Button binButton;
    @FXML Button hexButton;
    @FXML HBox registerBox;

    @FXML
    public void initialize() {
    
    }

    @FXML void setProperties(Register register, SimpleBooleanProperty showAllRegisters) {
        this.register = register;
        registerTitle.setText(register.getName());
        registerValue.textProperty().bind(register.getShownValue());
        registerBox.managedProperty().bind(register.getIsUsed().or(showAllRegisters));
        registerBox.visibleProperty().bind(register.getIsUsed().or(showAllRegisters));
    }

    @FXML
    private void updateToDec() { 
        register.setNumberFormat(Base.DEC);
        decButton.setDisable(true);
        binButton.setDisable(false);
        hexButton.setDisable(false);
    }

    @FXML
    private void updateToBin() { 
        register.setNumberFormat(Base.BIN);
        decButton.setDisable(false);
        binButton.setDisable(true);
        hexButton.setDisable(false);
    }

    @FXML
    private void updateToHex() { 
        register.setNumberFormat(Base.HEX);
        decButton.setDisable(false);
        binButton.setDisable(false);
        hexButton.setDisable(true);
    }
    
}
