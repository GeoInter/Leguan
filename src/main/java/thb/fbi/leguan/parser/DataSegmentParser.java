package thb.fbi.leguan.parser;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.antlr.v4.runtime.Token;

import thb.fbi.leguan.parser.antlr.LegV8BaseVisitor;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentPairingContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentTypeContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentValueContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.DataSegmentVariableContext;
import thb.fbi.leguan.parser.antlr.LegV8Parser.NumContext;

public class DataSegmentParser extends LegV8BaseVisitor<Object> {

    private ArrayList<ParsingError> semanticErrors;
    private HashMap<String, Long> dataSegmentMap;

    public DataSegmentParser(ArrayList<ParsingError> semanticErrors, HashMap<String, Long> dataSegmentMap) {
        this.semanticErrors = semanticErrors;
        this.dataSegmentMap = dataSegmentMap;
    }

    // TODO: Detect errors when value is bigger than its (data)type
    @Override
    public TreeMap<Long, Byte> visitDataSegment(DataSegmentContext ctx) {
        TreeMap<Long, Byte> dataSegment = new TreeMap<Long, Byte>();
        long address = 40000;

        if (ctx != null) {
            // for each Variable
            for (int i = 0; i < ctx.dataSegmentEntry().size(); i++) {

                dataSegmentMap.put(ctx.dataSegmentEntry(i).dataSegmentVariable().getText(), address);

                System.out.print(ctx.dataSegmentEntry(i).dataSegmentVariable().getText() + " has value: \n[\n");
                for (int j = 0; j < ctx.dataSegmentEntry(i).dataSegmentPairing().size(); j++) {
                    DataSegmentPairingContext pair = ctx.dataSegmentEntry(i).dataSegmentPairing(j);
                    System.out.print(pair.getText() + "\n");

                    switch (visitDataSegmentType(pair.dataSegmentType())) {
                        case ".byte":
                            byte bv = visitDataSegmentValue(pair.dataSegmentValue()).byteValue();
                            address = addByte(dataSegment, bv, address);
                            break;
                        case ".halfword":
                            short sv = visitDataSegmentValue(pair.dataSegmentValue()).shortValue();
                            address = addHalfword(dataSegment, sv, address);
                            break;
                        case ".word":
                            int iv = visitDataSegmentValue(pair.dataSegmentValue()).intValue();
                            address = addWord(dataSegment, iv, address);
                            break;
                        case ".dword":
                            long lv = visitDataSegmentValue(pair.dataSegmentValue()).longValue();
                            address = addDWord(dataSegment, lv, address);
                            break;
                        case ".ascii":
                            String asciiString = "";
                            address = addASCII(dataSegment, asciiString, address);
                            break;
                    }
                }
                System.out.print("]");
                System.out.print("\n");
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
            Token token = ctx.NUMBER().getSymbol();
            int line = token.getLine();
            int pos = token.getCharPositionInLine();
            ParsingError err = new ParsingError(line, pos, ParsingErrorType.NumberFormatException);
            semanticErrors.add(err);
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

    // TODO: Add support for Strings (stored as byte, but handling until the actual
    // saving)
    private long addASCII(TreeMap<Long, Byte> dataSegment, String value, long address) {
        return address;
    }
}
