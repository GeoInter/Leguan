package thb.fbi.leguan.parser;

public enum ParsingErrorType {
    UndefinedJumpInvocation(0),
    DoubledMarkDeclaration(1),
    RegisterOutOfRange(2),
    NumberFormatException(3),
    WideImmediateShiftOutOfRange(4);
    

    private int value;

    private ParsingErrorType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
