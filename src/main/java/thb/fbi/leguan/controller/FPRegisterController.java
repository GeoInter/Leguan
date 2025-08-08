package thb.fbi.leguan.controller;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import thb.fbi.leguan.simulation.Base;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.FPRegisterObserver;

public class FPRegisterController implements FPRegisterObserver {

    @FXML
    VBox registerBox;

    @FXML
    HBox spRegisterBox;

    @FXML
    Label spRegisterTitle;

    @FXML
    TextField spRegisterValue;

    @FXML
    Button spDecimalButton;

    @FXML
    Button spBinaryButton;

    @FXML
    Button spHexadecimalButton;

    @FXML
    Label dpRegisterTitle;

    @FXML
    TextField dpRegisterValue;

    @FXML
    ToggleButton toggleButton;

    @FXML
    Button dpDecimalButton;

    @FXML
    Button dpBinaryButton;

    @FXML
    Button dpHexadecimalButton;

    private FPRegister register;

    /*****
     * 
     * TODO: Highlight value changes
     * TODO: Fix BINARY too long for SP
     * 
     * 
     */

    @FXML
    public void initialize() {
        spRegisterBox.setManaged(false);
        spRegisterBox.setVisible(false);

        toggleButton.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (toggleButton.isSelected()) {
                spRegisterBox.setManaged(true);
                spRegisterBox.setVisible(true);
                toggleButton.setText("▲");
            } else {
                spRegisterBox.setManaged(false);
                spRegisterBox.setVisible(false);
                toggleButton.setText("▼");
            }
        });

        spRegisterValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    String valueString = spRegisterValue.getText();
                    float parsedValue = Float.parseFloat(valueString);
                    register.setSinlgePrecisionValue(parsedValue);
                } catch (NumberFormatException e) {
                    spRegisterValue.setText(register.getSinglePrecisionValueAsString());
                }
            }
        });

        dpRegisterValue.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    String valueString = dpRegisterValue.getText();
                    double parsedValue = Double.parseDouble(valueString);
                    register.setDoublePrecisionValue(parsedValue);
                } catch (NumberFormatException e) {
                    dpRegisterValue.setText(register.getDoublePrecisionValueAsString());
                }
            }
        });
    }

    /**
     * Adds a register and button to this Controller instance
     * 
     * binds value so it updates for every change and hides element when unused
     * 
     * @param register
     * @param showAllRegisters
     */
    public void setProperties(FPRegister register, BooleanProperty showAllRegisters, BooleanProperty displayUnsigned) {
        this.register = register;
        // set observer
        this.register.setObserver(this);

        registerBox.managedProperty().bind(register.getIsUsed().or(showAllRegisters));
        registerBox.visibleProperty().bind(register.getIsUsed().or(showAllRegisters));

        dpRegisterTitle.setText("DP" + register.getId());
        spRegisterTitle.setText("SP" + register.getId());
    }

    @Override
    public void update(String singlePrecisionValue, String doublePrecisionValue) {
        spRegisterValue.setText(singlePrecisionValue);
        dpRegisterValue.setText(doublePrecisionValue);
    }

    /**
     * updates displayed value to decimal format and deactivates the DEC button
     */
    @FXML
    private void updateDoublePrecisionToDecimal() {
        dpDecimalButton.setDisable(true);
        dpBinaryButton.setDisable(false);
        dpHexadecimalButton.setDisable(false);
        this.register.setDoublePrecisionNumberFormat(Base.DEC);
        this.dpRegisterValue.setText(this.register.getDoublePrecisionValueAsString());
    }

    @FXML
    private void updateSinglePrecisionToDecimal() {
        spDecimalButton.setDisable(true);
        spBinaryButton.setDisable(false);
        spHexadecimalButton.setDisable(false);
        this.register.setSinglePrecisionNumberFormat(Base.DEC);
        this.spRegisterValue.setText(this.register.getSinglePrecisionValueAsString());
    }

    /**
     * updates displayed value to binary format and deactivates the BIN button
     */
    @FXML
    private void updateDoublePrecisionToBinary() {
        dpDecimalButton.setDisable(false);
        dpBinaryButton.setDisable(true);
        dpHexadecimalButton.setDisable(false);
        this.register.setDoublePrecisionNumberFormat(Base.BIN);
        this.dpRegisterValue.setText(this.register.getDoublePrecisionValueAsString());
    }

    @FXML
    private void updateSinglePrecisionToBinary() {
        spDecimalButton.setDisable(false);
        spBinaryButton.setDisable(true);
        spHexadecimalButton.setDisable(false);
        this.register.setSinglePrecisionNumberFormat(Base.BIN);
        this.spRegisterValue.setText(this.register.getSinglePrecisionValueAsString());
    }

    /**
     * updates displayed value to hexadeciaml format and deactivates the HEX button
     */
    @FXML
    private void updateDoublePrecisionToHexadecimal() {
        dpDecimalButton.setDisable(false);
        dpBinaryButton.setDisable(false);
        dpHexadecimalButton.setDisable(true);
        this.register.setDoublePrecisionNumberFormat(Base.HEX);
        this.dpRegisterValue.setText(this.register.getDoublePrecisionValueAsString());
    }

    @FXML
    private void updateSinglePrecisionToHexadecimal() {
        spDecimalButton.setDisable(false);
        spBinaryButton.setDisable(false);
        spHexadecimalButton.setDisable(true);
        this.register.setSinglePrecisionNumberFormat(Base.HEX);
        this.spRegisterValue.setText(this.register.getSinglePrecisionValueAsString());
    }
}
