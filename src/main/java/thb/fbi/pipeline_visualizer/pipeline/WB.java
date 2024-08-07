/**
 * @author 'SIN
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.Serializable;

public class WB implements Serializable {
    
    /** flag if memory value will be written to a register */
    boolean MemToReg;
    /** flag if result of instruction will be written to a register */
    boolean RegWrite;  
    
    public String toString(int mode)
    {
        String str = "";
        if(mode==1){
            if(RegWrite)
                str += "True, ";
            else
                str += "False, ";

            if(MemToReg)
                str += "True";
            else
                str += "False";
        }else if(mode==2){
            if(RegWrite)
                str += "1, ";
            else
                str += "0, ";
            if(MemToReg)
                str += "1";
            else
                str += "0";
        }else if(mode==3)
            return "X";
        return str;

    }

}
