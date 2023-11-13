package thb.fbi.pipeline_visualizer.parser;

import java.util.HashMap;

import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.ProgramContext;
import thb.fbi.pipeline_visualizer.pipeline.Instruction;

public class ProgramParser extends LegV8BaseVisitor<Instruction[]> {

    private Instruction[] instructions;
    private String[] lines;
    private HashMap<String, Integer> jumpMarks = new HashMap<String, Integer>();
    private HashMap<Integer, String> unresolvedMarks = new HashMap<Integer, String>();

    @Override
    public Instruction[] visitMain(MainContext ctx) {
        return visitProgram(ctx.program());
    }

    @Override
    public Instruction[] visitProgram(ProgramContext ctx) {
        InstructionParser instructionParser = new InstructionParser(jumpMarks, unresolvedMarks);
        this.instructions = new Instruction[ctx.line().size()];
        this.lines = new String[ctx.line().size()];

        for (int i = 0; i < ctx.line().size(); i++) {
            instructionParser.setProgramIndex(i);
            Instruction instruction = instructionParser.visitLine(ctx.line(i));
            instructions[i] = instruction;
            lines[i] = ctx.line(i).getText();
        }


        // re-resolve marks when later declared
        HashMap<String, Integer> jumpMarks = instructionParser.getJumpMarks();
        HashMap<Integer, String> unresolvedMarks = instructionParser.getUnresolvedMarks();

        for (Integer index : unresolvedMarks.keySet()) {
            Instruction instruction = instructions[index];

            if(instruction.getOffsetIJ() == 0) {
                String id = unresolvedMarks.get(index);
                Integer sourceLine = jumpMarks.get(id);

                if(sourceLine != null) {
                    // resolve jump labels for forward branching (skip code)
                    // instead of a target address calculate distance between 
                    // branch instruction and label to jump to
                    // othwerwise addition with PC displaces the address
                    int target = sourceLine.shortValue() - 1; // Subtract one, because new address will include nextPC value
                    short address = (short) (target - index);
                    instruction.setOffsetIJ(address);
                }
                
            }
        }
        return instructions;
    }

    /**
     * clears all arrays and maps
     * resetting found jumpMarks
     */
    public void clear() {
        jumpMarks.clear();
        unresolvedMarks.clear();
    }

    public void printCode() {
        for (int i = 0; i < instructions.length; i++) {
            String str = "";
            str = "" + (i + 1) + " " + this.lines[i] + ";\t";
            if (str.length() < "9 addi $t5 , $t4 , 500;	 ".length()) {
                str = str + "\t";
            }
            str = str + " Decoded : ";
            System.out.print(str);
            this.instructions[i].printInstruction();
        }
    }
}
