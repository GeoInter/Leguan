package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ArithmeticInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ArithmeticParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.BranchParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.CondBranchInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.CondBranchParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DatatransferInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DatatransferParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DeclarationContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.InvocationContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.LineContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.RegisterContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftParamContext;
import thb.fbi.leguan.simulation.InstructionArguments;
import thb.fbi.leguan.simulation.ProgramStatement;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.simulation.Simulator;
import thb.fbi.leguan.simulation.SimulatorSingleton;

public class ProgramStatementParser extends LegV8BaseVisitor<Object> {

    private static Simulator simulator = SimulatorSingleton.getSimulator();
    private int sourceLine = 0; // current line of source code for jumpMark resolving

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

    public void setSourceLine(int sourceLine) {
        this.sourceLine = sourceLine;
    }

    /**
     * returns list of declared jump marks
     * @return all jump marks
     */
    public HashMap<String, Integer> getJumpMarks() {
        return jumpMarks;
    }

    /**
     * return list of unresolved jump marks (invocation came before declaration)
     * @return all unresolved jump marks
     */
    public HashMap<Integer, String> getUnresolvedMarks() {
        return unresolvedMarks;
    }

    /**
     * return list of used registers
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
        if(ctx.declaration() == null) {
            instr = (Instruction) visit(ctx.getChild(0));
            args = (InstructionArguments) visit(ctx.getChild(1));
        } else {
            visitDeclaration(ctx.declaration());
            instr = (Instruction) visit(ctx.getChild(1));
            args = (InstructionArguments) visit(ctx.getChild(2));
        }
        return new ProgramStatement(instr, args, null, ctx.start.getLine());
    }

    /**
     * visits a single register node
     * maps special registers to index
     */
    @Override
    public Register visitRegister(RegisterContext ctx) {
        String registerName = ctx.REGISTER().getText();
        int index = 0;
        switch(registerName) {
            case "SP": index = 28; break;
            case "FP": index = 29; break;
            case "LR": index = 30; break;
            case "XZR": index = 31; break;
            default:
                registerName = registerName.substring(1);
                index = Integer.parseInt(registerName);
        }
        
        Register register = null;
        try {
            register = simulator.getRegisters()[index];
            if(! usedRegisters.contains(register)) {
                usedRegisters.add(register);
            }
        } catch(ArrayIndexOutOfBoundsException  e) {
            Token token = ctx.REGISTER().getSymbol();
            int line = token.getLine();
            int pos = token.getCharPositionInLine();
            ParsingError err = new ParsingError(line, pos, ParsingErrorType.RegisterOutOfRange);
            semanticErrors.add(err);
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
        try {
            number = Integer.parseInt(numberText);
        } catch(NumberFormatException e) {
            Token token = ctx.NUMBER().getSymbol();
            int line = token.getLine();
            int pos = token.getCharPositionInLine();
            ParsingError err = new ParsingError(line, pos, ParsingErrorType.NumberFormatException);
            semanticErrors.add(err);
        }
        return number;
    }

    @Override
    public Object visitDeclaration(DeclarationContext ctx) {
        String id = ctx.JumpDeclaration().getText();
        id = id.substring(0, id.length()-1); //remove ":"
        jumpMarks.put(id, this.sourceLine);
        return null;
    }

    @Override
    public Integer visitInvocation(InvocationContext ctx) {
        String id = ctx.JumpInvocation().getText();
        Integer address = jumpMarks.get(id);
        if(address != null) {
            return address;
        } else {
            unresolvedMarks.put(this.sourceLine, id);
            return -1;
        }
    }

    /**
     * helper function for retrieving Instruction object
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
    public Instruction visitDatatransferInstruction(DatatransferInstructionContext ctx) {
        String instructionName = ctx.DatatransferInstruction().getText();
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
    public InstructionArguments visitCondBranchParam(CondBranchParamContext ctx) {
        Register Rt = visitRegister(ctx.register());
        int cond_br_address = visitInvocation(ctx.invocation());
        InstructionArguments args = new InstructionArguments();
        args.setRt(Rt);
        args.setCond_Br_Address(cond_br_address);
        return args;
    }

    @Override
    public InstructionArguments visitBranchParam(BranchParamContext ctx) {
        int br_address = visitInvocation(ctx.invocation());
        InstructionArguments args = new InstructionArguments();
        args.setBr_Address(br_address);
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

}
