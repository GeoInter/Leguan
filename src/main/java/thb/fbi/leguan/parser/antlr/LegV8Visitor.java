// Generated from java-escape by ANTLR 4.11.1
package thb.fbi.leguan.parser.antlr;
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
	 * Visit a parse tree produced by {@link LegV8Parser#dataSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSegment(LegV8Parser.DataSegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#dataSegmentEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSegmentEntry(LegV8Parser.DataSegmentEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#dataSegmentPairing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSegmentPairing(LegV8Parser.DataSegmentPairingContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#dataSegmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSegmentType(LegV8Parser.DataSegmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#dataSegmentVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSegmentVariable(LegV8Parser.DataSegmentVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#dataSegmentValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataSegmentValue(LegV8Parser.DataSegmentValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(LegV8Parser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#jumpLabelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpLabelDeclaration(LegV8Parser.JumpLabelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#jumpLabelReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpLabelReference(LegV8Parser.JumpLabelReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#arithmeticInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticInstruction(LegV8Parser.ArithmeticInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#shiftInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftInstruction(LegV8Parser.ShiftInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#immediateInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImmediateInstruction(LegV8Parser.ImmediateInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#wideImmediateInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWideImmediateInstruction(LegV8Parser.WideImmediateInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#datatransferInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatransferInstruction(LegV8Parser.DatatransferInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#exclusiveInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveInstruction(LegV8Parser.ExclusiveInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#condBranchInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBranchInstruction(LegV8Parser.CondBranchInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#branchInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchInstruction(LegV8Parser.BranchInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#branchByRegisterInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchByRegisterInstruction(LegV8Parser.BranchByRegisterInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#arithmeticParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticParam(LegV8Parser.ArithmeticParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#shiftParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftParam(LegV8Parser.ShiftParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#immediateParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImmediateParam(LegV8Parser.ImmediateParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#wideImmediateParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWideImmediateParam(LegV8Parser.WideImmediateParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#datatransferParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatransferParam(LegV8Parser.DatatransferParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#exclusiveParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveParam(LegV8Parser.ExclusiveParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#condBranchParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBranchParam(LegV8Parser.CondBranchParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#branchParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchParam(LegV8Parser.BranchParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#branchByRegisterParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchByRegisterParam(LegV8Parser.BranchByRegisterParamContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link LegV8Parser#ascii}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAscii(LegV8Parser.AsciiContext ctx);
}