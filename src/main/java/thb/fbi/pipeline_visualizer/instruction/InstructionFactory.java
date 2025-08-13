package thb.fbi.pipeline_visualizer.instruction;

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
    
    public static TreeMap<Long, Instruction> mapToInstruction(ARMProgram program) {
        TreeMap<Long, Instruction> instructions = new TreeMap<Long, Instruction>();
        for(Map.Entry<Long, ProgramStatement> entry : program.getProgramStatements().entrySet()) {
            ProgramStatement statement = entry.getValue();
            Instruction instruction = new Instruction();
            // register 
            if(statement.getArguments().getRd() != null) {
                instruction.setRd(statement.getArguments().getRd().getId());
            } else {
                instruction.setRd(31);
            }
            if(statement.getArguments().getRn() != null) {
                instruction.setRn(statement.getArguments().getRn().getId());
            } else {
                instruction.setRn(31);
            }
            if(statement.getArguments().getRt() != null) {
                instruction.setRt(statement.getArguments().getRt().getId());
            } else if(statement.getArguments().getRm() != null)  {
                instruction.setRt(statement.getArguments().getRm().getId());
            } else {
                instruction.setRt(31);
            }

            // instruction
            long jumpOffset = 0;
            if(statement.getInstruction() instanceof ArithmeticInstruction) {
                instruction.setFormat(InstructionFormat.Arithmetic);
                instruction.setShamt(statement.getArguments().getShamt());
            } else if(statement.getInstruction() instanceof BranchInstruction) {
                instruction.setFormat(InstructionFormat.Branch);
                jumpOffset = statement.getArguments().getImmediate() - entry.getKey() - thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH;
                instruction.setOffsetIJ(jumpOffset / thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH);
            } else if(statement.getInstruction() instanceof ConditionalBranchInstruction) {
                instruction.setFormat(InstructionFormat.Conditional_Branch);
                jumpOffset = statement.getArguments().getImmediate() - entry.getKey() - thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH;
                instruction.setOffsetIJ(jumpOffset / thb.fbi.leguan.instructions.Instruction.INSTRUCTION_LENGTH);
            } else if(statement.getInstruction() instanceof DataTransferInstruction) {
                instruction.setFormat(InstructionFormat.Datatransfer);
                instruction.setOffsetIJ((int) statement.getArguments().getImmediate());
            } else if(statement.getInstruction() instanceof ImmediateInstruction) {
                instruction.setFormat(InstructionFormat.Immediate);
                instruction.setOffsetIJ(statement.getArguments().getImmediate());
            } else if(statement.getInstruction() instanceof WideImmediateInstruction) {
                instruction.setFormat(InstructionFormat.Wide_Immediate);
                instruction.setOffsetIJ(statement.getArguments().getImmediate());
            }
            instruction.setMnemonic(statement.getInstruction().getMnemonic());
            instruction.setOpcode(statement.getInstruction().getOpcode());
            instruction.setCodeString(statement.getSource());
            instruction.setBinaryCodeString(statement.getInstruction().getMachineCodeString(statement.getArguments()));

            instructions.put(entry.getKey(), instruction);
        }

        return instructions;
    }
}
