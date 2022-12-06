package thb.fbi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import thb.fbi.controller.FileManager;
import thb.fbi.simulation.SimulatorSingleton;
import thb.fbi.utility.ExecutorServiceProvider;
import thb.fbi.utility.I18N;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;

/**
 * \brief JavaFX App
 * 
 * starts the application
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException { 
        App.stage = stage;
        Locale locale = I18N.getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("/thb/fbi/languages/language", locale);
        
        URL fxmlLocation = getClass().getResource("simulator.fxml");
        Parent root = FXMLLoader.load(fxmlLocation, bundle);

        scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/base.css").toExternalForm());
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/syntax-highlighting.css").toExternalForm());
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/dark.css").toExternalForm());

        App.stage.setScene(scene);
        App.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/thb/fbi/images/icon.png")));
        App.stage.setTitle("Intrastellar - an LEGv8 Simulator");
        App.stage.setMaximized(true);
        // following gets called when app is about to be closed 
        App.stage.setOnCloseRequest(event -> {
            confirmClosing(event);
        });
        App.stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() {
        SimulatorSingleton.getSimulator().reset();
        ExecutorServiceProvider.shutdownAllExecutorServices();
    }

    /**
     * Prompts dialog for saving file
     */
    public void confirmClosing(WindowEvent event) {
        if(! FileManager.isSaved()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            // TODO: detect actual unsaved changes
            alert.setTitle("Current project is modified");
            alert.setContentText("Save?");
            ButtonType okButton = new ButtonType("Save", ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonData.NO);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
            alert.showAndWait().ifPresent(response -> {
                if(response == okButton) {
                    FileManager.saveFile();
                } else if(response == cancelButton) { 
                    // cancel closing
                    event.consume();
                }
            });
        }
    }
}
