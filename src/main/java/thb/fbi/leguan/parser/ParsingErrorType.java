package thb.fbi.leguan.parser;

public enum ParsingErrorType {
    UndefinedJumpLabelReference(0),
    DoubledJumpLabelDeclaration(1),
    RegisterOutOfRange(2),
    NumberFormatException(3),
    WideImmediateShiftOutOfRange(4),
    WrongShiftforWideImmediate(5);
    

    private int value;

    private ParsingErrorType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
