// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.leguan.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LegV8Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ArithmeticInstruction=2, ShiftInstruction=3, ImmediateInstruction=4, 
		WideImmediateInstrcution=5, DatatransferInstruction=6, ExclusiveInstruction=7, 
		CondBranchInstruction=8, BranchInstruction=9, WS=10, COMMENT=11, LINE_COMMENT=12, 
		COMMA=13, SEMI=14, SQUARE_BRACKET_LEFT=15, SQUARE_BRACKET_RIGHT=16, REGISTER=17, 
		NUMBER=18, SP=19, FP=20, LR=21, XZR=22, JumpDeclaration=23, JumpInvocation=24;
	public static final int
		RULE_main = 0, RULE_program = 1, RULE_line = 2, RULE_declaration = 3, 
		RULE_invocation = 4, RULE_arithmeticInstruction = 5, RULE_shiftInstruction = 6, 
		RULE_immediateInstruction = 7, RULE_wideImmediateInstruction = 8, RULE_datatransferInstruction = 9, 
		RULE_exclusiveInstruction = 10, RULE_condBranchInstruction = 11, RULE_branchInstruction = 12, 
		RULE_arithmeticParam = 13, RULE_shiftParam = 14, RULE_immediateParam = 15, 
		RULE_wideImmediateParam = 16, RULE_datatransferParam = 17, RULE_exclusiveParam = 18, 
		RULE_condBranchParam = 19, RULE_branchParam = 20, RULE_num = 21, RULE_register = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "program", "line", "declaration", "invocation", "arithmeticInstruction", 
			"shiftInstruction", "immediateInstruction", "wideImmediateInstruction", 
			"datatransferInstruction", "exclusiveInstruction", "condBranchInstruction", 
			"branchInstruction", "arithmeticParam", "shiftParam", "immediateParam", 
			"wideImmediateParam", "datatransferParam", "exclusiveParam", "condBranchParam", 
			"branchParam", "num", "register"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'LSL'", null, null, null, null, null, "'STXR'", null, null, null, 
			null, null, "','", "';'", "'['", "']'", null, null, "'SP'", "'FP'", "'LR'", 
			"'XZR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ArithmeticInstruction", "ShiftInstruction", "ImmediateInstruction", 
			"WideImmediateInstrcution", "DatatransferInstruction", "ExclusiveInstruction", 
			"CondBranchInstruction", "BranchInstruction", "WS", "COMMENT", "LINE_COMMENT", 
			"COMMA", "SEMI", "SQUARE_BRACKET_LEFT", "SQUARE_BRACKET_RIGHT", "REGISTER", 
			"NUMBER", "SP", "FP", "LR", "XZR", "JumpDeclaration", "JumpInvocation"
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
	public String getGrammarFileName() { return "java-escape"; }

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
			setState(46);
			program();
			setState(47);
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
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				line();
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 8389628L) != 0 );
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
		public BranchInstructionContext branchInstruction() {
			return getRuleContext(BranchInstructionContext.class,0);
		}
		public BranchParamContext branchParam() {
			return getRuleContext(BranchParamContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
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
		enterRule(_localctx, 4, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==JumpDeclaration) {
				{
				setState(54);
				declaration();
				}
			}

			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ArithmeticInstruction:
				{
				setState(57);
				arithmeticInstruction();
				setState(58);
				arithmeticParam();
				}
				break;
			case ShiftInstruction:
				{
				setState(60);
				shiftInstruction();
				setState(61);
				shiftParam();
				}
				break;
			case ImmediateInstruction:
				{
				setState(63);
				immediateInstruction();
				setState(64);
				immediateParam();
				}
				break;
			case WideImmediateInstrcution:
				{
				setState(66);
				wideImmediateInstruction();
				setState(67);
				wideImmediateParam();
				}
				break;
			case DatatransferInstruction:
				{
				setState(69);
				datatransferInstruction();
				setState(70);
				datatransferParam();
				}
				break;
			case ExclusiveInstruction:
				{
				setState(72);
				exclusiveInstruction();
				setState(73);
				exclusiveParam();
				}
				break;
			case CondBranchInstruction:
				{
				setState(75);
				condBranchInstruction();
				setState(76);
				condBranchParam();
				}
				break;
			case BranchInstruction:
				{
				setState(78);
				branchInstruction();
				setState(79);
				branchParam();
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
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode JumpDeclaration() { return getToken(LegV8Parser.JumpDeclaration, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(JumpDeclaration);
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
	public static class InvocationContext extends ParserRuleContext {
		public TerminalNode JumpInvocation() { return getToken(LegV8Parser.JumpInvocation, 0); }
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(JumpInvocation);
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
		enterRule(_localctx, 10, RULE_arithmeticInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
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
		enterRule(_localctx, 12, RULE_shiftInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
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
		enterRule(_localctx, 14, RULE_immediateInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
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
		enterRule(_localctx, 16, RULE_wideImmediateInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
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
		enterRule(_localctx, 18, RULE_datatransferInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		enterRule(_localctx, 20, RULE_exclusiveInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		enterRule(_localctx, 22, RULE_condBranchInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
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
		enterRule(_localctx, 24, RULE_branchInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
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
	public static class ArithmeticParamContext extends ParserRuleContext {
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 26, RULE_arithmeticParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			register();
			setState(104);
			match(COMMA);
			setState(105);
			register();
			setState(106);
			match(COMMA);
			setState(107);
			register();
			setState(108);
			match(SEMI);
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
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 28, RULE_shiftParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			register();
			setState(111);
			match(COMMA);
			setState(112);
			register();
			setState(113);
			match(COMMA);
			setState(114);
			num();
			setState(115);
			match(SEMI);
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
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LegV8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LegV8Parser.COMMA, i);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 30, RULE_immediateParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			register();
			setState(118);
			match(COMMA);
			setState(119);
			register();
			setState(120);
			match(COMMA);
			setState(121);
			num();
			setState(122);
			match(SEMI);
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
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
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
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 32, RULE_wideImmediateParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			register();
			setState(125);
			match(COMMA);
			setState(126);
			num();
			setState(127);
			match(COMMA);
			setState(128);
			match(T__0);
			setState(129);
			num();
			setState(130);
			match(SEMI);
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
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
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
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 34, RULE_datatransferParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			register();
			setState(133);
			match(COMMA);
			setState(134);
			match(SQUARE_BRACKET_LEFT);
			setState(135);
			register();
			setState(136);
			match(COMMA);
			setState(137);
			num();
			setState(138);
			match(SQUARE_BRACKET_RIGHT);
			setState(139);
			match(SEMI);
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
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(LegV8Parser.COMMA, 0); }
		public TerminalNode SQUARE_BRACKET_LEFT() { return getToken(LegV8Parser.SQUARE_BRACKET_LEFT, 0); }
		public TerminalNode SQUARE_BRACKET_RIGHT() { return getToken(LegV8Parser.SQUARE_BRACKET_RIGHT, 0); }
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 36, RULE_exclusiveParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			register();
			setState(142);
			match(COMMA);
			setState(143);
			register();
			setState(144);
			match(SQUARE_BRACKET_LEFT);
			setState(145);
			register();
			setState(146);
			match(SQUARE_BRACKET_RIGHT);
			setState(147);
			match(SEMI);
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
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(LegV8Parser.COMMA, 0); }
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 38, RULE_condBranchParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			register();
			setState(150);
			match(COMMA);
			setState(151);
			invocation();
			setState(152);
			match(SEMI);
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
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LegV8Parser.SEMI, 0); }
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
		enterRule(_localctx, 40, RULE_branchParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			invocation();
			setState(155);
			match(SEMI);
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
		enterRule(_localctx, 42, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
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
	public static class RegisterContext extends ParserRuleContext {
		public TerminalNode REGISTER() { return getToken(LegV8Parser.REGISTER, 0); }
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterRegister(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitRegister(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitRegister(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(REGISTER);
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
		"\u0004\u0001\u0018\u00a2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0004\u00013\b\u0001\u000b\u0001\f\u00014\u0001\u0002\u0003\u0002"+
		"8\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002R\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0000"+
		"\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,\u0000\u0000\u0093\u0000.\u0001\u0000\u0000"+
		"\u0000\u00022\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006"+
		"S\u0001\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\nW\u0001\u0000\u0000"+
		"\u0000\fY\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010"+
		"]\u0001\u0000\u0000\u0000\u0012_\u0001\u0000\u0000\u0000\u0014a\u0001"+
		"\u0000\u0000\u0000\u0016c\u0001\u0000\u0000\u0000\u0018e\u0001\u0000\u0000"+
		"\u0000\u001ag\u0001\u0000\u0000\u0000\u001cn\u0001\u0000\u0000\u0000\u001e"+
		"u\u0001\u0000\u0000\u0000 |\u0001\u0000\u0000\u0000\"\u0084\u0001\u0000"+
		"\u0000\u0000$\u008d\u0001\u0000\u0000\u0000&\u0095\u0001\u0000\u0000\u0000"+
		"(\u009a\u0001\u0000\u0000\u0000*\u009d\u0001\u0000\u0000\u0000,\u009f"+
		"\u0001\u0000\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0005\u0000\u0000"+
		"\u00010\u0001\u0001\u0000\u0000\u000013\u0003\u0004\u0002\u000021\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u00005\u0003\u0001\u0000\u0000\u000068\u0003\u0006"+
		"\u0003\u000076\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008Q\u0001"+
		"\u0000\u0000\u00009:\u0003\n\u0005\u0000:;\u0003\u001a\r\u0000;R\u0001"+
		"\u0000\u0000\u0000<=\u0003\f\u0006\u0000=>\u0003\u001c\u000e\u0000>R\u0001"+
		"\u0000\u0000\u0000?@\u0003\u000e\u0007\u0000@A\u0003\u001e\u000f\u0000"+
		"AR\u0001\u0000\u0000\u0000BC\u0003\u0010\b\u0000CD\u0003 \u0010\u0000"+
		"DR\u0001\u0000\u0000\u0000EF\u0003\u0012\t\u0000FG\u0003\"\u0011\u0000"+
		"GR\u0001\u0000\u0000\u0000HI\u0003\u0014\n\u0000IJ\u0003$\u0012\u0000"+
		"JR\u0001\u0000\u0000\u0000KL\u0003\u0016\u000b\u0000LM\u0003&\u0013\u0000"+
		"MR\u0001\u0000\u0000\u0000NO\u0003\u0018\f\u0000OP\u0003(\u0014\u0000"+
		"PR\u0001\u0000\u0000\u0000Q9\u0001\u0000\u0000\u0000Q<\u0001\u0000\u0000"+
		"\u0000Q?\u0001\u0000\u0000\u0000QB\u0001\u0000\u0000\u0000QE\u0001\u0000"+
		"\u0000\u0000QH\u0001\u0000\u0000\u0000QK\u0001\u0000\u0000\u0000QN\u0001"+
		"\u0000\u0000\u0000R\u0005\u0001\u0000\u0000\u0000ST\u0005\u0017\u0000"+
		"\u0000T\u0007\u0001\u0000\u0000\u0000UV\u0005\u0018\u0000\u0000V\t\u0001"+
		"\u0000\u0000\u0000WX\u0005\u0002\u0000\u0000X\u000b\u0001\u0000\u0000"+
		"\u0000YZ\u0005\u0003\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0005\u0004"+
		"\u0000\u0000\\\u000f\u0001\u0000\u0000\u0000]^\u0005\u0005\u0000\u0000"+
		"^\u0011\u0001\u0000\u0000\u0000_`\u0005\u0006\u0000\u0000`\u0013\u0001"+
		"\u0000\u0000\u0000ab\u0005\u0007\u0000\u0000b\u0015\u0001\u0000\u0000"+
		"\u0000cd\u0005\b\u0000\u0000d\u0017\u0001\u0000\u0000\u0000ef\u0005\t"+
		"\u0000\u0000f\u0019\u0001\u0000\u0000\u0000gh\u0003,\u0016\u0000hi\u0005"+
		"\r\u0000\u0000ij\u0003,\u0016\u0000jk\u0005\r\u0000\u0000kl\u0003,\u0016"+
		"\u0000lm\u0005\u000e\u0000\u0000m\u001b\u0001\u0000\u0000\u0000no\u0003"+
		",\u0016\u0000op\u0005\r\u0000\u0000pq\u0003,\u0016\u0000qr\u0005\r\u0000"+
		"\u0000rs\u0003*\u0015\u0000st\u0005\u000e\u0000\u0000t\u001d\u0001\u0000"+
		"\u0000\u0000uv\u0003,\u0016\u0000vw\u0005\r\u0000\u0000wx\u0003,\u0016"+
		"\u0000xy\u0005\r\u0000\u0000yz\u0003*\u0015\u0000z{\u0005\u000e\u0000"+
		"\u0000{\u001f\u0001\u0000\u0000\u0000|}\u0003,\u0016\u0000}~\u0005\r\u0000"+
		"\u0000~\u007f\u0003*\u0015\u0000\u007f\u0080\u0005\r\u0000\u0000\u0080"+
		"\u0081\u0005\u0001\u0000\u0000\u0081\u0082\u0003*\u0015\u0000\u0082\u0083"+
		"\u0005\u000e\u0000\u0000\u0083!\u0001\u0000\u0000\u0000\u0084\u0085\u0003"+
		",\u0016\u0000\u0085\u0086\u0005\r\u0000\u0000\u0086\u0087\u0005\u000f"+
		"\u0000\u0000\u0087\u0088\u0003,\u0016\u0000\u0088\u0089\u0005\r\u0000"+
		"\u0000\u0089\u008a\u0003*\u0015\u0000\u008a\u008b\u0005\u0010\u0000\u0000"+
		"\u008b\u008c\u0005\u000e\u0000\u0000\u008c#\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0003,\u0016\u0000\u008e\u008f\u0005\r\u0000\u0000\u008f\u0090"+
		"\u0003,\u0016\u0000\u0090\u0091\u0005\u000f\u0000\u0000\u0091\u0092\u0003"+
		",\u0016\u0000\u0092\u0093\u0005\u0010\u0000\u0000\u0093\u0094\u0005\u000e"+
		"\u0000\u0000\u0094%\u0001\u0000\u0000\u0000\u0095\u0096\u0003,\u0016\u0000"+
		"\u0096\u0097\u0005\r\u0000\u0000\u0097\u0098\u0003\b\u0004\u0000\u0098"+
		"\u0099\u0005\u000e\u0000\u0000\u0099\'\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0003\b\u0004\u0000\u009b\u009c\u0005\u000e\u0000\u0000\u009c)\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u0012\u0000\u0000\u009e+\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0005\u0011\u0000\u0000\u00a0-\u0001\u0000\u0000"+
		"\u0000\u000347Q";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}