package thb.fbi.leguan.simulation;

import thb.fbi.leguan.data.ARMProgram;

public class RegisterFile {
     /** array of accessible regsiters */
    private static IntegerRegister[] integerRegisters;

    /** array of all fp registers (including SP and DP) */
    private static FPRegister[] fpRegisters;

    /** programm counter */
    private static PCRegister pc = new PCRegister("PC", Memory.CODE_SEGMENT_START, -1);

    /** register of processor flags */
    private static FlagRegister flagRegister = new FlagRegister();

    /** number of registers */
    public static final int registerNr = 32;

    public static void initRegisterFile() {
        integerRegisters = new IntegerRegister[registerNr];
        for (int i = 0; i < integerRegisters.length; i++) {
            integerRegisters[i] = new IntegerRegister("X"+i, 0, i);
            integerRegisters[i].setNumberFormat(Base.DEC);
        }

        fpRegisters = new FPRegister[registerNr];
        for (int i = 0; i < fpRegisters.length; i++) {
            fpRegisters[i] = new FPRegister(i);
            fpRegisters[i].setSinglePrecisionNumberFormat(Base.DEC);
            fpRegisters[i].setDoublePrecisionNumberFormat(Base.DEC);
        }

        pc.setValue(Memory.CODE_SEGMENT_START);
    }

    /**
     * gets the list of all registers (R0 - R31)
     * @return List of registers
     */
    public static IntegerRegister[] getIntegerRegisters() {
        return integerRegisters;
    }

    /**
     * gets the list of all registers (R0 - R31)
     * @return List of registers
     */
    public static FPRegister[] getFPRegisters() {
        return fpRegisters;
    }

    public static FlagRegister getFlagRegister() {
        return flagRegister;
    }

    public static PCRegister getPC() {
        return pc;
    }

    public static long getPCValue() {
        return pc.getValue();
    }

    public static void reset() {
        for (IntegerRegister register : integerRegisters) {
            register.setValue(0);
        }
        for (FPRegister register : fpRegisters) {
            register.reset();
        }

        pc.setValue(Memory.CODE_SEGMENT_START);
    }

    /**
     * updates the isUsed Property foreach Register
     * set register which not appear in program usedRegister list to false
     */
    public static void updateShownRegisters(ARMProgram program) {
        for (IntegerRegister r : integerRegisters) {
            if(! program.getUsedRegisters().contains(r)) {
                r.setIsUsed(false);
            } else {
                r.setIsUsed(true);
            }
        }

        for (FPRegister r : fpRegisters) {
            if(! program.getUsedRegisters().contains(r)) {
                r.setIsUsed(false);
            } else {
                r.setIsUsed(true);
            }
        }
    }
}
