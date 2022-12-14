package thb.fbi.utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.fxmisc.richtext.CodeArea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import thb.fbi.App;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;

/**
 * class for opening and saving files
 */
public class FileManager {

    private static FileChooser fileChooser = new FileChooser();
    private static Simulator simulator = SimulatorSingleton.getSimulator();
    private static CodeArea codeArea;
    private static boolean isSaved = false;

    public static void init(CodeArea codeArea) {
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
        FileManager.codeArea = codeArea;
        FileManager.codeArea.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                isSaved = false;
            }
            
        });
    }

    public static void openFile() {
        File selectedFile = fileChooser.showOpenDialog(App.getStage());
        if(selectedFile != null) {
            getTextFromFile(selectedFile);
        }
    }

    public static void saveFile() {
        if(simulator.getArmProgram() != null) {
            String filePath = simulator.getArmProgram().getFullFilePath();
            fileChooser.setInitialFileName(filePath);
            saveDialog();
        } else {
            saveFileAs();
        }
    }

    public static void saveFileAs() {
        fileChooser.setInitialFileName(null);
        saveDialog();
    }

    private static void saveDialog() {
        File selectedFile = fileChooser.showSaveDialog(App.getStage());
        if(selectedFile != null) {
            saveTextToFile(selectedFile);
            isSaved = true;
        }
    }

    /**
     * writes codearea content into specified file
     * @param file selected file to save to
     */
    private static void saveTextToFile(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(codeArea.textProperty().getValue());
            writer.close();
        } catch (IOException e) {
            showErrorAlert("Error read/ writing file", "File could not be read/ saved to. Abort save.");
        } catch(SecurityException s) {
            showErrorAlert("File writing access denied", "Writing access of file denied. Abort save.");
        }
    }

    /**
     * sets content of specified file into codearea
     * @param file selected file to open
     */
    private static void getTextFromFile(File file) {
        try {
            String content = Files.readString(file.toPath());
            codeArea.replaceText(content);
            isSaved = true;
        } catch(IOException e) {
            showErrorAlert("Could not read file", "File could not be read. Abort loading.");
        } catch(OutOfMemoryError m) {
            showErrorAlert("Invalid file size", "File too large to handle. Abort loading.");
        } catch(SecurityException s) {
            showErrorAlert("Cannot access file", "File cannot be accessed. Abort loading.");
        }
    }

    /**
     * shows an error alert for exceptions occuring while handling files
     * @param header header/ title text of alert
     * @param text main text/ message of alert
     */
    private static void showErrorAlert(String header, String text) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setHeaderText(header);
        errorAlert.setContentText(text);
        errorAlert.showAndWait();
    }

    public static boolean isSaved() {
        return isSaved;
    }
}
