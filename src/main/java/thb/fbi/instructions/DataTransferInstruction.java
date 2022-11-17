package thb.fbi.instructions;

import thb.fbi.simulation.InstructionArguments;
import thb.fbi.simulation.PCRegister;
import thb.fbi.simulation.Register;

/**
 * Subclass for datatransfer instructions.
 */
public class DataTransferInstruction extends Instruction {
    private IDataTransferCode dataTransferCode;

    public DataTransferInstruction(String mnemonic, String description, IDataTransferCode dataTransferCode) {
        setMnemonic(mnemonic);
        setDescription(description);
        setDataTransferCode(dataTransferCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        int dt_address = argument.getDt_Address();
        String opcode2 = "00"; // not used by LegV8
        Register Rn = argument.getRn();
        Register Rt = argument.getRt();
        this.dataTransferCode.simulate(dt_address, opcode2, Rn, Rt);
        pc.increase();
    }

    public IDataTransferCode getDataTransferCode() {
        return dataTransferCode;
    }

    private void setDataTransferCode(IDataTransferCode dataTransferCode) {
        this.dataTransferCode = dataTransferCode;
    }
}
