package thb.fbi.leguan.simulation;

import java.io.File;
import java.util.ArrayList;

/** 
 * Models the entire source code
 * 
 * contains all lines of code as @see ProgramStatements
 */
public class ARMProgram {
    private File file;

    private ArrayList<ProgramStatement> statements = new ArrayList<ProgramStatement>();
    private ArrayList<Register> usedRegisters = new ArrayList<Register>();

    public ARMProgram() {
        file = new File("MyARMProgram.txt");
        statements.clear();
    }

    /**
     * returns the file name belonging to this program
     * @return file name of the program
     */
    public String getFileName() {
        return file.getName();
    }

    public String getFilePath() {
        return file.getAbsolutePath();
    }

    /**
     * gets the list of used registers across the whole Program
     * @return list of used registers
     */
    public ArrayList<Register> getUsedRegisters() {
        return this.usedRegisters;
    }

    /**
     * gets a Program Statement at the specified index
     * @param address index pointing to statement
     * @return Program Statement at specified index
     */
    public ProgramStatement getProgramStatement(int address) {
        try {
            return statements.get(address);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        
    }

    /**
     * adds a parsed Program Statement/ Line of Source Code to this instance
     * @param statement Program Statement to add 
     */
    public void addStatement(ProgramStatement statement) {
        statements.add(statement);
    }

    public void setFilePath(String filepath) {
        file = new File(filepath);
    }

    /**
     * adds a List of Program Statement/ Line of Source Code to this instance
     * @param statement List of Program Statements to set 
     */
    public void setStatement(ArrayList<ProgramStatement> statements) {
        this.statements = statements;
    }

    /**
     * set list of used registers within this program
     * @param usedRegisters
     */
    public void setUsedRegister(ArrayList<Register> usedRegisters) {
        this.usedRegisters = usedRegisters;
    }
}