package thb.fbi.pipeline_visualizer;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import thb.fbi.leguan.data.ARMProgram;
import thb.fbi.leguan.service.ThemeService;
import thb.fbi.leguan.utility.ILeguanTools;
import thb.fbi.pipeline_visualizer.controller.PipelineVisualizerController;

public class PipelineVisualizerAdapter implements ILeguanTools {

    private PipelineVisualizerController pipelineVisualizerController;
    private Stage stage;

    @Override
    public void openExtension(ARMProgram program, String code) {
        if (pipelineVisualizerController == null) {
            try {
                URL fxmlLocation = getClass().getResource("/thb/fbi/pipeline_visualizer/pipelineVisualizer.fxml");
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent pipelineVisualizer = loader.load();
                pipelineVisualizerController = loader.getController();
                this.stage = new Stage();
                
                Scene scene = new Scene(pipelineVisualizer);
                
                ThemeService.applyCSS(scene);

                this.stage.setScene(scene);
                this.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/thb/fbi/leguan/images/leguan.png")));
                this.stage.setTitle("Pipeline-Visualizer");
                this.stage.setMaximized(true);
                this.stage.setOnCloseRequest(event -> {
                    unsetPipelineVisualizerController();
                });
                this.stage.show();
                // update code if it is parsed
                if (! program.getProgramStatements().isEmpty()) {
                    updateCode(program, code);
                }
            } catch (Exception e) {
                pipelineVisualizerController = null;
                e.printStackTrace();
            }
        }

    }

    
    @Override
    public void closeExtension() {
        if(this.stage != null) {
            this.stage.close();
        }
    }

    @Override
    public void updateCode(ARMProgram program, String code) {
        if (pipelineVisualizerController != null) {
            pipelineVisualizerController.updateCode(program, code);
        }
    }

    private void unsetPipelineVisualizerController() {
        pipelineVisualizerController = null;
    }

    @Override
    public void switchCSS(String newCSS) {
        if(this.stage != null) {
            Scene scene = this.stage.getScene();
            ThemeService.switchTheme(scene, newCSS);
        }
    }
    
}
