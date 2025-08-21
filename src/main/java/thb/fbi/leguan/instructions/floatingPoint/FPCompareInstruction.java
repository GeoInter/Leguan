package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.simulation.RegisterFile;
import thb.fbi.leguan.utility.MachineCodeTranslator;

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
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 11);
        // FP register id is bigger than 5 bit - convert back to fit range 0-31
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRm().getId() - RegisterFile.FP_START_INDEX, 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getShamt(), 6);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getId() - RegisterFile.FP_START_INDEX, 5);
        // Rd is not set
        s += " 11111";
        return s;
    }

    

    public IFPCompareCode getCompareCode() {
        return compareCode;
    }

    public void setCompareCode(IFPCompareCode compareCode) {
        this.compareCode = compareCode;
    }
}
