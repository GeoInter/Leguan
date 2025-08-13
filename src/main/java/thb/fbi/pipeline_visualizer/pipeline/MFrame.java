/**
 * @author
 * Tahsin Kabir
 * M Tahmid Bari
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import thb.fbi.pipeline_visualizer.instruction.Instruction;
import thb.fbi.pipeline_visualizer.instruction.InstructionFormat;
import thb.fbi.pipeline_visualizer.predictor.TwoBitPrecitionEntry;
import thb.fbi.pipeline_visualizer.predictor.TwoBitPredictorAutomata;
import thb.fbi.pipeline_visualizer.predictor.TwoBitPredictorState;

public class MFrame implements Serializable {

    public Instruction instruction;
    public IF_ID_Pipeline ifIdPipeline;
    public ID_EX_Pipeline idExPipeline;
    public EX_MEM_Pipeline exMemPipeline;
    public MEM_WB_Pipeline memWbPipeline;
    public long[] register;
    public boolean[] regFlag; // boolean indicating if register was changed
    public Memory Memory;
    public ForwardingUnit fwdUnit;
    public HazardDetectionUnit hdUnit;
    public ControlUnit cUnit;
    public ALU ALUnit;
    // used for the visualization part
    public String wbCodeString;
    public long currentPC;
    public long nextPC;
    public int dataHazardCounter; // indicates occurence of data hazard for this cycle
    public int controlHazardCounter; // indicates occurence of control hazard for this cycle
    public boolean isForwardingEnabled;
    public boolean is2BitPredictorEnabled;
    /** table of PC of Branch Instruction, Target PC and State of Predictor */
    public HashMap<Long, TwoBitPrecitionEntry> twoBitPredictionTable;
    public TwoBitPredictorState startingStateOfPrediction;

    public MFrame(boolean isForwardingEnabled, boolean is2BitPredictorEnabled) {
        register = new long[32];
        regFlag = new boolean[32];
        regFlag[31] = true;
        Memory = new Memory();
        ALUnit = new ALU();
        this.idExPipeline = null;
        this.ifIdPipeline = null;
        this.exMemPipeline = null;
        this.memWbPipeline = null;
        this.fwdUnit = null;
        this.hdUnit = null;
        this.dataHazardCounter = 0;
        this.controlHazardCounter = 0;
        this.isForwardingEnabled = isForwardingEnabled;
        this.is2BitPredictorEnabled = is2BitPredictorEnabled;
        twoBitPredictionTable = new HashMap<>();
        this.startingStateOfPrediction = TwoBitPredictorState.LikelyNotTaken;
        wbCodeString = "NOP";
    }

    private void executeWriteBackStage() {
        // Required data to the forwarding unit from MEM/WB pipeline is passed
        this.fwdUnit.RegWriteMemWbAdd = this.memWbPipeline.destReg;
        this.fwdUnit.RegWriteMemWbFlag = this.memWbPipeline.WB.RegWrite;
        this.fwdUnit.RegWriteMemWbValue = 0;

        long WriteData;
        // Following if block does the writing to the reg library for any reg write
        // instruction.
        if (this.memWbPipeline.WB.RegWrite) {
            if (this.memWbPipeline.WB.MemToReg) {
                WriteData = this.memWbPipeline.memoryData;
            } else {
                WriteData = this.memWbPipeline.ALU_result;
            }

            // register 31 has constant value of 0, never override it
            if (this.memWbPipeline.destReg != 31) {
                if (this.memWbPipeline.mnemonic.equals("BL")) {
                    this.register[this.memWbPipeline.destReg] = this.memWbPipeline.PC;
                } else {
                    this.register[this.memWbPipeline.destReg] = WriteData;
                }
            }
            this.regFlag[this.memWbPipeline.destReg] = true;
            this.fwdUnit.RegWriteMemWbValue = WriteData;
        }
        // Data Needed for visualization part
        this.wbCodeString = this.memWbPipeline.codeString;
        this.tempWbMemoryData = this.memWbPipeline.memoryData;
        this.tempWbAluResult = this.memWbPipeline.ALU_result;
        this.tempWbRegWrite = this.memWbPipeline.WB.RegWrite;
        this.tempWbMemToReg = this.memWbPipeline.WB.MemToReg;
    }

    private void executeMemoryStage() {
        this.memWbPipeline = new MEM_WB_Pipeline();
        // This is where I passed required data to the forwarding unit from EX/MEM
        // pipeline
        this.fwdUnit.RegWriteExMemAdd = this.exMemPipeline.destReg;
        this.fwdUnit.RegWriteExMemFlag = this.exMemPipeline.WB.RegWrite;
        this.fwdUnit.RegWriteExMemValue = this.exMemPipeline.ALU_result;
        this.hdUnit.branch = this.exMemPipeline.MEM.branch;
        this.hdUnit.ALUzero = this.exMemPipeline.ALU_zero;
        this.hdUnit.branchAddress = this.exMemPipeline.PCBranch;
        this.hdUnit.exMemRd = this.exMemPipeline.destReg;
        this.hdUnit.exMemRegWrite = this.exMemPipeline.WB.RegWrite;

        // Here datas from EX/MEM pipeline will come to MEM/WB pipeline
        this.memWbPipeline.WB = this.exMemPipeline.WB;
        if (this.exMemPipeline.MEM.MemRead) {
            // access memory, load
            if (this.exMemPipeline.memoryAccessExclusive) {
                // LDXR instruction
                this.memWbPipeline.memoryData = (int) this.Memory.loadExclusive(this.exMemPipeline.ALU_result);
            } else {
                this.memWbPipeline.memoryData = (int) this.Memory.loadBytes(this.exMemPipeline.ALU_result,
                        this.exMemPipeline.byteSizeMemoryAccess);
            }
        } else {
            this.memWbPipeline.memoryData = 0;
        }

        if (this.exMemPipeline.MEM.MemWrite) {
            // access memory, store
            if (this.exMemPipeline.memoryAccessExclusive) {
                // STXR instruction; success of operation is saved onto register Rn
                if (this.Memory.storeExclusive(this.exMemPipeline.ALU_result, this.exMemPipeline.MemDataWrite)) {
                    this.register[this.exMemPipeline.exclusiveCheckRegister] = 0;
                    this.regFlag[this.exMemPipeline.exclusiveCheckRegister] = true;
                } else {
                    this.register[this.exMemPipeline.exclusiveCheckRegister] = 1;
                    this.regFlag[this.exMemPipeline.exclusiveCheckRegister] = true;
                }
            } else {
                this.Memory.storeBytes(this.exMemPipeline.ALU_result, this.exMemPipeline.MemDataWrite,
                        this.exMemPipeline.byteSizeMemoryAccess);
            }
        }
        this.memWbPipeline.ALU_result = this.exMemPipeline.ALU_result;
        this.memWbPipeline.destReg = this.exMemPipeline.destReg;
        this.memWbPipeline.mnemonic = this.exMemPipeline.mnemonic;
        this.memWbPipeline.codeString = this.exMemPipeline.codeString;
        this.memWbPipeline.PC = this.exMemPipeline.PC;

        // Data Needed for visualization part
        this.tempMemMRead = this.exMemPipeline.MEM.MemRead;
        this.tempMemMWrite = this.exMemPipeline.MEM.MemWrite;
        this.tempMemWriteData = this.exMemPipeline.MemDataWrite;
    }

    private void executeExecutionStage() {
        this.fwdUnit.rnValue = this.idExPipeline.rnValue;
        this.fwdUnit.rtValue = this.idExPipeline.rtValue;
        this.fwdUnit.rn = this.idExPipeline.rn;
        this.fwdUnit.rt = this.idExPipeline.rt;

        this.exMemPipeline = new EX_MEM_Pipeline();
        this.exMemPipeline.WB = this.idExPipeline.WB;
        this.exMemPipeline.MEM = this.idExPipeline.MEM;
        this.exMemPipeline.PC = this.idExPipeline.PC;
        long operand1 = this.fwdUnit.valueMuxA();
        long operand2 = this.fwdUnit.valueMuxB();
        this.exMemPipeline.MemDataWrite = operand2;

        if (this.idExPipeline.ALUSrc)
            operand2 = this.idExPipeline.Offset;

        this.exMemPipeline.ALU_result = this.ALUnit.process(operand1,
                operand2, this.idExPipeline.opcode, this.idExPipeline.ALUOp,
                this.idExPipeline.setsFlag);

        if (this.idExPipeline.mnemonic.equals("BR")) {
            // BR uses Register value instead offset
            // regsiter value can be forwarded
            this.exMemPipeline.PCBranch = operand1; // address stored in Rn
        } else {
            this.exMemPipeline.PCBranch = this.idExPipeline.PC + this.idExPipeline.i32Offset * 4;
        }

        this.exMemPipeline.ALU_zero = ALUnit.checkBranchCondition(this.idExPipeline.mnemonic, operand2,
                this.exMemPipeline.ALU_result);

        // following if else block selects the destination register for the next stage
        // BR is the only exception, where Rt needs to be forwarded
        if (this.idExPipeline.RegDest) {
            this.exMemPipeline.destReg = this.idExPipeline.rd;
            this.hdUnit.idExRd = this.idExPipeline.rd;
        } else {
            this.exMemPipeline.destReg = this.idExPipeline.rt;
            this.hdUnit.idExRd = this.idExPipeline.rt;
        }
        this.hdUnit.idExMemRead = this.idExPipeline.MEM.MemRead;
        this.hdUnit.idExRegWrite = this.idExPipeline.WB.RegWrite;

        this.exMemPipeline.codeString = this.idExPipeline.codeString;
        this.exMemPipeline.byteSizeMemoryAccess = this.idExPipeline.byteSizeMemoryAccess;
        this.exMemPipeline.mnemonic = this.idExPipeline.mnemonic;
        this.exMemPipeline.memoryAccessExclusive = this.idExPipeline.memoryAccessExclusive;
        this.exMemPipeline.exclusiveCheckRegister = this.idExPipeline.rt;
        // Data Needed for visualization part
        this.tempExI32Offset = this.idExPipeline.i32Offset;
        this.tempExOpcode = this.idExPipeline.opcode;
        this.tempExShiftLeft2Offset = this.tempExI32Offset * 4;
        this.tempExPC = this.idExPipeline.PC;
        this.tempExAluOp = this.idExPipeline.ALUOp;
        this.tempExDestReg = this.idExPipeline.RegDest;
        this.tempExAluSource = this.idExPipeline.ALUSrc;
        this.tempExOperand2 = operand2;
        this.tempExRd = this.idExPipeline.rd;
    }

    private void executeDecodeStage() {
        this.idExPipeline = new ID_EX_Pipeline();
        this.cUnit = new ControlUnit(this.ifIdPipeline.instruction);

        this.idExPipeline.WB = this.cUnit.WB;
        this.idExPipeline.MEM = this.cUnit.MEM;
        this.idExPipeline.ALUOp = this.cUnit.ALUOp;
        this.idExPipeline.ALUSrc = this.cUnit.ALUSource;
        this.idExPipeline.RegDest = this.cUnit.RegDest;
        this.idExPipeline.PC = this.ifIdPipeline.PC;
        this.idExPipeline.rnValue = this.register[this.ifIdPipeline.instruction.getRn()];
        this.idExPipeline.rn = this.ifIdPipeline.instruction.getRn();
        this.idExPipeline.rtValue = this.register[this.ifIdPipeline.instruction.getRt()];
        this.idExPipeline.rt = this.ifIdPipeline.instruction.getRt();

        // if instruction has a set shift amount, pass that through the offset data path
        if (this.ifIdPipeline.instruction.getShamt() >= 0) {
            this.idExPipeline.i32Offset = this.ifIdPipeline.instruction.getShamt();
        } else {
            this.idExPipeline.i32Offset = this.ifIdPipeline.instruction.getOffsetIJ();
        }

        this.idExPipeline.Offset = this.idExPipeline.i32Offset;
        this.idExPipeline.opcode = this.ifIdPipeline.instruction.getOpcode();
        this.idExPipeline.codeString = this.ifIdPipeline.codeString;
        this.idExPipeline.binaryCodeString = this.ifIdPipeline.instruction.getBinaryCodeString();
        this.idExPipeline.byteSizeMemoryAccess = this.cUnit.byteSizeMemoryAccess;
        this.idExPipeline.mnemonic = this.ifIdPipeline.instruction.getMnemonic();
        this.idExPipeline.memoryAccessExclusive = this.cUnit.memoryAccessExclusive;
        this.idExPipeline.setsFlag = this.cUnit.setsFlag;

        this.idExPipeline.rd = this.ifIdPipeline.instruction.getRd();

        // Input For Hazard UNIT
        this.hdUnit.ifIdRn = this.ifIdPipeline.instruction.getRn();
        this.hdUnit.ifIdRt = this.ifIdPipeline.instruction.getRt();
    }

    /**
     * Executes the Fetch stage. Use a selected Control Hazard option to 
     * determine the next instruction/ next PC value
     * @param PC current program counter value
     * @return adress of the next instruction to load/ fetch
     */
    private long executeFetchStage(long PC) {
        if (is2BitPredictorEnabled && this.memWbPipeline != null) { // dynamic prediction
            // Branching evaluated in MEM stage, +12 behind current PC in Fetch
            TwoBitPrecitionEntry entry = twoBitPredictionTable.get(this.memWbPipeline.PC - 4);

            if (entry != null) {
                boolean isTaken = this.hdUnit.checkBranchHazard();
                TwoBitPredictorState predictedState = entry.getState();

                if (isTaken && (predictedState == TwoBitPredictorState.LikelyNotTaken
                        || predictedState == TwoBitPredictorState.NotTaken)) {
                    this.controlHazardCounter++;
                    if (this.exMemPipeline != null)
                        this.exMemPipeline.Flush();
                    if (this.idExPipeline != null)
                        this.idExPipeline.Flush();
                    entry.setState(TwoBitPredictorAutomata.getNextPrediction(predictedState, isTaken)); // update state
                    this.ifIdPipeline = null;
                    this.nextPC = this.hdUnit.branchAddress; // needed only for the visualization part
                    return this.hdUnit.branchAddress;
                } else if (!isTaken && (predictedState == TwoBitPredictorState.Taken
                        || predictedState == TwoBitPredictorState.LikelyTaken)) {
                    this.controlHazardCounter++;
                    if (this.exMemPipeline != null)
                        this.exMemPipeline.Flush();
                    if (this.idExPipeline != null)
                        this.idExPipeline.Flush();
                    entry.setState(TwoBitPredictorAutomata.getNextPrediction(predictedState, isTaken)); // update state
                    this.ifIdPipeline = null;
                    this.nextPC = this.memWbPipeline.PC;
                    return this.memWbPipeline.PC;
                } else {
                    entry.setState(TwoBitPredictorAutomata.getNextPrediction(predictedState, isTaken)); // update state
                }
            }
        } else { // static prediction: Predict Not Taken

            if (this.hdUnit.checkBranchHazard()) {
                this.controlHazardCounter++;
                if (this.exMemPipeline != null)
                    this.exMemPipeline.Flush();
                if (this.idExPipeline != null)
                    this.idExPipeline.Flush();
                this.ifIdPipeline = null;
                this.nextPC = this.hdUnit.branchAddress; // needed only for the visualization part
                return this.hdUnit.branchAddress;
            }
        }

        if (this.hdUnit.checkDataHazard()) {
            this.idExPipeline.Flush();
            this.dataHazardCounter++;
            this.nextPC = PC;
            return PC;
        }

        // stall when forwarding is disabled
        if (!isForwardingEnabled) {
            if (this.hdUnit.checkUnforwardedDataHazard()) {
                this.idExPipeline.Flush();
                this.dataHazardCounter++;
                this.nextPC = PC;// needed only for the visualization part
                return PC;
            }
        }

        if (is2BitPredictorEnabled) {
            TwoBitPrecitionEntry entry = twoBitPredictionTable.get(PC);
            if (entry != null) {
                if (entry.getState() == TwoBitPredictorState.LikelyTaken
                        || entry.getState() == TwoBitPredictorState.Taken) {
                    Long targetAddress = entry.getTargetPC();
                    this.ifIdPipeline = new IF_ID_Pipeline(instruction, PC + 4);
                    this.nextPC = targetAddress.intValue();
                    return targetAddress.intValue();
                }
            }
        }

        if (instruction == null || instruction.getMnemonic().equals("NOP")) // if null, default type or NOP
            this.ifIdPipeline = null;
        else
            this.ifIdPipeline = new IF_ID_Pipeline(instruction, PC + 4);

        this.nextPC = PC + 4; // needed only for the visualization part
        return PC + 4;
    }

    /**
     * Updates the prediction table by checking if entry already in table or not
     * @param initialPredictorState state to add for this entry
     * @param PC current program counter value
     */
    private void updatePredictionTable(TwoBitPredictorState initialPredictorState, long PC) {
        if (!twoBitPredictionTable.containsKey(PC)) {
            // same calculation as in MEM stage (Note: instead of PC uses nextPC)
            long targetAddress = (PC + 4) + this.instruction.getOffsetIJ() * 4;
            TwoBitPrecitionEntry entry = new TwoBitPrecitionEntry(targetAddress, initialPredictorState,
                    this.instruction.getCodeString());
            twoBitPredictionTable.put(PC, entry);
        }
    }

    /**
     * executes a clockcycle for a given instruction and pc
     * @param instruction instruction to start to fetch (in Fetch stage)
     * @param PC current program counter value
     * @return next program counter value
     */
    long executeClockCycle(Instruction instruction, long PC) {
        this.instruction = instruction; // needed only for the visualization part

        // add conditional branch instructions to prediction Table
        if (this.instruction != null) {
            if (this.instruction.getFormat() == InstructionFormat.Conditional_Branch) {
                updatePredictionTable(startingStateOfPrediction, PC);
            } else if (this.instruction.getFormat() == InstructionFormat.Branch) {
                updatePredictionTable(TwoBitPredictorState.Taken, PC);
            }
        }

        this.currentPC = PC; // needed only for the visualization part
        fwdUnit = new ForwardingUnit(isForwardingEnabled);
        hdUnit = new HazardDetectionUnit();
        this.wbCodeString = "NOP";

        if (this.memWbPipeline != null) {
            executeWriteBackStage();
        }

        if (this.exMemPipeline != null) {
            executeMemoryStage();
        } else {
            this.memWbPipeline = null;
        }

        if (this.idExPipeline != null) {
            executeExecutionStage();
        } else {
            this.exMemPipeline = null;
        }

        if (this.ifIdPipeline != null) {
            executeDecodeStage();
        } else {
            this.idExPipeline = null;
        }

        return executeFetchStage(PC);
    }

    public MFrame getCopy() {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return (MFrame) obj;
    }

    public int tempExAluOp;
    public boolean tempExDestReg;
    public boolean tempExAluSource;
    public long tempExPC;
    public long tempExI32Offset;
    public int tempExOpcode;
    public long tempExShiftLeft2Offset;
    public long tempExOperand2;
    public int tempExRd;
    public boolean tempMemMRead;
    public boolean tempMemMWrite;
    public long tempMemWriteData;
    public int tempWbMemoryData;
    public long tempWbAluResult;
    public boolean tempWbRegWrite;
    public boolean tempWbMemToReg;
}