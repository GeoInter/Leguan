package thb.fbi.leguan.utility;

public class MachineCodeTranslator {
    
    /**
     * converts a number to corresponding binary string with specified number of bytes 
     * either adds missing 0s or marks it with (expected size)
     * @param value value to be converted to a binary string
     * @param byteAmount number of bytes the string should have
     * @return correct binary string of value
     */
    public static String convertToMachineCode(int value, int byteAmount) {
        String s = Integer.toBinaryString(value);
        if(byteAmount <= 0) {
            return s;
        }
        if(s.length() > byteAmount) {
            s += "("+byteAmount+")";
        }
        while(s.length() < byteAmount) {
            s = "0" + s;
        }

        return s;
    }
}
