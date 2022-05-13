package thb.fbi.simulation;

import java.util.ArrayList;

/** 
 * Models the entire source code
 * 
 * contains all lines of code as @see ProgramStatements
 */
public class ARMProgram {
    private String fileName;
    private ArrayList<ProgramStatement> statements;

    public ARMProgram() {
        statements = Parser.getStatements();
    }

    public ProgramStatement getProgramStatement(int index) {
        if(index >= statements.size()) 
            return null;
        return statements.get(index);
    }

    public void addStatement(ProgramStatement statement) {
        statements.add(statement);
    }
}