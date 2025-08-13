package thb.fbi.leguan.controller;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import thb.fbi.leguan.simulation.Base;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.IntegerRegister;

/**
 * controller class for a register bar
 * 
 * controls only one specified register
 * register needs to be set seperate/ outside of this controller
 */
public class IntegerRegisterController extends RegisterController {

    /** register to associate to this UI element */
    private IntegerRegister register;

    private BooleanProperty displayUnsigned;

    @FXML
    Label registerTitle;
    @FXML
    TextField registerValue;
    @FXML
    Button decButton;
    @FXML
    Button binButton;
    @FXML
    Button hexButton;
    @FXML
    HBox registerBox;

    @FXML
    public void initialize() {
        registerValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    String valueString = registerValue.getText();
                    valueString = valueString.replace(".", "");

                    long parsedValue = Long.parseLong(valueString);
                    register.setValue(parsedValue);
                } catch (NumberFormatException e) {
                    registerValue.setText("0");
                }
            }
        });
    }

    /**
     * Adds an always visible register to this Controller
     * 
     * @param register
     */
    public void setProperties(PCRegister register, BooleanProperty displayUnsigned) {
        this.register = register;
        registerTitle.setText(register.getName());
        addShownValueObserver();
        setDisplayUnsigned(displayUnsigned);
        updateToHex(); // force update in UI
    }

    /**
     * Adds a register and button to this Controller instance
     * 
     * binds value so it updates for every change and hides element when unused
     * 
     * @param register
     * @param showAllRegisters
     */
    public void setProperties(IntegerRegister register, BooleanProperty showAllRegisters,
            BooleanProperty displayUnsigned) {
        this.register = register;
        registerTitle.setText(register.getName());
        addShownValueObserver();
        registerBox.managedProperty().bind(register.getIsUsed().or(showAllRegisters));
        registerBox.visibleProperty().bind(register.getIsUsed().or(showAllRegisters));
        setDisplayUnsigned(displayUnsigned);
    }

    /**
     * adds an observer to change UI
     * listens to shownValue of register
     * uses Platform.runLater for threading
     */
    public void addShownValueObserver() {
        register.getShownValue().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Platform.runLater(() -> {
                    registerValue.setText(register.getShownValue().get());
                });
            }

        });
    }

    @Override
    public void setHighlighting() {
        registerValue.setId("highlight-value");
    }
    
    @Override
    public void clearHighlighting() {
        registerValue.setId(null);
    }

    private void setDisplayUnsigned(BooleanProperty displayUnsigned) {
        this.displayUnsigned = displayUnsigned;
        displayUnsigned.addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldState, Boolean newState) {
                if (newState && register.getNumberFormat() == Base.DEC) {
                    register.setNumberFormat(Base.uDEC);
                } else if ((!newState) && register.getNumberFormat() == Base.uDEC) {
                    register.setNumberFormat(Base.DEC);
                }
            }

        });
    }

    /**
     * updates displayed value to decimal format and deactivates the DEC button
     */
    @FXML
    private void updateToDec() {
        if (displayUnsigned.get() == true) {
            register.setNumberFormat(Base.uDEC);
        } else {
            register.setNumberFormat(Base.DEC);
        }
        decButton.setDisable(true);
        binButton.setDisable(false);
        hexButton.setDisable(false);
    }

    /**
     * updates displayed value to binary format and deactivates the BIN button
     */
    @FXML
    private void updateToBin() {
        register.setNumberFormat(Base.BIN);
        decButton.setDisable(false);
        binButton.setDisable(true);
        hexButton.setDisable(false);
    }

    /**
     * updates displayed value to hexadeciaml format and deactivates the HEX button
     */
    @FXML
    private void updateToHex() {
        register.setNumberFormat(Base.HEX);
        decButton.setDisable(false);
        binButton.setDisable(false);
        hexButton.setDisable(true);
    }

}
