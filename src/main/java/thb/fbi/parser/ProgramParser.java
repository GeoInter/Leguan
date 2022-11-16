package thb.fbi.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import thb.fbi.parser.antlr.LegV8BaseVisitor;
import thb.fbi.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.parser.antlr.LegV8Parser.ProgramContext;
import thb.fbi.simulation.ARMProgram;
import thb.fbi.simulation.InstructionArguments;
import thb.fbi.simulation.ProgramStatement;

// each rule = one visitor
// 
/* ##### Types
 * arguments = parameterlist
 *      1 to 3 parameters
 * 
 * instruction accessed by simulator/ instructionset class
 * 
 * arguments + instruction + nrLine = ProgramStatement
 * 
 * ##### Notes
 * Find Object type for legv8BaseVisitor 
 * 
 * add visit method for each node (Rn, Rm, Rd, etc.)???
 * 
 * split up into line and program? -> base on typing
 *      -> here: Program, ProgramStatement, Arguments, Instruction 
 */

public class ProgramParser extends LegV8BaseVisitor<ARMProgram> {

    // could be refactored
    // start and end point of parsing -> calls visitProgram + same return type
    // using for setting ARMProgram property 
    @Override
    public ARMProgram visitMain(MainContext ctx) {
        ARMProgram program = visitProgram(ctx.program());
        return program;
    }

    @Override
    public ARMProgram visitProgram(ProgramContext ctx) {
        ProgramStatementParser statementVisitor = new ProgramStatementParser();
        ArrayList<ProgramStatement> lines = new ArrayList<ProgramStatement>();

        for(int i = 0; i < ctx.line().size(); i++) {
            statementVisitor.setSourceLine(i);
            ProgramStatement statement = statementVisitor.visitLine(ctx.line(i));
            statement.setSourceLine(i);
            lines.add(statement);
        }


        // re-resolve marks when later declared
        HashMap<String, Integer> jumpMarks = statementVisitor.getJumpMarks();
        HashMap<Integer, String> unresolvedMarks = statementVisitor.getUnresolvedMarks();

        for (Integer index : unresolvedMarks.keySet()) {
            ProgramStatement statement = lines.get(index);
            InstructionArguments args = statement.getArguments();

            if(args.getCond_Br_Address() == -1) {
                String id = unresolvedMarks.get(index);
                int sourceLine = jumpMarks.get(id);
                args.setCond_Br_Address(sourceLine);
            } else if(args.getBr_Address() == -1) {
                String id = unresolvedMarks.get(index);
                int sourceLine = jumpMarks.get(id);
                args.setBr_Address(sourceLine);
            }
        }
        

        ARMProgram program = new ARMProgram();
        program.setStatement(lines);
        program.setUsedRegister(statementVisitor.getUsedRegisters());
        return program;
    }

   
    
}
