package io.hostilerobot.yapping.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import groovyjarjarantlr.Token;import io.hostilerobot.yapping.parser.YappingTypes;import io.hostilerobot.yapping.parser.token.YappingElementType;import io.hostilerobot.yapping.parser.token.YappingTokenType;

%%

%class YappingLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
//%cup
%char
%line
%column
%{
// we want to handle java paths !com.user.Plugin
// different from file paths @file/user/pugin.yap
int CONTEXT = -1;
private void setContext(int state) {
    CONTEXT = state;
}
private int getContext() {
    return CONTEXT;
}
private int clearContext() {
    int prev = CONTEXT;
    CONTEXT = -1;
    yybegin(prev);
    return prev;
}
%}

%eof{  return;
%eof}
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n\t\f\ \#]
WhiteSpace     = {LineTerminator} | [ \t\f]
END_OF_LINE_COMMENT="#"[^\r\n]*
FCHARACTER     = {InputCharacter} && [^\/\"\`\!]
//JCHARACTER     = {InputCharacter} && [^\.\"\`\!]
PLUS=\+
MINUS=\-
SCOPE=\.
NATURAL=[0-9]+
DECIMAL=[0-9]+\.[0-9]+
LIST_START=\(
LIST_END=\)
JPATH_START=\!
JPATH_SEP=\.
FPATH_START=\@
FPATH_SEP=\/
LITERAL_QUOTE=\"
REGEX_QUOTE=\`
FNAME=!{WhiteSpace}
%state LITERAL
%state REGEX
%state REGEX_CLASS
%state JPATH, FPATH
%%

<YYINITIAL> {
    {END_OF_LINE_COMMENT}                           { }
    {WhiteSpace}                                    { }
    {PLUS}                                          { yybegin(YYINITIAL); return YappingTypes.PLUS; }
    {MINUS}                                         { yybegin(YYINITIAL); return YappingTypes.MINUS; }
    {NATURAL}                                       { yybegin(YYINITIAL); return YappingTypes.NATURAL; }
    {DECIMAL}                                       { yybegin(YYINITIAL); return YappingTypes.DECIMAL; }
    {LIST_START}                                    { yybegin(YYINITIAL); return YappingTypes.LIST_START; }
    {LIST_END}                                      { yybegin(YYINITIAL); return YappingTypes.LIST_END; }
    {LITERAL_QUOTE}                                 { yybegin(LITERAL); }
    {JPATH_START}                                   { setContext(JPATH); yybegin(JPATH); return YappingTypes.JPATH_START; }
    {FPATH_START}                                   { setContext(FPATH); yybegin(FPATH); return YappingTypes.FPATH_START; }
    {REGEX_QUOTE}                                   { yybegin(REGEX); }
}
<FPATH> {
    {REGEX_QUOTE}                                   {yybegin(REGEX);}
    {LITERAL_QUOTE}                                 {yybegin(LITERAL);}
    {FPATH_SEP}                                     {yybegin(0); return YappingTypes.SLASH; }
    {FCHARACTER}+                                   {return YappingTypes.FNAME;} // 
}
<LITERAL> {
    // escaped quote in string
    \\\"                                            { yybegin(LITERAL); }
    // end of quote
    {LITERAL_QUOTE}                                 { yybegin(YYINITIAL); return YappingTypes.LITERAL; }
}
<REGEX> {
    // escaped
    \\\`                                            { yybegin(REGEX); }
    \\\[                                            { yybegin(REGEX); }
    \[                                              { yybegin(REGEX_CLASS); }
    // end of regex, transition back to INITIAL
    {REGEX_QUOTE}                                   { yybegin(YYINITIAL); return YappingTypes.REGEX; }
}
<REGEX_CLASS> {
    // escaped end of char class
    \\\]                                            { yybegin(REGEX_CLASS); }
    // end of char class, transition back to REGEX
    \]                                              { yybegin(REGEX); }
}


