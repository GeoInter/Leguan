// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LegV8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, WS=9, 
		COMMENT=10, LINE_COMMENT=11, COMMA=12, SEMI=13, REGISTER=14, NUMBER=15, 
		JumpDeclaration=16, JumpInvocation=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "WS", 
			"COMMENT", "LINE_COMMENT", "COMMA", "SEMI", "REGISTER", "NUMBER", "JumpDeclaration", 
			"JumpInvocation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'SUB'", "'LSL'", "'LSR'", "'ADDI'", "'STUR'", "'CBNZ'", 
			"'B'", null, null, null, "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "WS", "COMMENT", 
			"LINE_COMMENT", "COMMA", "SEMI", "REGISTER", "NUMBER", "JumpDeclaration", 
			"JumpInvocation"
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


	public LegV8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LegV8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0011\u008a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\tM\b\t\n\t\f\tP\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n[\b\n\n\n\f\n^\t\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\rk\b\r\n\r\f\rn\t\r\u0003\rp\b\r\u0001\u000e\u0001\u000e\u0003"+
		"\u000et\b\u000e\u0001\u000e\u0001\u000e\u0005\u000ex\b\u000e\n\u000e\f"+
		"\u000e{\t\u000e\u0003\u000e}\b\u000e\u0001\u000f\u0004\u000f\u0080\b\u000f"+
		"\u000b\u000f\f\u000f\u0081\u0001\u000f\u0001\u000f\u0001\u0010\u0004\u0010"+
		"\u0087\b\u0010\u000b\u0010\f\u0010\u0088\u0001N\u0000\u0011\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011\u0001\u0000\u0005\u0003\u0000\t\n\f\r  \u0002\u0000"+
		"\n\n\r\r\u0001\u000019\u0001\u000009\u0002\u0000AZaz\u0092\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0001#\u0001\u0000\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000"+
		"\u0005+\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t3\u0001"+
		"\u0000\u0000\u0000\u000b8\u0001\u0000\u0000\u0000\r=\u0001\u0000\u0000"+
		"\u0000\u000fB\u0001\u0000\u0000\u0000\u0011D\u0001\u0000\u0000\u0000\u0013"+
		"H\u0001\u0000\u0000\u0000\u0015V\u0001\u0000\u0000\u0000\u0017a\u0001"+
		"\u0000\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001bo\u0001\u0000\u0000"+
		"\u0000\u001d|\u0001\u0000\u0000\u0000\u001f\u007f\u0001\u0000\u0000\u0000"+
		"!\u0086\u0001\u0000\u0000\u0000#$\u0005A\u0000\u0000$%\u0005D\u0000\u0000"+
		"%&\u0005D\u0000\u0000&\u0002\u0001\u0000\u0000\u0000\'(\u0005S\u0000\u0000"+
		"()\u0005U\u0000\u0000)*\u0005B\u0000\u0000*\u0004\u0001\u0000\u0000\u0000"+
		"+,\u0005L\u0000\u0000,-\u0005S\u0000\u0000-.\u0005L\u0000\u0000.\u0006"+
		"\u0001\u0000\u0000\u0000/0\u0005L\u0000\u000001\u0005S\u0000\u000012\u0005"+
		"R\u0000\u00002\b\u0001\u0000\u0000\u000034\u0005A\u0000\u000045\u0005"+
		"D\u0000\u000056\u0005D\u0000\u000067\u0005I\u0000\u00007\n\u0001\u0000"+
		"\u0000\u000089\u0005S\u0000\u00009:\u0005T\u0000\u0000:;\u0005U\u0000"+
		"\u0000;<\u0005R\u0000\u0000<\f\u0001\u0000\u0000\u0000=>\u0005C\u0000"+
		"\u0000>?\u0005B\u0000\u0000?@\u0005N\u0000\u0000@A\u0005Z\u0000\u0000"+
		"A\u000e\u0001\u0000\u0000\u0000BC\u0005B\u0000\u0000C\u0010\u0001\u0000"+
		"\u0000\u0000DE\u0007\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0006"+
		"\b\u0000\u0000G\u0012\u0001\u0000\u0000\u0000HI\u0005/\u0000\u0000IJ\u0005"+
		"*\u0000\u0000JN\u0001\u0000\u0000\u0000KM\t\u0000\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000"+
		"\u0000QR\u0005*\u0000\u0000RS\u0005/\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"TU\u0006\t\u0000\u0000U\u0014\u0001\u0000\u0000\u0000VW\u0005/\u0000\u0000"+
		"WX\u0005/\u0000\u0000X\\\u0001\u0000\u0000\u0000Y[\b\u0001\u0000\u0000"+
		"ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000_`\u0006\n\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005"+
		",\u0000\u0000b\u0018\u0001\u0000\u0000\u0000cd\u0005;\u0000\u0000d\u001a"+
		"\u0001\u0000\u0000\u0000ef\u0005X\u0000\u0000fp\u00050\u0000\u0000gh\u0005"+
		"X\u0000\u0000hl\u0007\u0002\u0000\u0000ik\u0007\u0003\u0000\u0000ji\u0001"+
		"\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000"+
		"\u0000oe\u0001\u0000\u0000\u0000og\u0001\u0000\u0000\u0000p\u001c\u0001"+
		"\u0000\u0000\u0000q}\u00050\u0000\u0000rt\u0005-\u0000\u0000sr\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uy\u0007"+
		"\u0002\u0000\u0000vx\u0007\u0003\u0000\u0000wv\u0001\u0000\u0000\u0000"+
		"x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|q\u0001\u0000"+
		"\u0000\u0000|s\u0001\u0000\u0000\u0000}\u001e\u0001\u0000\u0000\u0000"+
		"~\u0080\u0007\u0004\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005:\u0000\u0000\u0084 \u0001\u0000\u0000\u0000\u0085\u0087\u0007\u0004"+
		"\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\"\u0001\u0000\u0000\u0000\n\u0000N\\losy|\u0081\u0088"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}