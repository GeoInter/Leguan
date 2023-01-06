package thb.fbi.leguan.simulation;

import java.util.ArrayList;

/**
 * MOCK-class for parsing the written programm into handlable statements
 */
public class Parser {

    private static Simulator simulator = SimulatorSingleton.getSimulator();

    /**
     * example function 
     * find first 12 Fibonacci numbers
     * 
     * @return
     */
    public static ArrayList<ProgramStatement> getStatements() {
        // set 1 for 0
        // ADDI R0, 1, R0
        InstructionArguments arg0 = new InstructionArguments();
        arg0.setRn(simulator.getRegisters()[0]);
        arg0.setAlu_Immediate(1);
        arg0.setRd(simulator.getRegisters()[0]);

        ProgramStatement p0 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDI"), 
            arg0, "source", 0);

        // set 13 for R7
        // ADDI R0, 1, R0
        InstructionArguments arg7 = new InstructionArguments();
        arg7.setRn(simulator.getRegisters()[7]);
        arg7.setAlu_Immediate(20);
        arg7.setRd(simulator.getRegisters()[7]);

        ProgramStatement p7 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDI"), 
            arg7, "source", 1);


        // loop label


        // LOAD (byte)value of R1 into memory
        InstructionArguments arg5 = new InstructionArguments();
        arg5.setRn(simulator.getRegisters()[5]);
        arg5.setDt_Address(0);
        arg5.setRt(simulator.getRegisters()[1]);

        ProgramStatement p5 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("STURB"), 
            arg5, "source", 2);

        // i + j = k
        // ADD R2, R0, R1
        InstructionArguments arg1 = new InstructionArguments();
        arg1.setRn(simulator.getRegisters()[0]);
        arg1.setRm(simulator.getRegisters()[1]);
        arg1.setRd(simulator.getRegisters()[2]);

        ProgramStatement p1 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADD"), 
            arg1, "source", 3);

        // i = j
        // ADDI R0, 0, R1
        InstructionArguments arg2 = new InstructionArguments();
        arg2.setRn(simulator.getRegisters()[1]);
        arg2.setAlu_Immediate(0);
        arg2.setRd(simulator.getRegisters()[0]);

        ProgramStatement p2 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDI"), 
            arg2, "source", 4);

        // j = k
        // ADDI R1, 0, R2
        InstructionArguments arg3 = new InstructionArguments();
        arg3.setRn(simulator.getRegisters()[2]);
        arg3.setAlu_Immediate(0);
        arg3.setRd(simulator.getRegisters()[1]);

        ProgramStatement p3 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDI"), 
            arg3, "source", 5);

        // counter++
        // ADD R5, R5, 1
        InstructionArguments arg4 = new InstructionArguments();
        arg4.setRn(simulator.getRegisters()[5]);
        arg4.setAlu_Immediate(1);
        arg4.setRd(simulator.getRegisters()[5]);

        ProgramStatement p4 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("ADDI"), 
            arg4, "source", 6);

        // SUB R8, R7, R5
        InstructionArguments arg6 = new InstructionArguments();
        arg6.setRn(simulator.getRegisters()[7]);
        arg6.setRm(simulator.getRegisters()[5]);
        arg6.setRd(simulator.getRegisters()[8]);

        ProgramStatement p6 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("SUB"), 
            arg6, "source", 7);

        // branch back to label
        // if R7 - R5 = R8 == 0
        InstructionArguments arg8 = new InstructionArguments();
        arg8.setRt(simulator.getRegisters()[8]);
        arg8.setCond_Br_Address(2);

        ProgramStatement p8 = new ProgramStatement(
            simulator.getInstructionSet().findInstructionByMnemonic("CBNZ"), 
            arg8, "source", 8);

        ArrayList<ProgramStatement> statements = new ArrayList<ProgramStatement>();
        statements.add(p0);
        statements.add(p7);
        statements.add(p5);
        statements.add(p1);
        statements.add(p2);
        statements.add(p3);
        statements.add(p4);
        statements.add(p6);
        statements.add(p8);
        
        return statements;
    }
     
    
}
