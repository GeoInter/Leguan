grammar LegV8;

@header{package thb.fbi.parser.antlr;}

// ** Rules ** 
main : program EOF;

program : line+ ;

line : declaration? (arithmeticInstruction arithmeticParam | immediateInstruction immediateParam | datatransferInstruction datatransferParam) COMMENT?;

declaration: MarkDeclaration ;

arithmeticInstruction : 'ADD' | 'SUB' ;
immediateInstruction : 'ADDI' ;
datatransferInstruction : 'STUR' ;

arithmeticParam : register COMMA register COMMA register SEMI ;
immediateParam : register COMMA register COMMA num SEMI ;
datatransferParam : register COMMA register COMMA num SEMI ;

num: NUMBER ;

register : REGISTER ;


// ** Tokens **
COMMA : ',' ;
SEMI : ';' ;
WS : [ \t\r\n\f] -> skip;

// Token for regsiter naming
REGISTER : 'X0' | 'X'[1-9][0-9]* ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* ;
COMMENT: '//' [\t a-zA-Z0-9,?!#+-]+ ;

MarkDeclaration: [a-zA-Z]+ ':' ;
MarkInvocation: [a-zA-Z]+ ;