grammar LegV8;

@header{package thb.fbi.parser.antlr;}

// ** Rules ** 
main : program EOF;

program : line+ ;

line : declaration? (arithmeticInstruction arithmeticParam | immediateInstruction immediateParam | datatransferInstruction datatransferParam | condBranchInstruction condBranchParam);

declaration: MarkDeclaration ;
invocation: MarkInvocation ;

arithmeticInstruction : 'ADD' | 'SUB' ;
immediateInstruction : 'ADDI' ;
datatransferInstruction : 'STUR' ;
condBranchInstruction : 'CBNZ' ;

arithmeticParam : register COMMA register COMMA register SEMI ;
immediateParam : register COMMA register COMMA num SEMI ;
datatransferParam : register COMMA register COMMA num SEMI ;
condBranchParam : register COMMA invocation SEMI;

num: NUMBER ;
register : REGISTER ;


// ** Tokens **

// skip
WS : [ \t\r\n\f] -> skip;
COMMENT: '/*' .*? '*/' -> skip ;
LINE_COMMENT: '//' ~[\r\n]* -> skip ;

// syntax relared
COMMA : ',' ;
SEMI : ';' ;

// Token for regsiter and number parameter
REGISTER : 'X0' | 'X'[1-9][0-9]* ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* ;

// jump mark usage
MarkDeclaration: [a-zA-Z]+ ':' ;
MarkInvocation: [a-zA-Z]+ ;