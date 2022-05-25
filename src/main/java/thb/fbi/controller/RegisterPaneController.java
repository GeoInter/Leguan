package thb.fbi.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import thb.fbi.simulation.Base;
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
    @FXML Label r0Value;
    @FXML Label r1Value;
    @FXML Label r2Value;
    @FXML Label r3Value;
    @FXML Label r4Value;
    @FXML Label r5Value;
    @FXML Label r6Value;
    @FXML Label r7Value;
    @FXML Label r8Value;
    @FXML Label r9Value;

    @FXML Label r10Value;
    @FXML Label r11Value;
    @FXML Label r12Value;
    @FXML Label r13Value;
    @FXML Label r14Value;
    @FXML Label r15Value;
    @FXML Label r16Value;
    @FXML Label r17Value;
    @FXML Label r18Value;
    @FXML Label r19Value;

    @FXML Label r20Value;
    @FXML Label r21Value;
    @FXML Label r22Value;
    @FXML Label r23Value;
    @FXML Label r24Value;
    @FXML Label r25Value;
    @FXML Label r26Value;
    @FXML Label r27Value;
    @FXML Label r28Value;
    @FXML Label r29Value;

    @FXML Label r30Value;
    @FXML Label rZValue;
    @FXML Label pcValue;

    @FXML Label NFlagValue;
    @FXML Label ZFlagValue;
    @FXML Label CFlagValue;
    @FXML Label VFlagValue;

    @FXML Button r0DecButton;
    @FXML Button r0BinButton;
    @FXML Button r0HexButton;
    @FXML Button r1DecButton;
    @FXML Button r1BinButton;
    @FXML Button r1HexButton;
    @FXML Button r2DecButton;
    @FXML Button r2BinButton;
    @FXML Button r2HexButton;
    @FXML Button r3DecButton;
    @FXML Button r3BinButton;
    @FXML Button r3HexButton;
    @FXML Button r4DecButton;
    @FXML Button r4BinButton;
    @FXML Button r4HexButton;
    @FXML Button r5DecButton;
    @FXML Button r5BinButton;
    @FXML Button r5HexButton;
    @FXML Button r6DecButton;
    @FXML Button r6BinButton;
    @FXML Button r6HexButton;
    @FXML Button r7DecButton;
    @FXML Button r7BinButton;
    @FXML Button r7HexButton;
    @FXML Button r8DecButton;
    @FXML Button r8BinButton;
    @FXML Button r8HexButton;
    @FXML Button r9DecButton;
    @FXML Button r9BinButton;
    @FXML Button r9HexButton;

    @FXML Button r10DecButton;
    @FXML Button r10BinButton;
    @FXML Button r10HexButton;
    @FXML Button r11DecButton;
    @FXML Button r11BinButton;
    @FXML Button r11HexButton;
    @FXML Button r12DecButton;
    @FXML Button r12BinButton;
    @FXML Button r12HexButton;
    @FXML Button r13DecButton;
    @FXML Button r13BinButton;
    @FXML Button r13HexButton;
    @FXML Button r14DecButton;
    @FXML Button r14BinButton;
    @FXML Button r14HexButton;
    @FXML Button r15DecButton;
    @FXML Button r15BinButton;
    @FXML Button r15HexButton;
    @FXML Button r16DecButton;
    @FXML Button r16BinButton;
    @FXML Button r16HexButton;
    @FXML Button r17DecButton;
    @FXML Button r17BinButton;
    @FXML Button r17HexButton;
    @FXML Button r18DecButton;
    @FXML Button r18BinButton;
    @FXML Button r18HexButton;
    @FXML Button r19DecButton;
    @FXML Button r19BinButton;
    @FXML Button r19HexButton;

    @FXML Button r20DecButton;
    @FXML Button r20BinButton;
    @FXML Button r20HexButton;
    @FXML Button r21DecButton;
    @FXML Button r21BinButton;
    @FXML Button r21HexButton;
    @FXML Button r22DecButton;
    @FXML Button r22BinButton;
    @FXML Button r22HexButton;
    @FXML Button r23DecButton;
    @FXML Button r23BinButton;
    @FXML Button r23HexButton;
    @FXML Button r24DecButton;
    @FXML Button r24BinButton;
    @FXML Button r24HexButton;
    @FXML Button r25DecButton;
    @FXML Button r25BinButton;
    @FXML Button r25HexButton;
    @FXML Button r26DecButton;
    @FXML Button r26BinButton;
    @FXML Button r26HexButton;
    @FXML Button r27DecButton;
    @FXML Button r27BinButton;
    @FXML Button r27HexButton;
    @FXML Button r28DecButton;
    @FXML Button r28BinButton;
    @FXML Button r28HexButton;
    @FXML Button r29DecButton;
    @FXML Button r29BinButton;
    @FXML Button r29HexButton;

    @FXML Button r30DecButton;
    @FXML Button r30BinButton;
    @FXML Button r30HexButton;
    @FXML Button rZDecButton;
    @FXML Button rZBinButton;
    @FXML Button rZHexButton;
    @FXML Button pcDecButton;
    @FXML Button pcBinButton;
    @FXML Button pcHexButton;

    @FXML HBox r0Box;
    @FXML HBox r1Box;
    @FXML HBox r2Box;
    @FXML HBox r3Box;
    @FXML HBox r4Box;
    @FXML HBox r5Box;
    @FXML HBox r6Box;
    @FXML HBox r7Box;
    @FXML HBox r8Box;
    @FXML HBox r9Box;

    @FXML HBox r10Box;
    @FXML HBox r11Box;
    @FXML HBox r12Box;
    @FXML HBox r13Box;
    @FXML HBox r14Box;
    @FXML HBox r15Box;
    @FXML HBox r16Box;
    @FXML HBox r17Box;
    @FXML HBox r18Box;
    @FXML HBox r19Box;

    @FXML HBox r20Box;
    @FXML HBox r21Box;
    @FXML HBox r22Box;
    @FXML HBox r23Box;
    @FXML HBox r24Box;
    @FXML HBox r25Box;
    @FXML HBox r26Box;
    @FXML HBox r27Box;
    @FXML HBox r28Box;
    @FXML HBox r29Box;

    @FXML HBox r30Box;
    @FXML HBox rZBox;

    private Simulator simulator = SimulatorSingleton.getSimulator();

    /**
     * initializes all UI components and binds values of the register side pane
     */
    @FXML
    public void initialize() {
        r0Value.textProperty().bind(simulator.getRegisters()[0].getShownValue());
        r1Value.textProperty().bind(simulator.getRegisters()[1].getShownValue());
        r2Value.textProperty().bind(simulator.getRegisters()[2].getShownValue());
        r3Value.textProperty().bind(simulator.getRegisters()[3].getShownValue());
        r4Value.textProperty().bind(simulator.getRegisters()[4].getShownValue());
        r5Value.textProperty().bind(simulator.getRegisters()[5].getShownValue());
        r6Value.textProperty().bind(simulator.getRegisters()[6].getShownValue());
        r7Value.textProperty().bind(simulator.getRegisters()[7].getShownValue());
        r8Value.textProperty().bind(simulator.getRegisters()[8].getShownValue());
        r9Value.textProperty().bind(simulator.getRegisters()[9].getShownValue());

        r10Value.textProperty().bind(simulator.getRegisters()[10].getShownValue());
        r11Value.textProperty().bind(simulator.getRegisters()[11].getShownValue());
        r12Value.textProperty().bind(simulator.getRegisters()[12].getShownValue());
        r13Value.textProperty().bind(simulator.getRegisters()[13].getShownValue());
        r14Value.textProperty().bind(simulator.getRegisters()[14].getShownValue());
        r15Value.textProperty().bind(simulator.getRegisters()[15].getShownValue());
        r16Value.textProperty().bind(simulator.getRegisters()[16].getShownValue());
        r17Value.textProperty().bind(simulator.getRegisters()[17].getShownValue());
        r18Value.textProperty().bind(simulator.getRegisters()[18].getShownValue());
        r19Value.textProperty().bind(simulator.getRegisters()[19].getShownValue());

        r20Value.textProperty().bind(simulator.getRegisters()[20].getShownValue());
        r21Value.textProperty().bind(simulator.getRegisters()[21].getShownValue());
        r22Value.textProperty().bind(simulator.getRegisters()[22].getShownValue());
        r23Value.textProperty().bind(simulator.getRegisters()[23].getShownValue());
        r24Value.textProperty().bind(simulator.getRegisters()[24].getShownValue());
        r25Value.textProperty().bind(simulator.getRegisters()[25].getShownValue());
        r26Value.textProperty().bind(simulator.getRegisters()[26].getShownValue());
        r27Value.textProperty().bind(simulator.getRegisters()[27].getShownValue());
        r28Value.textProperty().bind(simulator.getRegisters()[28].getShownValue());
        r29Value.textProperty().bind(simulator.getRegisters()[29].getShownValue());

        r30Value.textProperty().bind(simulator.getRegisters()[30].getShownValue());
        rZValue.textProperty().bind(simulator.getRegisters()[31].getShownValue());
        // pcValue.textProperty().bind(simulator.getPC().getShownValue());

        // set On Action Event foreach Button
        // when Button clicked change register value to specified numberformat
        r0DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 0));
        r0BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 0));
        r0HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 0));
        r1DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 1));
        r1BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 1));
        r1HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 1));
        r2DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 2));
        r2BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 2));
        r2HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 2));
        r3DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 3));
        r3BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 3));
        r3HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 3));
        r4DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 4));
        r4BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 4));
        r4HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 4));
        r5DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 5));
        r5BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 5));
        r5HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 5));
        r6DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 6));
        r6BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 6));
        r6HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 6));
        r7DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 7));
        r7BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 7));
        r7HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 7));
        r8DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 8));
        r8BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 8));
        r8HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 8));
        r9DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 9));
        r9BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 9));
        r9HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 9));

        r10DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 10));
        r10BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 10));
        r10HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 10));
        r11DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 11));
        r11BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 11));
        r11HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 11));
        r12DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 12));
        r12BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 12));
        r12HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 12));
        r13DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 13));
        r13BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 13));
        r13HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 13));
        r14DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 14));
        r14BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 14));
        r14HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 14));
        r15DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 15));
        r15BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 15));
        r15HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 15));
        r16DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 16));
        r16BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 16));
        r16HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 16));
        r17DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 17));
        r17BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 17));
        r17HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 17));
        r18DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 18));
        r18BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 18));
        r18HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 18));
        r19DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 19));
        r19BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 19));
        r19HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 19));

        r20DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 20));
        r20BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 20));
        r20HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 20));
        r21DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 21));
        r21BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 21));
        r21HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 21));
        r22DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 22));
        r22BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 22));
        r22HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 22));
        r23DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 23));
        r23BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 23));
        r23HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 23));
        r24DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 24));
        r24BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 24));
        r24HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 24));
        r25DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 25));
        r25BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 25));
        r25HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 25));
        r26DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 26));
        r26BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 26));
        r26HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 26));
        r27DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 27));
        r27BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 27));
        r27HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 27));
        r28DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 28));
        r28BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 28));
        r28HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 28));
        r29DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 29));
        r29BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 29));
        r29HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 29));

        r30DecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 30));
        r30BinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 30));
        r30HexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 30));
        rZDecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 31));
        rZBinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 31));
        rZHexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 31));
        /*
        pcDecButton.setOnAction(event -> UpdateRegisterValueFormat(Base.DEC, 3));
        pcBinButton.setOnAction(event -> UpdateRegisterValueFormat(Base.BIN, 3));
        pcHexButton.setOnAction(event -> UpdateRegisterValueFormat(Base.HEX, 3));
        */

        // bind value of flags to flag labels
        NFlagValue.textProperty().bind(FlagRegister.getNFlagProperty().asString());
        ZFlagValue.textProperty().bind(FlagRegister.getZFlagProperty().asString());
        CFlagValue.textProperty().bind(FlagRegister.getCFlagProperty().asString());
        VFlagValue.textProperty().bind(FlagRegister.getVFlagProperty().asString());

        /**** this are bindings for making the register boxes invisible ****/ 
        // make the boxes invisble so they do not appear when not used
        // make the boxes unmanaged so the sidepanel resizes making room for the rest
        r0Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[0].getIsUsed()));
        r0Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[0].getIsUsed()));
        r1Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[1].getIsUsed()));
        r1Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[1].getIsUsed()));
        r2Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[2].getIsUsed()));
        r2Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[2].getIsUsed()));
        r3Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[3].getIsUsed()));
        r3Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[3].getIsUsed()));
        r4Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[4].getIsUsed()));
        r4Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[4].getIsUsed()));
        r5Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[5].getIsUsed()));
        r5Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[5].getIsUsed()));
        r6Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[6].getIsUsed()));
        r6Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[6].getIsUsed()));
        r7Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[7].getIsUsed()));
        r7Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[7].getIsUsed()));
        r8Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[8].getIsUsed()));
        r8Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[8].getIsUsed()));
        r9Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[9].getIsUsed()));
        r9Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[9].getIsUsed()));

        r10Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[10].getIsUsed()));
        r10Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[10].getIsUsed()));
        r11Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[11].getIsUsed()));
        r11Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[11].getIsUsed()));
        r12Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[12].getIsUsed()));
        r12Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[12].getIsUsed()));
        r13Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[13].getIsUsed()));
        r13Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[13].getIsUsed()));
        r14Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[14].getIsUsed()));
        r14Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[14].getIsUsed()));
        r15Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[15].getIsUsed()));
        r15Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[15].getIsUsed()));
        r16Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[16].getIsUsed()));
        r16Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[16].getIsUsed()));
        r17Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[17].getIsUsed()));
        r17Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[17].getIsUsed()));
        r18Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[18].getIsUsed()));
        r18Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[18].getIsUsed()));
        r19Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[19].getIsUsed()));
        r19Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[19].getIsUsed()));

        r20Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[20].getIsUsed()));
        r20Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[20].getIsUsed()));
        r21Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[21].getIsUsed()));
        r21Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[21].getIsUsed()));
        r22Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[22].getIsUsed()));
        r22Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[22].getIsUsed()));
        r23Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[23].getIsUsed()));
        r23Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[23].getIsUsed()));
        r24Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[24].getIsUsed()));
        r24Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[24].getIsUsed()));
        r25Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[25].getIsUsed()));
        r25Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[25].getIsUsed()));
        r26Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[26].getIsUsed()));
        r26Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[26].getIsUsed()));
        r27Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[27].getIsUsed()));
        r27Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[27].getIsUsed()));
        r28Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[28].getIsUsed()));
        r28Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[28].getIsUsed()));
        r29Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[29].getIsUsed()));
        r29Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[29].getIsUsed()));

        r30Box.visibleProperty().bind(showAllRegisters.or(simulator.getRegisters()[30].getIsUsed()));
        r30Box.managedProperty().bind(showAllRegisters.or(simulator.getRegisters()[30].getIsUsed()));
    }

    /**
     * 
     * @param format numberformat 
     * @param index index of the register in array 
     */
    private void UpdateRegisterValueFormat(Base format, int index) {
        simulator.UpdateRegisterValueFormat(format, index);
    }

    public Simulator getSimulator() {
        return simulator;
    }
    
}
