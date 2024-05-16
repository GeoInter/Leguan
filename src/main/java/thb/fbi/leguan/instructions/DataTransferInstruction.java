package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.Register;

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
        registerPaneController.clearFlagHighlighting();
        memoryController.clearMemoryHighlighting();
        int dt_address = argument.getDt_Address();
        Register Rn = argument.getRn();
        Register Rt = argument.getRt();
        this.dataTransferCode.simulate(dt_address, Rn, Rt);
        pc.increase();
        registerPaneController.updateRegisterHighlighting(Rt.getID());
    }

    public IDataTransferCode getDataTransferCode() {
        return dataTransferCode;
    }

    private void setDataTransferCode(IDataTransferCode dataTransferCode) {
        this.dataTransferCode = dataTransferCode;
    }
}
