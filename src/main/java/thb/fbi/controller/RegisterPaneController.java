package thb.fbi.controller;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;

/**
 * UI Controller for the Register Sidepanel
 */
public class RegisterPaneController {

    @FXML VBox RegisterPane;

    @FXML RegisterTitleBarController pcController; 
    @FXML RegisterTitleBarController r0Controller; 
    @FXML RegisterTitleBarController r1Controller;  
    @FXML RegisterTitleBarController r2Controller; 
    @FXML RegisterTitleBarController r3Controller; 
    @FXML RegisterTitleBarController r4Controller; 
    @FXML RegisterTitleBarController r5Controller; 
    @FXML RegisterTitleBarController r6Controller; 
    @FXML RegisterTitleBarController r7Controller;
    @FXML RegisterTitleBarController r8Controller;

    @FXML RegisterTitleBarController r9Controller; 
    @FXML RegisterTitleBarController r10Controller;  
    @FXML RegisterTitleBarController r11Controller; 
    @FXML RegisterTitleBarController r12Controller; 
    @FXML RegisterTitleBarController r13Controller; 
    @FXML RegisterTitleBarController r14Controller; 
    @FXML RegisterTitleBarController r15Controller; 
    @FXML RegisterTitleBarController r16Controller;
    @FXML RegisterTitleBarController r17Controller;  
    @FXML RegisterTitleBarController r18Controller;

    @FXML RegisterTitleBarController r19Controller; 
    @FXML RegisterTitleBarController r20Controller;  
    @FXML RegisterTitleBarController r21Controller; 
    @FXML RegisterTitleBarController r22Controller; 
    @FXML RegisterTitleBarController r23Controller; 
    @FXML RegisterTitleBarController r24Controller; 
    @FXML RegisterTitleBarController r25Controller; 
    @FXML RegisterTitleBarController r26Controller;
    @FXML RegisterTitleBarController r27Controller;
      
    @FXML RegisterTitleBarController r28Controller; 
    @FXML RegisterTitleBarController r29Controller; 
    @FXML RegisterTitleBarController r30Controller;
    @FXML RegisterTitleBarController r31Controller;

    @FXML Label NFlagValue;
    @FXML Label ZFlagValue;
    @FXML Label CFlagValue;
    @FXML Label VFlagValue;

    @FXML CheckBox showUnusedRegisterCheckBox;
    @FXML CheckBox displayUnsignedCheckBox;
    
    private Simulator simulator = SimulatorSingleton.getSimulator();

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

        // bind value of flags to flag labels
        NFlagValue.textProperty().bind(FlagRegister.getNFlagProperty().asString());
        ZFlagValue.textProperty().bind(FlagRegister.getZFlagProperty().asString());
        CFlagValue.textProperty().bind(FlagRegister.getCFlagProperty().asString());
        VFlagValue.textProperty().bind(FlagRegister.getVFlagProperty().asString());
    }

    public Simulator getSimulator() {
        return simulator;
    }
    
}
