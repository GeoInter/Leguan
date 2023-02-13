package thb.fbi.leguan.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Listener for Errors occuring while parsing
 */
public class SyntaxErrorListener extends BaseErrorListener {

    public ArrayList<ParsingError> syntaxErrors = new ArrayList<ParsingError>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        
        syntaxErrors.add(new ParsingError(line, charPositionInLine, msg));
    }

    /**
     * remove all entries from error list - clearing all entries
     */
    public void clearSyntaxErrors() {
        syntaxErrors.clear();
    }
}
