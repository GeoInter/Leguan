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
    /**
     * TreeMap of all static values being stored in memory defined within the
     * dataSegment (address, value)
     */
    private TreeMap<Long, Byte> dataSegment = new TreeMap<Long, Byte>();
    /**
     * List of all occured semantic Errors (occuring during parser/ non-syntax
     * errors)
     */
    public ArrayList<ParsingError> semanticErrors = new ArrayList<ParsingError>();
    /** List of all used registers */
    private Set<Register> usedRegisters = new HashSet<Register>();
    /** Map of all (resolved) jump labels */
    private HashMap<String, Long> jumpMarks = new HashMap<String, Long>();
    /**
     * Map of all (unresolved) jump label (=labels that were referenced before they
     * were declared aka downward jump
     */
    private HashMap<Long, TerminalNode> unresolvedMarks = new HashMap<Long, TerminalNode>();

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
        // right after the code segment starts the static data segment; Use Context to get
        // number of instructions of program beforehand
        int endOfCodeSegmentAdress = Memory.CODE_SEGMENT_START + ctx.line().size() * Instruction.INSTRUCTION_LENGTH;
        ParserHelper.setSemanticErrors(this.semanticErrors);
        DataSegmentParser dataSegmentParser = new DataSegmentParser(dataSegmentVariables, endOfCodeSegmentAdress);
        ProgramStatementParser statementVisitor = new ProgramStatementParser(usedRegisters, jumpMarks, unresolvedMarks,
                dataSegmentVariables);
        TreeMap<Long, ProgramStatement> lines = new TreeMap<Long, ProgramStatement>();

        dataSegment = dataSegmentParser.visitDataSegment(ctx.dataSegment());

        long codeAdress = Memory.CODE_SEGMENT_START;
        for (int i = 0; i < ctx.line().size(); i++) {
            statementVisitor.setProgramIndex(codeAdress);
            ProgramStatement statement = statementVisitor.visitLine(ctx.line(i));
            lines.put(codeAdress, statement);
            codeAdress = codeAdress + Instruction.INSTRUCTION_LENGTH;
        }

        // re-resolve marks when later declared
        HashMap<String, Long> jumpMarks = statementVisitor.getJumpMarks();
        HashMap<Long, TerminalNode> unresolvedMarks = statementVisitor.getUnresolvedMarks();

        for (Long instructionAddress : unresolvedMarks.keySet()) {
            ProgramStatement statement = lines.get(instructionAddress);
            InstructionArguments args = statement.getArguments();

            TerminalNode pointerReference = unresolvedMarks.get(instructionAddress);
            String pointerReferenceName = pointerReference.getText();

            Long sourceLine = jumpMarks.get(pointerReferenceName);

            // if jump mark could not be resolved, create a parser error
            if (sourceLine == null) {
                addSemanticError(pointerReference, ParsingErrorType.UndefinedJumpLabelReference);
            } else {
                args.setImmediate(sourceLine);
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
     * 
     * @param node     the node of the parse tree which is responsible for
     *                  throwing the error
     * @param errorType type of parsing error
     */
    private void addSemanticError(TerminalNode node, ParsingErrorType errorType) {
        ParsingError err = new ParsingError(node, errorType);
        semanticErrors.add(err);
    }

}
