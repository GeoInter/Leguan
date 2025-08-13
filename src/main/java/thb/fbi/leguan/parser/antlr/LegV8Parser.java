// Generated from LegV8.g4 by ANTLR 4.13.2
package thb.fbi.leguan.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LegV8Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ArithmeticInstruction=1, FP_ArithemticInstruction=2, ShiftInstruction=3, 
		ImmediateInstruction=4, WideImmediateInstrcution=5, DatatransferInstruction=6, 
		FP_DatatransferInstruction=7, ExclusiveInstruction=8, CondBranchInstruction=9, 
		B_cond_Instruction=10, BranchInstruction=11, BranchByRegisterInstruction=12, 
		DataSegmentInstruction=13, WS=14, COMMENT=15, LINE_COMMENT=16, COMMA=17, 
		SEMI=18, EQUALS_SIGN=19, SQUARE_BRACKET_LEFT=20, SQUARE_BRACKET_RIGHT=21, 
		INTEGER_REGISTER=22, FP_REGISTER=23, NUMBER=24, SP=25, FP=26, LR=27, XZR=28, 
		PointerDeclaration=29, PointerReference=30, DataSegmentTypes=31, ASCII_String=32;
	public static final int
		RULE_main = 0, RULE_program = 1, RULE_dataSegment = 2, RULE_dataSegmentEntry = 3, 
		RULE_dataSegmentPairing = 4, RULE_dataSegmentType = 5, RULE_dataSegmentVariable = 6, 
		RULE_dataSegmentValue = 7, RULE_line = 8, RULE_jumpLabelDeclaration = 9, 
		RULE_jumpLabelReference = 10, RULE_dataSegmentLabelReference = 11, RULE_arithmeticInstruction = 12, 
		RULE_fp_arithmeticInstruction = 13, RULE_shiftInstruction = 14, RULE_immediateInstruction = 15, 
		RULE_wideImmediateInstruction = 16, RULE_datatransferInstruction = 17, 
		RULE_fp_datatransferInstruction = 18, RULE_exclusiveInstruction = 19, 
		RULE_condBranchInstruction = 20, RULE_b_cond_Instruction = 21, RULE_branchInstruction = 22, 
		RULE_branchByRegisterInstruction = 23, RULE_dataSegmentInstruction = 24, 
		RULE_arithmeticParam = 25, RULE_fp_arithmeticParam = 26, RULE_shiftParam = 27, 
		RULE_immediateParam = 28, RULE_wideImmediateParam = 29, RULE_datatransferParam = 30, 
		RULE_fp_datatransferParam = 31, RULE_exclusiveParam = 32, RULE_condBranchParam = 33, 
		RULE_b_cond_Param = 34, RULE_branchParam = 35, RULE_branchByRegisterParam = 36, 
		RULE_dataSegmentParam = 37, RULE_num = 38, RULE_integer_register = 39, 
		RULE_fp_register = 40, RULE_ascii = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "program", "dataSegment", "dataSegmentEntry", "dataSegmentPairing", 
			"dataSegmentType", "dataSegmentVariable", "dataSegmentValue", "line", 
			"jumpLabelDeclaration", "jumpLabelReference", "dataSegmentLabelReference", 
			"arithmeticInstruction", "fp_arithmeticInstruction", "shiftInstruction", 
			"immediateInstruction", "wideImmediateInstruction", "datatransferInstruction", 
			"fp_datatransferInstruction", "exclusiveInstruction", "condBranchInstruction", 
			"b_cond_Instruction", "branchInstruction", "branchByRegisterInstruction", 
			"dataSegmentInstruction", "arithmeticParam", "fp_arithmeticParam", "shiftParam", 
			"immediateParam", "wideImmediateParam", "datatransferParam", "fp_datatransferParam", 
			"exclusiveParam", "condBranchParam", "b_cond_Param", "branchParam", "branchByRegisterParam", 
			"dataSegmentParam", "num", "integer_register", "fp_register", "ascii"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'STXR'", null, null, 
			null, "'BR'", "'LDR'", null, null, null, "','", "';'", "'='", "'['", 
			"']'", null, null, null, "'SP'", "'FP'", "'LR'", "'XZR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ArithmeticInstruction", "FP_ArithemticInstruction", "ShiftInstruction", 
			"ImmediateInstruction", "WideImmediateInstrcution", "DatatransferInstruction", 
			"FP_DatatransferInstruction", "ExclusiveInstruction", "CondBranchInstruction", 
			"B_cond_Instruction", "BranchInstruction", "BranchByRegisterInstruction", 
			"DataSegmentInstruction", "WS", "COMMENT", "LINE_COMMENT", "COMMA", "SEMI", 
			"EQUALS_SIGN", "SQUARE_BRACKET_LEFT", "SQUARE_BRACKET_RIGHT", "INTEGER_REGISTER", 
			"FP_REGISTER", "NUMBER", "SP", "FP", "LR", "XZR", "PointerDeclaration", 
			"PointerReference", "DataSegmentTypes", "ASCII_String"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LegV8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LegV8Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LegV8Parser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			program();
			setState(85);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DataSegmentContext dataSegment() {
			return getRuleContext(DataSegmentContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(87);
				dataSegment();
				}
				break;
			}
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				line();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 536887294L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentContext extends ParserRuleContext {
		public List<DataSegmentEntryContext> dataSegmentEntry() {
			return getRuleContexts(DataSegmentEntryContext.class);
		}
		public DataSegmentEntryContext dataSegmentEntry(int i) {
			return getRuleContext(DataSegmentEntryContext.class,i);
		}
		public DataSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentContext dataSegment() throws RecognitionException {
		DataSegmentContext _localctx = new DataSegmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dataSegment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(95);
					dataSegmentEntry();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(98); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentEntryContext extends ParserRuleContext {
		public DataSegmentVariableContext dataSegmentVariable() {
			return getRuleContext(DataSegmentVariableContext.class,0);
		}
		public List<DataSegmentPairingContext> dataSegmentPairing() {
			return getRuleContexts(DataSegmentPairingContext.class);
		}
		public DataSegmentPairingContext dataSegmentPairing(int i) {
			return getRuleContext(DataSegmentPairingContext.class,i);
		}
		public DataSegmentEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentEntryContext dataSegmentEntry() throws RecognitionException {
		DataSegmentEntryContext _localctx = new DataSegmentEntryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dataSegmentEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			dataSegmentVariable();
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				dataSegmentPairing();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DataSegmentTypes );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentPairingContext extends ParserRuleContext {
		public DataSegmentTypeContext dataSegmentType() {
			return getRuleContext(DataSegmentTypeContext.class,0);
		}
		public DataSegmentValueContext dataSegmentValue() {
			return getRuleContext(DataSegmentValueContext.class,0);
		}
		public DataSegmentPairingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentPairing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentPairing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentPairing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentPairing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentPairingContext dataSegmentPairing() throws RecognitionException {
		DataSegmentPairingContext _localctx = new DataSegmentPairingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dataSegmentPairing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			dataSegmentType();
			setState(107);
			dataSegmentValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentTypeContext extends ParserRuleContext {
		public TerminalNode DataSegmentTypes() { return getToken(LegV8Parser.DataSegmentTypes, 0); }
		public DataSegmentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentTypeContext dataSegmentType() throws RecognitionException {
		DataSegmentTypeContext _localctx = new DataSegmentTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataSegmentType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(DataSegmentTypes);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentVariableContext extends ParserRuleContext {
		public TerminalNode PointerDeclaration() { return getToken(LegV8Parser.PointerDeclaration, 0); }
		public DataSegmentVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentVariableContext dataSegmentVariable() throws RecognitionException {
		DataSegmentVariableContext _localctx = new DataSegmentVariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dataSegmentVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(PointerDeclaration);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentValueContext extends ParserRuleContext {
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public AsciiContext ascii() {
			return getRuleContext(AsciiContext.class,0);
		}
		public DataSegmentValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentValueContext dataSegmentValue() throws RecognitionException {
		DataSegmentValueContext _localctx = new DataSegmentValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataSegmentValue);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				num();
				}
				break;
			case ASCII_String:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				ascii();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public ArithmeticInstructionContext arithmeticInstruction() {
			return getRuleContext(ArithmeticInstructionContext.class,0);
		}
		public ArithmeticParamContext arithmeticParam() {
			return getRuleContext(ArithmeticParamContext.class,0);
		}
		public Fp_arithmeticInstructionContext fp_arithmeticInstruction() {
			return getRuleContext(Fp_arithmeticInstructionContext.class,0);
		}
		public Fp_arithmeticParamContext fp_arithmeticParam() {
			return getRuleContext(Fp_arithmeticParamContext.class,0);
		}
		public ShiftInstructionContext shiftInstruction() {
			return getRuleContext(ShiftInstructionContext.class,0);
		}
		public ShiftParamContext shiftParam() {
			return getRuleContext(ShiftParamContext.class,0);
		}
		public ImmediateInstructionContext immediateInstruction() {
			return getRuleContext(ImmediateInstructionContext.class,0);
		}
		public ImmediateParamContext immediateParam() {
			return getRuleContext(ImmediateParamContext.class,0);
		}
		public WideImmediateInstructionContext wideImmediateInstruction() {
			return getRuleContext(WideImmediateInstructionContext.class,0);
		}
		public WideImmediateParamContext wideImmediateParam() {
			return getRuleContext(WideImmediateParamContext.class,0);
		}
		public DatatransferInstructionContext datatransferInstruction() {
			return getRuleContext(DatatransferInstructionContext.class,0);
		}
		public DatatransferParamContext datatransferParam() {
			return getRuleContext(DatatransferParamContext.class,0);
		}
		public Fp_datatransferInstructionContext fp_datatransferInstruction() {
			return getRuleContext(Fp_datatransferInstructionContext.class,0);
		}
		public Fp_datatransferParamContext fp_datatransferParam() {
			return getRuleContext(Fp_datatransferParamContext.class,0);
		}
		public ExclusiveInstructionContext exclusiveInstruction() {
			return getRuleContext(ExclusiveInstructionContext.class,0);
		}
		public ExclusiveParamContext exclusiveParam() {
			return getRuleContext(ExclusiveParamContext.class,0);
		}
		public CondBranchInstructionContext condBranchInstruction() {
			return getRuleContext(CondBranchInstructionContext.class,0);
		}
		public CondBranchParamContext condBranchParam() {
			return getRuleContext(CondBranchParamContext.class,0);
		}
		public B_cond_InstructionContext b_cond_Instruction() {
			return getRuleContext(B_cond_InstructionContext.class,0);
		}
		public B_cond_ParamContext b_cond_Param() {
			return getRuleContext(B_cond_ParamContext.class,0);
		}
		public BranchInstructionContext branchInstruction() {
			return getRuleContext(BranchInstructionContext.class,0);
		}
		public BranchParamContext branchParam() {
			return getRuleContext(BranchParamContext.class,0);
		}
		public BranchByRegisterInstructionContext branchByRegisterInstruction() {
			return getRuleContext(BranchByRegisterInstructionContext.class,0);
		}
		public BranchByRegisterParamContext branchByRegisterParam() {
			return getRuleContext(BranchByRegisterParamContext.class,0);
		}
		public DataSegmentInstructionContext dataSegmentInstruction() {
			return getRuleContext(DataSegmentInstructionContext.class,0);
		}
		public DataSegmentParamContext dataSegmentParam() {
			return getRuleContext(DataSegmentParamContext.class,0);
		}
		public JumpLabelDeclarationContext jumpLabelDeclaration() {
			return getRuleContext(JumpLabelDeclarationContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PointerDeclaration) {
				{
				setState(117);
				jumpLabelDeclaration();
				}
			}

			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ArithmeticInstruction:
				{
				setState(120);
				arithmeticInstruction();
				setState(121);
				arithmeticParam();
				}
				break;
			case FP_ArithemticInstruction:
				{
				setState(123);
				fp_arithmeticInstruction();
				setState(124);
				fp_arithmeticParam();
				}
				break;
			case ShiftInstruction:
				{
				setState(126);
				shiftInstruction();
				setState(127);
				shiftParam();
				}
				break;
			case ImmediateInstruction:
				{
				setState(129);
				immediateInstruction();
				setState(130);
				immediateParam();
				}
				break;
			case WideImmediateInstrcution:
				{
				setState(132);
				wideImmediateInstruction();
				setState(133);
				wideImmediateParam();
				}
				break;
			case DatatransferInstruction:
				{
				setState(135);
				datatransferInstruction();
				setState(136);
				datatransferParam();
				}
				break;
			case FP_DatatransferInstruction:
				{
				setState(138);
				fp_datatransferInstruction();
				setState(139);
				fp_datatransferParam();
				}
				break;
			case ExclusiveInstruction:
				{
				setState(141);
				exclusiveInstruction();
				setState(142);
				exclusiveParam();
				}
				break;
			case CondBranchInstruction:
				{
				setState(144);
				condBranchInstruction();
				setState(145);
				condBranchParam();
				}
				break;
			case B_cond_Instruction:
				{
				setState(147);
				b_cond_Instruction();
				setState(148);
				b_cond_Param();
				}
				break;
			case BranchInstruction:
				{
				setState(150);
				branchInstruction();
				setState(151);
				branchParam();
				}
				break;
			case BranchByRegisterInstruction:
				{
				setState(153);
				branchByRegisterInstruction();
				setState(154);
				branchByRegisterParam();
				}
				break;
			case DataSegmentInstruction:
				{
				setState(156);
				dataSegmentInstruction();
				setState(157);
				dataSegmentParam();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpLabelDeclarationContext extends ParserRuleContext {
		public TerminalNode PointerDeclaration() { return getToken(LegV8Parser.PointerDeclaration, 0); }
		public JumpLabelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpLabelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterJumpLabelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitJumpLabelDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitJumpLabelDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpLabelDeclarationContext jumpLabelDeclaration() throws RecognitionException {
		JumpLabelDeclarationContext _localctx = new JumpLabelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_jumpLabelDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(PointerDeclaration);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpLabelReferenceContext extends ParserRuleContext {
		public TerminalNode PointerReference() { return getToken(LegV8Parser.PointerReference, 0); }
		public JumpLabelReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpLabelReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterJumpLabelReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitJumpLabelReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitJumpLabelReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpLabelReferenceContext jumpLabelReference() throws RecognitionException {
		JumpLabelReferenceContext _localctx = new JumpLabelReferenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jumpLabelReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(PointerReference);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentLabelReferenceContext extends ParserRuleContext {
		public TerminalNode PointerReference() { return getToken(LegV8Parser.PointerReference, 0); }
		public DataSegmentLabelReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentLabelReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentLabelReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentLabelReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentLabelReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentLabelReferenceContext dataSegmentLabelReference() throws RecognitionException {
		DataSegmentLabelReferenceContext _localctx = new DataSegmentLabelReferenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dataSegmentLabelReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(PointerReference);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticInstructionContext extends ParserRuleContext {
		public TerminalNode ArithmeticInstruction() { return getToken(LegV8Parser.ArithmeticInstruction, 0); }
		public ArithmeticInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterArithmeticInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitArithmeticInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitArithmeticInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticInstructionContext arithmeticInstruction() throws RecognitionException {
		ArithmeticInstructionContext _localctx = new ArithmeticInstructionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arithmeticInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(ArithmeticInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fp_arithmeticInstructionContext extends ParserRuleContext {
		public TerminalNode FP_ArithemticInstruction() { return getToken(LegV8Parser.FP_ArithemticInstruction, 0); }
		public Fp_arithmeticInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fp_arithmeticInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterFp_arithmeticInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitFp_arithmeticInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitFp_arithmeticInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fp_arithmeticInstructionContext fp_arithmeticInstruction() throws RecognitionException {
		Fp_arithmeticInstructionContext _localctx = new Fp_arithmeticInstructionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fp_arithmeticInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(FP_ArithemticInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftInstructionContext extends ParserRuleContext {
		public TerminalNode ShiftInstruction() { return getToken(LegV8Parser.ShiftInstruction, 0); }
		public ShiftInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterShiftInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitShiftInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitShiftInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftInstructionContext shiftInstruction() throws RecognitionException {
		ShiftInstructionContext _localctx = new ShiftInstructionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_shiftInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(ShiftInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImmediateInstructionContext extends ParserRuleContext {
		public TerminalNode ImmediateInstruction() { return getToken(LegV8Parser.ImmediateInstruction, 0); }
		public ImmediateInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_immediateInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterImmediateInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitImmediateInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitImmediateInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImmediateInstructionContext immediateInstruction() throws RecognitionException {
		ImmediateInstructionContext _localctx = new ImmediateInstructionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_immediateInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ImmediateInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WideImmediateInstructionContext extends ParserRuleContext {
		public TerminalNode WideImmediateInstrcution() { return getToken(LegV8Parser.WideImmediateInstrcution, 0); }
		public WideImmediateInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wideImmediateInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterWideImmediateInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitWideImmediateInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitWideImmediateInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WideImmediateInstructionContext wideImmediateInstruction() throws RecognitionException {
		WideImmediateInstructionContext _localctx = new WideImmediateInstructionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_wideImmediateInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(WideImmediateInstrcution);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatatransferInstructionContext extends ParserRuleContext {
		public TerminalNode DatatransferInstruction() { return getToken(LegV8Parser.DatatransferInstruction, 0); }
		public DatatransferInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatransferInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDatatransferInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDatatransferInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDatatransferInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatransferInstructionContext datatransferInstruction() throws RecognitionException {
		DatatransferInstructionContext _localctx = new DatatransferInstructionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_datatransferInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(DatatransferInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fp_datatransferInstructionContext extends ParserRuleContext {
		public TerminalNode FP_DatatransferInstruction() { return getToken(LegV8Parser.FP_DatatransferInstruction, 0); }
		public Fp_datatransferInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fp_datatransferInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterFp_datatransferInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitFp_datatransferInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitFp_datatransferInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fp_datatransferInstructionContext fp_datatransferInstruction() throws RecognitionException {
		Fp_datatransferInstructionContext _localctx = new Fp_datatransferInstructionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fp_datatransferInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(FP_DatatransferInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExclusiveInstructionContext extends ParserRuleContext {
		public TerminalNode ExclusiveInstruction() { return getToken(LegV8Parser.ExclusiveInstruction, 0); }
		public ExclusiveInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterExclusiveInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitExclusiveInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitExclusiveInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveInstructionContext exclusiveInstruction() throws RecognitionException {
		ExclusiveInstructionContext _localctx = new ExclusiveInstructionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exclusiveInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(ExclusiveInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondBranchInstructionContext extends ParserRuleContext {
		public TerminalNode CondBranchInstruction() { return getToken(LegV8Parser.CondBranchInstruction, 0); }
		public CondBranchInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condBranchInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterCondBranchInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitCondBranchInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitCondBranchInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondBranchInstructionContext condBranchInstruction() throws RecognitionException {
		CondBranchInstructionContext _localctx = new CondBranchInstructionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condBranchInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(CondBranchInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class B_cond_InstructionContext extends ParserRuleContext {
		public TerminalNode B_cond_Instruction() { return getToken(LegV8Parser.B_cond_Instruction, 0); }
		public B_cond_InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b_cond_Instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterB_cond_Instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitB_cond_Instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitB_cond_Instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final B_cond_InstructionContext b_cond_Instruction() throws RecognitionException {
		B_cond_InstructionContext _localctx = new B_cond_InstructionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_b_cond_Instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(B_cond_Instruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchInstructionContext extends ParserRuleContext {
		public TerminalNode BranchInstruction() { return getToken(LegV8Parser.BranchInstruction, 0); }
		public BranchInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterBranchInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitBranchInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitBranchInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchInstructionContext branchInstruction() throws RecognitionException {
		BranchInstructionContext _localctx = new BranchInstructionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_branchInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(BranchInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchByRegisterInstructionContext extends ParserRuleContext {
		public TerminalNode BranchByRegisterInstruction() { return getToken(LegV8Parser.BranchByRegisterInstruction, 0); }
		public BranchByRegisterInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchByRegisterInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterBranchByRegisterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitBranchByRegisterInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitBranchByRegisterInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchByRegisterInstructionContext branchByRegisterInstruction() throws RecognitionException {
		BranchByRegisterInstructionContext _localctx = new BranchByRegisterInstructionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_branchByRegisterInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(BranchByRegisterInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentInstructionContext extends ParserRuleContext {
		public TerminalNode DataSegmentInstruction() { return getToken(LegV8Parser.DataSegmentInstruction, 0); }
		public DataSegmentInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentInstructionContext dataSegmentInstruction() throws RecognitionException {
		DataSegmentInstructionContext _localctx = new DataSegmentInstructionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_dataSegmentInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(DataSegmentInstruction);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticParamContext extends ParserRuleContext {
		public List<Integer_registerContext> integer_register() {
			return getRuleContexts(Integer_registerContext.class);
		}
		public Integer_registerContext integer_register(int i) {
			return getRuleContext(Integer_registerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public ArithmeticParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterArithmeticParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitArithmeticParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitArithmeticParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticParamContext arithmeticParam() throws RecognitionException {
		ArithmeticParamContext _localctx = new ArithmeticParamContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arithmeticParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			integer_register();
			setState(194);
			match(COMMA);
			setState(195);
			integer_register();
			setState(196);
			match(COMMA);
			setState(197);
			integer_register();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fp_arithmeticParamContext extends ParserRuleContext {
		public List<Fp_registerContext> fp_register() {
			return getRuleContexts(Fp_registerContext.class);
		}
		public Fp_registerContext fp_register(int i) {
			return getRuleContext(Fp_registerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public Fp_arithmeticParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fp_arithmeticParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterFp_arithmeticParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitFp_arithmeticParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitFp_arithmeticParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fp_arithmeticParamContext fp_arithmeticParam() throws RecognitionException {
		Fp_arithmeticParamContext _localctx = new Fp_arithmeticParamContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_fp_arithmeticParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			fp_register();
			setState(200);
			match(COMMA);
			setState(201);
			fp_register();
			setState(202);
			match(COMMA);
			setState(203);
			fp_register();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftParamContext extends ParserRuleContext {
		public List<Integer_registerContext> integer_register() {
			return getRuleContexts(Integer_registerContext.class);
		}
		public Integer_registerContext integer_register(int i) {
			return getRuleContext(Integer_registerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public ShiftParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterShiftParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitShiftParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitShiftParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftParamContext shiftParam() throws RecognitionException {
		ShiftParamContext _localctx = new ShiftParamContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_shiftParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			integer_register();
			setState(206);
			match(COMMA);
			setState(207);
			integer_register();
			setState(208);
			match(COMMA);
			setState(209);
			num();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImmediateParamContext extends ParserRuleContext {
		public List<Integer_registerContext> integer_register() {
			return getRuleContexts(Integer_registerContext.class);
		}
		public Integer_registerContext integer_register(int i) {
			return getRuleContext(Integer_registerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public ImmediateParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_immediateParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterImmediateParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitImmediateParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitImmediateParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImmediateParamContext immediateParam() throws RecognitionException {
		ImmediateParamContext _localctx = new ImmediateParamContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_immediateParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			integer_register();
			setState(212);
			match(COMMA);
			setState(213);
			integer_register();
			setState(214);
			match(COMMA);
			setState(215);
			num();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WideImmediateParamContext extends ParserRuleContext {
		public Integer_registerContext integer_register() {
			return getRuleContext(Integer_registerContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public TerminalNode ShiftInstruction() { return getToken(LegV8Parser.ShiftInstruction, 0); }
		public WideImmediateParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wideImmediateParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterWideImmediateParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitWideImmediateParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitWideImmediateParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WideImmediateParamContext wideImmediateParam() throws RecognitionException {
		WideImmediateParamContext _localctx = new WideImmediateParamContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_wideImmediateParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			integer_register();
			setState(218);
			match(COMMA);
			setState(219);
			num();
			setState(220);
			match(COMMA);
			setState(221);
			match(ShiftInstruction);
			setState(222);
			num();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatatransferParamContext extends ParserRuleContext {
		public List<Integer_registerContext> integer_register() {
			return getRuleContexts(Integer_registerContext.class);
		}
		public Integer_registerContext integer_register(int i) {
			return getRuleContext(Integer_registerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public TerminalNode SQUARE_BRACKET_LEFT() { return getToken(LegV8Parser.SQUARE_BRACKET_LEFT, 0); }
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode SQUARE_BRACKET_RIGHT() { return getToken(LegV8Parser.SQUARE_BRACKET_RIGHT, 0); }
		public DatatransferParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatransferParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDatatransferParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDatatransferParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDatatransferParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatransferParamContext datatransferParam() throws RecognitionException {
		DatatransferParamContext _localctx = new DatatransferParamContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_datatransferParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			integer_register();
			setState(225);
			match(COMMA);
			setState(226);
			match(SQUARE_BRACKET_LEFT);
			setState(227);
			integer_register();
			setState(228);
			match(COMMA);
			setState(229);
			num();
			setState(230);
			match(SQUARE_BRACKET_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fp_datatransferParamContext extends ParserRuleContext {
		public Fp_registerContext fp_register() {
			return getRuleContext(Fp_registerContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public TerminalNode SQUARE_BRACKET_LEFT() { return getToken(LegV8Parser.SQUARE_BRACKET_LEFT, 0); }
		public Integer_registerContext integer_register() {
			return getRuleContext(Integer_registerContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode SQUARE_BRACKET_RIGHT() { return getToken(LegV8Parser.SQUARE_BRACKET_RIGHT, 0); }
		public Fp_datatransferParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fp_datatransferParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterFp_datatransferParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitFp_datatransferParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitFp_datatransferParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fp_datatransferParamContext fp_datatransferParam() throws RecognitionException {
		Fp_datatransferParamContext _localctx = new Fp_datatransferParamContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_fp_datatransferParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			fp_register();
			setState(233);
			match(COMMA);
			setState(234);
			match(SQUARE_BRACKET_LEFT);
			setState(235);
			integer_register();
			setState(236);
			match(COMMA);
			setState(237);
			num();
			setState(238);
			match(SQUARE_BRACKET_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExclusiveParamContext extends ParserRuleContext {
		public List<Integer_registerContext> integer_register() {
			return getRuleContexts(Integer_registerContext.class);
		}
		public Integer_registerContext integer_register(int i) {
			return getRuleContext(Integer_registerContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(LegV8Parser.COMMA, 0); }
		public TerminalNode SQUARE_BRACKET_LEFT() { return getToken(LegV8Parser.SQUARE_BRACKET_LEFT, 0); }
		public TerminalNode SQUARE_BRACKET_RIGHT() { return getToken(LegV8Parser.SQUARE_BRACKET_RIGHT, 0); }
		public ExclusiveParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterExclusiveParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitExclusiveParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitExclusiveParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveParamContext exclusiveParam() throws RecognitionException {
		ExclusiveParamContext _localctx = new ExclusiveParamContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exclusiveParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			integer_register();
			setState(241);
			match(COMMA);
			setState(242);
			integer_register();
			setState(243);
			match(SQUARE_BRACKET_LEFT);
			setState(244);
			integer_register();
			setState(245);
			match(SQUARE_BRACKET_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondBranchParamContext extends ParserRuleContext {
		public Integer_registerContext integer_register() {
			return getRuleContext(Integer_registerContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(LegV8Parser.COMMA, 0); }
		public JumpLabelReferenceContext jumpLabelReference() {
			return getRuleContext(JumpLabelReferenceContext.class,0);
		}
		public CondBranchParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condBranchParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterCondBranchParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitCondBranchParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitCondBranchParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondBranchParamContext condBranchParam() throws RecognitionException {
		CondBranchParamContext _localctx = new CondBranchParamContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_condBranchParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			integer_register();
			setState(248);
			match(COMMA);
			setState(249);
			jumpLabelReference();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class B_cond_ParamContext extends ParserRuleContext {
		public JumpLabelReferenceContext jumpLabelReference() {
			return getRuleContext(JumpLabelReferenceContext.class,0);
		}
		public B_cond_ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b_cond_Param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterB_cond_Param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitB_cond_Param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitB_cond_Param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final B_cond_ParamContext b_cond_Param() throws RecognitionException {
		B_cond_ParamContext _localctx = new B_cond_ParamContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_b_cond_Param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			jumpLabelReference();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchParamContext extends ParserRuleContext {
		public JumpLabelReferenceContext jumpLabelReference() {
			return getRuleContext(JumpLabelReferenceContext.class,0);
		}
		public BranchParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterBranchParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitBranchParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitBranchParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchParamContext branchParam() throws RecognitionException {
		BranchParamContext _localctx = new BranchParamContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_branchParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			jumpLabelReference();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchByRegisterParamContext extends ParserRuleContext {
		public Integer_registerContext integer_register() {
			return getRuleContext(Integer_registerContext.class,0);
		}
		public BranchByRegisterParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchByRegisterParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterBranchByRegisterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitBranchByRegisterParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitBranchByRegisterParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchByRegisterParamContext branchByRegisterParam() throws RecognitionException {
		BranchByRegisterParamContext _localctx = new BranchByRegisterParamContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_branchByRegisterParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			integer_register();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataSegmentParamContext extends ParserRuleContext {
		public Integer_registerContext integer_register() {
			return getRuleContext(Integer_registerContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(LegV8Parser.COMMA, 0); }
		public TerminalNode EQUALS_SIGN() { return getToken(LegV8Parser.EQUALS_SIGN, 0); }
		public DataSegmentLabelReferenceContext dataSegmentLabelReference() {
			return getRuleContext(DataSegmentLabelReferenceContext.class,0);
		}
		public DataSegmentParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSegmentParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDataSegmentParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDataSegmentParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDataSegmentParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataSegmentParamContext dataSegmentParam() throws RecognitionException {
		DataSegmentParamContext _localctx = new DataSegmentParamContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_dataSegmentParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			integer_register();
			setState(258);
			match(COMMA);
			setState(259);
			match(EQUALS_SIGN);
			setState(260);
			dataSegmentLabelReference();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LegV8Parser.NUMBER, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Integer_registerContext extends ParserRuleContext {
		public TerminalNode INTEGER_REGISTER() { return getToken(LegV8Parser.INTEGER_REGISTER, 0); }
		public Integer_registerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_register; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterInteger_register(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitInteger_register(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitInteger_register(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_registerContext integer_register() throws RecognitionException {
		Integer_registerContext _localctx = new Integer_registerContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_integer_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(INTEGER_REGISTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fp_registerContext extends ParserRuleContext {
		public TerminalNode FP_REGISTER() { return getToken(LegV8Parser.FP_REGISTER, 0); }
		public Fp_registerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fp_register; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterFp_register(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitFp_register(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitFp_register(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fp_registerContext fp_register() throws RecognitionException {
		Fp_registerContext _localctx = new Fp_registerContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_fp_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(FP_REGISTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsciiContext extends ParserRuleContext {
		public TerminalNode ASCII_String() { return getToken(LegV8Parser.ASCII_String, 0); }
		public AsciiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ascii; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterAscii(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitAscii(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitAscii(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsciiContext ascii() throws RecognitionException {
		AsciiContext _localctx = new AsciiContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_ascii);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(ASCII_String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u010f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0003\u0001Y\b\u0001\u0001\u0001\u0004\u0001\\\b\u0001\u000b\u0001\f"+
		"\u0001]\u0001\u0002\u0004\u0002a\b\u0002\u000b\u0002\f\u0002b\u0001\u0003"+
		"\u0001\u0003\u0004\u0003g\b\u0003\u000b\u0003\f\u0003h\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007t\b\u0007\u0001\b\u0003\bw\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00a0\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!"+
		"\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0000\u0000*\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"\u0000\u0000\u00f6\u0000T\u0001\u0000\u0000\u0000\u0002X\u0001\u0000\u0000"+
		"\u0000\u0004`\u0001\u0000\u0000\u0000\u0006d\u0001\u0000\u0000\u0000\b"+
		"j\u0001\u0000\u0000\u0000\nm\u0001\u0000\u0000\u0000\fo\u0001\u0000\u0000"+
		"\u0000\u000es\u0001\u0000\u0000\u0000\u0010v\u0001\u0000\u0000\u0000\u0012"+
		"\u00a1\u0001\u0000\u0000\u0000\u0014\u00a3\u0001\u0000\u0000\u0000\u0016"+
		"\u00a5\u0001\u0000\u0000\u0000\u0018\u00a7\u0001\u0000\u0000\u0000\u001a"+
		"\u00a9\u0001\u0000\u0000\u0000\u001c\u00ab\u0001\u0000\u0000\u0000\u001e"+
		"\u00ad\u0001\u0000\u0000\u0000 \u00af\u0001\u0000\u0000\u0000\"\u00b1"+
		"\u0001\u0000\u0000\u0000$\u00b3\u0001\u0000\u0000\u0000&\u00b5\u0001\u0000"+
		"\u0000\u0000(\u00b7\u0001\u0000\u0000\u0000*\u00b9\u0001\u0000\u0000\u0000"+
		",\u00bb\u0001\u0000\u0000\u0000.\u00bd\u0001\u0000\u0000\u00000\u00bf"+
		"\u0001\u0000\u0000\u00002\u00c1\u0001\u0000\u0000\u00004\u00c7\u0001\u0000"+
		"\u0000\u00006\u00cd\u0001\u0000\u0000\u00008\u00d3\u0001\u0000\u0000\u0000"+
		":\u00d9\u0001\u0000\u0000\u0000<\u00e0\u0001\u0000\u0000\u0000>\u00e8"+
		"\u0001\u0000\u0000\u0000@\u00f0\u0001\u0000\u0000\u0000B\u00f7\u0001\u0000"+
		"\u0000\u0000D\u00fb\u0001\u0000\u0000\u0000F\u00fd\u0001\u0000\u0000\u0000"+
		"H\u00ff\u0001\u0000\u0000\u0000J\u0101\u0001\u0000\u0000\u0000L\u0106"+
		"\u0001\u0000\u0000\u0000N\u0108\u0001\u0000\u0000\u0000P\u010a\u0001\u0000"+
		"\u0000\u0000R\u010c\u0001\u0000\u0000\u0000TU\u0003\u0002\u0001\u0000"+
		"UV\u0005\u0000\u0000\u0001V\u0001\u0001\u0000\u0000\u0000WY\u0003\u0004"+
		"\u0002\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001"+
		"\u0000\u0000\u0000Z\\\u0003\u0010\b\u0000[Z\u0001\u0000\u0000\u0000\\"+
		"]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\u0003\u0001\u0000\u0000\u0000_a\u0003\u0006\u0003\u0000`_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u0005\u0001\u0000\u0000\u0000df\u0003\f\u0006"+
		"\u0000eg\u0003\b\u0004\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0007\u0001"+
		"\u0000\u0000\u0000jk\u0003\n\u0005\u0000kl\u0003\u000e\u0007\u0000l\t"+
		"\u0001\u0000\u0000\u0000mn\u0005\u001f\u0000\u0000n\u000b\u0001\u0000"+
		"\u0000\u0000op\u0005\u001d\u0000\u0000p\r\u0001\u0000\u0000\u0000qt\u0003"+
		"L&\u0000rt\u0003R)\u0000sq\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000t\u000f\u0001\u0000\u0000\u0000uw\u0003\u0012\t\u0000vu\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000w\u009f\u0001\u0000\u0000\u0000"+
		"xy\u0003\u0018\f\u0000yz\u00032\u0019\u0000z\u00a0\u0001\u0000\u0000\u0000"+
		"{|\u0003\u001a\r\u0000|}\u00034\u001a\u0000}\u00a0\u0001\u0000\u0000\u0000"+
		"~\u007f\u0003\u001c\u000e\u0000\u007f\u0080\u00036\u001b\u0000\u0080\u00a0"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0003\u001e\u000f\u0000\u0082\u0083"+
		"\u00038\u001c\u0000\u0083\u00a0\u0001\u0000\u0000\u0000\u0084\u0085\u0003"+
		" \u0010\u0000\u0085\u0086\u0003:\u001d\u0000\u0086\u00a0\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0003\"\u0011\u0000\u0088\u0089\u0003<\u001e\u0000"+
		"\u0089\u00a0\u0001\u0000\u0000\u0000\u008a\u008b\u0003$\u0012\u0000\u008b"+
		"\u008c\u0003>\u001f\u0000\u008c\u00a0\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0003&\u0013\u0000\u008e\u008f\u0003@ \u0000\u008f\u00a0\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0003(\u0014\u0000\u0091\u0092\u0003B!\u0000"+
		"\u0092\u00a0\u0001\u0000\u0000\u0000\u0093\u0094\u0003*\u0015\u0000\u0094"+
		"\u0095\u0003D\"\u0000\u0095\u00a0\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0003,\u0016\u0000\u0097\u0098\u0003F#\u0000\u0098\u00a0\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0003.\u0017\u0000\u009a\u009b\u0003H$\u0000"+
		"\u009b\u00a0\u0001\u0000\u0000\u0000\u009c\u009d\u00030\u0018\u0000\u009d"+
		"\u009e\u0003J%\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009fx\u0001"+
		"\u0000\u0000\u0000\u009f{\u0001\u0000\u0000\u0000\u009f~\u0001\u0000\u0000"+
		"\u0000\u009f\u0081\u0001\u0000\u0000\u0000\u009f\u0084\u0001\u0000\u0000"+
		"\u0000\u009f\u0087\u0001\u0000\u0000\u0000\u009f\u008a\u0001\u0000\u0000"+
		"\u0000\u009f\u008d\u0001\u0000\u0000\u0000\u009f\u0090\u0001\u0000\u0000"+
		"\u0000\u009f\u0093\u0001\u0000\u0000\u0000\u009f\u0096\u0001\u0000\u0000"+
		"\u0000\u009f\u0099\u0001\u0000\u0000\u0000\u009f\u009c\u0001\u0000\u0000"+
		"\u0000\u00a0\u0011\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u001d\u0000"+
		"\u0000\u00a2\u0013\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u001e\u0000"+
		"\u0000\u00a4\u0015\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u001e\u0000"+
		"\u0000\u00a6\u0017\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0001\u0000"+
		"\u0000\u00a8\u0019\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0002\u0000"+
		"\u0000\u00aa\u001b\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0003\u0000"+
		"\u0000\u00ac\u001d\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000"+
		"\u0000\u00ae\u001f\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0005\u0000"+
		"\u0000\u00b0!\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0006\u0000\u0000"+
		"\u00b2#\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0007\u0000\u0000\u00b4"+
		"%\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\b\u0000\u0000\u00b6\'\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0005\t\u0000\u0000\u00b8)\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0005\n\u0000\u0000\u00ba+\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005\u000b\u0000\u0000\u00bc-\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005\f\u0000\u0000\u00be/\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0005\r\u0000\u0000\u00c01\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0003N\'\u0000\u00c2\u00c3\u0005\u0011\u0000\u0000\u00c3\u00c4\u0003"+
		"N\'\u0000\u00c4\u00c5\u0005\u0011\u0000\u0000\u00c5\u00c6\u0003N\'\u0000"+
		"\u00c63\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003P(\u0000\u00c8\u00c9"+
		"\u0005\u0011\u0000\u0000\u00c9\u00ca\u0003P(\u0000\u00ca\u00cb\u0005\u0011"+
		"\u0000\u0000\u00cb\u00cc\u0003P(\u0000\u00cc5\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0003N\'\u0000\u00ce\u00cf\u0005\u0011\u0000\u0000\u00cf"+
		"\u00d0\u0003N\'\u0000\u00d0\u00d1\u0005\u0011\u0000\u0000\u00d1\u00d2"+
		"\u0003L&\u0000\u00d27\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003N\'\u0000"+
		"\u00d4\u00d5\u0005\u0011\u0000\u0000\u00d5\u00d6\u0003N\'\u0000\u00d6"+
		"\u00d7\u0005\u0011\u0000\u0000\u00d7\u00d8\u0003L&\u0000\u00d89\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0003N\'\u0000\u00da\u00db\u0005\u0011"+
		"\u0000\u0000\u00db\u00dc\u0003L&\u0000\u00dc\u00dd\u0005\u0011\u0000\u0000"+
		"\u00dd\u00de\u0005\u0003\u0000\u0000\u00de\u00df\u0003L&\u0000\u00df;"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003N\'\u0000\u00e1\u00e2\u0005"+
		"\u0011\u0000\u0000\u00e2\u00e3\u0005\u0014\u0000\u0000\u00e3\u00e4\u0003"+
		"N\'\u0000\u00e4\u00e5\u0005\u0011\u0000\u0000\u00e5\u00e6\u0003L&\u0000"+
		"\u00e6\u00e7\u0005\u0015\u0000\u0000\u00e7=\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0003P(\u0000\u00e9\u00ea\u0005\u0011\u0000\u0000\u00ea\u00eb\u0005"+
		"\u0014\u0000\u0000\u00eb\u00ec\u0003N\'\u0000\u00ec\u00ed\u0005\u0011"+
		"\u0000\u0000\u00ed\u00ee\u0003L&\u0000\u00ee\u00ef\u0005\u0015\u0000\u0000"+
		"\u00ef?\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003N\'\u0000\u00f1\u00f2"+
		"\u0005\u0011\u0000\u0000\u00f2\u00f3\u0003N\'\u0000\u00f3\u00f4\u0005"+
		"\u0014\u0000\u0000\u00f4\u00f5\u0003N\'\u0000\u00f5\u00f6\u0005\u0015"+
		"\u0000\u0000\u00f6A\u0001\u0000\u0000\u0000\u00f7\u00f8\u0003N\'\u0000"+
		"\u00f8\u00f9\u0005\u0011\u0000\u0000\u00f9\u00fa\u0003\u0014\n\u0000\u00fa"+
		"C\u0001\u0000\u0000\u0000\u00fb\u00fc\u0003\u0014\n\u0000\u00fcE\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0003\u0014\n\u0000\u00feG\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0003N\'\u0000\u0100I\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0003N\'\u0000\u0102\u0103\u0005\u0011\u0000\u0000\u0103"+
		"\u0104\u0005\u0013\u0000\u0000\u0104\u0105\u0003\u0016\u000b\u0000\u0105"+
		"K\u0001\u0000\u0000\u0000\u0106\u0107\u0005\u0018\u0000\u0000\u0107M\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0005\u0016\u0000\u0000\u0109O\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0005\u0017\u0000\u0000\u010bQ\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0005 \u0000\u0000\u010dS\u0001\u0000\u0000\u0000\u0007"+
		"X]bhsv\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}