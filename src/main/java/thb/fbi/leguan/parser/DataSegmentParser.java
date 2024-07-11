package thb.fbi.leguan.parser;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.TreeMap;

import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.AsciiContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentPairingContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentTypeContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentValueContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentVariableContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.NumContext;
import thb.fbi.leguan.simulation.Memory;

public class DataSegmentParser extends LegV8BaseVisitor<Object> {

    private HashMap<String, Long> dataSegmentMap;

    public DataSegmentParser(HashMap<String, Long> dataSegmentMap) {
        this.dataSegmentMap = dataSegmentMap;
    }

    @Override
    public TreeMap<Long, Byte> visitDataSegment(DataSegmentContext ctx) {
        TreeMap<Long, Byte> dataSegment = new TreeMap<Long, Byte>();
        long address = Memory.dataSegmentStart;

        if (ctx != null) {
            // for each Variable
            for (int i = 0; i < ctx.dataSegmentEntry().size(); i++) {

                String dataVariableName = ctx.dataSegmentEntry(i).dataSegmentVariable().getText();
                dataVariableName = dataVariableName.substring(0, dataVariableName.length() - 1); // remove ":"

                if (ParserHelper.isLabelNameValid(dataVariableName)) {
                    dataSegmentMap.put(dataVariableName, address);

                    for (int j = 0; j < ctx.dataSegmentEntry(i).dataSegmentPairing().size(); j++) {
                        DataSegmentPairingContext pair = ctx.dataSegmentEntry(i).dataSegmentPairing(j);
                        Long longValue = 0L;

                        switch (visitDataSegmentType(pair.dataSegmentType())) {
                            case ".byte":
                                longValue = visitDataSegmentValue(pair.dataSegmentValue());
                                byte bv = 0;
                                if (fitSpecifiedByteSize(longValue, 1)) {
                                    bv = longValue.byteValue();
                                } else {
                                    ParserHelper.addSemanticError(pair.dataSegmentType().DataSegmentTypes(),
                                            ParsingErrorType.DataSegmentTypeFormatException);
                                }
                                address = addByte(dataSegment, bv, address);
                                break;
                            case ".halfword":
                                longValue = visitDataSegmentValue(pair.dataSegmentValue());
                                short sv = 0;
                                if (fitSpecifiedByteSize(longValue, 2)) {
                                    sv = longValue.shortValue();
                                } else {
                                    ParserHelper.addSemanticError(pair.dataSegmentType().DataSegmentTypes(),
                                            ParsingErrorType.DataSegmentTypeFormatException);
                                }
                                address = addHalfword(dataSegment, sv, address);
                                break;
                            case ".word":
                                longValue = visitDataSegmentValue(pair.dataSegmentValue());
                                int iv = 0;
                                if (fitSpecifiedByteSize(longValue, 4)) {
                                    iv = longValue.intValue();
                                } else {
                                    ParserHelper.addSemanticError(pair.dataSegmentType().DataSegmentTypes(),
                                            ParsingErrorType.DataSegmentTypeFormatException);
                                }
                                address = addWord(dataSegment, iv, address);
                                break;
                            case ".dword":
                                // no check needed, because if value is bigger than a long, throws
                                // NumberFormatException
                                long lv = visitDataSegmentValue(pair.dataSegmentValue()).longValue();
                                address = addDWord(dataSegment, lv, address);
                                break;
                            case ".ascii":
                                // ascii string has no limit of bytes
                                AsciiContext asciiContext = pair.dataSegmentValue().ascii();
                                if (asciiContext != null) {
                                    String asciiString = asciiContext.getText();
                                    asciiString = asciiString.replace("\"", ""); // remove quotes
                                    address = addASCII(dataSegment, asciiString, address);
                                }
                                break;
                        }
                    }
                } else {
                    ParserHelper.addSemanticError(ctx.dataSegmentEntry(i).dataSegmentVariable().PointerDeclaration(), ParsingErrorType.InvalidLabelName);
                }
            }
        }
        return dataSegment;
    }

    @Override
    public String visitDataSegmentType(DataSegmentTypeContext ctx) {
        return ctx.DataSegmentTypes().getText();
    }

    @Override
    public Long visitDataSegmentValue(DataSegmentValueContext ctx) {
        return visitNum(ctx.num());
    }

    /**
     * Unlike the method for the ProgramStatementParser this returns a long instead
     * of an int value
     */
    @Override
    public Long visitNum(NumContext ctx) {
        String numberText = ctx.NUMBER().getText();
        long number = 0;
        int radix = 0;
        if (numberText.startsWith("0x")) { // hex number
            radix = 16;
            numberText = numberText.substring(2);
        } else { // dec number
            radix = 10;
        }

        try {
            number = Long.parseLong(numberText, radix);
        } catch (NumberFormatException e) {
            ParserHelper.addSemanticError(ctx.NUMBER(), ParsingErrorType.NumberFormatException);
        }
        return number;
    }

    @Override
    public String visitDataSegmentVariable(DataSegmentVariableContext ctx) {
        return ctx.PointerDeclaration().getText();
    }

    private long addByte(TreeMap<Long, Byte> dataSegment, byte value, long address) {
        dataSegment.put(address, value);
        return address + 1;
    }

    private long addHalfword(TreeMap<Long, Byte> dataSegment, short value, long address) {
        byte[] bytes = ByteBuffer.allocate(2).putShort(value).array();
        for (int i = 0; i < bytes.length; i++) {
            dataSegment.put(address + i, bytes[i]);
        }
        return address + bytes.length;
    }

    private long addWord(TreeMap<Long, Byte> dataSegment, int value, long address) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        for (int i = 0; i < bytes.length; i++) {
            dataSegment.put(address + i, bytes[i]);
        }
        return address + bytes.length;
    }

    private long addDWord(TreeMap<Long, Byte> dataSegment, long value, long address) {
        byte[] bytes = ByteBuffer.allocate(8).putLong(value).array();
        for (int i = 0; i < bytes.length; i++) {
            dataSegment.put(address + i, bytes[i]);
        }
        return address + bytes.length;
    }

    private long addASCII(TreeMap<Long, Byte> dataSegment, String value, long address) {
        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            dataSegment.put(address + i, bytes[i]);
        }
        return address + bytes.length;
    }

    /**
     * returns boolean indicate if value needs more bytes than specified or not
     * 
     * @param value    value to check its byte size
     * @param maxBytes number of bytes the value can use at maximum
     * @return boolean indicate wheter value is within the limit of specified bytes
     *         or not
     */
    private boolean fitSpecifiedByteSize(Long value, int maxBytes) {
        int bytesUsed = 0;
        boolean isNotFinished = true;
        for (int i = 0; i < Long.BYTES && isNotFinished; i++) {
            if ((value >> (i * Byte.SIZE)) != 0) { // left shift until all remains are 0
                bytesUsed++;
            } else {
                isNotFinished = false;
            }
        }
        if (bytesUsed > maxBytes)
            return false;
        return true;
    }
}
