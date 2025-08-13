package thb.fbi.leguan.instructions.floatingPoint;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.instructions.Instruction;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

public class FPArithmeticInstruction extends Instruction {

    private IFPArithmeticCode floatingPointCode;

    public FPArithmeticInstruction(String mnemonic, int opcode, String description, IFPArithmeticCode floatingPointCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setFloatingPointCode(floatingPointCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        FPRegister Rm = (FPRegister) argument.getRm();
        int shamt = argument.getShamt();
        FPRegister Rn = (FPRegister) argument.getRn();
        FPRegister Rd = (FPRegister) argument.getRd();
        this.floatingPointCode.simulate(Rm, shamt, Rn, Rd);
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
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getId(), 5);
        return s;
    }

    public IFPArithmeticCode getFloatingPointCode() {
        return floatingPointCode;
    }

    public void setFloatingPointCode(IFPArithmeticCode floatingPointCode) {
        this.floatingPointCode = floatingPointCode;
    }

    
}
