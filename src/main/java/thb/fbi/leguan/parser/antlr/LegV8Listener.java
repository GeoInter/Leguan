// Generated from LegV8.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegment}.
	 * @param ctx the parse tree
	 */
	void enterDataSegment(LegV8Parser.DataSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegment}.
	 * @param ctx the parse tree
	 */
	void exitDataSegment(LegV8Parser.DataSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentEntry}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentEntry(LegV8Parser.DataSegmentEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentEntry}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentEntry(LegV8Parser.DataSegmentEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentPairing}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentPairing(LegV8Parser.DataSegmentPairingContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentPairing}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentPairing(LegV8Parser.DataSegmentPairingContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentType}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentType(LegV8Parser.DataSegmentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentType}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentType(LegV8Parser.DataSegmentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentVariable}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentVariable(LegV8Parser.DataSegmentVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentVariable}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentVariable(LegV8Parser.DataSegmentVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentValue}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentValue(LegV8Parser.DataSegmentValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentValue}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentValue(LegV8Parser.DataSegmentValueContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#jumpLabelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterJumpLabelDeclaration(LegV8Parser.JumpLabelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#jumpLabelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitJumpLabelDeclaration(LegV8Parser.JumpLabelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#jumpLabelReference}.
	 * @param ctx the parse tree
	 */
	void enterJumpLabelReference(LegV8Parser.JumpLabelReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#jumpLabelReference}.
	 * @param ctx the parse tree
	 */
	void exitJumpLabelReference(LegV8Parser.JumpLabelReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentLabelReference}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentLabelReference(LegV8Parser.DataSegmentLabelReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentLabelReference}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentLabelReference(LegV8Parser.DataSegmentLabelReferenceContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#fp_arithmeticInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFp_arithmeticInstruction(LegV8Parser.Fp_arithmeticInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#fp_arithmeticInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFp_arithmeticInstruction(LegV8Parser.Fp_arithmeticInstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#fp_datatransferInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFp_datatransferInstruction(LegV8Parser.Fp_datatransferInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#fp_datatransferInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFp_datatransferInstruction(LegV8Parser.Fp_datatransferInstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#b_cond_Instruction}.
	 * @param ctx the parse tree
	 */
	void enterB_cond_Instruction(LegV8Parser.B_cond_InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#b_cond_Instruction}.
	 * @param ctx the parse tree
	 */
	void exitB_cond_Instruction(LegV8Parser.B_cond_InstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#branchByRegisterInstruction}.
	 * @param ctx the parse tree
	 */
	void enterBranchByRegisterInstruction(LegV8Parser.BranchByRegisterInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#branchByRegisterInstruction}.
	 * @param ctx the parse tree
	 */
	void exitBranchByRegisterInstruction(LegV8Parser.BranchByRegisterInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentInstruction}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentInstruction(LegV8Parser.DataSegmentInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentInstruction}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentInstruction(LegV8Parser.DataSegmentInstructionContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#fp_arithmeticParam}.
	 * @param ctx the parse tree
	 */
	void enterFp_arithmeticParam(LegV8Parser.Fp_arithmeticParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#fp_arithmeticParam}.
	 * @param ctx the parse tree
	 */
	void exitFp_arithmeticParam(LegV8Parser.Fp_arithmeticParamContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#fp_datatransferParam}.
	 * @param ctx the parse tree
	 */
	void enterFp_datatransferParam(LegV8Parser.Fp_datatransferParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#fp_datatransferParam}.
	 * @param ctx the parse tree
	 */
	void exitFp_datatransferParam(LegV8Parser.Fp_datatransferParamContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#b_cond_Param}.
	 * @param ctx the parse tree
	 */
	void enterB_cond_Param(LegV8Parser.B_cond_ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#b_cond_Param}.
	 * @param ctx the parse tree
	 */
	void exitB_cond_Param(LegV8Parser.B_cond_ParamContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#branchByRegisterParam}.
	 * @param ctx the parse tree
	 */
	void enterBranchByRegisterParam(LegV8Parser.BranchByRegisterParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#branchByRegisterParam}.
	 * @param ctx the parse tree
	 */
	void exitBranchByRegisterParam(LegV8Parser.BranchByRegisterParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#dataSegmentParam}.
	 * @param ctx the parse tree
	 */
	void enterDataSegmentParam(LegV8Parser.DataSegmentParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#dataSegmentParam}.
	 * @param ctx the parse tree
	 */
	void exitDataSegmentParam(LegV8Parser.DataSegmentParamContext ctx);
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
	 * Enter a parse tree produced by {@link LegV8Parser#integer_register}.
	 * @param ctx the parse tree
	 */
	void enterInteger_register(LegV8Parser.Integer_registerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#integer_register}.
	 * @param ctx the parse tree
	 */
	void exitInteger_register(LegV8Parser.Integer_registerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#fp_register}.
	 * @param ctx the parse tree
	 */
	void enterFp_register(LegV8Parser.Fp_registerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#fp_register}.
	 * @param ctx the parse tree
	 */
	void exitFp_register(LegV8Parser.Fp_registerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LegV8Parser#ascii}.
	 * @param ctx the parse tree
	 */
	void enterAscii(LegV8Parser.AsciiContext ctx);
	/**
	 * Exit a parse tree produced by {@link LegV8Parser#ascii}.
	 * @param ctx the parse tree
	 */
	void exitAscii(LegV8Parser.AsciiContext ctx);
}