package thb.fbi.leguan.utility;

public class MachineCodeTranslator {
    
    /**
     * converts a number to corresponding binary string with specified number of bytes 
     * either adds missing 0s or marks it with (expected size)
     * @param value value to be converted to a binary string
     * @param bitAmount number of bits the string should have
     * @return correct binary string of given value
     */
    public static String convertToMachineCode(long value, int bitAmount) {
        String s = Long.toBinaryString(value);
        if(bitAmount <= 0) {
            return s;
        }
        if(s.length() > bitAmount) { // if number exceeds byte size or is negativ can't change the string without breaking its meaning
            s += "("+bitAmount+")";
        }
        while(s.length() < bitAmount) {
            s = "0" + s;
        }

        return s;
    }

    /**
     * Converts opcode to binary with optional sign extension to match set bit number
     * @param value
     * @param bitAmount
     * @return
     */
    public static String convertOpCodeToBinary(long value, int bitAmount) {
        String s = Long.toBinaryString(value);

        // all instruction should be extended to 11bit, 
        // but because some have leading zeros they have less chars than 11
        while(s.length() < 11) {
            s = "0" + s;
        }
        // truncate chars according to their format
        if (s.length() > bitAmount) {
            s = s.substring(0, bitAmount);
        }
        
        return s;
    }
}
