package thb.fbi.simulation;

import java.util.ArrayList;

/**
 * MOCK-class for parsing the written programm into handlable statements
 */
public class Parser {

    private static Simulator simulator = SimulatorSingleton.getSimulator();

    /**
     * example function 
     * 1) Add 4096 to r3
     * 2) Subtract 1029383 from r2
     * 3) add r3 and r1 to r0 with ADDS
     * 
     * @return
     */
    public static ArrayList<ProgramStatement> getStatements() {
        InstructionArguments arg1 = new InstructionArguments();
        arg1.setRn(simulator.getRegisters()[3]);
        arg1.setRd(simulator.getRegisters()[3]);
        arg1.setAlu_Immediate(4096);

        ProgramStatement p1 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDI"), 
            arg1, "source", 0);

        InstructionArguments arg2 = new InstructionArguments();
        arg2.setRn(simulator.getRegisters()[2]);
        arg2.setRd(simulator.getRegisters()[2]);
        arg2.setAlu_Immediate(1029383);

        ProgramStatement p2 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("SUBI"), 
            arg2, "source", 1);

        InstructionArguments arg3 = new InstructionArguments();
        arg3.setRm(simulator.getRegisters()[3]);
        arg3.setRn(simulator.getRegisters()[1]);
        arg3.setRd(simulator.getRegisters()[0]);

        ProgramStatement p3 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDS"), 
            arg3, "source", 2);

        ArrayList<ProgramStatement> statements = new ArrayList<ProgramStatement>();
        statements.add(p1);
        statements.add(p2);
        statements.add(p3);
        return statements;
    }
     
    
}
