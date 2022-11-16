package thb.fbi.parser;

import java.util.ArrayList;

import thb.fbi.instructions.Instruction;
import thb.fbi.parser.antlr.LegV8BaseVisitor;
import thb.fbi.parser.antlr.LegV8Parser.ArithmeticInstructionContext;
import thb.fbi.parser.antlr.LegV8Parser.ArithmeticParamContext;
import thb.fbi.parser.antlr.LegV8Parser.DatatransferInstructionContext;
import thb.fbi.parser.antlr.LegV8Parser.DatatransferParamContext;
import thb.fbi.parser.antlr.LegV8Parser.ImmediateInstructionContext;
import thb.fbi.parser.antlr.LegV8Parser.ImmediateParamContext;
import thb.fbi.parser.antlr.LegV8Parser.LineContext;
import thb.fbi.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.parser.antlr.LegV8Parser.RegisterContext;
import thb.fbi.simulation.InstructionArguments;
import thb.fbi.simulation.ProgramStatement;
import thb.fbi.simulation.Register;
import thb.fbi.simulation.Simulator;
import thb.fbi.simulation.SimulatorSingleton;

public class ProgramStatementParser extends LegV8BaseVisitor {

    private static Simulator simulator = SimulatorSingleton.getSimulator();
    private ArrayList<Register> usedRegisters = new ArrayList<Register>();

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
            System.out.println(ctx.declaration().getText());
            instr = (Instruction) visit(ctx.getChild(1));
            args = (InstructionArguments) visit(ctx.getChild(2));
        }
        return new ProgramStatement(instr, args, null, 0);
    }

    @Override
    public Register visitRegister(RegisterContext ctx) {
        String registerName = ctx.REGISTER().getText();
        registerName = registerName.substring(1);
        int index = Integer.parseInt(registerName);
        // TODO: catch OutOfBounds Exception when number exceeds range 
        Register register = simulator.getRegisters()[index];
        if(! usedRegisters.contains(register)) {
            usedRegisters.add(register);
        }
        return register;
    }

    @Override
    public Integer visitNum(NumContext ctx) {
        String numberText = ctx.NUMBER().getText();
        // TODO: catch NumberFormatException
        int number = Integer.parseInt(numberText);
        return number;
    }

    private Instruction getInstructionByName(String instructionName) {
        Instruction instruction = simulator.getInstructionSet().findInstructionByMnemonic(instructionName);
        return instruction;
    }

    @Override
    public Instruction visitArithmeticInstruction(ArithmeticInstructionContext ctx) {
        String instructionName = ctx.getChild(0).getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitImmediateInstruction(ImmediateInstructionContext ctx) {
        String instructionName = ctx.getChild(0).getText();
        return getInstructionByName(instructionName);
    }

    @Override
    public Instruction visitDatatransferInstruction(DatatransferInstructionContext ctx) {
        String instructionName = ctx.getChild(0).getText();
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

}