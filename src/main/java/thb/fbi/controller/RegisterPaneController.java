package thb.fbi.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;

/**
 * UI Controller for the Register Sidepanel
 */
public class RegisterPaneController {

    /** boolean if checkbox is checked to show all registers */
    public static SimpleBooleanProperty showAllRegisters = new SimpleBooleanProperty();

    @FXML VBox RegisterPane;


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

    @FXML Parent r0;
    @FXML Parent r1;
    @FXML Parent r2;
    @FXML Parent r3;
    @FXML Parent r4;
    @FXML Parent r5;
    @FXML Parent r6;
    @FXML Parent r7;
    @FXML Parent r8;

    @FXML Label NFlagValue;
    @FXML Label ZFlagValue;
    @FXML Label CFlagValue;
    @FXML Label VFlagValue;

    

    

    private Simulator simulator = SimulatorSingleton.getSimulator();

    /**
     * initializes all UI components and binds values of the register side pane
     */
    @FXML
    public void initialize() {

        r0Controller.setProperties(simulator.getRegisters()[0], showAllRegisters);
        r1Controller.setProperties(simulator.getRegisters()[1], showAllRegisters);
        r2Controller.setProperties(simulator.getRegisters()[2], showAllRegisters);
        r3Controller.setProperties(simulator.getRegisters()[3], showAllRegisters);
        r4Controller.setProperties(simulator.getRegisters()[4], showAllRegisters);
        r5Controller.setProperties(simulator.getRegisters()[5], showAllRegisters);
        r6Controller.setProperties(simulator.getRegisters()[6], showAllRegisters);
        r7Controller.setProperties(simulator.getRegisters()[7], showAllRegisters);
        r8Controller.setProperties(simulator.getRegisters()[8], showAllRegisters);

        r9Controller.setProperties(simulator.getRegisters()[9], showAllRegisters);
        r10Controller.setProperties(simulator.getRegisters()[10], showAllRegisters);
        r11Controller.setProperties(simulator.getRegisters()[11], showAllRegisters);
        r12Controller.setProperties(simulator.getRegisters()[12], showAllRegisters);
        r13Controller.setProperties(simulator.getRegisters()[13], showAllRegisters);
        r14Controller.setProperties(simulator.getRegisters()[14], showAllRegisters);
        r15Controller.setProperties(simulator.getRegisters()[15], showAllRegisters);
        r16Controller.setProperties(simulator.getRegisters()[16], showAllRegisters);
        r17Controller.setProperties(simulator.getRegisters()[17], showAllRegisters);
        r18Controller.setProperties(simulator.getRegisters()[18], showAllRegisters);

        r19Controller.setProperties(simulator.getRegisters()[19], showAllRegisters);
        r20Controller.setProperties(simulator.getRegisters()[20], showAllRegisters);
        r21Controller.setProperties(simulator.getRegisters()[21], showAllRegisters);
        r22Controller.setProperties(simulator.getRegisters()[22], showAllRegisters);
        r23Controller.setProperties(simulator.getRegisters()[23], showAllRegisters);
        r24Controller.setProperties(simulator.getRegisters()[24], showAllRegisters);
        r25Controller.setProperties(simulator.getRegisters()[25], showAllRegisters);
        r26Controller.setProperties(simulator.getRegisters()[26], showAllRegisters);
        r27Controller.setProperties(simulator.getRegisters()[27], showAllRegisters);

        r28Controller.setProperties(simulator.getRegisters()[28], showAllRegisters);
        r29Controller.setProperties(simulator.getRegisters()[29], showAllRegisters);
        r30Controller.setProperties(simulator.getRegisters()[30], showAllRegisters);
        r31Controller.setProperties(simulator.getRegisters()[31], showAllRegisters);

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
