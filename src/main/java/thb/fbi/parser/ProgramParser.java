package thb.fbi.parser;

import thb.fbi.parser.antlr.LegV8BaseVisitor;
import thb.fbi.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.parser.antlr.LegV8Parser.ProgramContext;
import thb.fbi.simulation.ARMProgram;
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
        ARMProgram program = visitProgram((ProgramContext)ctx.getChild(0));
        return program;
    }

    @Override
    public ARMProgram visitProgram(ProgramContext ctx) {
        ProgramStatementParser statementVisitor = new ProgramStatementParser();
        ProgramStatement statement = (ProgramStatement)statementVisitor.visit(ctx);
        ARMProgram program = new ARMProgram();
        program.addStatement(statement);
        program.setUsedRegister(statementVisitor.getUsedRegisters());
        return program;
    }

   
    
}
