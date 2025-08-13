package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.simulation.PCRegister;
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
        if(args.getRm() != null) {
            s += " " + MachineCodeTranslator.convertToMachineCode(args.getRm().getId(), 5);
        } else {
            s += " 11111";
        }
        // TODO: Fix retrieving Ids
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getShamt(), 6);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getId(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRt().getId(), 5);
        return s;
    }

    public IFPDataTransferCode getDataTransferCode() {
        return dataTransferCode;
    }

    public void setDataTransferCode(IFPDataTransferCode dataTransferCode) {
        this.dataTransferCode = dataTransferCode;
    }
}
