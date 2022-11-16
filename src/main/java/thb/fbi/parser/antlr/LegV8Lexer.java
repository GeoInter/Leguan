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
		COMMENT=10, MarkDeclaration=11, MarkInvocation=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "COMMA", "SEMI", "WS", "REGISTER", "NUMBER", 
			"COMMENT", "MarkDeclaration", "MarkInvocation"
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
			"COMMENT", "MarkDeclaration", "MarkInvocation"
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
		"\u0004\u0000\f`\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u00079\b\u0007\n\u0007\f\u0007<\t\u0007"+
		"\u0003\u0007>\b\u0007\u0001\b\u0001\b\u0003\bB\b\b\u0001\b\u0001\b\u0005"+
		"\bF\b\b\n\b\f\bI\t\b\u0003\bK\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\tQ\b\t\u000b\t\f\tR\u0001\n\u0004\nV\b\n\u000b\n\f\nW\u0001\n\u0001\n"+
		"\u0001\u000b\u0004\u000b]\b\u000b\u000b\u000b\f\u000b^\u0000\u0000\f\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000\u0005\u0003\u0000"+
		"\t\n\f\r  \u0001\u000019\u0001\u000009\b\u0000\t\t !##+-09??AZaz\u0002"+
		"\u0000AZazg\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0001\u0019\u0001\u0000\u0000\u0000\u0003\u001d\u0001\u0000\u0000\u0000"+
		"\u0005!\u0001\u0000\u0000\u0000\u0007&\u0001\u0000\u0000\u0000\t+\u0001"+
		"\u0000\u0000\u0000\u000b-\u0001\u0000\u0000\u0000\r/\u0001\u0000\u0000"+
		"\u0000\u000f=\u0001\u0000\u0000\u0000\u0011J\u0001\u0000\u0000\u0000\u0013"+
		"L\u0001\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017\\\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0005A\u0000\u0000\u001a\u001b\u0005D\u0000"+
		"\u0000\u001b\u001c\u0005D\u0000\u0000\u001c\u0002\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005S\u0000\u0000\u001e\u001f\u0005U\u0000\u0000\u001f "+
		"\u0005B\u0000\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005A\u0000\u0000"+
		"\"#\u0005D\u0000\u0000#$\u0005D\u0000\u0000$%\u0005I\u0000\u0000%\u0006"+
		"\u0001\u0000\u0000\u0000&\'\u0005S\u0000\u0000\'(\u0005T\u0000\u0000("+
		")\u0005U\u0000\u0000)*\u0005R\u0000\u0000*\b\u0001\u0000\u0000\u0000+"+
		",\u0005,\u0000\u0000,\n\u0001\u0000\u0000\u0000-.\u0005;\u0000\u0000."+
		"\f\u0001\u0000\u0000\u0000/0\u0007\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u000012\u0006\u0006\u0000\u00002\u000e\u0001\u0000\u0000\u000034\u0005"+
		"X\u0000\u00004>\u00050\u0000\u000056\u0005X\u0000\u00006:\u0007\u0001"+
		"\u0000\u000079\u0007\u0002\u0000\u000087\u0001\u0000\u0000\u00009<\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=3\u0001\u0000\u0000"+
		"\u0000=5\u0001\u0000\u0000\u0000>\u0010\u0001\u0000\u0000\u0000?K\u0005"+
		"0\u0000\u0000@B\u0005-\u0000\u0000A@\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CG\u0007\u0001\u0000\u0000DF\u0007"+
		"\u0002\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000J?\u0001\u0000\u0000\u0000JA\u0001\u0000"+
		"\u0000\u0000K\u0012\u0001\u0000\u0000\u0000LM\u0005/\u0000\u0000MN\u0005"+
		"/\u0000\u0000NP\u0001\u0000\u0000\u0000OQ\u0007\u0003\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000S\u0014\u0001\u0000\u0000\u0000TV\u0007\u0004"+
		"\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0005:\u0000\u0000Z\u0016\u0001\u0000\u0000\u0000[]\u0007\u0004\u0000"+
		"\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0018\u0001\u0000\u0000\u0000"+
		"\t\u0000:=AGJRW^\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}