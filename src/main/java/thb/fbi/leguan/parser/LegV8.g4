grammar LegV8;

@header{package thb.fbi.leguan.parser.antlr;}

// ** Rules ** 
main : program EOF;

program : line+ ;

line : declaration? (arithmeticInstruction arithmeticParam | 
                    shiftInstruction shiftParam | 
                    immediateInstruction immediateParam | 
                    wideImmediateInstruction wideImmediateParam |
                    datatransferInstruction datatransferParam | 
                    exclusiveInstruction exclusiveParam |
                    condBranchInstruction condBranchParam | 
                    branchInstruction branchParam |
                    branchByRegisterInstruction branchByRegisterParam);

declaration: JumpDeclaration ;
invocation: JumpInvocation ;

arithmeticInstruction : ArithmeticInstruction;
shiftInstruction: ShiftInstruction;
immediateInstruction : ImmediateInstruction;
wideImmediateInstruction : WideImmediateInstrcution;
datatransferInstruction : DatatransferInstruction;
exclusiveInstruction : ExclusiveInstruction;
condBranchInstruction : CondBranchInstruction;
branchInstruction : BranchInstruction;
branchByRegisterInstruction : BranchByRegisterInstruction;

arithmeticParam : register COMMA register COMMA register ;
shiftParam : register COMMA register COMMA num ; // separated from arithemtic
immediateParam : register COMMA register COMMA num ;
wideImmediateParam : register COMMA num COMMA ShiftInstruction num ;
datatransferParam : register COMMA SQUARE_BRACKET_LEFT register COMMA num SQUARE_BRACKET_RIGHT ;
exclusiveParam : register COMMA register SQUARE_BRACKET_LEFT register SQUARE_BRACKET_RIGHT ;
condBranchParam : register COMMA invocation ;
branchParam : invocation ;
branchByRegisterParam : register ;

num: NUMBER ;
register : REGISTER ;


// ** Tokens **
ArithmeticInstruction: 'ADD' | 'ADDS' | 'AND' | 'ANDS' | 'EOR' | 'ORR' | 'SUB' | 'SUBS';
ShiftInstruction: 'LSL' | 'LSR' ;
ImmediateInstruction : 'ADDI' | 'ADDIS' | 'ANDI' | 'ANDIS' | 'EORI' | 'ORRI' | 'SUBI' | 'SUBIS';
WideImmediateInstrcution : 'MOVK' | 'MOVZ';
DatatransferInstruction : 'LDUR' | 'LDURB' | 'LDURH' | 'LDURSW' | 'LDXR' | 'STUR' | 'STURB' | 'STURH' | 'STURW';
ExclusiveInstruction : 'STXR';
CondBranchInstruction : 'CBNZ' | 'CBZ' ;
BranchInstruction : 'B' | 'BL' | 'B.EQ' | 'B.NE' | 'B.LT' | 'B.LE' | 'B.GT' | 'B.GE' | 'B.MI' | 'B.PL' | 'B.VS' | 'B.VC';
BranchByRegisterInstruction : 'BR';


// skipped Tokens
WS : [ \t\r\n\f] -> skip;
COMMENT: '/*' .*? '*/' -> skip; // non-greedy wildcart (ends with trailing */)
LINE_COMMENT: '//' ~[\r\n]* -> skip; // matches everything except tab and newline

// syntax related
COMMA : ',' ;
SEMI : ';' ;
SQUARE_BRACKET_LEFT : '[';
SQUARE_BRACKET_RIGHT: ']';

// Token for regsiter and number parameter
REGISTER : SP | FP | LR | XZR | 'X0' | 'X'[1-9][0-9]* ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* | '0x' [1-9a-fA-F][0-9a-fA-F]*;

SP: 'SP' ;
FP: 'FP' ;
LR: 'LR' ;
XZR: 'XZR' ;

// jump mark usage
JumpDeclaration: [a-zA-Z]+ ':' ;
JumpInvocation: [a-zA-Z]+ ;