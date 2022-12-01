package thb.fbi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.fxmisc.richtext.CodeArea;

import javafx.stage.FileChooser;
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

    public static void init(CodeArea codeArea) {
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileManager.codeArea = codeArea;
    }

    public static void openFile() {
        File selectedFile = fileChooser.showOpenDialog(App.getStage());
        getTextFromFile(selectedFile);
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
            System.err.println("Error trying to save file");
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
        } catch(IOException e) {
            
        }
    }
}
