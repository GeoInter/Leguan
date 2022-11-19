package thb.fbi.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Listener for Errors occuring while parsing
 */
public class SyntaxErrorListener extends BaseErrorListener {

    public ArrayList<String> syntaxErrors = new ArrayList<String>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        
        syntaxErrors.add(msg + ". (" + line + ", " + charPositionInLine + ")");
    }
    
}
