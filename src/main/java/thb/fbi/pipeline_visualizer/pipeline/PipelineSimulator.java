/**
 * @author 'SIN
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import thb.fbi.pipeline_visualizer.parser.ProgramParser;
import thb.fbi.leguan.parser.antlr.LegV8Lexer;
import thb.fbi.leguan.parser.antlr.LegV8Parser;


public class PipelineSimulator {

    public Instruction[] instructions;
    public String code;
    public ArrayList<MFrame> Frames; // equals a clock cycle
    public MFrame FramesRet[];
    public MFrame Frame;
    public ProgramParser programParser = new ProgramParser();
    public int i = 0;
    public String[] Registers = { "X0", "X1", "X2", "X3", "X4", "X5", "X6",
            "X7", "X8", "X9", "X10", "X11", "X12", "X13", "X14",
            "X15", "X16", "X17", "X18", "X19", "X20", "X21", "X22",
            "X23", "X24", "X25", "X26", "X27", "X28(SP)", "X29(FP)", "X30(LR)",
            "XZR" };

    public int clockCycleCounter = 0;
    public int instructionCounter = 0; // includes looped instruction =/= instruction.length
    public int dataHazardCounter = 0;
    public int controlHazardCounter = 0;
    public double cpi = 0; // clocks per instruction
    public double sf = 0; // speed-up factor

    private boolean isForwardingEnabled = true;
    private boolean is2BitPredictorEnabled = false;
    private boolean debugOutput = false;

    public PipelineSimulator() {
        this.instructions = new Instruction[0];
    }

    public MFrame[] execute(Instruction ins[]) {
        Frames = new ArrayList<MFrame>();
        Frame = new MFrame(isForwardingEnabled, is2BitPredictorEnabled);
        this.instructionCounter = 0;
        i = 0;
        while (i < ins.length + 5) {
            Instruction instruction;
            try {
                instruction = ins[i];
            } catch (ArrayIndexOutOfBoundsException a) {
                instruction = null;
            }

            if(debugOutput) System.out.println("clock: " + (Frames.size() + 1) + " PC: " + (i * 4));
            i = this.Frame.insertInstruction(instruction, i * 4) / 4;

            if (i < 0) {
                System.err.println("Negative PC returned: " + i);
            }

            // count non-NOP (not flushed) instructions
            if (this.Frame.memWbPipeline != null) {
                if (!this.Frame.memWbPipeline.iString.equals("NOP")) {
                    this.instructionCounter++;
                }
            }

            Frames.add(Frame.getCopy());
        }
        this.clockCycleCounter = this.Frames.size();

        if(instructionCounter == 0) {
            this.cpi = 0.0;
        } else {
            this.cpi = (double) this.Frames.size() / this.instructionCounter;
        }
        this.sf = (double) (this.instructionCounter * 5) / this.Frames.size();

        this.controlHazardCounter = Frame.controlHazardCounter;
        this.dataHazardCounter = Frame.dataHazardCounter;

        if(debugOutput) {
            for (int j = 0; j < 8; j++) {
                System.out.print(this.Registers[j] + ":\t" + this.Frame.register[j] + "\t");
                System.out.print(this.Registers[8 + j] + ":\t" + this.Frame.register[8 + j] + "\t");
                System.out.print(this.Registers[16 + j] + ":\t" + this.Frame.register[16 + j] + "\t");
                System.out.print(this.Registers[24 + j] + ":\t" + this.Frame.register[24 + j] + "\t");
                System.out.println();
            }
        }
        
        i = 0;
        this.FramesRet = new MFrame[Frames.size()];
        while (i < Frames.size()) {
            FramesRet[i] = (MFrame) Frames.get(i);

            if(debugOutput) {
                if (FramesRet[i].ifIdPipeline == null)
                    System.out.println("IfId null at " + i);
                else if (FramesRet[i].ifIdPipeline.Instruction == null)
                    System.out.println("IfId not null but ins null at " + i);
            }

            i++;
        }

        return FramesRet;
    }

    public MFrame[] execute(String str) {
        LegV8Parser parser = getParser(str);
        ParseTree antlTree = parser.main();
        Instruction[] ins;
        programParser.clear();
        ins = programParser.visit(antlTree);
        this.instructions = ins;
        if(debugOutput) programParser.printCode();
        return this.execute(ins);
    }

    private LegV8Parser getParser(String code) {
        LegV8Parser parser = null;

        CharStream input = CharStreams.fromString(code);
        LegV8Lexer lexer = new LegV8Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new LegV8Parser(tokens);

        return parser;
    }

    public MFrame[] setForwardingEnabled(boolean isForwardingEnabled) {
        this.isForwardingEnabled = isForwardingEnabled;
        return execute(this.instructions);
    }

    public MFrame[] setIs2BitPredictorEnabled(boolean is2BitPredictorEnabled) {
        this.is2BitPredictorEnabled = is2BitPredictorEnabled;
        return execute(this.instructions);
    }

}
