package thb.fbi.leguan.utility;

import thb.fbi.leguan.data.ARMProgram;

public interface ILeguanTools {
    
    public abstract void openExtension(ARMProgram program, String code);

    public abstract void closeExtension();

    public abstract void updateCode(ARMProgram program, String code);

    public abstract void switchCSS(String newCSS);
}
