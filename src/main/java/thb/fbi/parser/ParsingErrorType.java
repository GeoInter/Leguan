package thb.fbi.parser;

public enum ParsingErrorType {
    UndefinedJumpInvocation(0),
    RegisterOutOfRange(1),
    NumberFormatException(2);

    private int value;

    private ParsingErrorType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
