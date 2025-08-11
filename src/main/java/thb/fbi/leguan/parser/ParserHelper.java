package thb.fbi.leguan.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.tree.TerminalNode;

public class ParserHelper {

    public static ArrayList<ParsingError> semanticErrors = new ArrayList<ParsingError>();

    /**
     * function to verify that a label name does not equal another name (register, instruction, ...)
     * @param label string to be verified
     * @return boolean indicating if given string is valid or not
     */
    static boolean isLabelNameValid(String label) {
        ArrayList<String> forbiddenNames = new ArrayList<String>(Arrays.asList("XZR", "SP", "LR", "FP"));
        if(forbiddenNames.contains(label)) {
            return false;
        }
        // pattern matches exactly Register Numbers 0 to 31
        Pattern pattern = Pattern.compile("(X|S|D)(0|[1-9]|1[0-9]|2[0-9]|3[0-1])");
        Matcher matcher = pattern.matcher(label);
        if(matcher.matches()) {
            return false;
        }
        return true;
    }
    
    /**
     * helper function for adding semantic errors to list
     * 
     * @param token     the token of the parse tree which is responsible for
     *                  throwing the error
     * @param errorType type of parsing error
     */
    static void addSemanticError(TerminalNode node, ParsingErrorType errorType) {
        ParsingError err = new ParsingError(node, errorType);
        semanticErrors.add(err);
    }

    public static ArrayList<ParsingError> getSemanticErrors() {
        return semanticErrors;
    }

    public static void setSemanticErrors(ArrayList<ParsingError> semanticErrors) {
        ParserHelper.semanticErrors = semanticErrors;
    }
}
