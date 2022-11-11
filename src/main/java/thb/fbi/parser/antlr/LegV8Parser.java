// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.parser.antlr;
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
		T__0=1, T__1=2, T__2=3, T__3=4, COMMA=5, SEMI=6, WS=7, REGISTER=8, NUMBER=9, 
		MarkDeclaration=10, MarkInvocation=11;
	public static final int
		RULE_main = 0, RULE_program = 1, RULE_line = 2, RULE_declaration = 3, 
		RULE_arithmeticInstruction = 4, RULE_immediateInstruction = 5, RULE_datatransferInstruction = 6, 
		RULE_arithmeticParam = 7, RULE_immediateParam = 8, RULE_datatransferParam = 9, 
		RULE_num = 10, RULE_register = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "program", "line", "declaration", "arithmeticInstruction", "immediateInstruction", 
			"datatransferInstruction", "arithmeticParam", "immediateParam", "datatransferParam", 
			"num", "register"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'SUB'", "'ADDI'", "'STUR'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "COMMA", "SEMI", "WS", "REGISTER", "NUMBER", 
			"MarkDeclaration", "MarkInvocation"
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
			setState(24);
			program();
			setState(25);
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
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				line();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1054L) != 0 );
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
		public ImmediateInstructionContext immediateInstruction() {
			return getRuleContext(ImmediateInstructionContext.class,0);
		}
		public ImmediateParamContext immediateParam() {
			return getRuleContext(ImmediateParamContext.class,0);
		}
		public DatatransferInstructionContext datatransferInstruction() {
			return getRuleContext(DatatransferInstructionContext.class,0);
		}
		public DatatransferParamContext datatransferParam() {
			return getRuleContext(DatatransferParamContext.class,0);
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MarkDeclaration) {
				{
				setState(32);
				declaration();
				}
			}

			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				{
				setState(35);
				arithmeticInstruction();
				setState(36);
				arithmeticParam();
				}
				break;
			case T__2:
				{
				setState(38);
				immediateInstruction();
				setState(39);
				immediateParam();
				}
				break;
			case T__3:
				{
				setState(41);
				datatransferInstruction();
				setState(42);
				datatransferParam();
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
		public TerminalNode MarkDeclaration() { return getToken(LegV8Parser.MarkDeclaration, 0); }
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
			setState(46);
			match(MarkDeclaration);
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
		enterRule(_localctx, 8, RULE_arithmeticInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ImmediateInstructionContext extends ParserRuleContext {
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
		enterRule(_localctx, 10, RULE_immediateInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__2);
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
		enterRule(_localctx, 12, RULE_datatransferInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__3);
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
		enterRule(_localctx, 14, RULE_arithmeticParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			register();
			setState(55);
			match(COMMA);
			setState(56);
			register();
			setState(57);
			match(COMMA);
			setState(58);
			register();
			setState(59);
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
		enterRule(_localctx, 16, RULE_immediateParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			register();
			setState(62);
			match(COMMA);
			setState(63);
			register();
			setState(64);
			match(COMMA);
			setState(65);
			num();
			setState(66);
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
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_datatransferParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			register();
			setState(69);
			match(COMMA);
			setState(70);
			register();
			setState(71);
			match(COMMA);
			setState(72);
			num();
			setState(73);
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
		enterRule(_localctx, 20, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
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
		enterRule(_localctx, 22, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
		"\u0004\u0001\u000bP\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001\u001d\b\u0001\u000b"+
		"\u0001\f\u0001\u001e\u0001\u0002\u0003\u0002\"\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001\u0001\u0000\u0001\u0002"+
		"G\u0000\u0018\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000"+
		"\u0004!\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000\u0000\b0\u0001"+
		"\u0000\u0000\u0000\n2\u0001\u0000\u0000\u0000\f4\u0001\u0000\u0000\u0000"+
		"\u000e6\u0001\u0000\u0000\u0000\u0010=\u0001\u0000\u0000\u0000\u0012D"+
		"\u0001\u0000\u0000\u0000\u0014K\u0001\u0000\u0000\u0000\u0016M\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0003\u0002\u0001\u0000\u0019\u001a\u0005\u0000"+
		"\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001d\u0003\u0004"+
		"\u0002\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001f\u0003\u0001\u0000\u0000\u0000 \"\u0003\u0006\u0003"+
		"\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\",\u0001\u0000"+
		"\u0000\u0000#$\u0003\b\u0004\u0000$%\u0003\u000e\u0007\u0000%-\u0001\u0000"+
		"\u0000\u0000&\'\u0003\n\u0005\u0000\'(\u0003\u0010\b\u0000(-\u0001\u0000"+
		"\u0000\u0000)*\u0003\f\u0006\u0000*+\u0003\u0012\t\u0000+-\u0001\u0000"+
		"\u0000\u0000,#\u0001\u0000\u0000\u0000,&\u0001\u0000\u0000\u0000,)\u0001"+
		"\u0000\u0000\u0000-\u0005\u0001\u0000\u0000\u0000./\u0005\n\u0000\u0000"+
		"/\u0007\u0001\u0000\u0000\u000001\u0007\u0000\u0000\u00001\t\u0001\u0000"+
		"\u0000\u000023\u0005\u0003\u0000\u00003\u000b\u0001\u0000\u0000\u0000"+
		"45\u0005\u0004\u0000\u00005\r\u0001\u0000\u0000\u000067\u0003\u0016\u000b"+
		"\u000078\u0005\u0005\u0000\u000089\u0003\u0016\u000b\u00009:\u0005\u0005"+
		"\u0000\u0000:;\u0003\u0016\u000b\u0000;<\u0005\u0006\u0000\u0000<\u000f"+
		"\u0001\u0000\u0000\u0000=>\u0003\u0016\u000b\u0000>?\u0005\u0005\u0000"+
		"\u0000?@\u0003\u0016\u000b\u0000@A\u0005\u0005\u0000\u0000AB\u0003\u0014"+
		"\n\u0000BC\u0005\u0006\u0000\u0000C\u0011\u0001\u0000\u0000\u0000DE\u0003"+
		"\u0016\u000b\u0000EF\u0005\u0005\u0000\u0000FG\u0003\u0016\u000b\u0000"+
		"GH\u0005\u0005\u0000\u0000HI\u0003\u0014\n\u0000IJ\u0005\u0006\u0000\u0000"+
		"J\u0013\u0001\u0000\u0000\u0000KL\u0005\t\u0000\u0000L\u0015\u0001\u0000"+
		"\u0000\u0000MN\u0005\b\u0000\u0000N\u0017\u0001\u0000\u0000\u0000\u0003"+
		"\u001e!,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}