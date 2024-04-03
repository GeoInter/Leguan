package thb.fbi.leguan.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.FlagRegister;
import thb.fbi.leguan.simulation.FlagRegisterObserver;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;

/**
 * UI Controller for the Register Sidepanel
 */
public class RegisterPaneController implements FlagRegisterObserver {

    @FXML
    VBox RegisterPane;
    @FXML 
    HBox flagRegisterPane;

    @FXML
    RegisterTitleBarController pcController;
    @FXML
    RegisterTitleBarController r0Controller;
    @FXML
    RegisterTitleBarController r1Controller;
    @FXML
    RegisterTitleBarController r2Controller;
    @FXML
    RegisterTitleBarController r3Controller;
    @FXML
    RegisterTitleBarController r4Controller;
    @FXML
    RegisterTitleBarController r5Controller;
    @FXML
    RegisterTitleBarController r6Controller;
    @FXML
    RegisterTitleBarController r7Controller;
    @FXML
    RegisterTitleBarController r8Controller;

    @FXML
    RegisterTitleBarController r9Controller;
    @FXML
    RegisterTitleBarController r10Controller;
    @FXML
    RegisterTitleBarController r11Controller;
    @FXML
    RegisterTitleBarController r12Controller;
    @FXML
    RegisterTitleBarController r13Controller;
    @FXML
    RegisterTitleBarController r14Controller;
    @FXML
    RegisterTitleBarController r15Controller;
    @FXML
    RegisterTitleBarController r16Controller;
    @FXML
    RegisterTitleBarController r17Controller;
    @FXML
    RegisterTitleBarController r18Controller;

    @FXML
    RegisterTitleBarController r19Controller;
    @FXML
    RegisterTitleBarController r20Controller;
    @FXML
    RegisterTitleBarController r21Controller;
    @FXML
    RegisterTitleBarController r22Controller;
    @FXML
    RegisterTitleBarController r23Controller;
    @FXML
    RegisterTitleBarController r24Controller;
    @FXML
    RegisterTitleBarController r25Controller;
    @FXML
    RegisterTitleBarController r26Controller;
    @FXML
    RegisterTitleBarController r27Controller;

    @FXML
    RegisterTitleBarController r28Controller;
    @FXML
    RegisterTitleBarController r29Controller;
    @FXML
    RegisterTitleBarController r30Controller;
    @FXML
    RegisterTitleBarController r31Controller;

    @FXML
    ToggleButton NFlagValue;
    @FXML
    ToggleButton ZFlagValue;
    @FXML
    ToggleButton CFlagValue;
    @FXML
    ToggleButton VFlagValue;
    @FXML
    Label NFlagNameLabel;
    @FXML
    Label ZFlagNameLabel;
    @FXML
    Label CFlagNameLabel;
    @FXML
    Label VFlagNameLabel;

    @FXML
    CheckBox showUnusedRegisterCheckBox;
    @FXML
    CheckBox displayUnsignedCheckBox;

    private Simulator simulator = SimulatorSingleton.getSimulator();
    private List<RegisterTitleBarController> registerControllerList = new ArrayList<RegisterTitleBarController>();

    /**
     * initializes all UI components and binds values of the register side pane
     */
    @FXML
    public void initialize() {

        BooleanProperty showAllRegisters = showUnusedRegisterCheckBox.selectedProperty();
        BooleanProperty displayUnsigned = displayUnsignedCheckBox.selectedProperty();

        pcController.setProperties(simulator.getPC(), displayUnsigned);
        r0Controller.setProperties(simulator.getRegisters()[0], showAllRegisters, displayUnsigned);
        r1Controller.setProperties(simulator.getRegisters()[1], showAllRegisters, displayUnsigned);
        r2Controller.setProperties(simulator.getRegisters()[2], showAllRegisters, displayUnsigned);
        r3Controller.setProperties(simulator.getRegisters()[3], showAllRegisters, displayUnsigned);
        r4Controller.setProperties(simulator.getRegisters()[4], showAllRegisters, displayUnsigned);
        r5Controller.setProperties(simulator.getRegisters()[5], showAllRegisters, displayUnsigned);
        r6Controller.setProperties(simulator.getRegisters()[6], showAllRegisters, displayUnsigned);
        r7Controller.setProperties(simulator.getRegisters()[7], showAllRegisters, displayUnsigned);
        r8Controller.setProperties(simulator.getRegisters()[8], showAllRegisters, displayUnsigned);

        r9Controller.setProperties(simulator.getRegisters()[9], showAllRegisters, displayUnsigned);
        r10Controller.setProperties(simulator.getRegisters()[10], showAllRegisters, displayUnsigned);
        r11Controller.setProperties(simulator.getRegisters()[11], showAllRegisters, displayUnsigned);
        r12Controller.setProperties(simulator.getRegisters()[12], showAllRegisters, displayUnsigned);
        r13Controller.setProperties(simulator.getRegisters()[13], showAllRegisters, displayUnsigned);
        r14Controller.setProperties(simulator.getRegisters()[14], showAllRegisters, displayUnsigned);
        r15Controller.setProperties(simulator.getRegisters()[15], showAllRegisters, displayUnsigned);
        r16Controller.setProperties(simulator.getRegisters()[16], showAllRegisters, displayUnsigned);
        r17Controller.setProperties(simulator.getRegisters()[17], showAllRegisters, displayUnsigned);
        r18Controller.setProperties(simulator.getRegisters()[18], showAllRegisters, displayUnsigned);

        r19Controller.setProperties(simulator.getRegisters()[19], showAllRegisters, displayUnsigned);
        r20Controller.setProperties(simulator.getRegisters()[20], showAllRegisters, displayUnsigned);
        r21Controller.setProperties(simulator.getRegisters()[21], showAllRegisters, displayUnsigned);
        r22Controller.setProperties(simulator.getRegisters()[22], showAllRegisters, displayUnsigned);
        r23Controller.setProperties(simulator.getRegisters()[23], showAllRegisters, displayUnsigned);
        r24Controller.setProperties(simulator.getRegisters()[24], showAllRegisters, displayUnsigned);
        r25Controller.setProperties(simulator.getRegisters()[25], showAllRegisters, displayUnsigned);
        r26Controller.setProperties(simulator.getRegisters()[26], showAllRegisters, displayUnsigned);
        r27Controller.setProperties(simulator.getRegisters()[27], showAllRegisters, displayUnsigned);

        r28Controller.setProperties(simulator.getRegisters()[28], showAllRegisters, displayUnsigned);
        r29Controller.setProperties(simulator.getRegisters()[29], showAllRegisters, displayUnsigned);
        r30Controller.setProperties(simulator.getRegisters()[30], showAllRegisters, displayUnsigned);
        r31Controller.setProperties(simulator.getRegisters()[31], showAllRegisters, displayUnsigned);

        registerControllerList.add(r0Controller);
        registerControllerList.add(r1Controller);
        registerControllerList.add(r2Controller);
        registerControllerList.add(r3Controller);
        registerControllerList.add(r4Controller);
        registerControllerList.add(r5Controller);
        registerControllerList.add(r6Controller);
        registerControllerList.add(r7Controller);
        registerControllerList.add(r8Controller);
        registerControllerList.add(r9Controller);
        registerControllerList.add(r10Controller);
        registerControllerList.add(r11Controller);
        registerControllerList.add(r12Controller);
        registerControllerList.add(r13Controller);
        registerControllerList.add(r14Controller);
        registerControllerList.add(r15Controller);
        registerControllerList.add(r16Controller);
        registerControllerList.add(r17Controller);
        registerControllerList.add(r18Controller);
        registerControllerList.add(r19Controller);
        registerControllerList.add(r20Controller);
        registerControllerList.add(r21Controller);
        registerControllerList.add(r22Controller);
        registerControllerList.add(r23Controller);
        registerControllerList.add(r24Controller);
        registerControllerList.add(r25Controller);
        registerControllerList.add(r26Controller);
        registerControllerList.add(r27Controller);
        registerControllerList.add(r28Controller);
        registerControllerList.add(r29Controller);
        registerControllerList.add(r30Controller);
        registerControllerList.add(r31Controller);

        CFlagValue.setText("0");
        NFlagValue.setText("0");
        VFlagValue.setText("0");
        ZFlagValue.setText("0");

        CFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setCFlag(newValue);
            if(newValue) {
                CFlagValue.setText("1");
            } else {
                CFlagValue.setText("0");
            }
        });
        NFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setNFlag(newValue);
            if(newValue) {
                NFlagValue.setText("1");
            } else {
                NFlagValue.setText("0");
            }
        });
        VFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setVFlag(newValue);
            if(newValue) {
                VFlagValue.setText("1");
            } else {
                VFlagValue.setText("0");
            }
        });
        ZFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setZFlag(newValue);
            if(newValue) {
                ZFlagValue.setText("1");
            } else {
                ZFlagValue.setText("0");
            }
        });

        Instruction.setRegisterPaneController(this);
        FlagRegister.setObserver(this);
    }

    @Override
    public void update(boolean n, boolean z, boolean c, boolean v) {
        Platform.runLater(() -> {
            if (n) {
                NFlagValue.setText("1");
            } else {
                NFlagValue.setText("0");
            }
            NFlagValue.selectedProperty().set(n);

            if (z) {
                ZFlagValue.setText("1");
            } else {
                ZFlagValue.setText("0");
            }
            ZFlagValue.selectedProperty().set(z);

            if (c) {
                CFlagValue.setText("1");
            } else {
                CFlagValue.setText("0");
            }
            CFlagValue.selectedProperty().set(c);

            if (v) {
                VFlagValue.setText("1");
            } else {
                VFlagValue.setText("0");
            }
            VFlagValue.selectedProperty().set(v);

            flagRegisterPane.setId("highlight-value");
        });
    }

    public void clearFlagHighlighting() {
        Platform.runLater(() -> {
            flagRegisterPane.setId(null);
        });
    }

    /**
     * Set highlighting for a specific register
     * 
     * @param index ID of register to highlight
     */
    public void updateRegisterHighlighting(int index) {
        Platform.runLater(() -> {
            for (int i = 0; i < registerControllerList.size(); i++) {
                if (i == index) {
                    registerControllerList.get(i).registerValue.setId("highlight-value");
                } else {
                    registerControllerList.get(i).registerValue.setId(null);
                }
            }
        });
    }

    /**
     * undo highlighting for all registers
     */
    public void clearRegisterHighlighting() {
        for (RegisterTitleBarController controller : registerControllerList) {
            controller.clearHighlighting();
        }
    }

    public Simulator getSimulator() {
        return simulator;
    }

}
