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
	 * Enter a parse tree produced by {@link LegV8Parser#arithmeticInstruction}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticInstruction(LegV8Parser.ArithmeticInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#arithmeticInstruction}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticInstruction(LegV8Parser.ArithmeticInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 */
	void enterImmediateInstruction(LegV8Parser.ImmediateInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 */
	void exitImmediateInstruction(LegV8Parser.ImmediateInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#datatransferInstruction}.
	 * @param ctx the parse tree
	 */
	void enterDatatransferInstruction(LegV8Parser.DatatransferInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#datatransferInstruction}.
	 * @param ctx the parse tree
	 */
	void exitDatatransferInstruction(LegV8Parser.DatatransferInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#arithmeticParam}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticParam(LegV8Parser.ArithmeticParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#arithmeticParam}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticParam(LegV8Parser.ArithmeticParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#immediateParam}.
	 * @param ctx the parse tree
	 */
	void enterImmediateParam(LegV8Parser.ImmediateParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#immediateParam}.
	 * @param ctx the parse tree
	 */
	void exitImmediateParam(LegV8Parser.ImmediateParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#datatransferParam}.
	 * @param ctx the parse tree
	 */
	void enterDatatransferParam(LegV8Parser.DatatransferParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#datatransferParam}.
	 * @param ctx the parse tree
	 */
	void exitDatatransferParam(LegV8Parser.DatatransferParamContext ctx);
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