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

register : 'X0' | 'X1' | 'X2' ;


// ** Tokens **
COMMA : ',' ;
SEMI : ';' ;
WS : [ \t\r\n\f] -> skip;

NUMBER : '0' | '-'? [1-9][0-9]* ;

MarkDeclaration: [:a-zA-Z]+ ':' ;
MarkInvocation: [:a-zA-Z]+ ;