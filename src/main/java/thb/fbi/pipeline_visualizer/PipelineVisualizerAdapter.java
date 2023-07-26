package thb.fbi.pipeline_visualizer;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import thb.fbi.leguan.App;
import thb.fbi.leguan.utility.ILeguanTools;
import thb.fbi.pipeline_visualizer.controller.PipelineVisualizerController;

public class PipelineVisualizerAdapter implements ILeguanTools {

    private PipelineVisualizerController pipelineVisualizerController;

    @Override
    public void display() {
        if (pipelineVisualizerController == null) {
            try {
                URL fxmlLocation = getClass().getResource("/thb/fbi/pipeline_visualizer/pipelineVisualizer.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent pipelineVisualizer = loader.load();
                pipelineVisualizerController = loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Pipeline Visualizer");
                stage.initOwner(App.getStage());
                stage.setScene(new Scene(pipelineVisualizer));
                stage.setOnCloseRequest(event -> {
                    unsetPipelineVisualizerController();
                });
                stage.show();
            } catch (Exception e) {
                pipelineVisualizerController = null;
                e.printStackTrace();
            }
        }

    }

    @Override
    public void updateCode(String code) {
        if (pipelineVisualizerController != null) {
            pipelineVisualizerController.updateCode(code);
        }
    }

    private void unsetPipelineVisualizerController() {
        pipelineVisualizerController = null;
    }
    
}
