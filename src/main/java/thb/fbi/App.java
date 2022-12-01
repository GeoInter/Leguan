package thb.fbi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import thb.fbi.controller.FileManager;
import thb.fbi.simulation.SimulatorSingleton;
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
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/dark.css").toExternalForm());
        App.stage.setScene(scene);
        App.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/thb/fbi/images/icon.png")));
        App.stage.setTitle("Intrastellar - an LEGv8 Simulator");
        App.stage.setMaximized(true);
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
        SimulatorSingleton.getSimulator().stopExecutor();
        // TODO: get codearea content save / open dialog for confirmation
        FileManager.saveFile("");
    }
}
