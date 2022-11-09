// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LegV8Parser}.
 */
public interface LegV8Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(LegV8Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(LegV8Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LegV8Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LegV8Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(LegV8Parser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(LegV8Parser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LegV8Parser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LegV8Parser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#rinstr}.
	 * @param ctx the parse tree
	 */
	void enterRinstr(LegV8Parser.RinstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#rinstr}.
	 * @param ctx the parse tree
	 */
	void exitRinstr(LegV8Parser.RinstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#iinstr}.
	 * @param ctx the parse tree
	 */
	void enterIinstr(LegV8Parser.IinstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#iinstr}.
	 * @param ctx the parse tree
	 */
	void exitIinstr(LegV8Parser.IinstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#rparam}.
	 * @param ctx the parse tree
	 */
	void enterRparam(LegV8Parser.RparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#rparam}.
	 * @param ctx the parse tree
	 */
	void exitRparam(LegV8Parser.RparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#iparam}.
	 * @param ctx the parse tree
	 */
	void enterIparam(LegV8Parser.IparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#iparam}.
	 * @param ctx the parse tree
	 */
	void exitIparam(LegV8Parser.IparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(LegV8Parser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(LegV8Parser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#register}.
	 * @param ctx the parse tree
	 */
	void enterRegister(LegV8Parser.RegisterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#register}.
	 * @param ctx the parse tree
	 */
	void exitRegister(LegV8Parser.RegisterContext ctx);
}