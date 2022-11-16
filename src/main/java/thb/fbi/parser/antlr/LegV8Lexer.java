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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, WS=6, COMMENT=7, LINE_COMMENT=8, 
		COMMA=9, SEMI=10, REGISTER=11, NUMBER=12, MarkDeclaration=13, MarkInvocation=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "WS", "COMMENT", "LINE_COMMENT", 
			"COMMA", "SEMI", "REGISTER", "NUMBER", "MarkDeclaration", "MarkInvocation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'SUB'", "'ADDI'", "'STUR'", "'CBNZ'", null, null, null, 
			"','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"COMMA", "SEMI", "REGISTER", "NUMBER", "MarkDeclaration", "MarkInvocation"
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
		"\u0004\u0000\u000ez\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006=\b"+
		"\u0006\n\u0006\f\u0006@\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007K\b\u0007\n\u0007\f\u0007N\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n[\b\n\n\n\f\n^\t\n\u0003\n`\b\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"d\b\u000b\u0001\u000b\u0001\u000b\u0005\u000bh\b\u000b\n\u000b\f\u000b"+
		"k\t\u000b\u0003\u000bm\b\u000b\u0001\f\u0004\fp\b\f\u000b\f\f\fq\u0001"+
		"\f\u0001\f\u0001\r\u0004\rw\b\r\u000b\r\f\rx\u0001>\u0000\u000e\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001"+
		"\u0000\u0005\u0003\u0000\t\n\f\r  \u0002\u0000\n\n\r\r\u0001\u000019\u0001"+
		"\u000009\u0002\u0000AZaz\u0082\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003!\u0001\u0000"+
		"\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007*\u0001\u0000\u0000\u0000"+
		"\t/\u0001\u0000\u0000\u0000\u000b4\u0001\u0000\u0000\u0000\r8\u0001\u0000"+
		"\u0000\u0000\u000fF\u0001\u0000\u0000\u0000\u0011Q\u0001\u0000\u0000\u0000"+
		"\u0013S\u0001\u0000\u0000\u0000\u0015_\u0001\u0000\u0000\u0000\u0017l"+
		"\u0001\u0000\u0000\u0000\u0019o\u0001\u0000\u0000\u0000\u001bv\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0005A\u0000\u0000\u001e\u001f\u0005D\u0000\u0000"+
		"\u001f \u0005D\u0000\u0000 \u0002\u0001\u0000\u0000\u0000!\"\u0005S\u0000"+
		"\u0000\"#\u0005U\u0000\u0000#$\u0005B\u0000\u0000$\u0004\u0001\u0000\u0000"+
		"\u0000%&\u0005A\u0000\u0000&\'\u0005D\u0000\u0000\'(\u0005D\u0000\u0000"+
		"()\u0005I\u0000\u0000)\u0006\u0001\u0000\u0000\u0000*+\u0005S\u0000\u0000"+
		"+,\u0005T\u0000\u0000,-\u0005U\u0000\u0000-.\u0005R\u0000\u0000.\b\u0001"+
		"\u0000\u0000\u0000/0\u0005C\u0000\u000001\u0005B\u0000\u000012\u0005N"+
		"\u0000\u000023\u0005Z\u0000\u00003\n\u0001\u0000\u0000\u000045\u0007\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u000067\u0006\u0005\u0000\u00007\f\u0001"+
		"\u0000\u0000\u000089\u0005/\u0000\u00009:\u0005*\u0000\u0000:>\u0001\u0000"+
		"\u0000\u0000;=\t\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?A\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0005*\u0000\u0000BC\u0005"+
		"/\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006\u0006\u0000\u0000E\u000e"+
		"\u0001\u0000\u0000\u0000FG\u0005/\u0000\u0000GH\u0005/\u0000\u0000HL\u0001"+
		"\u0000\u0000\u0000IK\b\u0001\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MO\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0006\u0007\u0000"+
		"\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0005,\u0000\u0000R\u0012\u0001"+
		"\u0000\u0000\u0000ST\u0005;\u0000\u0000T\u0014\u0001\u0000\u0000\u0000"+
		"UV\u0005X\u0000\u0000V`\u00050\u0000\u0000WX\u0005X\u0000\u0000X\\\u0007"+
		"\u0002\u0000\u0000Y[\u0007\u0003\u0000\u0000ZY\u0001\u0000\u0000\u0000"+
		"[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_U\u0001\u0000"+
		"\u0000\u0000_W\u0001\u0000\u0000\u0000`\u0016\u0001\u0000\u0000\u0000"+
		"am\u00050\u0000\u0000bd\u0005-\u0000\u0000cb\u0001\u0000\u0000\u0000c"+
		"d\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ei\u0007\u0002\u0000"+
		"\u0000fh\u0007\u0003\u0000\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000"+
		"\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jm\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000la\u0001\u0000\u0000\u0000"+
		"lc\u0001\u0000\u0000\u0000m\u0018\u0001\u0000\u0000\u0000np\u0007\u0004"+
		"\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"st\u0005:\u0000\u0000t\u001a\u0001\u0000\u0000\u0000uw\u0007\u0004\u0000"+
		"\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000y\u001c\u0001\u0000\u0000\u0000"+
		"\n\u0000>L\\_cilqx\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}