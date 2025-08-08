package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.IntegerRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for datatransfer instructions.
 */
public class DataTransferInstruction extends Instruction {
    private IDataTransferCode dataTransferCode;

    public DataTransferInstruction(String mnemonic, int opcode, String description, IDataTransferCode dataTransferCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setDataTransferCode(dataTransferCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        long dt_address = argument.getDt_Address();
        IntegerRegister Rn = (IntegerRegister) argument.getRn();
        IntegerRegister Rt = (IntegerRegister) argument.getRt();
        this.dataTransferCode.simulate(dt_address, Rn, Rt);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(11bit), dt_address(9bit), op2(2bit), Rn(5bit), Rt(5bit)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 11);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getDt_Address(), 9);
        s += " 00 "; // opcode not used, therefore always 0
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getId(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRt().getId(), 5);
        return s;
    }

    public IDataTransferCode getDataTransferCode() {
        return dataTransferCode;
    }

    private void setDataTransferCode(IDataTransferCode dataTransferCode) {
        this.dataTransferCode = dataTransferCode;
    }
}
