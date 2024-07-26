package thb.fbi.pipeline_visualizer.pipeline;

import thb.fbi.leguan.data.ARMProgram;
import thb.fbi.leguan.data.ProgramStatement;
import thb.fbi.leguan.instructions.ArithmeticInstruction;
import thb.fbi.leguan.instructions.BranchInstruction;
import thb.fbi.leguan.instructions.ConditionalBranchInstruction;
import thb.fbi.leguan.instructions.DataTransferInstruction;
import thb.fbi.leguan.instructions.ImmediateInstruction;
import thb.fbi.leguan.instructions.WideImmediateInstruction;

import java.util.TreeMap;
import java.util.Map;

public class InstructionFactory {
    
    public static TreeMap<Integer, Instruction> mapToInstruction(ARMProgram program) {
        TreeMap<Integer, Instruction> instructions = new TreeMap<Integer, Instruction>();
        for(Map.Entry<Integer, ProgramStatement> entry : program.getProgramStatements().entrySet()) {
            ProgramStatement statement = entry.getValue();
            Instruction instruction = new Instruction();
            if(statement.getArguments().getRd() != null) {
                instruction.setRd(statement.getArguments().getRd().getID());
            } else {
                instruction.setRd(31);
            }
            if(statement.getArguments().getRn() != null) {
                instruction.setRn(statement.getArguments().getRn().getID());
            } else {
                instruction.setRn(31);
            }
            if(statement.getArguments().getRt() != null) {
                instruction.setRt(statement.getArguments().getRt().getID());
            } else if(statement.getArguments().getRm() != null)  {
                instruction.setRt(statement.getArguments().getRm().getID());
            } else {
                instruction.setRt(31);
            }
            int jumpOffset = 0;
            if(statement.getInstruction() instanceof ArithmeticInstruction) {
                instruction.setType('R');
                instruction.setShamt(statement.getArguments().getShamt());
            } else if(statement.getInstruction() instanceof BranchInstruction) {
                instruction.setType('B');
                jumpOffset = statement.getArguments().getBr_Address() - entry.getKey() - thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH;
                instruction.setOffsetIJ(jumpOffset / thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH);
            } else if(statement.getInstruction() instanceof ConditionalBranchInstruction) {
                instruction.setType('C');
                jumpOffset = statement.getArguments().getCond_Br_Address() - entry.getKey() - thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH;
                instruction.setOffsetIJ(jumpOffset / thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH);
            } else if(statement.getInstruction() instanceof DataTransferInstruction) {
                instruction.setType('D');
                instruction.setOffsetIJ((int) statement.getArguments().getDt_Address());
            } else if(statement.getInstruction() instanceof ImmediateInstruction) {
                instruction.setType('I');
                instruction.setOffsetIJ(statement.getArguments().getAlu_Immediate());
            } else if(statement.getInstruction() instanceof WideImmediateInstruction) {
                instruction.setType('W');
                instruction.setOffsetIJ(statement.getArguments().getAlu_Immediate());
            }
            instruction.setMnemonic(statement.getInstruction().getMnemonic());
            instruction.setOpcode(statement.getInstruction().getOpcode());
            instruction.setCodeString(statement.getSource());

            instructions.put(entry.getKey(), instruction);
        }

        return instructions;
    }
}
