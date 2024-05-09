package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.data.ProgramStatement;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ArithmeticInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ArithmeticParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchByRegisterInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchByRegisterParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.CondBranchInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.CondBranchParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DatatransferInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DatatransferParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ExclusiveInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ExclusiveParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.JumpLabelDeclarationContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.JumpLabelReferenceContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.LineContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.RegisterContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.WideImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.WideImmediateParamContext;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;

public class ProgramStatementParser extends LegV8BaseVisitor<Object> {

    private static Simulator simulator = SimulatorSingleton.getSimulator();
    private int programIndex = 0; // current program statement in list

    private ArrayList<ParsingError> semanticErrors;
    private ArrayList<Register> usedRegisters;
    private HashMap<String, Integer> jumpMarks;
    private HashMap<Integer, String> unresolvedMarks;

    
    public ProgramStatementParser(ArrayList<ParsingError> semanticErrors, ArrayList<Register> usedRegisters,
            HashMap<String, Integer> jumpMarks, HashMap<Integer, String> unresolvedMarks) {
        this.semanticErrors = semanticErrors;
        this.usedRegisters = usedRegisters;
        this.jumpMarks = jumpMarks;
        this.unresolvedMarks = unresolvedMarks;
    }

    /**
     * sets Index of ProgramStatement for jumpMarks and ArrayList in ARMProgram
     * 
     * @param programIndex index of current ProgramStatement
     */
    public void setProgramIndex(int programIndex) {
        this.programIndex = programIndex;
    }

    /**
     * returns list of declared jump marks
     * 
     * @return all jump marks
     */
    public HashMap<String, Integer> getJumpMarks() {
        return jumpMarks;
    }

    /**
     * return list of unresolved jump marks (invocation came before declaration)
     * 
     * @return all unresolved jump marks
     */
    public HashMap<Integer, String> getUnresolvedMarks() {
        return unresolvedMarks;
    }

    /**
     * return list of used registers
     * 
     * @return list of (used) parsed registers
     */
    public ArrayList<Register> getUsedRegisters() {
        return usedRegisters;
    }

    @Override
    public ProgramStatement visitLine(LineContext ctx) {
        Instruction instr = null;
        InstructionArguments args = null;
        // generic access to nodes
        if (ctx.jumpLabelDeclaration() == null) {
            instr = (Instruction) visit(ctx.getChild(0));
            args = (InstructionArguments) visit(ctx.getChild(1));
        } else {
            visitJumpLabelDeclaration(ctx.jumpLabelDeclaration());
            instr = (Instruction) visit(ctx.getChild(1));
            args = (InstructionArguments) visit(ctx.getChild(2));
        }
        return new ProgramStatement(instr, args, null, ctx.start.getLine() - 1); // lines are off by 1
    }

    /**
     * visits a single register node
     * maps special registers to index
     */
    @Override
    public Register visitRegister(RegisterContext ctx) {
        String registerName = ctx.REGISTER().getText();
        int index = 0;
        switch (registerName) {
            case "SP":
                index = 28;
                break;
            case "FP":
                index = 29;
                break;
            case "LR":
                index = 30;
                break;
            case "XZR":
                index = 31;
                break;
            default:
                registerName = registerName.substring(1);
                index = Integer.parseInt(registerName);
        }

        Register register = null;
        try {
            register = simulator.getRegisters()[index];
            if (!usedRegisters.contains(register)) {
                usedRegisters.add(register);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            addSemanticError(ctx.REGISTER().getSymbol(), ParsingErrorType.RegisterOutOfRange);
        }
        return register;
    }

    /**
     * visits a single num node
     */
    @Override
    public Integer visitNum(NumContext ctx) {
        String numberText = ctx.NUMBER().getText();
        int number = 0;
        int radix = 0;
        if (numberText.startsWith("0x")) { // hex number
            radix = 16;
            numberText = numberText.substring(2);
        } else { // dec number
            radix = 10;
        }

        try {
            number = Integer.parseInt(numberText, radix);
        } catch (NumberFormatException e) {
            addSemanticError(ctx.NUMBER().getSymbol(), ParsingErrorType.NumberFormatException);
        }
        return number;
    }

    @Override
    public Object visitJumpLabelDeclaration(JumpLabelDeclarationContext ctx) {
        String id = ctx.PointerDeclaration().getText();
        id = id.substring(0, id.length() - 1); // remove ":"
        if (jumpMarks.containsKey(id)) {
            addSemanticError(ctx.PointerDeclaration().getSymbol(), ParsingErrorType.DoubledJumpLabelDeclaration);
        } else {
            jumpMarks.put(id, this.programIndex);
        }
        return null;
    }

    @Override
    public Integer visitJumpLabelReference(JumpLabelReferenceContext ctx) {
        String id = ctx.PointerReference().getText();
        Integer address = jumpMarks.get(id);
        if (address != null) {
            return address;
        } else {
            unresolvedMarks.put(this.programIndex, id);
            return -1;
        }
    }

    /**
     * helper function for retrieving Instruction object
     * 
     * @param instructionName
     * @return
     */
    private Instruction getInstructionByName(String instructionName) {
        Instruction instruction = simulator.getInstructionSet().findInstructionByMnemonic(instructionName);
        return instruction;
    }

    @Override
    public Instruction visitArithmeticInstruction(ArithmeticInstructionContext ctx) {
        String instructionName = ctx.ArithmeticInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitShiftInstruction(ShiftInstructionContext ctx) {
        String instructionName = ctx.ShiftInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitImmediateInstruction(ImmediateInstructionContext ctx) {
        String instructionName = ctx.ImmediateInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitWideImmediateInstruction(WideImmediateInstructionContext ctx) {
        String instructionName = ctx.WideImmediateInstrcution().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitDatatransferInstruction(DatatransferInstructionContext ctx) {
        String instructionName = ctx.DatatransferInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitExclusiveInstruction(ExclusiveInstructionContext ctx) {
        String instructionName = ctx.ExclusiveInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitCondBranchInstruction(CondBranchInstructionContext ctx) {
        String instructionName = ctx.CondBranchInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitBranchInstruction(BranchInstructionContext ctx) {
        String instructionName = ctx.BranchInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitBranchByRegisterInstruction(BranchByRegisterInstructionContext ctx) {
        String instructionName = ctx.BranchByRegisterInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public InstructionArguments visitArithmeticParam(ArithmeticParamContext ctx) {
        Register Rd = visitRegister(ctx.register(0));
        Register Rn = visitRegister(ctx.register(1));
        Register Rm = visitRegister(ctx.register(2));
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }

    @Override
    public InstructionArguments visitImmediateParam(ImmediateParamContext ctx) {
        Register Rd = visitRegister(ctx.register(0));
        Register Rn = visitRegister(ctx.register(1));
        int alu_immediate = visitNum(ctx.num());
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setAlu_Immediate(alu_immediate);
        return args;
    }

    @Override
    public InstructionArguments visitWideImmediateParam(WideImmediateParamContext ctx) {
        Register Rd = visitRegister(ctx.register());
        int immediate = visitNum(ctx.num(0));
        int shamt = visitNum(ctx.num(1));
        // only allows 0, 16, 32 and 48 as shift value
        if (shamt != 0 && shamt != 16 && shamt != 32 && shamt != 48) {
            addSemanticError(ctx.num(1).NUMBER().getSymbol(), ParsingErrorType.WideImmediateShiftOutOfRange);
        }
        if (ctx.ShiftInstruction().getText().equals("LSR")) {
            addSemanticError(ctx.ShiftInstruction().getSymbol(), ParsingErrorType.WrongShiftforWideImmediate);
        }
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setAlu_Immediate(immediate);
        args.setShamt(shamt);
        return args;
    }

    @Override
    public InstructionArguments visitDatatransferParam(DatatransferParamContext ctx) {
        Register Rt = visitRegister(ctx.register(0));
        Register Rn = visitRegister(ctx.register(1));
        int dt_address = visitNum(ctx.num());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setRn(Rn);
        args.setDt_Address(dt_address);
        return args;
    }

    @Override
    public InstructionArguments visitExclusiveParam(ExclusiveParamContext ctx) {
        Register Rd = visitRegister(ctx.register(0));
        Register Rn = visitRegister(ctx.register(1));
        Register Rm = visitRegister(ctx.register(2));
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }

    @Override
    public InstructionArguments visitCondBranchParam(CondBranchParamContext ctx) {
        Register Rt = visitRegister(ctx.register());
        int cond_br_address = visitJumpLabelReference(ctx.jumpLabelReference());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setCond_Br_Address(cond_br_address);
        return args;
    }

    @Override
    public InstructionArguments visitBranchParam(BranchParamContext ctx) {
        int br_address = visitJumpLabelReference(ctx.jumpLabelReference());
        InstructionArguments args = new InstructionArguments();
        args.setBr_Address(br_address);
        return args;
    }

    @Override
    public InstructionArguments visitBranchByRegisterParam(BranchByRegisterParamContext ctx) {
        Register Rt = visitRegister(ctx.register());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        return args;
    }

    @Override
    public InstructionArguments visitShiftParam(ShiftParamContext ctx) {
        Register Rd = visitRegister(ctx.register(0));
        Register Rn = visitRegister(ctx.register(1));
        int shamt = visitNum(ctx.num());
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setShamt(shamt);
        return args;
    }

    /**
     * helper function for adding parser error to list
     * @param token the token of the parse tree which is responsible for throwing the error 
     * @param errorType type of parsing error
     */
    private void addSemanticError(Token token, ParsingErrorType errorType) {
        int line = token.getLine();
        int pos = token.getCharPositionInLine();
        ParsingError err = new ParsingError(line, pos, errorType);
        semanticErrors.add(err);
    }

}
