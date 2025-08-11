package thb.fbi.leguan.parser;

public enum ParsingErrorType {
    UnknownError,
    UndefinedJumpLabelReference,
    DoubledJumpLabelDeclaration,
    InvalidLabelName,
    RegisterOutOfRange,
    NumberFormatException,
    WideImmediateShiftOutOfRange,
    WrongShiftforWideImmediate,
    DataSegmentTypeFormatException;

}
