package thb.fbi.leguan.parser;

import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * \brief class for collecting syntax and semantic errors while parsing
 * includes error message and position of ocuring error
 */
public class ParsingError {

    private int line;
    private int charPositionInLine;
    private String msg;

    /**
     * constructor using defined (semantic) error messages
     * @param line line number of error
     * @param charPositionInLine position of char where error starts
     * @param e type of error 
     */
    public ParsingError(TerminalNode node, ParsingErrorType e) {
        this.line = node.getSymbol().getLine();
        this.charPositionInLine = node.getSymbol().getCharPositionInLine();
        String identifier = node.getText();
        switch(e) {
            case NumberFormatException:
                this.msg = "Number has not appropriate format '" + identifier + "'"; // number
                break;
            case DoubledJumpLabelDeclaration:
                this.msg = "Duplicate jump label '" + identifier + "'"; // label name
                break;
            case RegisterOutOfRange:
                this.msg = "Register not in allowed range 0-31. Used '" + identifier + "'"; // register name
                break;
            case UndefinedJumpLabelReference:
                this.msg = "Cannot branch to undeclared label '"  + identifier + "'"; // label name
                break;
            case WideImmediateShiftOutOfRange:
                this.msg = "Shift value has to be either 0, 16, 32 or 48"; // used x
                break;
            case WrongShiftforWideImmediate:
                this.msg = "Wide Immediate Shifting has to LSL"; // unused
                break;
            case DataSegmentTypeFormatException:
                this.msg = "Value in data segment exceeds its specified size '" + identifier + "'"; // type + value
                break;
            default:
                this.msg = "Undefined Error occured";
                break;
        }
    }

    /**
     * Default constructor used by the SyntaxErrorListener
     * @param line line number where the error occured
     * @param charPositionInLine char position in line
     * @param msg error message
     */
    public ParsingError(int line, int charPositionInLine, String msg) {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
        this.msg = msg;
    }

    public String getErrorMessage() {
        String errMsg = msg + ". (" + line + ", " + charPositionInLine + ")";
        return errMsg;
    }
}
