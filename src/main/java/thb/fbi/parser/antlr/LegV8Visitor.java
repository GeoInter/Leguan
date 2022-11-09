// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LegV8Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LegV8Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(LegV8Parser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LegV8Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(LegV8Parser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LegV8Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#rinstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRinstr(LegV8Parser.RinstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#iinstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIinstr(LegV8Parser.IinstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#rparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRparam(LegV8Parser.RparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#iparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIparam(LegV8Parser.IparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(LegV8Parser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#register}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegister(LegV8Parser.RegisterContext ctx);
}