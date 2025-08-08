package thb.fbi.leguan.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import thb.fbi.leguan.simulation.FlagRegister;
import thb.fbi.leguan.simulation.FlagRegisterObserver;
import thb.fbi.leguan.simulation.RegisterFile;
import thb.fbi.leguan.simulation.Simulator;

/**
 * UI Controller for the Register Sidepanel
 */
public class RegisterPaneController implements FlagRegisterObserver {

    @FXML
    VBox RegisterPane;
    @FXML 
    HBox flagRegisterPane;

    @FXML
    IntegerRegisterController pcController;
    @FXML
    IntegerRegisterController r0Controller;
    @FXML
    IntegerRegisterController r1Controller;
    @FXML
    IntegerRegisterController r2Controller;
    @FXML
    IntegerRegisterController r3Controller;
    @FXML
    IntegerRegisterController r4Controller;
    @FXML
    IntegerRegisterController r5Controller;
    @FXML
    IntegerRegisterController r6Controller;
    @FXML
    IntegerRegisterController r7Controller;
    @FXML
    IntegerRegisterController r8Controller;

    @FXML
    IntegerRegisterController r9Controller;
    @FXML
    IntegerRegisterController r10Controller;
    @FXML
    IntegerRegisterController r11Controller;
    @FXML
    IntegerRegisterController r12Controller;
    @FXML
    IntegerRegisterController r13Controller;
    @FXML
    IntegerRegisterController r14Controller;
    @FXML
    IntegerRegisterController r15Controller;
    @FXML
    IntegerRegisterController r16Controller;
    @FXML
    IntegerRegisterController r17Controller;
    @FXML
    IntegerRegisterController r18Controller;

    @FXML
    IntegerRegisterController r19Controller;
    @FXML
    IntegerRegisterController r20Controller;
    @FXML
    IntegerRegisterController r21Controller;
    @FXML
    IntegerRegisterController r22Controller;
    @FXML
    IntegerRegisterController r23Controller;
    @FXML
    IntegerRegisterController r24Controller;
    @FXML
    IntegerRegisterController r25Controller;
    @FXML
    IntegerRegisterController r26Controller;
    @FXML
    IntegerRegisterController r27Controller;

    @FXML
    IntegerRegisterController r28Controller;
    @FXML
    IntegerRegisterController r29Controller;
    @FXML
    IntegerRegisterController r30Controller;
    @FXML
    IntegerRegisterController r31Controller;

    @FXML 
    FPRegisterController fp0Controller;
    @FXML 
    FPRegisterController fp1Controller;
    @FXML 
    FPRegisterController fp2Controller;
    @FXML 
    FPRegisterController fp3Controller;
    @FXML 
    FPRegisterController fp4Controller;
    @FXML 
    FPRegisterController fp5Controller;
    @FXML 
    FPRegisterController fp6Controller;
    @FXML 
    FPRegisterController fp7Controller;
    @FXML 
    FPRegisterController fp8Controller;
    @FXML 
    FPRegisterController fp9Controller;
    @FXML 
    FPRegisterController fp10Controller;
    @FXML 
    FPRegisterController fp11Controller;
    @FXML 
    FPRegisterController fp12Controller;
    @FXML 
    FPRegisterController fp13Controller;
    @FXML 
    FPRegisterController fp14Controller;
    @FXML 
    FPRegisterController fp15Controller;
    @FXML 
    FPRegisterController fp16Controller;
    @FXML 
    FPRegisterController fp17Controller;
    @FXML 
    FPRegisterController fp18Controller;
    @FXML 
    FPRegisterController fp19Controller;
    @FXML 
    FPRegisterController fp20Controller;
    @FXML 
    FPRegisterController fp21Controller;
    @FXML 
    FPRegisterController fp22Controller;
    @FXML 
    FPRegisterController fp23Controller;
    @FXML 
    FPRegisterController fp24Controller;
    @FXML 
    FPRegisterController fp25Controller;
    @FXML 
    FPRegisterController fp26Controller;
    @FXML 
    FPRegisterController fp27Controller;
    @FXML 
    FPRegisterController fp28Controller;
    @FXML 
    FPRegisterController fp29Controller;
    @FXML 
    FPRegisterController fp30Controller;
    @FXML 
    FPRegisterController fp31Controller;

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

    private List<IntegerRegisterController> registerControllerList = new ArrayList<IntegerRegisterController>();

    /**
     * initializes all UI components and binds values of the register side pane
     */
    @FXML
    public void initialize() {

        BooleanProperty showAllRegisters = showUnusedRegisterCheckBox.selectedProperty();
        BooleanProperty displayUnsigned = displayUnsignedCheckBox.selectedProperty();

        pcController.setProperties(RegisterFile.getPC(), displayUnsigned);
        r0Controller.setProperties(RegisterFile.getIntegerRegisters()[0], showAllRegisters, displayUnsigned);
        r1Controller.setProperties(RegisterFile.getIntegerRegisters()[1], showAllRegisters, displayUnsigned);
        r2Controller.setProperties(RegisterFile.getIntegerRegisters()[2], showAllRegisters, displayUnsigned);
        r3Controller.setProperties(RegisterFile.getIntegerRegisters()[3], showAllRegisters, displayUnsigned);
        r4Controller.setProperties(RegisterFile.getIntegerRegisters()[4], showAllRegisters, displayUnsigned);
        r5Controller.setProperties(RegisterFile.getIntegerRegisters()[5], showAllRegisters, displayUnsigned);
        r6Controller.setProperties(RegisterFile.getIntegerRegisters()[6], showAllRegisters, displayUnsigned);
        r7Controller.setProperties(RegisterFile.getIntegerRegisters()[7], showAllRegisters, displayUnsigned);
        r8Controller.setProperties(RegisterFile.getIntegerRegisters()[8], showAllRegisters, displayUnsigned);

        r9Controller.setProperties(RegisterFile.getIntegerRegisters()[9], showAllRegisters, displayUnsigned);
        r10Controller.setProperties(RegisterFile.getIntegerRegisters()[10], showAllRegisters, displayUnsigned);
        r11Controller.setProperties(RegisterFile.getIntegerRegisters()[11], showAllRegisters, displayUnsigned);
        r12Controller.setProperties(RegisterFile.getIntegerRegisters()[12], showAllRegisters, displayUnsigned);
        r13Controller.setProperties(RegisterFile.getIntegerRegisters()[13], showAllRegisters, displayUnsigned);
        r14Controller.setProperties(RegisterFile.getIntegerRegisters()[14], showAllRegisters, displayUnsigned);
        r15Controller.setProperties(RegisterFile.getIntegerRegisters()[15], showAllRegisters, displayUnsigned);
        r16Controller.setProperties(RegisterFile.getIntegerRegisters()[16], showAllRegisters, displayUnsigned);
        r17Controller.setProperties(RegisterFile.getIntegerRegisters()[17], showAllRegisters, displayUnsigned);
        r18Controller.setProperties(RegisterFile.getIntegerRegisters()[18], showAllRegisters, displayUnsigned);

        r19Controller.setProperties(RegisterFile.getIntegerRegisters()[19], showAllRegisters, displayUnsigned);
        r20Controller.setProperties(RegisterFile.getIntegerRegisters()[20], showAllRegisters, displayUnsigned);
        r21Controller.setProperties(RegisterFile.getIntegerRegisters()[21], showAllRegisters, displayUnsigned);
        r22Controller.setProperties(RegisterFile.getIntegerRegisters()[22], showAllRegisters, displayUnsigned);
        r23Controller.setProperties(RegisterFile.getIntegerRegisters()[23], showAllRegisters, displayUnsigned);
        r24Controller.setProperties(RegisterFile.getIntegerRegisters()[24], showAllRegisters, displayUnsigned);
        r25Controller.setProperties(RegisterFile.getIntegerRegisters()[25], showAllRegisters, displayUnsigned);
        r26Controller.setProperties(RegisterFile.getIntegerRegisters()[26], showAllRegisters, displayUnsigned);
        r27Controller.setProperties(RegisterFile.getIntegerRegisters()[27], showAllRegisters, displayUnsigned);

        r28Controller.setProperties(RegisterFile.getIntegerRegisters()[28], showAllRegisters, displayUnsigned);
        r29Controller.setProperties(RegisterFile.getIntegerRegisters()[29], showAllRegisters, displayUnsigned);
        r30Controller.setProperties(RegisterFile.getIntegerRegisters()[30], showAllRegisters, displayUnsigned);
        r31Controller.setProperties(RegisterFile.getIntegerRegisters()[31], showAllRegisters, displayUnsigned);

        fp0Controller.setProperties(RegisterFile.getFPRegisters()[0], showAllRegisters, displayUnsigned);
        fp1Controller.setProperties(RegisterFile.getFPRegisters()[1], showAllRegisters, displayUnsigned);
        fp2Controller.setProperties(RegisterFile.getFPRegisters()[2], showAllRegisters, displayUnsigned);
        fp3Controller.setProperties(RegisterFile.getFPRegisters()[3], showAllRegisters, displayUnsigned);
        fp4Controller.setProperties(RegisterFile.getFPRegisters()[4], showAllRegisters, displayUnsigned);
        fp5Controller.setProperties(RegisterFile.getFPRegisters()[5], showAllRegisters, displayUnsigned);
        fp6Controller.setProperties(RegisterFile.getFPRegisters()[6], showAllRegisters, displayUnsigned);
        fp7Controller.setProperties(RegisterFile.getFPRegisters()[7], showAllRegisters, displayUnsigned);
        fp8Controller.setProperties(RegisterFile.getFPRegisters()[8], showAllRegisters, displayUnsigned);
        fp9Controller.setProperties(RegisterFile.getFPRegisters()[9], showAllRegisters, displayUnsigned);
        fp10Controller.setProperties(RegisterFile.getFPRegisters()[10], showAllRegisters, displayUnsigned);
        fp11Controller.setProperties(RegisterFile.getFPRegisters()[11], showAllRegisters, displayUnsigned);
        fp12Controller.setProperties(RegisterFile.getFPRegisters()[12], showAllRegisters, displayUnsigned);
        fp13Controller.setProperties(RegisterFile.getFPRegisters()[13], showAllRegisters, displayUnsigned);
        fp14Controller.setProperties(RegisterFile.getFPRegisters()[14], showAllRegisters, displayUnsigned);
        fp15Controller.setProperties(RegisterFile.getFPRegisters()[15], showAllRegisters, displayUnsigned);
        fp16Controller.setProperties(RegisterFile.getFPRegisters()[16], showAllRegisters, displayUnsigned);
        fp17Controller.setProperties(RegisterFile.getFPRegisters()[17], showAllRegisters, displayUnsigned);
        fp18Controller.setProperties(RegisterFile.getFPRegisters()[18], showAllRegisters, displayUnsigned);
        fp19Controller.setProperties(RegisterFile.getFPRegisters()[19], showAllRegisters, displayUnsigned);
        fp20Controller.setProperties(RegisterFile.getFPRegisters()[20], showAllRegisters, displayUnsigned);
        fp21Controller.setProperties(RegisterFile.getFPRegisters()[21], showAllRegisters, displayUnsigned);
        fp22Controller.setProperties(RegisterFile.getFPRegisters()[22], showAllRegisters, displayUnsigned);
        fp23Controller.setProperties(RegisterFile.getFPRegisters()[23], showAllRegisters, displayUnsigned);
        fp24Controller.setProperties(RegisterFile.getFPRegisters()[24], showAllRegisters, displayUnsigned);
        fp25Controller.setProperties(RegisterFile.getFPRegisters()[25], showAllRegisters, displayUnsigned);
        fp26Controller.setProperties(RegisterFile.getFPRegisters()[26], showAllRegisters, displayUnsigned);
        fp27Controller.setProperties(RegisterFile.getFPRegisters()[27], showAllRegisters, displayUnsigned);
        fp28Controller.setProperties(RegisterFile.getFPRegisters()[28], showAllRegisters, displayUnsigned);
        fp29Controller.setProperties(RegisterFile.getFPRegisters()[29], showAllRegisters, displayUnsigned);
        fp30Controller.setProperties(RegisterFile.getFPRegisters()[30], showAllRegisters, displayUnsigned);
        fp31Controller.setProperties(RegisterFile.getFPRegisters()[31], showAllRegisters, displayUnsigned);


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

        Simulator.setRegisterPaneController(this);
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
        // TODO: how to handle fp registers?
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
        for (IntegerRegisterController controller : registerControllerList) {
            controller.clearHighlighting();
        }
    }

}
