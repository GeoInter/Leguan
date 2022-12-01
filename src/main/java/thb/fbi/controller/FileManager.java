package thb.fbi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

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
    // TODO: set initial directory to user documents

    public static String openFile() {
        File selectedFile = fileChooser.showOpenDialog(App.getStage());
        return getTextFromFile(selectedFile);
    }

    public static void saveFile(String content) {
        if(simulator.getArmProgram() != null) {
            String filePath = simulator.getArmProgram().getFullFilePath();
            fileChooser.setInitialFileName(filePath);
            saveDialog(content);
        } else {
            saveFileAs(content);
        }
    }

    public static void saveFileAs(String content) {
        fileChooser.setInitialFileName(null);
        saveDialog(content);
    }

    private static void saveDialog(String content) {
        File selectedFile = fileChooser.showSaveDialog(App.getStage());
        if(selectedFile != null) {
            saveTextToFile(selectedFile, content);
        }
    }

    /**
     * writes codearea content into specified file
     * @param file selected file to save to
     */
    private static void saveTextToFile(File file, String content) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error trying to save file");
        }
    }

    /**
     * sets content of specified file into codearea
     * @param file selected file to open
     */
    private static String getTextFromFile(File file) {
        try {
            String content = Files.readString(file.toPath());
            return content;
        } catch(IOException e) {
            return null;
        }
    }
    
}
