package thb.fbi.pipeline_visualizer.parser;

import java.util.HashMap;

import org.antlr.v4.runtime.Token;

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
import thb.fbi.leguan.parser.antlr.LegV8Parser.DeclarationContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ExclusiveInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ExclusiveParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ImmediateParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.InvocationContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.LineContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.RegisterContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ShiftParamContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.WideImmediateInstructionContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.WideImmediateParamContext;
import thb.fbi.pipeline_visualizer.pipeline.Instruction;

public class InstructionParser extends LegV8BaseVisitor<Object> {

    private Instruction instruction;
    private HashMap<String, Integer> jumpMarks;
    private HashMap<Integer, String> unresolvedMarks;
    private int programIndex = 0; // code line

    public InstructionParser(HashMap<String, Integer> jumpMarks, HashMap<Integer, String> unresolvedMarks) {
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

    @Override
    public Instruction visitLine(LineContext ctx) {
        this.instruction = new Instruction();

        if (ctx.declaration() == null) {
            visit(ctx.getChild(0));
            visit(ctx.getChild(1));
            this.instruction.setString(ctx.getChild(0).getText() + " " + ctx.getChild(1).getText());
        } else {
            visitDeclaration(ctx.declaration());
            visit(ctx.getChild(1));
            visit(ctx.getChild(2));
            this.instruction.setString(
                    ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " + ctx.getChild(2).getText());
        }
        return instruction;
    }

    @Override
    public Object visitDeclaration(DeclarationContext ctx) {
        String id = ctx.PointerDeclaration().getText();
        id = id.substring(0, id.length() - 1); // remove ":"
        if (! jumpMarks.containsKey(id)) {
            jumpMarks.put(id, this.programIndex);
        }
        return null;
    }

    @Override
    public Integer visitInvocation(InvocationContext ctx) {
        String id = ctx.PointerReference().getText();
        Integer address = jumpMarks.get(id);
        if (address != null) { // calculate difference and multiply by -1
            return (programIndex - address + 1) * -1;
        } else {
            unresolvedMarks.put(this.programIndex, id);
            return 0;
        }
    }

    @Override
    public Integer visitNum(NumContext ctx) {
        String numberText = ctx.NUMBER().getText();
        int number = 0;
        try {
            number = Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            Token token = ctx.NUMBER().getSymbol();
            int line = token.getLine();
            int pos = token.getCharPositionInLine();
            System.out.println("Error at (" + line + ", " + pos + ") for Token: " + token);
        }
        return number;
    }

    @Override
    public Integer visitRegister(RegisterContext ctx) {
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
        return index;
    }

    @Override
    public Object visitArithmeticParam(ArithmeticParamContext ctx) {
        this.instruction.setRd(visitRegister(ctx.register(0)));
        this.instruction.setRs(visitRegister(ctx.register(1)));
        this.instruction.setRt(visitRegister(ctx.register(2)));
        return null;
    }

    @Override
    public Object visitBranchByRegisterParam(BranchByRegisterParamContext ctx) {
        this.instruction.setRs(visitRegister(ctx.register()));
        return null;
    }

    @Override
    public Object visitBranchParam(BranchParamContext ctx) {
        this.instruction.setOffsetIJ(visitInvocation(ctx.invocation()).shortValue());
        return null;
    }

    @Override
    public Object visitCondBranchParam(CondBranchParamContext ctx) {
        this.instruction.setOffsetIJ(visitInvocation(ctx.invocation()).shortValue());
        this.instruction.setRs(visitRegister(ctx.register()));
        return null;
    }

    @Override
    public Object visitDatatransferParam(DatatransferParamContext ctx) {
        this.instruction.setRt(visitRegister(ctx.register(0)));
        this.instruction.setRs(visitRegister(ctx.register(1)));
        short address = visitNum(ctx.num()).shortValue();
        this.instruction.setOffsetIJ(address);
        return null;
    }

    @Override
    public Object visitExclusiveParam(ExclusiveParamContext ctx) {
        this.instruction.setRd(visitRegister(ctx.register(0)));
        this.instruction.setRs(visitRegister(ctx.register(2)));
        this.instruction.setRt(visitRegister(ctx.register(1)));
        return null;
    }

    @Override
    public Object visitImmediateParam(ImmediateParamContext ctx) {
        this.instruction.setRd(visitRegister(ctx.register(0)));
        this.instruction.setRs(visitRegister(ctx.register(1)));
        short offset = visitNum(ctx.num()).shortValue();
        this.instruction.setOffsetIJ(offset);
        return null;
    }

    @Override
    public Object visitShiftParam(ShiftParamContext ctx) {
        this.instruction.setRd(visitRegister(ctx.register(0)));
        this.instruction.setRs(visitRegister(ctx.register(1)));
        this.instruction.setRt(0);
        this.instruction.setShamt(visitNum(ctx.num()));
        return null;
    }

    @Override
    public Object visitWideImmediateParam(WideImmediateParamContext ctx) {
        return super.visitWideImmediateParam(ctx);
    }

    // Instruction
    @Override
    public Object visitArithmeticInstruction(ArithmeticInstructionContext ctx) {
        this.instruction.setType('R');
        this.instruction.setOp(0);
        int alu_function = -1;
        boolean setsFlag = false;

        switch (ctx.ArithmeticInstruction().getText()) {
            case "ADDS":
                setsFlag = true;
            case "ADD":
                alu_function = 32;
                break;
            case "ANDS":
                setsFlag = true;
            case "AND":
                alu_function = 36;
                break;
            case "EOR":
                alu_function = 40;
                break;
            case "ORR":
                alu_function = 37;
                break;
            case "SUBS":
                setsFlag = true;
            case "SUB":
                alu_function = 34;
                break;
        }
        this.instruction.setFunction(alu_function);
        this.instruction.setSetsFlag(setsFlag);

        return null;
    }

    @Override
    public Object visitBranchByRegisterInstruction(BranchByRegisterInstructionContext ctx) {
        this.instruction.setType('P'); // BranchByRegister is hardly predictable
        this.instruction.setOp(4);
        this.instruction.setBranchCheck(ctx.getText());
        return null;
    }

    @Override
    public Object visitBranchInstruction(BranchInstructionContext ctx) {
        if (ctx.BranchInstruction().getText().matches("B|BL")) {
            this.instruction.setType('B');
        } else {
            this.instruction.setType('C');
        }

        if (ctx.BranchInstruction().getText().equals("BL")) { // BL uses Register 30
            this.instruction.setRd(30);
            this.instruction.setOp(34);
        } else {
            this.instruction.setOp(4);
        }

        this.instruction.setBranchCheck(ctx.getText());
        return null;
    }

    @Override
    public Object visitCondBranchInstruction(CondBranchInstructionContext ctx) {
        this.instruction.setType('C');
        this.instruction.setOp(4);
        this.instruction.setBranchCheck(ctx.getText());
        return null;
    }

    @Override
    public Object visitDatatransferInstruction(DatatransferInstructionContext ctx) {
        this.instruction.setType('D');
        String instructionName = ctx.DatatransferInstruction().getText();
        switch (instructionName) {
            case "STUR":
                this.instruction.setByteSizeMemoryAccess((byte) 8);
                this.instruction.setOp(43);
                break;
            case "LDUR":
                this.instruction.setByteSizeMemoryAccess((byte) 8);
                this.instruction.setOp(35);
                break;
            case "LDXR":
                this.instruction.setByteSizeMemoryAccess((byte) 8);
                this.instruction.setOp(35);
                this.instruction.setMemoryAccessExclusive(true);
                break;
            case "STURB":
                this.instruction.setByteSizeMemoryAccess((byte) 1);
                this.instruction.setOp(43);
                break;
            case "LDURB":
                this.instruction.setByteSizeMemoryAccess((byte) 1);
                this.instruction.setOp(35);
                break;
            case "STURH":
                this.instruction.setByteSizeMemoryAccess((byte) 2);
                this.instruction.setOp(43);
                break;
            case "LDURH":
                this.instruction.setByteSizeMemoryAccess((byte) 2);
                this.instruction.setOp(35);
                break;
            case "STURW":
                this.instruction.setByteSizeMemoryAccess((byte) 4);
                this.instruction.setOp(43);
                break;
            case "LDURSW":
                this.instruction.setByteSizeMemoryAccess((byte) 4);
                this.instruction.setOp(35);
                break;
        }
        return null;
    }

    @Override
    public Object visitExclusiveInstruction(ExclusiveInstructionContext ctx) {
        this.instruction.setType('D');
        this.instruction.setByteSizeMemoryAccess((byte) 8);
        this.instruction.setOp(6);
        this.instruction.setMemoryAccessExclusive(true);
        return null;
    }

    @Override
    public Object visitImmediateInstruction(ImmediateInstructionContext ctx) {
        this.instruction.setType('I');
        this.instruction.setOp(3); // for mapping see control unit
        int alu_function = -1;
        boolean setsFlag = false;

        switch (ctx.ImmediateInstruction().getText()) {
            case "ADDIS":
                setsFlag = true;
            case "ADDI":
                alu_function = 32;
                break;
            case "ANDIS":
                setsFlag = true;
            case "ANDI":
                alu_function = 36;
                break;
            case "EORI":
                alu_function = 40;
                break;
            case "ORRI":
                alu_function = 37;
                break;
            case "SUBIS":
                setsFlag = true;
            case "SUBI":
                alu_function = 34;
                break;
        }
        this.instruction.setFunction(alu_function);
        this.instruction.setSetsFlag(setsFlag);
        return null;
    }

    @Override
    public Object visitShiftInstruction(ShiftInstructionContext ctx) {
        this.instruction.setType('R');
        // shift amount is handled as an immediate-like instructions offset parameter
        this.instruction.setOp(5);
        if (ctx.getText().equals("LSL")) {
            this.instruction.setFunction(0);
        } else if (ctx.getText().equals("LSR")) {
            this.instruction.setFunction(2);
        }
        return null;
    }

    @Override
    public Object visitWideImmediateInstruction(WideImmediateInstructionContext ctx) {
        return super.visitWideImmediateInstruction(ctx);
    }

}
