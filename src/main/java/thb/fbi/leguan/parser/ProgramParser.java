package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ProgramContext;
import thb.fbi.leguan.simulation.ARMProgram;
import thb.fbi.leguan.simulation.InstructionArguments;
import thb.fbi.leguan.simulation.ProgramStatement;
import thb.fbi.leguan.simulation.Register;

public class ProgramParser extends LegV8BaseVisitor<ARMProgram> {

    public ArrayList<ParsingError> semanticErrors = new ArrayList<ParsingError>();
    private ArrayList<Register> usedRegisters = new ArrayList<Register>();
    private HashMap<String, Integer> jumpMarks = new HashMap<String, Integer>();
    private HashMap<Integer, String> unresolvedMarks = new HashMap<Integer, String>();

    /**
     * clears all arrays and maps
     * resetting errors and found jumpMarks
     */
    public void clear() {
        semanticErrors.clear();
        usedRegisters.clear();
        jumpMarks.clear();
        unresolvedMarks.clear();
    }

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
        ProgramStatementParser statementVisitor = new ProgramStatementParser(semanticErrors, usedRegisters, jumpMarks, unresolvedMarks);
        ArrayList<ProgramStatement> lines = new ArrayList<ProgramStatement>();

        for(int i = 0; i < ctx.line().size(); i++) {
            statementVisitor.setProgramIndex(i);
            ProgramStatement statement = statementVisitor.visitLine(ctx.line(i));
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
                Integer sourceLine = jumpMarks.get(id);

                if(sourceLine == null) {
                    Token token = ctx.line(index).condBranchParam().invocation().JumpInvocation().getSymbol();
                    int line = token.getLine();
                    int pos = token.getCharPositionInLine();
                    ParsingError err = new ParsingError(line, pos, ParsingErrorType.UndefinedJumpInvocation);
                    semanticErrors.add(err);
                } else {
                    args.setCond_Br_Address(sourceLine);
                }
                
            } else if(args.getBr_Address() == -1) {
                String id = unresolvedMarks.get(index);
                Integer sourceLine = jumpMarks.get(id);

                if(sourceLine == null) {
                    Token token = ctx.line(index).branchParam().invocation().JumpInvocation().getSymbol();
                    int line = token.getLine();
                    int pos = token.getCharPositionInLine();
                    ParsingError err = new ParsingError(line, pos, ParsingErrorType.UndefinedJumpInvocation);
                    semanticErrors.add(err);
                } else {
                    args.setBr_Address(sourceLine);
                }   
            }
        }
        

        ARMProgram program = new ARMProgram();
        program.setStatement(lines);
        program.setUsedRegister(statementVisitor.getUsedRegisters());
        return program;
    }

   
    
}
