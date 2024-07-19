package thb.fbi.leguan.parser;

public enum ParsingErrorType {
    UndefinedJumpLabelReference,
    DoubledJumpLabelDeclaration,
    InvalidLabelName,
    RegisterOutOfRange,
    NumberFormatException,
    WideImmediateShiftOutOfRange,
    WrongShiftforWideImmediate,
    DataSegmentTypeFormatException;

}
