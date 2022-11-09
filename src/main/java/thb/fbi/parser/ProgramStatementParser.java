package thb.fbi.parser;

import java.util.ArrayList;

import thb.fbi.instructions.Instruction;
import thb.fbi.parser.antlr.LegV8BaseVisitor;
import thb.fbi.parser.antlr.LegV8Parser.IinstrContext;
import thb.fbi.parser.antlr.LegV8Parser.IparamContext;
import thb.fbi.parser.antlr.LegV8Parser.LineContext;
import thb.fbi.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.parser.antlr.LegV8Parser.RegisterContext;
import thb.fbi.parser.antlr.LegV8Parser.RinstrContext;
import thb.fbi.parser.antlr.LegV8Parser.RparamContext;
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
        Instruction instr = visitRinstr((RinstrContext)ctx.getChild(0));
        InstructionArguments args = visitRparam((RparamContext)ctx.getChild(1));
        return new ProgramStatement(instr, args, null, 0);
    }

    @Override
    public Register visitRegister(RegisterContext ctx) {
        String registerName = ctx.getChild(0).getText();
        registerName = registerName.substring(1);
        int index = Integer.parseInt(registerName);
        Register register = simulator.getRegisters()[index];
        if(! usedRegisters.contains(register)) {
            usedRegisters.add(register);
        }
        return register;
    }

    @Override
    public Instruction visitRinstr(RinstrContext ctx) {
        String instructionName = ctx.getChild(0).getText();
        Instruction instruction = simulator.getInstructionSet().findInstructionByMnemonic(instructionName);
        return instruction;
    }

    @Override
    public InstructionArguments visitRparam(RparamContext ctx) {
        Register Rd = visitRegister(((RegisterContext)ctx.getChild(0)));
        Register Rn = visitRegister(((RegisterContext)ctx.getChild(2)));
        Register Rm = visitRegister(((RegisterContext)ctx.getChild(4)));
        InstructionArguments args = new InstructionArguments();
        args.setRd(Rd);
        args.setRn(Rn);
        args.setRm(Rm);
        return args;
    }
    //////////////////////////////// LATER ///////////////////////////
    @Override
    public Long visitNum(NumContext ctx) {
        String numberText = ctx.getChild(0).getText();
        long number = Long.parseLong(numberText);
        return number;
    }

    
    @Override
    public Object visitIinstr(IinstrContext ctx) {
        // TODO Auto-generated method stub
        return super.visitIinstr(ctx);
    }

    @Override
    public Object visitIparam(IparamContext ctx) {
        // TODO Auto-generated method stub
        return super.visitIparam(ctx);
    }

    

    

}