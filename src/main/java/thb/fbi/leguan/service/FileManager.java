package thb.fbi.leguan.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import thb.fbi.leguan.App;
import thb.fbi.leguan.controller.EditorController;

/**
 * class for opening and saving files
 */
public class FileManager {

    private static FileChooser fileChooser = new FileChooser();
    private static File defaultDirectory = new File(System.getProperty("user.home"));
    private static EditorController editorController;
    private static boolean isSaved = true;
    private static File currentFile = null;

    public static void init(EditorController editorController) {
        fileChooser.setInitialDirectory(defaultDirectory);
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Assembly Code", "*.txt", "*.asm", "*.s", "*.S"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text File", "*.txt"));
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Assembly Language Source Code File", "*.asm", "*.s", "*.S"));
        FileManager.editorController = editorController;
        editorController.getCodeArea().textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                isSaved = false;
            }
            
        });
    }

    /**
     * opens a fileDialog and put file content in text editor
     * @return boolean indicating if new file was succesful opened or not
     */
    public static boolean openFile() {
        if(! isSaved) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Current project is modified");
            alert.setContentText("Current file has unsaved changes. Want to save current file before opening another file?");
            ButtonType okButton = new ButtonType("YES", ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(response -> {
                if(response == okButton) {
                    FileManager.saveFile();
                }
            });
        }
        fileChooser.setInitialDirectory(defaultDirectory);
        File selectedFile = fileChooser.showOpenDialog(App.getStage());
        if(selectedFile != null) {
            loadFileIntoEditor(selectedFile);
            return true;
        }
        return false;
    }

    /**
     * opens a predefined example file (packaged in jar) and load file content into text editor
     * @param exampleFile path to the example file within the project folder (path should start with /thb/fbi/examples/)
     */
    public static void openExampleFile(String exampleFile) {
        if(! isSaved) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Current project is modified");
            alert.setContentText("Current file has unsaved changes. Want to save current file before opening another file?");
            ButtonType okButton = new ButtonType("YES", ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(response -> {
                if(response == okButton) {
                    FileManager.saveFile();
                }
            });
        }

        try {
            InputStream textSource = FileManager.class.getResourceAsStream(exampleFile);
            String content = new String(textSource.readAllBytes(), StandardCharsets.UTF_8);
            editorController.getCodeArea().replaceText(content);
        } catch (IOException e) {
            showErrorAlert("Could not read file", "File could not be read. Abort loading.");
        } catch (OutOfMemoryError m) {
            showErrorAlert("Invalid file size", "File too large to handle. Abort loading.");
        } catch (Exception exception) {
            showErrorAlert("Could not read file", "Unkown Error.");
        }
    }

    public static void saveFile() {
        if(currentFile != null && currentFile.exists()) {
            saveTextToFile(currentFile);
            isSaved = true;
        } else {
            saveFileAs();
        }
    }

    public static void saveFileAs() {
        fileChooser.setInitialFileName(null);
        fileChooser.setInitialDirectory(defaultDirectory);
        showSaveDialog();
    }

    private static void showSaveDialog() {
        File selectedFile = fileChooser.showSaveDialog(App.getStage());
        if(selectedFile != null) {
            saveTextToFile(selectedFile);
            currentFile = selectedFile;
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
            writer.println(editorController.getCodeArea().textProperty().getValue());
            writer.close();
        } catch (IOException e) {
            showErrorAlert("Error read/ writing file", "File could not be read/ saved to. Abort save.");
        } catch (SecurityException s) {
            showErrorAlert("File writing access denied", "Writing access of file denied. Abort save.");
        } catch (Exception exception) {
            showErrorAlert("Error read/ writing file", "Unkown Error.");   
        }
    }

    /**
     * sets content of specified file into codearea
     * @param file selected file to open
     */
    public static void loadFileIntoEditor(File file) {
        try {
            String content = Files.readString(file.toPath());
            editorController.getCodeArea().replaceText(content);
            editorController.getVirtualizedScrollPane().scrollToPixel(0, 0); // scroll to top
            isSaved = true; // set isSaved after listener of codeArea has been triggered
            currentFile = file;
        } catch (IOException e) {
            showErrorAlert("Could not read file", "File could not be read. Abort loading.");
        } catch (OutOfMemoryError m) {
            showErrorAlert("Invalid file size", "File too large to handle. Abort loading.");
        } catch (SecurityException s) {
            showErrorAlert("Cannot access file", "File cannot be accessed. Abort loading.");
        } catch (Exception exception) {
            showErrorAlert("Could not read file", "Unkown Error.");   
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
