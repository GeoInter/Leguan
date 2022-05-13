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

    public ARMProgram(String fileName) {
        this.fileName = fileName;
        statements = Parser.getStatements();
    }

    public ProgramStatement getProgramStatement(int address) {
        //TODO: figure out how to do it
        // 1) convert parameter to index (4000000 + parameter)
        // 2) start pc at start of address space of the code
        try {
            return statements.get(address);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        
    }

    public void addStatement(ProgramStatement statement) {
        statements.add(statement);
    }
}