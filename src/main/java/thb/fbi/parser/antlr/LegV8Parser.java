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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, COMMA=7, SEMI=8, WS=9, 
		NUMBER=10, MarkDeclaration=11, MarkInvocation=12;
	public static final int
		RULE_main = 0, RULE_program = 1, RULE_line = 2, RULE_declaration = 3, 
		RULE_rinstr = 4, RULE_iinstr = 5, RULE_rparam = 6, RULE_iparam = 7, RULE_num = 8, 
		RULE_register = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "program", "line", "declaration", "rinstr", "iinstr", "rparam", 
			"iparam", "num", "register"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'SUB'", "'ADDI'", "'X0'", "'X1'", "'X2'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "COMMA", "SEMI", "WS", "NUMBER", 
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
			setState(20);
			program();
			setState(21);
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
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				line();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 2062L) != 0 );
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
		public RinstrContext rinstr() {
			return getRuleContext(RinstrContext.class,0);
		}
		public RparamContext rparam() {
			return getRuleContext(RparamContext.class,0);
		}
		public IinstrContext iinstr() {
			return getRuleContext(IinstrContext.class,0);
		}
		public IparamContext iparam() {
			return getRuleContext(IparamContext.class,0);
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MarkDeclaration) {
				{
				setState(28);
				declaration();
				}
			}

			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				{
				setState(31);
				rinstr();
				setState(32);
				rparam();
				}
				break;
			case T__2:
				{
				setState(34);
				iinstr();
				setState(35);
				iparam();
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
			setState(39);
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
	public static class RinstrContext extends ParserRuleContext {
		public RinstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rinstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterRinstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitRinstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitRinstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RinstrContext rinstr() throws RecognitionException {
		RinstrContext _localctx = new RinstrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rinstr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
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
	public static class IinstrContext extends ParserRuleContext {
		public IinstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iinstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterIinstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitIinstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitIinstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IinstrContext iinstr() throws RecognitionException {
		IinstrContext _localctx = new IinstrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_iinstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
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
	public static class RparamContext extends ParserRuleContext {
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
		public RparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterRparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitRparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitRparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RparamContext rparam() throws RecognitionException {
		RparamContext _localctx = new RparamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			register();
			setState(46);
			match(COMMA);
			setState(47);
			register();
			setState(48);
			match(COMMA);
			setState(49);
			register();
			setState(50);
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
	public static class IparamContext extends ParserRuleContext {
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
		public IparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).enterIparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LegV8Listener ) ((LegV8Listener)listener).exitIparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LegV8Visitor ) return ((LegV8Visitor<? extends T>)visitor).visitIparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IparamContext iparam() throws RecognitionException {
		IparamContext _localctx = new IparamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_iparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			register();
			setState(53);
			match(COMMA);
			setState(54);
			register();
			setState(55);
			match(COMMA);
			setState(56);
			num();
			setState(57);
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
		enterRule(_localctx, 16, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
		enterRule(_localctx, 18, RULE_register);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\f@\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0004\u0001\u0019\b\u0001\u000b\u0001\f\u0001\u001a\u0001\u0002\u0003"+
		"\u0002\u001e\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002&\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0002\u0001\u0000\u0001\u0002\u0001\u0000"+
		"\u0004\u00068\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000"+
		"\u0000\u0000\u0004\u001d\u0001\u0000\u0000\u0000\u0006\'\u0001\u0000\u0000"+
		"\u0000\b)\u0001\u0000\u0000\u0000\n+\u0001\u0000\u0000\u0000\f-\u0001"+
		"\u0000\u0000\u0000\u000e4\u0001\u0000\u0000\u0000\u0010;\u0001\u0000\u0000"+
		"\u0000\u0012=\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000"+
		"\u0015\u0016\u0005\u0000\u0000\u0001\u0016\u0001\u0001\u0000\u0000\u0000"+
		"\u0017\u0019\u0003\u0004\u0002\u0000\u0018\u0017\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000"+
		"\u001c\u001e\u0003\u0006\u0003\u0000\u001d\u001c\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e%\u0001\u0000\u0000\u0000\u001f"+
		" \u0003\b\u0004\u0000 !\u0003\f\u0006\u0000!&\u0001\u0000\u0000\u0000"+
		"\"#\u0003\n\u0005\u0000#$\u0003\u000e\u0007\u0000$&\u0001\u0000\u0000"+
		"\u0000%\u001f\u0001\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000&\u0005"+
		"\u0001\u0000\u0000\u0000\'(\u0005\u000b\u0000\u0000(\u0007\u0001\u0000"+
		"\u0000\u0000)*\u0007\u0000\u0000\u0000*\t\u0001\u0000\u0000\u0000+,\u0005"+
		"\u0003\u0000\u0000,\u000b\u0001\u0000\u0000\u0000-.\u0003\u0012\t\u0000"+
		"./\u0005\u0007\u0000\u0000/0\u0003\u0012\t\u000001\u0005\u0007\u0000\u0000"+
		"12\u0003\u0012\t\u000023\u0005\b\u0000\u00003\r\u0001\u0000\u0000\u0000"+
		"45\u0003\u0012\t\u000056\u0005\u0007\u0000\u000067\u0003\u0012\t\u0000"+
		"78\u0005\u0007\u0000\u000089\u0003\u0010\b\u00009:\u0005\b\u0000\u0000"+
		":\u000f\u0001\u0000\u0000\u0000;<\u0005\n\u0000\u0000<\u0011\u0001\u0000"+
		"\u0000\u0000=>\u0007\u0001\u0000\u0000>\u0013\u0001\u0000\u0000\u0000"+
		"\u0003\u001a\u001d%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}