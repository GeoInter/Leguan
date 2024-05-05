package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import org.antlr.v4.runtime.Token;

import thb.fbi.leguan.data.ARMProgram;
import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.data.ProgramStatement;
import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ProgramContext;
import thb.fbi.leguan.simulation.Register;

public class ProgramParser extends LegV8BaseVisitor<ARMProgram> {

    /** Map of all entries in the dataSegment (Name, Address) */
    private HashMap<String, Long> dataSegmentVariables = new HashMap<String, Long>();
    /** TreeMap of all static values being stored in memory defined within the dataSegment (address, value) */
    private TreeMap<Long, Byte> dataSegment = new TreeMap<Long, Byte>();
    /** List of all occured semantic Errors (occuring during parser/ non-syntax errors) */
    public ArrayList<ParsingError> semanticErrors = new ArrayList<ParsingError>();
    /** List of all used registers */
    private ArrayList<Register> usedRegisters = new ArrayList<Register>();
    /** Map of all (resolved) jump labels */
    private HashMap<String, Integer> jumpMarks = new HashMap<String, Integer>();
    /** Map of all (unresolved) jump label (=labels that were referenced before they were declared aka downward jump */
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
        DataSegmentParser dataSegmentParser = new DataSegmentParser(semanticErrors, dataSegmentVariables);
        ProgramStatementParser statementVisitor = new ProgramStatementParser(semanticErrors, usedRegisters, jumpMarks, unresolvedMarks);
        ArrayList<ProgramStatement> lines = new ArrayList<ProgramStatement>();

        dataSegment = dataSegmentParser.visitDataSegment(ctx.dataSegment());

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
                    Token token = ctx.line(index).condBranchParam().jumpLabelReference().PointerReference().getSymbol();
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
                    Token token = ctx.line(index).branchParam().jumpLabelReference().PointerReference().getSymbol();
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
        program.setDataSegment(dataSegment);
        program.setStatement(lines);
        program.setUsedRegister(statementVisitor.getUsedRegisters());
        return program;
    }

   
    
}
