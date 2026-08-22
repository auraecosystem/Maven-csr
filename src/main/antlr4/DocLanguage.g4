// src/main/antlr4/DocLanguage.g4
grammar DocLanguage;

doc       : block* EOF ;
block     : header | paragraph ;
header    : H1_MARKER TEXT NEWLINE ;
paragraph : TEXT NEWLINE ;

H1_MARKER : '# ' ;
NEWLINE   : '\r'? '\n' ;
TEXT      : ~[\r\n#]+ ;
