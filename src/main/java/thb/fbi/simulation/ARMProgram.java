package thb.fbi.simulation;

import java.util.ArrayList;

/** 
 * Models the entire source code
 * 
 * contains all lines of code as @see ProgramStatements
 */
public class ARMProgram {
    // temp property
    private static Simulator simulator = SimulatorSingleton.getSimulator();

    private String fileName;
    private ArrayList<ProgramStatement> statements;
    private ArrayList<Register> usedRegisters = new ArrayList<Register>();

    public ARMProgram(String fileName) {
        this.fileName = fileName;
        statements = Parser.getStatements();
        usedRegisters.add(simulator.getRegisters()[0]);
        usedRegisters.add(simulator.getRegisters()[1]);
        usedRegisters.add(simulator.getRegisters()[2]);
        usedRegisters.add(simulator.getRegisters()[3]);
    }

    /**
     * returns the file name belonging to this program
     * @return file name of the program
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * gets the list of used registers across the whole Program
     * @return list of used registers
     */
    public ArrayList<Register> getUsedRegisters() {
        return this.usedRegisters;
    }

    /**
     * gets a Program Statement at the specified address
     * @param address where the Program Statement is located
     * @return Program Statement at specified address
     */
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

    /**
     * adds a parsed Program Statement/ Line of Source Code to this instance
     * @param statement Program Statement to add 
     */
    public void addStatement(ProgramStatement statement) {
        statements.add(statement);
    }
}