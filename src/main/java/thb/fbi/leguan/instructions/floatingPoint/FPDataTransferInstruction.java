package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.RegisterFile;
import thb.fbi.leguan.utility.MachineCodeTranslator;

public class FPDataTransferInstruction extends Instruction {
    
    private IFPDataTransferCode dataTransferCode;

    public FPDataTransferInstruction(String mnemonic, int opcode, String description, IFPDataTransferCode dataTransferCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setDataTransferCode(dataTransferCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        long dt_address = argument.getImmediate();
        IntegerRegister Rn = (IntegerRegister) argument.getRn();
        FPRegister Rt = (FPRegister) argument.getRt();
        this.dataTransferCode.simulate(dt_address, Rn, Rt);
        pc.increase();
    }

    @Override
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 11);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getImmediate(), 9);
        s += " 00 "; // opcode not used, therefore always 0
        // FP register id is bigger than 5 bit. Exception is Rn which is an integer register
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getId(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRt().getId() - RegisterFile.FP_START_INDEX, 5);
        return s;
    }

    public IFPDataTransferCode getDataTransferCode() {
        return dataTransferCode;
    }

    public void setDataTransferCode(IFPDataTransferCode dataTransferCode) {
        this.dataTransferCode = dataTransferCode;
    }
}
