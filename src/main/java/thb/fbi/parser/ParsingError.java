package thb.fbi.parser;

public class ParsingError {

    private int line;
    private int charPositionInLine;
    private String msg;


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
