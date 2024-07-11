package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserHelper {

    /**
     * function to verify that a label name does not equal another name (register, instruction, ...)
     * @param label string to be verified
     * @return boolean indicating if given string is valid or not
     */
    public static boolean isLabelNameValid(String label) {
        System.out.println(label);
        ArrayList<String> forbiddenNames = new ArrayList<String>(Arrays.asList("XZR", "SP", "LR", "FP"));
        if(forbiddenNames.contains(label)) {
            return false;
        }
        Pattern pattern = Pattern.compile("X(0|[1-9]|1[0-9]|2[0-9]|3[0-1])");
        Matcher matcher = pattern.matcher(label);
        if(matcher.matches()) {
            return false;
        }
        return true;
    }
    
    // TODO: share semantic errors
}
