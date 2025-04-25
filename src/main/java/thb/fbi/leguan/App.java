package thb.fbi.leguan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import thb.fbi.leguan.controller.SimulatorController;
import thb.fbi.leguan.service.ThemeService;
import thb.fbi.leguan.simulation.SimulatorSingleton;
import thb.fbi.leguan.utility.ExecutorServiceProvider;
import thb.fbi.leguan.utility.FileManager;
import thb.fbi.leguan.utility.I18N;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * \brief JavaFX App
 * 
 * starts the application
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    private static SimulatorController simulatorController;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException { 
        App.stage = stage;
        Locale locale = I18N.getDefaultLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("thb/fbi/leguan/languages/language", locale);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("simulator.fxml"), bundle);
        Parent root = loader.load();

        App.simulatorController = loader.getController();

        scene = new Scene(root);
        
        ThemeService.applyCSS(scene);

        App.stage.setScene(scene);
        App.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/thb/fbi/leguan/images/leguan.png")));
        App.stage.setTitle("Leguan - a LEGv8 Simulator");
        App.stage.setMaximized(true);
        App.stage.show();

        // ** Read in given parameters **
        // Open given file after startup
        Parameters params = getParameters();
        List<String> list = params.getRaw();
        if (list.size() > 0) {
            // check if file is readable and openable
            FileManager.loadFileIntoEditor(new File(list.get(0)));
        }

        // register key shortcuts
        simulatorController.registerEventFilter();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        SimulatorSingleton.getSimulator().reset();
        ExecutorServiceProvider.shutdownAllExecutorServices();
    }

    
}
