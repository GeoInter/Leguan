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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, COMMA=7, SEMI=8, WS=9, 
		NUMBER=10, MarkDeclaration=11, MarkInvocation=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "COMMA", "SEMI", "WS", 
			"NUMBER", "MarkDeclaration", "MarkInvocation"
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
		"\u0004\u0000\fP\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0003\t:\b\t\u0001\t\u0001\t\u0005\t>\b\t\n\t\f\tA\t\t\u0003"+
		"\tC\b\t\u0001\n\u0004\nF\b\n\u000b\n\f\nG\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000bM\b\u000b\u000b\u000b\f\u000bN\u0000\u0000\f\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000\u0004\u0003\u0000\t\n\f\r "+
		" \u0001\u000019\u0001\u000009\u0003\u0000::AZazT\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000"+
		"\u0003\u001d\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000\u0000\u0007"+
		"&\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b,\u0001\u0000"+
		"\u0000\u0000\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000\u0000"+
		"\u00113\u0001\u0000\u0000\u0000\u0013B\u0001\u0000\u0000\u0000\u0015E"+
		"\u0001\u0000\u0000\u0000\u0017L\u0001\u0000\u0000\u0000\u0019\u001a\u0005"+
		"A\u0000\u0000\u001a\u001b\u0005D\u0000\u0000\u001b\u001c\u0005D\u0000"+
		"\u0000\u001c\u0002\u0001\u0000\u0000\u0000\u001d\u001e\u0005S\u0000\u0000"+
		"\u001e\u001f\u0005U\u0000\u0000\u001f \u0005B\u0000\u0000 \u0004\u0001"+
		"\u0000\u0000\u0000!\"\u0005A\u0000\u0000\"#\u0005D\u0000\u0000#$\u0005"+
		"D\u0000\u0000$%\u0005I\u0000\u0000%\u0006\u0001\u0000\u0000\u0000&\'\u0005"+
		"X\u0000\u0000\'(\u00050\u0000\u0000(\b\u0001\u0000\u0000\u0000)*\u0005"+
		"X\u0000\u0000*+\u00051\u0000\u0000+\n\u0001\u0000\u0000\u0000,-\u0005"+
		"X\u0000\u0000-.\u00052\u0000\u0000.\f\u0001\u0000\u0000\u0000/0\u0005"+
		",\u0000\u00000\u000e\u0001\u0000\u0000\u000012\u0005;\u0000\u00002\u0010"+
		"\u0001\u0000\u0000\u000034\u0007\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000056\u0006\b\u0000\u00006\u0012\u0001\u0000\u0000\u00007C\u00050\u0000"+
		"\u00008:\u0005-\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;?\u0007\u0001\u0000\u0000<>\u0007\u0002"+
		"\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000B7\u0001\u0000\u0000\u0000B9\u0001\u0000\u0000"+
		"\u0000C\u0014\u0001\u0000\u0000\u0000DF\u0007\u0003\u0000\u0000ED\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005:\u0000\u0000"+
		"J\u0016\u0001\u0000\u0000\u0000KM\u0007\u0003\u0000\u0000LK\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000O\u0018\u0001\u0000\u0000\u0000\u0006\u00009?BGN\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}