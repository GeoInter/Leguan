package thb.fbi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
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

    @Override
    public void start(Stage stage) throws IOException { 
        Locale locale = I18N.getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("/thb/fbi/languages/language", locale);
        
        URL fxmlLocation = getClass().getResource("simulator.fxml");
        Parent root = FXMLLoader.load(fxmlLocation, bundle);

        scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/base.css").toExternalForm());
        scene.getStylesheets().add(this.getClass().getResource("/thb/fbi/css/dark.css").toExternalForm());
        stage.setScene(scene);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/thb/fbi/images/icon.png")));
        stage.setTitle("Intrastellar - an LEGv8 Simulator");
        stage.setMaximized(true);
        stage.show();
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
    }
}
