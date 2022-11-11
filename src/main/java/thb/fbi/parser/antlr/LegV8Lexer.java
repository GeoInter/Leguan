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
		T__0=1, T__1=2, T__2=3, T__3=4, COMMA=5, SEMI=6, WS=7, REGISTER=8, NUMBER=9, 
		MarkDeclaration=10, MarkInvocation=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "COMMA", "SEMI", "WS", "REGISTER", "NUMBER", 
			"MarkDeclaration", "MarkInvocation"
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
		"\u0004\u0000\u000bV\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u00077\b\u0007\n\u0007\f\u0007:\t\u0007\u0003\u0007<\b\u0007\u0001"+
		"\b\u0001\b\u0003\b@\b\b\u0001\b\u0001\b\u0005\bD\b\b\n\b\f\bG\t\b\u0003"+
		"\bI\b\b\u0001\t\u0004\tL\b\t\u000b\t\f\tM\u0001\t\u0001\t\u0001\n\u0004"+
		"\nS\b\n\u000b\n\f\nT\u0000\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0001\u0000\u0004\u0003\u0000\t\n\f\r  \u0001\u000019\u0001\u0000"+
		"09\u0003\u0000::AZaz\\\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000"+
		"\u0000\u0000\u0003\u001b\u0001\u0000\u0000\u0000\u0005\u001f\u0001\u0000"+
		"\u0000\u0000\u0007$\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000"+
		"\u000b+\u0001\u0000\u0000\u0000\r-\u0001\u0000\u0000\u0000\u000f;\u0001"+
		"\u0000\u0000\u0000\u0011H\u0001\u0000\u0000\u0000\u0013K\u0001\u0000\u0000"+
		"\u0000\u0015R\u0001\u0000\u0000\u0000\u0017\u0018\u0005A\u0000\u0000\u0018"+
		"\u0019\u0005D\u0000\u0000\u0019\u001a\u0005D\u0000\u0000\u001a\u0002\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0005S\u0000\u0000\u001c\u001d\u0005U\u0000"+
		"\u0000\u001d\u001e\u0005B\u0000\u0000\u001e\u0004\u0001\u0000\u0000\u0000"+
		"\u001f \u0005A\u0000\u0000 !\u0005D\u0000\u0000!\"\u0005D\u0000\u0000"+
		"\"#\u0005I\u0000\u0000#\u0006\u0001\u0000\u0000\u0000$%\u0005S\u0000\u0000"+
		"%&\u0005T\u0000\u0000&\'\u0005U\u0000\u0000\'(\u0005R\u0000\u0000(\b\u0001"+
		"\u0000\u0000\u0000)*\u0005,\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005"+
		";\u0000\u0000,\f\u0001\u0000\u0000\u0000-.\u0007\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/0\u0006\u0006\u0000\u00000\u000e\u0001\u0000\u0000"+
		"\u000012\u0005X\u0000\u00002<\u00050\u0000\u000034\u0005X\u0000\u0000"+
		"48\u0007\u0001\u0000\u000057\u0007\u0002\u0000\u000065\u0001\u0000\u0000"+
		"\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000"+
		"\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;1\u0001"+
		"\u0000\u0000\u0000;3\u0001\u0000\u0000\u0000<\u0010\u0001\u0000\u0000"+
		"\u0000=I\u00050\u0000\u0000>@\u0005-\u0000\u0000?>\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AE\u0007\u0001\u0000"+
		"\u0000BD\u0007\u0002\u0000\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FI\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000H=\u0001\u0000\u0000\u0000"+
		"H?\u0001\u0000\u0000\u0000I\u0012\u0001\u0000\u0000\u0000JL\u0007\u0003"+
		"\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0005:\u0000\u0000P\u0014\u0001\u0000\u0000\u0000QS\u0007\u0003\u0000"+
		"\u0000RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000U\u0016\u0001\u0000\u0000\u0000"+
		"\b\u00008;?EHMT\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}