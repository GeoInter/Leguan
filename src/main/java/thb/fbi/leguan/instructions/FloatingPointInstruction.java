package thb.fbi.leguan.instructions;

import thb.fbi.leguan.data.InstructionArguments;
import thb.fbi.leguan.simulation.FPRegister;
import thb.fbi.leguan.simulation.PCRegister;
import thb.fbi.leguan.utility.MachineCodeTranslator;

public class FloatingPointInstruction extends Instruction {

    private IFloatingPointCode floatingPointCode;

    public FloatingPointInstruction(String mnemonic, int opcode, String description, IFloatingPointCode floatingPointCode) {
        setMnemonic(mnemonic);
        setOpcode(opcode);
        setDescription(description);
        setFloatingPointCode(floatingPointCode);
    }

    @Override
    public void simulate(InstructionArguments argument, PCRegister pc) {
        // TODO: Get FP register from Arguments
        FPRegister Rm = null;
        int shamt = argument.getShamt();
        FPRegister Rn = null;
        FPRegister Rd = null;
        this.floatingPointCode.simulate(Rm, shamt, Rn, Rd);
        pc.increase();
    }

    @Override
    public String getMachineCodeString(InstructionArguments args) {
        String s = "";
        s = MachineCodeTranslator.convertOpCodeToBinary(opcode, 11);
        if(args.getRm() != null) {
            s += " " + MachineCodeTranslator.convertToMachineCode(args.getRm().getID(), 5);
        } else {
            s += " 11111";
        }
        // TODO: get actual FP Register from Arguments
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getShamt(), 6);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRn().getID(), 5);
        s += " " + MachineCodeTranslator.convertToMachineCode(args.getRd().getID(), 5);
        return s;
    }

    public IFloatingPointCode getFloatingPointCode() {
        return floatingPointCode;
    }

    public void setFloatingPointCode(IFloatingPointCode floatingPointCode) {
        this.floatingPointCode = floatingPointCode;
    }

    
}
