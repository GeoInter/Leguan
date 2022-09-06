package thb.fbi.controller;

import java.util.Locale;

import org.fxmisc.richtext.CodeArea;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import thb.fbi.simulation.FlagRegister;
import thb.fbi.simulation.Memory;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;
import thb.fbi.utility.I18N;

/**
 * UI Controller of the app
 * includes all UI controls
 * 
 */
public class SimulatorController {

    @FXML RegisterPaneController registerPaneController;
    @FXML Parent registerPane;

    @FXML StackPane codeStackPane;
    @FXML SplitPane splitPane;
    @FXML AnchorPane rightSideAnchorPane;
    @FXML TabPane tabPane;
    @FXML ScrollPane codeScrollPane;
    @FXML CodeArea codeArea;

    // @FXML Menu file_Menu;

    @FXML MenuItem switchENButton;
    @FXML MenuItem switchDEButton;
    @FXML MenuItem lightThemeItem;
    @FXML MenuItem darkThemeItem;

    Simulator simulator = SimulatorSingleton.getSimulator();

    @FXML
    public void initialize() {
        codeArea.prefHeightProperty().bind(codeScrollPane.heightProperty()); 
        codeArea.prefWidthProperty().bind(codeScrollPane.widthProperty().subtract(15)); // size of scrollbar

        // prevent rightside to resize (change divider position) when maximazing
        SplitPane.setResizableWithParent(rightSideAnchorPane, false);

        // tabs fill header of tabPane
        tabPane.tabMaxWidthProperty().bind(rightSideAnchorPane.widthProperty().divide(tabPane.getTabs().size()));
        tabPane.tabMinWidthProperty().bind(rightSideAnchorPane.widthProperty().divide(tabPane.getTabs().size()));

        switchENButton.setOnAction((evt) -> switchLanguage(Locale.ENGLISH));
        switchDEButton.setOnAction((evt) -> switchLanguage(Locale.GERMAN));

        lightThemeItem.setOnAction((evt) -> switchStylesheets("light.css"));
        darkThemeItem.setOnAction((evt) -> switchStylesheets("dark.css"));

        // file_Menu.textProperty().bind(I18N.createStringBinding("menubar.File"));
    }

    @FXML
    private void runCode() {
        simulator.testASCIIInMemory();
    }

    /**
     * resets the simulator including memory and flags
     */
    @FXML
    private void reset() {
        Memory.reset();
        FlagRegister.reset();
        simulator.reset();
    }

    @FXML
    private void stepForward() {
        simulator.simulateStep();
    }

    @FXML
    private void stepBackward() {
        System.out.println("step backward");
    }   
    
    /**
     * sets the given Locale in the I18N class and keeps count of the number of switches.
     *
     * @param locale
     *         the new local to set
     */
    private void switchLanguage(Locale locale) {
        I18N.setLocale(locale);
    }

    /**
     * switches to a stylesheet
     */
    public void switchStylesheets(String css) {
        Scene scene = registerPane.getScene();
        scene.getStylesheets().remove(1); // remove except for base
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/" + css).toExternalForm());
    }
}
