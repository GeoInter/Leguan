package thb.fbi.leguan.parser;

/**
 * \brief class for collecting syntax and semantic errors while parsing
 * includes error message and position of ocuring error
 */
public class ParsingError {

    private int line;
    private int charPositionInLine;
    private String msg;

    /**
     * constructor using defined error messages
     * @param line line number of error
     * @param charPositionInLine position of char where error starts
     * @param e type of error 
     */
    public ParsingError(int line, int charPositionInLine, ParsingErrorType e) {
        this(line, charPositionInLine, "");
        switch(e) {
            case NumberFormatException:
                this.msg = "Number has not appropriate format";
                break;
            case DoubledMarkDeclaration:
                this.msg = "Duplicate label";
                break;
            case RegisterOutOfRange:
                this.msg = "Register not in allowed range"; // range of simulator.registerNr
                break;
            case UndefinedJumpInvocation:
                this.msg = "Cannot branch to undeclared mark"; // '" + id + "'";
                break;
            default:
                this.msg = "";
                break;
        }
    }

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
