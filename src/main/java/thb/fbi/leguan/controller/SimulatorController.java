package thb.fbi.leguan.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import thb.fbi.leguan.App;
import thb.fbi.leguan.data.InstructionPosition;
import thb.fbi.leguan.parser.ParsingError;
import thb.fbi.leguan.service.FileManager;
import thb.fbi.leguan.service.ThemeService;
import thb.fbi.leguan.simulation.FlagRegister;
import thb.fbi.leguan.simulation.Memory;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;
import thb.fbi.leguan.utility.I18N;
import thb.fbi.leguan.utility.ILeguanTools;
import thb.fbi.pipeline_visualizer.PipelineVisualizerAdapter;

/**
 * UI Controller of the app
 * includes all UI controls
 * 
 */
public class SimulatorController {

    @FXML
    RegisterPaneController registerPaneController; // bound via registerPane + Controller (automatically)
    @FXML
    MemoryController memoryController; // bound via memory + Controller (automatically)
    @FXML
    EditorController editorController;
    @FXML
    Parent registerPane;
    @FXML
    Parent memory;
    @FXML
    Parent editor;

    @FXML
    SplitPane splitPane;
    @FXML
    SplitPane combinedTab_SplitPane;
    @FXML
    SplitPane textSplitpane;
    @FXML
    AnchorPane rightSideAnchorPane;
    @FXML
    TabPane tabPane;
    @FXML
    TextArea console;

    @FXML
    Menu file_Menu;

    @FXML
    MenuItem switchENButton;
    @FXML
    MenuItem switchDEButton;
    @FXML
    MenuItem lightThemeItem;
    @FXML
    MenuItem darkThemeItem;
    @FXML
    MenuItem enableLineHighlighterButton;
    @FXML
    MenuItem disableLineHighlighterButton;

    @FXML
    Button assembleButton;
    @FXML
    Button runButton;
    @FXML
    Button resetButton;
    @FXML
    Button stopButton;
    @FXML
    Button stepForwardButton;
    @FXML
    Button stepBackwardButton;
    @FXML
    Circle assembleIndicator;

    private Simulator simulator = SimulatorSingleton.getSimulator();

    private ILeguanTools pipelineVisualizer;

    @FXML
    public void initialize() {
        editorController.setAssembleIndicator(assembleIndicator);

        // prevent rightside to resize (change divider position) when maximazing
        SplitPane.setResizableWithParent(rightSideAnchorPane, false);

        // tabs fill header of tabPane
        // BUG: Switching Tabs (which are filling the tabPane) leaves empty extra space
        // at right side; subtract 20 to prevent
        tabPane.tabMaxWidthProperty()
                .bind((rightSideAnchorPane.widthProperty().divide(tabPane.getTabs().size())).subtract(20));
        tabPane.tabMinWidthProperty()
                .bind((rightSideAnchorPane.widthProperty().divide(tabPane.getTabs().size())).subtract(20));

        switchENButton.setOnAction((evt) -> switchLanguage(Locale.ENGLISH));
        switchDEButton.setOnAction((evt) -> switchLanguage(Locale.GERMAN));

        lightThemeItem.setOnAction((evt) -> switchStylesheets("light.css"));
        darkThemeItem.setOnAction((evt) -> switchStylesheets("dark.css"));

        runButton.disableProperty().bind(simulator.getIsRunning());
        stopButton.disableProperty().bind(simulator.getIsRunning().not());
        // file_Menu.textProperty().bind(I18N.createStringBinding("menubar.File"));

        // load images for buttons
        Image runButtonImage = new Image(getClass().getResourceAsStream("/thb/fbi/leguan/images/run.png"));
        runButton.setGraphic(new ImageView(runButtonImage));
        Image resetButtonImage = new Image(getClass().getResourceAsStream("/thb/fbi/leguan/images/reset.png"));
        resetButton.setGraphic(new ImageView(resetButtonImage));
        Image stopButtonImage = new Image(getClass().getResourceAsStream("/thb/fbi/leguan/images/stop.png"));
        stopButton.setGraphic(new ImageView(stopButtonImage));
        Image stepForwardButtonImage = new Image(getClass().getResourceAsStream("/thb/fbi/leguan/images/forward.png"));
        stepForwardButton.setGraphic(new ImageView(stepForwardButtonImage));
        Image stepBackwardButtonImage = new Image(
                getClass().getResourceAsStream("/thb/fbi/leguan/images/backward.png"));
        stepBackwardButton.setGraphic(new ImageView(stepBackwardButtonImage));

        FileManager.init(editorController);

        pipelineVisualizer = new PipelineVisualizerAdapter();

        // following gets called when app is about to be closed
        App.getStage().setOnCloseRequest(event -> {
            confirmClosing(event);
        });
    }

    /**
     * Register key shortcuts/ Key Code Combinations for the whole scene
     */
    public void registerEventFilter() {
        /**
         * If a TextControl has focus, it will consume Key Events and Accelerator Events
         * despite being set on different nodes. 
         * To prevent these events being consumed else, add Event Filter to the whole scene,
         * so that any node can be focused and the events will be still correctly handled.
         */
        App.getStage().getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (new KeyCodeCombination(KeyCode.PLUS, KeyCombination.CONTROL_DOWN).match(event)) {
                zoomIn();           
                event.consume(); // Prevents propagation to avoid double-handling
            } else if (new KeyCodeCombination(KeyCode.MINUS, KeyCombination.CONTROL_DOWN).match(event)) {
                zoomOut();
                event.consume();
            } else if (new KeyCodeCombination(KeyCode.S, KeyCodeCombination.CONTROL_DOWN).match(event)) {
                saveFile();
                event.consume();
            }
        });
    }

    @FXML
    private void assembleCode() {
        if (simulator.parse(editorController.getCodeAreaText())) {
            setConsoleText(simulator.getErrors());
            stepForwardButton.setDisable(false);
            // stepBackwardButton.setDisable(false);
            reset();
            // Update Memory Code Segment Table
            memoryController.updateCode(simulator.getArmProgram());

            // Update Tool
            pipelineVisualizer.updateCode(simulator.getArmProgram(), editorController.getCodeAreaText());

            assembleIndicator.setId("codeStatus_assembled");
        } else {
            setConsoleText(simulator.getErrors());
            editorController.setLineNumber(null);
            stepForwardButton.setDisable(true);
            // stepBackwardButton.setDisable(true);
        }
    }

    @FXML
    private void runCode() {
        if (simulator.parse(editorController.getCodeAreaText())) {
            setConsoleText(simulator.getErrors());
            memoryController.updateCode(simulator.getArmProgram()); // Update Memory Code Segment Table
            simulator.runAllInstructions();
        } else {
            setConsoleText(simulator.getErrors());
        }
        editorController.setLineNumber(null);
    }

    /**
     * resets the simulator including memory and flags
     */
    @FXML
    private void reset() {
        Memory.reset();
        FlagRegister.reset();
        simulator.reset();

        registerPaneController.clearRegisterHighlighting();
        registerPaneController.clearFlagHighlighting();

        // set initial position of line highlighter at the first Instruction
        if (simulator.getArmProgram() != null && simulator.getArmProgram().getProgramStatements().size() > 0) {
            InstructionPosition position = simulator.getArmProgram().getProgramStatement(Memory.CODE_SEGMENT_START).getLinePosition();
            editorController.setLineNumber(position);
        } else {
            editorController.setLineNumber(null);
        }
    }

    @FXML
    private void stepForward() {
        InstructionPosition position = simulator.forwardStep();
        if (position != null)
            editorController.setLineNumber(position);
    }

    // run clear line
    // get instr, check for null, return lineNumber

    @FXML
    private void stepBackward() {
        System.out.println("step backward");
    }

    @FXML
    private void stopThread() {
        simulator.stopThread();
    }

    @FXML
    private void openFile() {
        if (FileManager.openFile()) {
            reset();
        }
    }

    @FXML
    private void saveFile() {
        FileManager.saveFile();
    }

    @FXML
    private void saveFileAs() {
        FileManager.saveFileAs();
    }

    @FXML
    private void zoomIn() {
        editorController.increaseFontSize();
    }

    @FXML
    private void zoomOut() {
        editorController.decreaseFontSize();
    }

    @FXML
    private void restoreDefaultZoom() {
        editorController.restoreDefaultFontSize();
    }

    @FXML
    private void loadExample_simpleLoop() {
        FileManager.openExampleFile("/thb/fbi/leguan/examples/counterExample.txt");
    }

    @FXML
    private void loadExample_dataSegment() {
        FileManager.openExampleFile("/thb/fbi/leguan/examples/dataSegment.txt");
    }

    /**
     * sets/ clears console text
     * 
     * @param errors parsingErrors
     */
    private void setConsoleText(ArrayList<ParsingError> errors) {
        if (errors == null) {
            console.clear();
        } else {
            String errorMessage = "";
            for (ParsingError parsingError : errors) {
                errorMessage += parsingError.getErrorMessage() + "\n";
            }
            console.setText(errorMessage);
        }
    }

    /**
     * sets the given Locale in the I18N class
     * 
     * @param locale the new local to set
     */
    private void switchLanguage(Locale locale) {
        I18N.setLocale(locale);
    }

    /**
     * switches to a stylesheet
     * 
     * @param css name of the css file to use
     */
    private void switchStylesheets(String css) {
        Scene scene = registerPane.getScene();
        ThemeService.switchTheme(scene, css);
        pipelineVisualizer.switchCSS(css);
    }

    @FXML
    private void showAboutPage() throws IOException {
        Stage stage = new Stage();
        Locale locale = I18N.getDefaultLocale();
        ResourceBundle bundle =
        ResourceBundle.getBundle("thb/fbi/leguan/languages/language", locale);
        
        URL fxmlLocation = getClass().getResource("/thb/fbi/leguan/about.fxml");
        Parent root = FXMLLoader.load(fxmlLocation, bundle);
        
        Scene scene = new Scene(root);
        
        ThemeService.applyCSS(scene);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/thb/fbi/leguan/images/leguan.png")));
        stage.setTitle("Leguan - a LEGv8 Simulator");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue) stage.close();
        });
        stage.show();
    }

    /**
     * Prompts dialog for saving file
     */
    public void confirmClosing(WindowEvent event) {
        pipelineVisualizer.closeExtension();
        if (!FileManager.isSaved()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Current project is modified");
            alert.setContentText("Save?");
            ButtonType okButton = new ButtonType("Save", ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonData.NO);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
            alert.showAndWait().ifPresent(response -> {
                if (response == okButton) {
                    FileManager.saveFile();
                    Platform.exit();
                } else if (response == cancelButton) {
                    // cancel closing
                    event.consume();
                }
            });
        }
    }

    @FXML
    private void openPipelineVisualizer() {
        pipelineVisualizer.openExtension();
    }
}
