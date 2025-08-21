package thb.fbi.leguan.parser;

import java.util.HashMap;
import java.util.Set;

import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.data.ProgramStatement;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ArithmeticInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ArithmeticParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.B_cond_InstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.B_cond_ParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchByRegisterInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchByRegisterParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.CondBranchInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.CondBranchParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentLabelReferenceContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DatatransferInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DatatransferParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ExclusiveInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ExclusiveParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_arithmeticInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_arithmeticParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_compareInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_compareParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_datatransferInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_datatransferParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Fp_registerContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.Integer_registerContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.JumpLabelDeclarationContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.JumpLabelReferenceContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.LineContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.WideImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.WideImmediateParamContext;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.simulation.RegisterFile;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;

public class ProgramStatementParser extends LegV8BaseVisitor<Object> {

    private static Simulator simulator = SimulatorSingleton.getSimulator();
    private long programIndex = 0; // current program statement in list

    private Set<Register> usedRegisters;
    private HashMap<String, Long> jumpMarks;
    private HashMap<Long, TerminalNode> unresolvedMarks;
    private HashMap<String, Long> dataSegmentVariables;

    public ProgramStatementParser(Set<Register> usedRegisters, HashMap<String, Long> jumpMarks,
            HashMap<Long, TerminalNode> unresolvedMarks, HashMap<String, Long> dataSegmentVariables) {
        this.usedRegisters = usedRegisters;
        this.jumpMarks = jumpMarks;
        this.unresolvedMarks = unresolvedMarks;
        this.dataSegmentVariables = dataSegmentVariables;
    }

    /**
     * sets Index of ProgramStatement for jumpMarks and ArrayList in ARMProgram
     * 
     * @param programIndex index of current ProgramStatement
     */
    public void setProgramIndex(long programIndex) {
        this.programIndex = programIndex;
    }

    /**
     * returns list of declared jump marks
     * 
     * @return all jump marks
     */
    public HashMap<String, Long> getJumpMarks() {
        return jumpMarks;
    }

    /**
     * return list of unresolved jump marks (invocation came before declaration)
     * 
     * @return all unresolved jump marks
     */
    public HashMap<Long, TerminalNode> getUnresolvedMarks() {
        return unresolvedMarks;
    }

    /**
     * return list of used registers
     * 
     * @return list of (used) parsed registers
     */
    public Set<Register> getUsedRegisters() {
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
        // get original line of code (excludes label and not comments)
        int start = ctx.start.getStartIndex();
        int end = ctx.stop.getStopIndex();
        Interval interval = new Interval(start, end);
        String codeString = ctx.start.getInputStream().getText(interval);
        codeString = codeString.replace('\n', ' ');
        int endOfLabel = codeString.indexOf(":");
        codeString = codeString.substring(endOfLabel+1);
        codeString = codeString.trim();
        return new ProgramStatement(instr, args, codeString, ctx.start.getLine() - 1, ctx.stop.getLine() - 1); // lines are starting at 1
    }

    /**
     * visits a single register node
     * maps special registers to index
     */
    private IntegerRegister visitIntegerRegister(Integer_registerContext ctx) {
        String registerName = ctx.INTEGER_REGISTER().getText();
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

        if (index > 31) {
            ParserHelper.addSemanticError(ctx.INTEGER_REGISTER(), ParsingErrorType.RegisterOutOfRange);
        }

        IntegerRegister register = null;
        try {
            register = RegisterFile.getIntegerRegister(index);
            if (!usedRegisters.contains(register)) {
                usedRegisters.add(register);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ParserHelper.addSemanticError(ctx.INTEGER_REGISTER(), ParsingErrorType.RegisterOutOfRange);
        }
        return register;
    }

    private FPRegister visitFPRegister(Fp_registerContext ctx) {
        String registerName = ctx.getText();
        int index = 0;

        registerName = registerName.substring(1);
        index = Integer.parseInt(registerName);

        FPRegister register = null; 
        try {
            register = RegisterFile.getFPRegister(index);
            if (!usedRegisters.contains(register)) {
                usedRegisters.add(register);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ParserHelper.addSemanticError(ctx.FP_REGISTER(), ParsingErrorType.RegisterOutOfRange);
        }
        return register;
    }

    /**
     * visits a single num node
     */
    @Override
    public Long visitNum(NumContext ctx) {
        String numberText = ctx.NUMBER().getText();
        long number = 0;
        int radix = 0;
        if (numberText.startsWith("0x")) { // hex number
            radix = 16;
            numberText = numberText.substring(2);
        } else { // dec number
            radix = 10;
        }

        try {
            number = Long.parseLong(numberText, radix);
        } catch (NumberFormatException e) {
            ParserHelper.addSemanticError(ctx.NUMBER(), ParsingErrorType.NumberFormatException);
        }
        return number;
    }

    @Override
    public Object visitJumpLabelDeclaration(JumpLabelDeclarationContext ctx) {
        String id = ctx.PointerDeclaration().getText();
        id = id.substring(0, id.length() - 1); // remove ":"
        if (ParserHelper.isLabelNameValid(id)) {
            if (jumpMarks.containsKey(id)) {
                ParserHelper.addSemanticError(ctx.PointerDeclaration(), ParsingErrorType.DoubledJumpLabelDeclaration);
            } else {
                jumpMarks.put(id, this.programIndex);
            }
        } else {
            ParserHelper.addSemanticError(ctx.PointerDeclaration(), ParsingErrorType.InvalidLabelName);
        }
        return null;
    }

    @Override
    public Long visitJumpLabelReference(JumpLabelReferenceContext ctx) {
        String id = ctx.PointerReference().getText();
        if (ParserHelper.isLabelNameValid(id)) {
            Long address = jumpMarks.get(id);
            if (address != null) {
                return address;
            } else {
                unresolvedMarks.put(this.programIndex, ctx.PointerReference());
            }
        } else {
            ParserHelper.addSemanticError(ctx.PointerReference(), ParsingErrorType.InvalidLabelName);
        }
        return -1L;
    }

    @Override
    public Long visitDataSegmentLabelReference(DataSegmentLabelReferenceContext ctx) {
        String id = ctx.PointerReference().getText();
        if (ParserHelper.isLabelNameValid(id)) {
            Long address = dataSegmentVariables.get(id);
            if (address != null) {
                return address;
            } else {
                ParserHelper.addSemanticError(ctx.PointerReference(), ParsingErrorType.UndefinedJumpLabelReference);
            }
        } else {
            ParserHelper.addSemanticError(ctx.PointerReference(), ParsingErrorType.InvalidLabelName);
        }
        return -1L;
    }

    /**
     * helper function for retrieving Instruction object
     * 
     * @param instructionName
     * @return
     */
    private Instruction getInstructionByName(String instructionName) {
        Instruction instruction = simulator.getInstructionSet().findInstructionByMnemonic(instructionName);
        if(instruction == null) {
            instruction = simulator.getInstructionSet().findInstructionByMnemonic("NULL");
        }
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
    public Instruction visitB_cond_Instruction(B_cond_InstructionContext ctx) {
        String instructionName = ctx.B_cond_Instruction().getText();
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
    public Instruction visitDataSegmentInstruction(DataSegmentInstructionContext ctx) {
        String instructionName = ctx.DataSegmentInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public InstructionArguments visitArithmeticParam(ArithmeticParamContext ctx) {
        Register Rd = visitIntegerRegister(ctx.integer_register(0));
        Register Rn = visitIntegerRegister(ctx.integer_register(1));
        Register Rm = visitIntegerRegister(ctx.integer_register(2));
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }

    @Override
    public InstructionArguments visitImmediateParam(ImmediateParamContext ctx) {
        Register Rd = visitIntegerRegister(ctx.integer_register(0));
        Register Rn = visitIntegerRegister(ctx.integer_register(1));
        long alu_immediate = visitNum(ctx.num());
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setImmediate(alu_immediate);
        return args;
    }

    @Override
    public InstructionArguments visitWideImmediateParam(WideImmediateParamContext ctx) {
        Register Rd = visitIntegerRegister(ctx.integer_register());
        long immediate = visitNum(ctx.num(0));
        int shamt = visitNum(ctx.num(1)).intValue();
        // only allows 0, 16, 32 and 48 as shift value
        if (shamt != 0 && shamt != 16 && shamt != 32 && shamt != 48) {
            ParserHelper.addSemanticError(ctx.num(1).NUMBER(), ParsingErrorType.WideImmediateShiftOutOfRange);
        }
        if (ctx.ShiftInstruction().getText().equals("LSR")) {
            ParserHelper.addSemanticError(ctx.ShiftInstruction(), ParsingErrorType.WrongShiftforWideImmediate);
        }
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setImmediate(immediate);
        args.setShamt(shamt);
        return args;
    }

    @Override
    public InstructionArguments visitDatatransferParam(DatatransferParamContext ctx) {
        Register Rt = visitIntegerRegister(ctx.integer_register(0));
        Register Rn = visitIntegerRegister(ctx.integer_register(1));
        long dt_address = visitNum(ctx.num());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setRn(Rn);
        args.setImmediate(dt_address);
        return args;
    }

    @Override
    public InstructionArguments visitExclusiveParam(ExclusiveParamContext ctx) {
        Register Rd = visitIntegerRegister(ctx.integer_register(0));
        Register Rn = visitIntegerRegister(ctx.integer_register(1));
        Register Rm = visitIntegerRegister(ctx.integer_register(2));
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }

    @Override
    public InstructionArguments visitCondBranchParam(CondBranchParamContext ctx) {
        Register Rt = visitIntegerRegister(ctx.integer_register());
        long cond_br_address = visitJumpLabelReference(ctx.jumpLabelReference());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setImmediate(cond_br_address);
        return args;
    }

    @Override
    public InstructionArguments visitB_cond_Param(B_cond_ParamContext ctx) {
        long cond_br_address = visitJumpLabelReference(ctx.jumpLabelReference());
        InstructionArguments args = new InstructionArguments();
        args.setImmediate(cond_br_address);
        return args;
    }

    @Override
    public InstructionArguments visitBranchParam(BranchParamContext ctx) {
        long br_address = visitJumpLabelReference(ctx.jumpLabelReference());
        InstructionArguments args = new InstructionArguments();
        args.setImmediate(br_address);
        return args;
    }

    @Override
    public InstructionArguments visitBranchByRegisterParam(BranchByRegisterParamContext ctx) {
        Register Rt = visitIntegerRegister(ctx.integer_register());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        return args;
    }

    @Override
    public InstructionArguments visitShiftParam(ShiftParamContext ctx) {
        Register Rd = visitIntegerRegister(ctx.integer_register(0));
        Register Rn = visitIntegerRegister(ctx.integer_register(1));
        int shamt = visitNum(ctx.num()).intValue();
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setShamt(shamt);
        return args;
    }

    @Override
    public InstructionArguments visitDataSegmentParam(DataSegmentParamContext ctx) {
        Register Rt = visitIntegerRegister(ctx.integer_register());
        Register Rn = RegisterFile.getIntegerRegister(31);
        long dt_address = visitDataSegmentLabelReference(ctx.dataSegmentLabelReference());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setRn(Rn);
        args.setImmediate(dt_address);
        return args;
    }

    @Override
    public Instruction visitFp_arithmeticInstruction(Fp_arithmeticInstructionContext ctx) {
        String instructionName = ctx.FP_ArithemticInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public InstructionArguments visitFp_arithmeticParam(Fp_arithmeticParamContext ctx) {
        Register Rd = visitFPRegister(ctx.fp_register(0));
        Register Rn = visitFPRegister(ctx.fp_register(1));
        Register Rm = visitFPRegister(ctx.fp_register(2));
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }

    @Override
    public Instruction visitFp_datatransferInstruction(Fp_datatransferInstructionContext ctx) {
        String instructionName = ctx.FP_DatatransferInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public InstructionArguments visitFp_datatransferParam(Fp_datatransferParamContext ctx) {
        Register Rt = visitFPRegister(ctx.fp_register());
        Register Rn = visitIntegerRegister(ctx.integer_register());
        long dt_address = visitNum(ctx.num());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setRn(Rn);
        args.setImmediate(dt_address);
        return args;
    }

    @Override
    public Instruction visitFp_compareInstruction(Fp_compareInstructionContext ctx) {
        String instructionName = ctx.FP_CompareInstruction().getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public InstructionArguments visitFp_compareParam(Fp_compareParamContext ctx) {
        Register Rn = visitFPRegister(ctx.fp_register(0));
        Register Rm = visitFPRegister(ctx.fp_register(1));
        InstructionArguments args = new InstructionArguments();
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }

}
