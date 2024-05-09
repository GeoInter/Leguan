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
            case DoubledJumpLabelDeclaration:
                this.msg = "Duplicate jump label";
                break;
            case RegisterOutOfRange:
                this.msg = "Register not in allowed range"; // range of simulator.registerNr
                break;
            case UndefinedJumpLabelReference:
                this.msg = "Cannot branch to undeclared label"; // '" + id + "'";
                break;
            case WideImmediateShiftOutOfRange:
                this.msg = "Shift value has to be either 0, 16, 32 or 48";
                break;
            case WrongShiftforWideImmediate:
                this.msg = "Wide Immediate Shifting has to LSL";
                break;
            default:
                this.msg = "Undefined Error occured";
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
