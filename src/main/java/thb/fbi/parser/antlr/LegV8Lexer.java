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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, COMMA=6, SEMI=7, WS=8, REGISTER=9, 
		NUMBER=10, COMMENT=11, MarkDeclaration=12, MarkInvocation=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "COMMA", "SEMI", "WS", "REGISTER", 
			"NUMBER", "COMMENT", "MarkDeclaration", "MarkInvocation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'SUB'", "'ADDI'", "'STUR'", "'CBNZ'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "COMMA", "SEMI", "WS", "REGISTER", 
			"NUMBER", "COMMENT", "MarkDeclaration", "MarkInvocation"
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
		"\u0004\u0000\rg\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b@\b\b\n\b\f\bC\t\b\u0003\bE\b\b\u0001\t\u0001\t\u0003"+
		"\tI\b\t\u0001\t\u0001\t\u0005\tM\b\t\n\t\f\tP\t\t\u0003\tR\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0004\nX\b\n\u000b\n\f\nY\u0001\u000b\u0004\u000b"+
		"]\b\u000b\u000b\u000b\f\u000b^\u0001\u000b\u0001\u000b\u0001\f\u0004\f"+
		"d\b\f\u000b\f\f\fe\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u0001\u0000\u0005\u0003\u0000\t\n\f\r  \u0001\u00001"+
		"9\u0001\u000009\b\u0000\t\t !##+-09??AZaz\u0002\u0000AZazn\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003\u001f\u0001\u0000"+
		"\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007(\u0001\u0000\u0000\u0000"+
		"\t-\u0001\u0000\u0000\u0000\u000b2\u0001\u0000\u0000\u0000\r4\u0001\u0000"+
		"\u0000\u0000\u000f6\u0001\u0000\u0000\u0000\u0011D\u0001\u0000\u0000\u0000"+
		"\u0013Q\u0001\u0000\u0000\u0000\u0015S\u0001\u0000\u0000\u0000\u0017\\"+
		"\u0001\u0000\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"A\u0000\u0000\u001c\u001d\u0005D\u0000\u0000\u001d\u001e\u0005D\u0000"+
		"\u0000\u001e\u0002\u0001\u0000\u0000\u0000\u001f \u0005S\u0000\u0000 "+
		"!\u0005U\u0000\u0000!\"\u0005B\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000"+
		"#$\u0005A\u0000\u0000$%\u0005D\u0000\u0000%&\u0005D\u0000\u0000&\'\u0005"+
		"I\u0000\u0000\'\u0006\u0001\u0000\u0000\u0000()\u0005S\u0000\u0000)*\u0005"+
		"T\u0000\u0000*+\u0005U\u0000\u0000+,\u0005R\u0000\u0000,\b\u0001\u0000"+
		"\u0000\u0000-.\u0005C\u0000\u0000./\u0005B\u0000\u0000/0\u0005N\u0000"+
		"\u000001\u0005Z\u0000\u00001\n\u0001\u0000\u0000\u000023\u0005,\u0000"+
		"\u00003\f\u0001\u0000\u0000\u000045\u0005;\u0000\u00005\u000e\u0001\u0000"+
		"\u0000\u000067\u0007\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0006"+
		"\u0007\u0000\u00009\u0010\u0001\u0000\u0000\u0000:;\u0005X\u0000\u0000"+
		";E\u00050\u0000\u0000<=\u0005X\u0000\u0000=A\u0007\u0001\u0000\u0000>"+
		"@\u0007\u0002\u0000\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000D:\u0001\u0000\u0000\u0000D<\u0001"+
		"\u0000\u0000\u0000E\u0012\u0001\u0000\u0000\u0000FR\u00050\u0000\u0000"+
		"GI\u0005-\u0000\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JN\u0007\u0001\u0000\u0000KM\u0007\u0002\u0000"+
		"\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000QF\u0001\u0000\u0000\u0000QH\u0001\u0000\u0000\u0000"+
		"R\u0014\u0001\u0000\u0000\u0000ST\u0005/\u0000\u0000TU\u0005/\u0000\u0000"+
		"UW\u0001\u0000\u0000\u0000VX\u0007\u0003\u0000\u0000WV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z\u0016\u0001\u0000\u0000\u0000[]\u0007\u0004\u0000\u0000"+
		"\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0005:\u0000"+
		"\u0000a\u0018\u0001\u0000\u0000\u0000bd\u0007\u0004\u0000\u0000cb\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000f\u001a\u0001\u0000\u0000\u0000\t\u0000ADHN"+
		"QY^e\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}