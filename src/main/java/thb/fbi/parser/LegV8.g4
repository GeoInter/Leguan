grammar LegV8;

@header{package thb.fbi.parser.antlr;}

// ** Rules ** 
main : program EOF;

program : line+ ;

line : declaration? (arithmeticInstruction arithmeticParam | shiftInstruction shiftParam | immediateInstruction immediateParam | datatransferInstruction datatransferParam | condBranchInstruction condBranchParam | branchInstruction branchParam);

declaration: JumpDeclaration ;
invocation: JumpInvocation ;

arithmeticInstruction : 'ADD' | 'ADDS' | 'AND' | 'ANDS' | 'EOR' | 'EORI' | 'ORR' | 'SUB' | 'SUBS';
shiftInstruction: 'LSL' | 'LSR' ;
immediateInstruction : 'ADDI' | 'ADDIS' | 'ANDI' | 'ANDIS' | 'ORRI' | 'SUBI' | 'SUBIS';
datatransferInstruction : 'LDUR' | 'LDURB' | 'LDURH' | 'LDURSW' | 'STUR' | 'STURB' | 'STURH' | 'STURW';
condBranchInstruction : 'CBNZ' ;
branchInstruction : 'B';

arithmeticParam : register COMMA register COMMA register SEMI ;
shiftParam : register COMMA register COMMA num SEMI ; // seperated from arithemtic
immediateParam : register COMMA register COMMA num SEMI ;
datatransferParam : register COMMA register COMMA num SEMI ;
condBranchParam : register COMMA invocation SEMI;
branchParam : invocation SEMI;

num: NUMBER ;
register : REGISTER ;


// ** Tokens **

// skip
WS : [ \t\r\n\f] -> skip;
COMMENT: '/*' .*? '*/' -> skip ; // non-greedy wildcart (ends with trailing */)
LINE_COMMENT: '//' ~[\r\n]* -> skip ; // matches everything except tab and newline

// syntax relared
COMMA : ',' ;
SEMI : ';' ;

// Token for regsiter and number parameter
REGISTER : 'X0' | 'X'[1-9][0-9]* ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* ;

// jump mark usage
JumpDeclaration: [a-zA-Z]+ ':' ;
JumpInvocation: [a-zA-Z]+ ;