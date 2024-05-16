package thb.fbi.leguan.utility;

import thb.fbi.leguan.data.ARMProgram;

public interface ILeguanTools {
    
    public abstract void openExtension();

    public abstract void closeExtension();

    public abstract void updateCode(ARMProgram program, String code);

    /**
     * add css files to be loaded when initializing/ displaying extension
     * @param cssFile complete path to the css file to be added
     */
    public abstract void addInitCSS(String cssFile);

    public abstract void switchCSS(String newCSS);
}
