grammar LegV8;

@header{package thb.fbi.parser.antlr;}

// ** Rules ** 
main : program EOF;

program : line+ ;

line : declaration? (rinstr rparam | iinstr iparam);

declaration: MarkDeclaration ;

rinstr : 'ADD' | 'SUB' ;
iinstr : 'ADDI' ;

rparam : register COMMA register COMMA register SEMI;
iparam : register COMMA register COMMA num SEMI;

num: NUMBER ;

register : REGISTER ;


// ** Tokens **
COMMA : ',' ;
SEMI : ';' ;
WS : [ \t\r\n\f] -> skip;

// Token for regsiter naming
REGISTER : 'X0' | 'X'[1-9][0-9]* ; // manual check required for range
NUMBER : '0' | '-'? [1-9][0-9]* ;

MarkDeclaration: [:a-zA-Z]+ ':' ;
MarkInvocation: [:a-zA-Z]+ ;