package thb.fbi.leguan.data;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import thb.fbi.leguan.simulation.Register;

/** 
 * Models the entire source code
 * 
 * contains all lines of code as @see ProgramStatements
 */
public class ARMProgram {

    private TreeMap<Long, ProgramStatement> statements = new TreeMap<Long, ProgramStatement>();
    private Set<Register> usedRegisters = new HashSet<Register>();
    private TreeMap<Long, Byte> dataSegment = new TreeMap<Long, Byte>();

    public ARMProgram() {
        statements.clear();
    }

    /**
     * gets the list of used registers across the whole Program
     * @return list of used registers
     */
    public Set<Register> getUsedRegisters() {
        return this.usedRegisters;
    }

    /**
     * gets a Program Statement at the specified index
     * @param address index pointing to statement
     * @return Program Statement at specified index
     */
    public TreeMap<Long, ProgramStatement> getProgramStatements() {
        return this.statements;
    }

    /**
     * gets a Program Statement at the specified index
     * @param address index pointing to statement
     * @return Program Statement at specified index
     */
    public ProgramStatement getProgramStatement(long address) {
        return statements.get(address);
    }

    /**
     * adds a parsed Program Statement/ Line of Source Code to this instance
     * @param statement Program Statement to add 
     */
    public void addStatement(long index, ProgramStatement statement) {
        statements.put(index, statement);
    }

    /**
     * adds a List of Program Statement/ Line of Source Code to this instance
     * @param statement List of Program Statements to set 
     */
    public void setStatement(TreeMap<Long, ProgramStatement> statements) {
        this.statements = statements;
    }

    /**
     * set list of used registers within this program
     * @param usedRegisters
     */
    public void setUsedRegister(Set<Register> usedRegisters) {
        this.usedRegisters = usedRegisters;
    }

    public TreeMap<Long, Byte> getDataSegment() {
        return dataSegment;
    }

    public void setDataSegment(TreeMap<Long, Byte> dataSegmentValues) {
        this.dataSegment = dataSegmentValues;
    }
}