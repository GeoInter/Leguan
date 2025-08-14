package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.PCRegister;

public class FPCompareInstruction extends Instruction {
    
    private IFPCompareCode compareCode;

    public FPCompareInstruction(String mnemonic, int opcode, String description, IFPCompareCode compareCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setCompareCode(compareCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        FPRegister Rn = (FPRegister) argument.getRn();
        FPRegister Rm = (FPRegister) argument.getRm();
        this.compareCode.simulate(Rn, Rm);
        pc.increase();
    }

    @Override
    public String getMachineCodeString(InstructionArguments args) {
        // TODO: Fix
        return "";
    }

    

    public IFPCompareCode getCompareCode() {
        return compareCode;
    }

    public void setCompareCode(IFPCompareCode compareCode) {
        this.compareCode = compareCode;
    }
}
