package thb.fbi.pipeline_visualizer;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import thb.fbi.leguan.utility.ILeguanTools;
import thb.fbi.pipeline_visualizer.pipeline.PipelineSimulator;
import thb.fbi.pipeline_visualizer.controller.PipelineFrame;

public class PipelineVisualizer implements ILeguanTools {


    // TODO: Fix Lines
    // TODO: Fix closing vis -> closes also leguan
    // TODO: Fix assembling with button results in endless loop (sometimes)

    private PipelineSimulator pipelineSimulator;
    private PipelineFrame pipelineFrame;

    private String ccccLEGv8Code = 
                "ADDI X0, X0, 1;\n" +
                "ADDI X7, X7, 20;\n" +
                "ADDI X12, X12, 0;\n" +
                "loop: STUR X1, [X12, 0];\n" +
                "ADD X2, X0, X1;\n" +
                "ADDI X0, X1, 0;\n" +
                "ADDI X1, X2, 0;\n" +
                "ADDI X5, X5, 1; // counter\n" +
                "ADDI X12, X12, 8; // storing address\n" +
                "SUB X8, X7, X5;\n" +
                "CBNZ X8, loop;\n" + 
                "ADDI X10, X10, 420;\n";

    private String LEGv8Code = "ADDI X7, X7, 20; loop: ADDI X0, X0, 1; SUB X8, X7, X0; CBNZ X8, loop;";

    public PipelineVisualizer() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void buildGUI() {
        pipelineSimulator = new PipelineSimulator();
        pipelineFrame = new PipelineFrame(LEGv8Code, pipelineSimulator);
    }

    @Override
    public void updateCode(String code) {
        pipelineSimulator.execute(code);
    }

    public PipelineSimulator getPipelineSimulator() {
        return this.pipelineSimulator;
    }

    public PipelineFrame getPipelineFrame() {
        return this.pipelineFrame;
    }
    
}
