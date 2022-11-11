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
		T__0=1, T__1=2, T__2=3, COMMA=4, SEMI=5, WS=6, REGISTER=7, NUMBER=8, MarkDeclaration=9, 
		MarkInvocation=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "COMMA", "SEMI", "WS", "REGISTER", "NUMBER", 
			"MarkDeclaration", "MarkInvocation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'SUB'", "'ADDI'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "COMMA", "SEMI", "WS", "REGISTER", "NUMBER", 
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
		"\u0004\u0000\nO\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u00060\b\u0006\n\u0006\f\u00063\t\u0006\u0003\u00065\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0003\u00079\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"=\b\u0007\n\u0007\f\u0007@\t\u0007\u0003\u0007B\b\u0007\u0001\b\u0004"+
		"\bE\b\b\u000b\b\f\bF\u0001\b\u0001\b\u0001\t\u0004\tL\b\t\u000b\t\f\t"+
		"M\u0000\u0000\n\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0001\u0000\u0004\u0003\u0000"+
		"\t\n\f\r  \u0001\u000019\u0001\u000009\u0003\u0000::AZazU\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000"+
		"\u0000\u0000\u0003\u0019\u0001\u0000\u0000\u0000\u0005\u001d\u0001\u0000"+
		"\u0000\u0000\u0007\"\u0001\u0000\u0000\u0000\t$\u0001\u0000\u0000\u0000"+
		"\u000b&\u0001\u0000\u0000\u0000\r4\u0001\u0000\u0000\u0000\u000fA\u0001"+
		"\u0000\u0000\u0000\u0011D\u0001\u0000\u0000\u0000\u0013K\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0005A\u0000\u0000\u0016\u0017\u0005D\u0000\u0000\u0017"+
		"\u0018\u0005D\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0005S\u0000\u0000\u001a\u001b\u0005U\u0000\u0000\u001b\u001c\u0005B"+
		"\u0000\u0000\u001c\u0004\u0001\u0000\u0000\u0000\u001d\u001e\u0005A\u0000"+
		"\u0000\u001e\u001f\u0005D\u0000\u0000\u001f \u0005D\u0000\u0000 !\u0005"+
		"I\u0000\u0000!\u0006\u0001\u0000\u0000\u0000\"#\u0005,\u0000\u0000#\b"+
		"\u0001\u0000\u0000\u0000$%\u0005;\u0000\u0000%\n\u0001\u0000\u0000\u0000"+
		"&\'\u0007\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0006\u0005\u0000"+
		"\u0000)\f\u0001\u0000\u0000\u0000*+\u0005X\u0000\u0000+5\u00050\u0000"+
		"\u0000,-\u0005X\u0000\u0000-1\u0007\u0001\u0000\u0000.0\u0007\u0002\u0000"+
		"\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u00004*\u0001\u0000\u0000\u00004,\u0001\u0000\u0000\u0000"+
		"5\u000e\u0001\u0000\u0000\u00006B\u00050\u0000\u000079\u0005-\u0000\u0000"+
		"87\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:>\u0007\u0001\u0000\u0000;=\u0007\u0002\u0000\u0000<;\u0001\u0000"+
		"\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"A6\u0001\u0000\u0000\u0000A8\u0001\u0000\u0000\u0000B\u0010\u0001\u0000"+
		"\u0000\u0000CE\u0007\u0003\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HI\u0005:\u0000\u0000I\u0012\u0001\u0000\u0000"+
		"\u0000JL\u0007\u0003\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0014"+
		"\u0001\u0000\u0000\u0000\b\u0000148>AFM\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}