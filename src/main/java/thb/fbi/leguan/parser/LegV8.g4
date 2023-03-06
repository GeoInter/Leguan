grammar LegV8;

@header{package thb.fbi.leguan.parser.antlr;}

// ** Rules ** 
main : program EOF;

program : line+ ;

line : declaration? (arithmeticInstruction arithmeticParam | 
                    shiftInstruction shiftParam | 
                    immediateInstruction immediateParam | 
                    datatransferInstruction datatransferParam | 
                    exclusiveInstruction exclusiveParam |
                    condBranchInstruction condBranchParam | 
                    branchInstruction branchParam);

declaration: JumpDeclaration ;
invocation: JumpInvocation ;

arithmeticInstruction : ArithmeticInstruction;
shiftInstruction: ShiftInstruction;
immediateInstruction : ImmediateInstruction;
datatransferInstruction : DatatransferInstruction;
exclusiveInstruction : ExclusiveInstruction;
condBranchInstruction : CondBranchInstruction;
branchInstruction : BranchInstruction;

arithmeticParam : register COMMA register COMMA register SEMI ;
shiftParam : register COMMA register COMMA num SEMI ; // separated from arithemtic
immediateParam : register COMMA register COMMA num SEMI ;
datatransferParam : register COMMA SQUARE_BRACKET_LEFT register COMMA num SQUARE_BRACKET_RIGHT SEMI ;
exclusiveParam : register COMMA register SQUARE_BRACKET_LEFT register SQUARE_BRACKET_RIGHT SEMI;
condBranchParam : register COMMA invocation SEMI;
branchParam : invocation SEMI;

num: NUMBER ;
register : REGISTER ;


// ** Tokens **
ArithmeticInstruction: 'ADD' | 'ADDS' | 'AND' | 'ANDS' | 'EOR' | 'EORI' | 'ORR' | 'SUB' | 'SUBS';
ShiftInstruction: 'LSL' | 'LSR' ;
ImmediateInstruction : 'ADDI' | 'ADDIS' | 'ANDI' | 'ANDIS' | 'ORRI' | 'SUBI' | 'SUBIS';
DatatransferInstruction : 'LDUR' | 'LDURB' | 'LDURH' | 'LDURSW' | 'LDXR' | 'STUR' | 'STURB' | 'STURH' | 'STURW';
ExclusiveInstruction : 'STXR';
CondBranchInstruction : 'CBNZ' | 'CBZ' ;
BranchInstruction : 'B' | 'B.EQ' | 'B.NE' | 'B.LT' | 'B.LE' | 'B.GT' | 'B.GE' | 'B.MI' | 'B.PL' | 'B.VS' | 'B.VC';


// skipped Tokens
WS : [ \t\r\n\f] -> skip;
COMMENT: '/*' .*? '*/' -> skip; // non-greedy wildcart (ends with trailing */)
LINE_COMMENT: '//' ~[\r\n]* -> skip; // matches everything except tab and newline

// syntax relared
COMMA : ',' ;
SEMI : ';' ;
SQUARE_BRACKET_LEFT : '[';
SQUARE_BRACKET_RIGHT: ']';

// Token for regsiter and number parameter
REGISTER : SP | FP | LR | XZR | 'X0' | 'X'[1-9][0-9]* ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* ;

SP: 'SP' ;
FP: 'FP' ;
LR: 'LR' ;
XZR: 'XZR' ;

// jump mark usage
JumpDeclaration: [a-zA-Z]+ ':' ;
JumpInvocation: [a-zA-Z]+ ;