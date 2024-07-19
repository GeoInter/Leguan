package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;
import thb.fbi.leguan.utility.MachineCodeTranslator;

/**
 * Subclass for datatransfer instructions.
 */
public class DataTransferInstruction extends Instruction {
    private IDataTransferCode dataTransferCode;

    public DataTransferInstruction(String mnemonic, String opcode, String description, IDataTransferCode dataTransferCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setDataTransferCode(dataTransferCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        long dt_address = argument.getDt_Address();
        Register Rn = argument.getRn();
        Register Rt = argument.getRt();
        this.dataTransferCode.simulate(dt_address, Rn, Rt);
        pc.increase();
    }

    /**
     * returns this instructions machine code representation with provided arguments
     * in the form of opcode(11b), dt_address(9b), op2(2b), Rn(5b), Rt(5b)
     */
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertToMachineCode(opcode, 11);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getDt_Address(), 9);
        s += " 00 "; // opcode not used, therefore always 0
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getID(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRt().getID(), 5);
        return s;
    }

    public IDataTransferCode getDataTransferCode() {
        return dataTransferCode;
    }

    private void setDataTransferCode(IDataTransferCode dataTransferCode) {
        this.dataTransferCode = dataTransferCode;
    }
}
