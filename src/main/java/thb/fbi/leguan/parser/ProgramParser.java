package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.antlr.v4.runtime.tree.TerminalNode;

import thb.fbi.leguan.data.ARMProgram;
import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.data.ProgramStatement;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ProgramContext;
import thb.fbi.leguan.simulation.Memory;
import thb.fbi.leguan.simulation.Register;

public class ProgramParser extends LegV8BaseVisitor<ARMProgram> {

    /** Map of all entries in the dataSegment (Name, Address) */
    private HashMap<String, Long> dataSegmentVariables = new HashMap<String, Long>();
    /** TreeMap of all static values being stored in memory defined within the dataSegment (address, value) */
    private TreeMap<Long, Byte> dataSegment = new TreeMap<Long, Byte>();
    /** List of all occured semantic Errors (occuring during parser/ non-syntax errors) */
    public ArrayList<ParsingError> semanticErrors = new ArrayList<ParsingError>();
    /** List of all used registers */
    private Set<Register> usedRegisters = new HashSet<Register>();
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
        // right after code segment starts the static data segment; Use Context to get number of instructions of program beforehand
        int endOfCodeSegmentAdress = Memory.CODE_SEGMENT_START + ctx.line().size() * Instruction.INSTRUCTION_LENGTH;
        ParserHelper.setSemanticErrors(this.semanticErrors);
        DataSegmentParser dataSegmentParser = new DataSegmentParser(dataSegmentVariables, endOfCodeSegmentAdress);
        ProgramStatementParser statementVisitor = new ProgramStatementParser(usedRegisters, jumpMarks, unresolvedMarks, dataSegmentVariables);
        TreeMap<Integer, ProgramStatement> lines = new TreeMap<Integer, ProgramStatement>();

        dataSegment = dataSegmentParser.visitDataSegment(ctx.dataSegment());

        int codeAdress = Memory.CODE_SEGMENT_START;
        for(int i = 0; i < ctx.line().size(); i++) {
            statementVisitor.setProgramIndex(codeAdress);
            ProgramStatement statement = statementVisitor.visitLine(ctx.line(i));
            lines.put(codeAdress, statement);
            codeAdress = codeAdress + Instruction.INSTRUCTION_LENGTH;
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
                    addSemanticError(ctx.line(index).condBranchParam().jumpLabelReference().PointerReference(), ParsingErrorType.UndefinedJumpLabelReference);
                } else {
                    args.setCond_Br_Address(sourceLine);
                }
                
            } else if(args.getBr_Address() == -1) {
                String id = unresolvedMarks.get(index);
                Integer sourceLine = jumpMarks.get(id);

                if(sourceLine == null) {
                    addSemanticError(ctx.line(index).branchParam().jumpLabelReference().PointerReference(), ParsingErrorType.UndefinedJumpLabelReference);
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

    /**
     * helper function for adding parser error to list
     * @param token the token of the parse tree which is responsible for throwing the error 
     * @param errorType type of parsing error
     */
    private void addSemanticError(TerminalNode node, ParsingErrorType errorType) {
        ParsingError err = new ParsingError(node, errorType);
        semanticErrors.add(err);
    }

}
