// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.leguan.parser.antlr;
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
	 * Enter a parse tree produced by {@link LegV8Parser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(LegV8Parser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(LegV8Parser.InvocationContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#shiftInstruction}.
	 * @param ctx the parse tree
	 */
	void enterShiftInstruction(LegV8Parser.ShiftInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#shiftInstruction}.
	 * @param ctx the parse tree
	 */
	void exitShiftInstruction(LegV8Parser.ShiftInstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#wideImmediateInstruction}.
	 * @param ctx the parse tree
	 */
	void enterWideImmediateInstruction(LegV8Parser.WideImmediateInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#wideImmediateInstruction}.
	 * @param ctx the parse tree
	 */
	void exitWideImmediateInstruction(LegV8Parser.WideImmediateInstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#exclusiveInstruction}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveInstruction(LegV8Parser.ExclusiveInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#exclusiveInstruction}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveInstruction(LegV8Parser.ExclusiveInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#condBranchInstruction}.
	 * @param ctx the parse tree
	 */
	void enterCondBranchInstruction(LegV8Parser.CondBranchInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#condBranchInstruction}.
	 * @param ctx the parse tree
	 */
	void exitCondBranchInstruction(LegV8Parser.CondBranchInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#branchInstruction}.
	 * @param ctx the parse tree
	 */
	void enterBranchInstruction(LegV8Parser.BranchInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#branchInstruction}.
	 * @param ctx the parse tree
	 */
	void exitBranchInstruction(LegV8Parser.BranchInstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#shiftParam}.
	 * @param ctx the parse tree
	 */
	void enterShiftParam(LegV8Parser.ShiftParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#shiftParam}.
	 * @param ctx the parse tree
	 */
	void exitShiftParam(LegV8Parser.ShiftParamContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#wideImmediateParam}.
	 * @param ctx the parse tree
	 */
	void enterWideImmediateParam(LegV8Parser.WideImmediateParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#wideImmediateParam}.
	 * @param ctx the parse tree
	 */
	void exitWideImmediateParam(LegV8Parser.WideImmediateParamContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#exclusiveParam}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveParam(LegV8Parser.ExclusiveParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#exclusiveParam}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveParam(LegV8Parser.ExclusiveParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#condBranchParam}.
	 * @param ctx the parse tree
	 */
	void enterCondBranchParam(LegV8Parser.CondBranchParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#condBranchParam}.
	 * @param ctx the parse tree
	 */
	void exitCondBranchParam(LegV8Parser.CondBranchParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#branchParam}.
	 * @param ctx the parse tree
	 */
	void enterBranchParam(LegV8Parser.BranchParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#branchParam}.
	 * @param ctx the parse tree
	 */
	void exitBranchParam(LegV8Parser.BranchParamContext ctx);
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