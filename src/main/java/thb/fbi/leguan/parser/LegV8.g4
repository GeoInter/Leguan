grammar LegV8;

@header{package thb.fbi.leguan.parser.antlr;}

// ** Rules **
main : program EOF;

program : dataSegment? line+ ;

// data segment
dataSegment: (dataSegmentEntry)+;

dataSegmentEntry: dataSegmentVariable dataSegmentPairing+;
dataSegmentPairing: dataSegmentType dataSegmentValue;

dataSegmentType: DataSegmentTypes;
dataSegmentVariable: PointerDeclaration;

dataSegmentValue: num | ascii;

// code segment
line : jumpLabelDeclaration? (arithmeticInstruction arithmeticParam | 
                    fp_arithmeticInstruction fp_arithmeticParam |
                    shiftInstruction shiftParam | 
                    immediateInstruction immediateParam | 
                    wideImmediateInstruction wideImmediateParam |
                    datatransferInstruction datatransferParam | 
                    exclusiveInstruction exclusiveParam |
                    condBranchInstruction condBranchParam | 
                    b_cond_Instruction b_cond_Param |
                    branchInstruction branchParam |
                    branchByRegisterInstruction branchByRegisterParam |
                    dataSegmentInstruction dataSegmentParam);

jumpLabelDeclaration: PointerDeclaration ;
jumpLabelReference: PointerReference ;
dataSegmentLabelReference: PointerReference ;

arithmeticInstruction : ArithmeticInstruction;
fp_arithmeticInstruction: FP_ArithemticInstruction;
shiftInstruction: ShiftInstruction;
immediateInstruction : ImmediateInstruction;
wideImmediateInstruction : WideImmediateInstrcution;
datatransferInstruction : DatatransferInstruction;
exclusiveInstruction : ExclusiveInstruction;
condBranchInstruction : CondBranchInstruction;
b_cond_Instruction : B_cond_Instruction;
branchInstruction : BranchInstruction;
branchByRegisterInstruction : BranchByRegisterInstruction;
dataSegmentInstruction: DataSegmentInstruction;

arithmeticParam : integer_register COMMA integer_register COMMA integer_register ;
fp_arithmeticParam: fp_register COMMA fp_register COMMA fp_register ;
shiftParam : integer_register COMMA integer_register COMMA num ; // separated from arithemtic
immediateParam : integer_register COMMA integer_register COMMA num ;
wideImmediateParam : integer_register COMMA num COMMA ShiftInstruction num ;
datatransferParam : integer_register COMMA SQUARE_BRACKET_LEFT integer_register COMMA num SQUARE_BRACKET_RIGHT ;
exclusiveParam : integer_register COMMA integer_register SQUARE_BRACKET_LEFT integer_register SQUARE_BRACKET_RIGHT ;
condBranchParam : integer_register COMMA jumpLabelReference ;
b_cond_Param: jumpLabelReference ;
branchParam : jumpLabelReference ;
branchByRegisterParam : integer_register ;
dataSegmentParam : integer_register COMMA EQUALS_SIGN dataSegmentLabelReference ;

num: NUMBER ;
integer_register: INTEGER_REGISTER ;
fp_register : FP_REGISTER ;
ascii: ASCII_String ;


// ** Tokens **
ArithmeticInstruction: 'ADD' | 'ADDS' | 'AND' | 'ANDS' | 'EOR' | 'ORR' | 'MUL' | 'SDIV' | 'SMULH' | 'SUB' | 'SUBS' | 'UDIV' | 'UMULH';
FP_ArithemticInstruction: 'FADDS' | 'FADDD' | 'FDIVS' | 'FDIVD' | 'FMULS' | 'FMULD' | 'FSUBS' | 'FSUBD';
ShiftInstruction: 'LSL' | 'LSR' ;
ImmediateInstruction : 'ADDI' | 'ADDIS' | 'ANDI' | 'ANDIS' | 'EORI' | 'ORRI' | 'SUBI' | 'SUBIS';
WideImmediateInstrcution : 'MOVK' | 'MOVZ';
DatatransferInstruction : 'LDUR' | 'LDURB' | 'LDURH' | 'LDURSW' | 'LDXR' | 'STUR' | 'STURB' | 'STURH' | 'STURW';
ExclusiveInstruction : 'STXR';
CondBranchInstruction : 'CBNZ' | 'CBZ' ;
B_cond_Instruction: 'B.EQ' | 'B.NE' | 'B.LT' | 'B.LE' | 'B.GT' | 'B.GE' | 'B.MI' | 'B.PL' | 'B.VS' | 'B.VC';
BranchInstruction : 'B' | 'BL' ;
BranchByRegisterInstruction : 'BR';
DataSegmentInstruction : 'LDR' ;


// skipped Tokens
WS : [ \t\r\n\f] -> skip;
COMMENT: '/*' .*? '*/' -> skip; // non-greedy wildcart (ends with trailing */)
LINE_COMMENT: '//' ~[\r\n]* -> skip; // matches everything except tab and newline

// syntax related
COMMA : ',' ;
SEMI : ';' ;
EQUALS_SIGN : '=' ;
SQUARE_BRACKET_LEFT : '[';
SQUARE_BRACKET_RIGHT: ']';

// Token for regsiter and number parameter
INTEGER_REGISTER : SP | FP | LR | XZR | 'X0' | 'X'[1-9][0-9]? ; // manual check required for range
FP_REGISTER : 'SP0' | 'DP0' | 'SP'[1-9][0-9]? | 'DP'[1-9][0-9]? ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* | '0x' [1-9a-fA-F][0-9a-fA-F]*;

SP: 'SP' ;
FP: 'FP' ;
LR: 'LR' ;
XZR: 'XZR' ;

// Pointer Token (data segment variable names and jump label names)
PointerDeclaration: [a-zA-Z][a-zA-Z0-9]* ':' ; 
PointerReference: [a-zA-Z][a-zA-Z0-9]* ; // potential overlap with register names

DataSegmentTypes: '.byte' | '.halfword' | '.word' | '.dword' | '.ascii';
ASCII_String: '"' [a-zA-Z_,.;: ]+ '"';