package thb.fbi.leguan.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
    VBox argumentRegisterBox;
    @FXML
    VBox temporaryRegisterBox;
    @FXML
    VBox savedRegisterBox;
    @FXML
    VBox otherRegisterBox;
    @FXML
    VBox floatingPointRegisterBox;

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

    private List<RegisterController<?>> registerControllerList = new ArrayList<RegisterController<?>>();

    /**
     * id of the last register that was highlighted in UI 
     * (value was changed or accessed)
     */ 
    private int lastHighlightedRegisterId = 0;

    private BooleanProperty showAllRegisters;

    /**
     * initializes all UI components and binds values of the register side pane
     */
    @FXML
    public void initialize() {

        showAllRegisters = showUnusedRegisterCheckBox.selectedProperty();
        BooleanProperty displayUnsigned = displayUnsignedCheckBox.selectedProperty();

        pcController.setProperties(RegisterFile.getPC(), displayUnsigned);

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

        registerControllerList.add(fp0Controller);
        registerControllerList.add(fp1Controller);
        registerControllerList.add(fp2Controller);
        registerControllerList.add(fp3Controller);
        registerControllerList.add(fp4Controller);
        registerControllerList.add(fp5Controller);
        registerControllerList.add(fp6Controller);
        registerControllerList.add(fp7Controller);
        registerControllerList.add(fp8Controller);
        registerControllerList.add(fp9Controller);
        registerControllerList.add(fp10Controller);
        registerControllerList.add(fp11Controller);
        registerControllerList.add(fp12Controller);
        registerControllerList.add(fp13Controller);
        registerControllerList.add(fp14Controller);
        registerControllerList.add(fp15Controller);
        registerControllerList.add(fp16Controller);
        registerControllerList.add(fp17Controller);
        registerControllerList.add(fp18Controller);
        registerControllerList.add(fp19Controller);
        registerControllerList.add(fp20Controller);
        registerControllerList.add(fp21Controller);
        registerControllerList.add(fp22Controller);
        registerControllerList.add(fp23Controller);
        registerControllerList.add(fp24Controller);
        registerControllerList.add(fp25Controller);
        registerControllerList.add(fp26Controller);
        registerControllerList.add(fp27Controller);
        registerControllerList.add(fp28Controller);
        registerControllerList.add(fp29Controller);
        registerControllerList.add(fp30Controller);
        registerControllerList.add(fp31Controller);

        for(int i = 0; i < 64; i++) {
            RegisterController<?> controller = registerControllerList.get(i);
            if (i < RegisterFile.FP_START_INDEX) {
                IntegerRegisterController integerRegisterController = (IntegerRegisterController) controller;
                integerRegisterController.setProperties(RegisterFile.getIntegerRegister(i), showAllRegisters, displayUnsigned);
            } else {
                FPRegisterController fpRegisterController = (FPRegisterController) controller;
                fpRegisterController.setProperties(RegisterFile.getFPRegister(i - RegisterFile.FP_START_INDEX), showAllRegisters, displayUnsigned);
            }
            
        }

        
        initFlagRegister();
        initRegisterBoxBindings();
        

        Simulator.setRegisterPaneController(this);
        FlagRegister.setObserver(this);
    }

    /**
     * Sets up flagRegisterController and adds ChangeListener
     */
    private void initFlagRegister() {
        CFlagValue.setText("0");
        NFlagValue.setText("0");
        VFlagValue.setText("0");
        ZFlagValue.setText("0");

        CFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setCFlag(newValue);
            if (newValue) {
                CFlagValue.setText("1");
            } else {
                CFlagValue.setText("0");
            }
        });
        NFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setNFlag(newValue);
            if (newValue) {
                NFlagValue.setText("1");
            } else {
                NFlagValue.setText("0");
            }
        });
        VFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setVFlag(newValue);
            if (newValue) {
                VFlagValue.setText("1");
            } else {
                VFlagValue.setText("0");
            }
        });
        ZFlagValue.selectedProperty().addListener((observable, oldValue, newValue) -> {
            FlagRegister.setZFlag(newValue);
            if (newValue) {
                ZFlagValue.setText("1");
            } else {
                ZFlagValue.setText("0");
            }
        });
    }

    /**
     * Sets up the bindings for all register boxes.
     * Binds visible and managed property for all VBoxes.
     */
    private void initRegisterBoxBindings() {
        BooleanBinding argumentIsVisible = getBindings(0, 8);

        argumentRegisterBox.visibleProperty()
                .bind(argumentIsVisible);
        argumentRegisterBox.managedProperty()
                .bind(argumentIsVisible);


        BooleanBinding temporaryIsVisible = getBindings(9, 18);

        temporaryRegisterBox.visibleProperty()
                .bind(temporaryIsVisible);
        temporaryRegisterBox.managedProperty()
                .bind(temporaryIsVisible);


        BooleanBinding savedIsVisible = getBindings(19, 27);

        savedRegisterBox.visibleProperty()
                .bind(savedIsVisible);
        savedRegisterBox.managedProperty()
                .bind(savedIsVisible);
        

        BooleanBinding otherIsVisible = getBindings(28, 31);

        otherRegisterBox.visibleProperty()
                .bind(otherIsVisible);
        otherRegisterBox.managedProperty()
                .bind(otherIsVisible);


        BooleanBinding floatingPointIsVisible = getBindings(32, 63);

        floatingPointRegisterBox.visibleProperty()
                .bind(floatingPointIsVisible);
        floatingPointRegisterBox.managedProperty()
                .bind(floatingPointIsVisible);
    }

    /**
     * Generate Bindings based on visibe/ managed property of register controller.
     * @param start start index
     * @param end last index (inclusive)
     * @return binding containing the properties of all registers in the given range
     */
    private BooleanBinding getBindings(int start, int end) {
        BooleanBinding binding = new SimpleBooleanProperty(true).not();
        binding = binding.or(showAllRegisters);
        for (int i = start; i < end; i++) {
            binding = binding.or(registerControllerList.get(i).getIsVisible());
        }
        return binding;
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
            registerControllerList.get(lastHighlightedRegisterId).clearHighlighting();
            if (index >= 0) {
                lastHighlightedRegisterId = index;
                registerControllerList.get(index).setHighlighting();
            }
        });
    }

    /**
     * undo highlighting for all registers
     */
    public void clearRegisterHighlighting() {
        Platform.runLater(() -> {
            for (RegisterController<?> controller : registerControllerList) {
                controller.clearHighlighting();
            }
        });
    }

}
