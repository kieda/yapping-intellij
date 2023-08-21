package io.hostilerobot.yapping.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import io.hostilerobot.yapping.parser.YappingTypes;import java.util.ArrayDeque;import java.util.Deque;import com.intellij.lexer.FlexLexer;

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
// different from YAPPING paths { ... }.my-value.3.length
Deque<Integer> CONTEXT = new ArrayDeque<>();
final int GLOBAL = YYINITIAL;
private void pushContext(int state) {
    CONTEXT.push(state);
}
private int getContext() {
    if(CONTEXT.isEmpty())
        return GLOBAL;
    return CONTEXT.peek();
}
private void popContext() {
    if(!CONTEXT.isEmpty())
        CONTEXT.pop();
}
%}

%eof{  return;
%eof}
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n\t\f\ \#]
WHITESPACE     = {LineTerminator} | [ \t\f]
COMMENT        = "#"[^\r\n]*{LineTerminator}?
FNAMECHAR      = [^\/\"\`\!\@\r\n\t\f\ \#\[\]\(\)\{\}\<\>]
FNAME          = {FNAMECHAR}+
YFIRSTCHAR     = [^\/\"\'\`\!\@\r\n\t\f\ \#\[\]\(\)\{\}\<\>\:\&\-\+\;\|\=\,\~\*\^\%\\\?\%\.[0-9]]
YBODYCHAR      = [^\/\"\'\`\!\@\r\n\t\f\ \#\[\]\(\)\{\}\<\>\:\&\-\+\;\|\=\,\~\*\^\%\\\?\%\.]
YBODY          = {YBODYCHAR}+    // asdf10
YNAME          = {YFIRSTCHAR}({YBODYCHAR}*) // sadf-asdf asdf10
PLUS=\+
MINUS=\-
DOT=\.
NATURAL=[0-9]+
AND=\&
LIST_START=\[
LIST_END=\]
PRECEDENCE_START=\(
PRECEDENCE_END=\)
MAP_START=\{
MAP_END=\}
PAIR_SEP=\=
LIST_SEP=\,
JPATH_START=\!
FPATH_START=\@
SLASH=\/
PROPERTY_SEP=\:
LITERAL_QUOTE=\"
REGEX_QUOTE=\`
TRANSITION_SEP_L="<-"
TRANSITION_SEP_R="->"
%state LITERAL
%state REGEX
%state REGEX_CLASS
%state BEFORE_SLASH, AFTER_SLASH, PENDING_SLASH
%state BEFORE_JSCOPE, AFTER_JSCOPE, PENDING_JSCOPE
%state BEFORE_YSCOPE, AFTER_YSCOPE, PENDING_YSCOPE

%%

// we have found a new identifier.

// DEFAULT 1: new identifier stops previous path
<YYINITIAL, PENDING_SLASH, PENDING_JSCOPE, PENDING_YSCOPE> {
    {LITERAL_QUOTE}                                 {
                                                        // we are encountering a new literal
                                                        popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(LITERAL);
                                                    }
    {REGEX_QUOTE}                                   {
                                                        popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(REGEX);
                                                    }
    {YNAME}                                         {
                                                        popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(AFTER_YSCOPE);
                                                        return YappingTypes.YNAME;
                                                    }
    {NATURAL}                                       {
                                                        return YappingTypes.NATURAL;
                                                    }
    {AND}                                           {
                                                        return YappingTypes.AND;
                                                    }
    {PLUS}                                          {
                                                        return YappingTypes.PLUS;
                                                    }
    {MINUS}                                         {
                                                        return YappingTypes.MINUS;
                                                    }
    {MAP_START}                                     {
                                                        return YappingTypes.MAP_START;
                                                    }
    {MAP_END}                                       {
                                                        return YappingTypes.MAP_END;
                                                    }
    {PAIR_SEP}                                      {
                                                        return YappingTypes.PAIR_SEP;
                                                    }
    {LIST_START}                                    {
                                                        return YappingTypes.LIST_START;
                                                    }
    {LIST_END}                                      {
                                                        return YappingTypes.LIST_END;
                                                    }
    {LIST_SEP}                                      {
                                                        return YappingTypes.LIST_SEP;
                                                    }
    {PRECEDENCE_START}                              {
                                                        return YappingTypes.PRECEDENCE_START;
                                                    }
    {PRECEDENCE_END}                                {
                                                        return YappingTypes.PRECEDENCE_END;
                                                    }
    {PLUS}                                          {
                                                        return YappingTypes.PLUS;
                                                    }
    {MINUS}                                         {
                                                        return YappingTypes.MINUS;
                                                    }
    {NATURAL}                                       {
                                                        popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(AFTER_YSCOPE);
                                                        return YappingTypes.NATURAL;
                                                    }
    // new identifier.
    // Also add cases for AFTER_* and BEFORE_*
}

// DEFAULT 2: new item detected stops previous path
<YYINITIAL, PENDING_SLASH, BEFORE_SLASH, PENDING_JSCOPE, BEFORE_JSCOPE, BEFORE_YSCOPE, PENDING_YSCOPE> {
    {FPATH_START}                                   {
                                                        /* fall back to BEFORE_SLASH when we're done parsing regex or literal */
                                                        pushContext(BEFORE_SLASH);
                                                        yybegin(AFTER_SLASH);
                                                        return YappingTypes.FPATH_START;
                                                    }
    {JPATH_START}                                   {
                                                        pushContext(BEFORE_JSCOPE);
                                                        yybegin(AFTER_JSCOPE);
                                                        return YappingTypes.JPATH_START;
                                                    }
}

// DEFAULT 3: whitespace and comments at top-level
<YYINITIAL> {
    {COMMENT}                                       { return YappingTypes.COMMENT; }
    {WHITESPACE}                                    { return TokenType.WHITE_SPACE; }
    /*{PLUS}                                          { yybegin(YYINITIAL); return YappingTypes.PLUS; }
    {MINUS}                                         { yybegin(YYINITIAL); return YappingTypes.MINUS; }
    {NATURAL}                                       { yybegin(YYINITIAL); return YappingTypes.NATURAL; }
    {DECIMAL}                                       { yybegin(YYINITIAL); return YappingTypes.DECIMAL; }
    {LIST_START}                                    { yybegin(YYINITIAL); return YappingTypes.LIST_START; }
    {LIST_END}                                      { yybegin(YYINITIAL); return YappingTypes.LIST_END; }*/
    //{JPATH_START}                                   { setContext(JPATH); yybegin(JPATH); return YappingTypes.JPATH_START; }
}
<BEFORE_SLASH, BEFORE_JSCOPE, BEFORE_YSCOPE> {
    // parsing these will fallback to BEFORE_(SLASH|JSCOPE)
    {REGEX_QUOTE}                                   {yybegin(REGEX);}
    {LITERAL_QUOTE}                                 {yybegin(LITERAL);}
}
<BEFORE_SLASH> {
    // encounter a file name, state doesn't change.
    {FNAME}                                         {return YappingTypes.FNAME;}

    // encountered a slash - we may now have whitespace
    {SLASH}                                         {yybegin(AFTER_SLASH); return YappingTypes.SLASH; }
    // pending slash - if we encounter another / we are still parsing file path. otherwise we are parsing a new item.
    {COMMENT}                                       {yybegin(PENDING_SLASH); return YappingTypes.COMMENT;}
    {WHITESPACE}                                    {yybegin(PENDING_SLASH); return TokenType.WHITE_SPACE;}
    // other valid tokens are covered in DEFAULT 2
}
<BEFORE_YSCOPE> {
    // note - ambiguity with the following: "a."123 vs "a."123asdf
    //  however 123asdf will match to YBODY since it's the larger token, and
    //  123 will match to NATURAL as it's the first listed in the program.
    {NATURAL}                                       {return YappingTypes.NATURAL;}
    {YBODY}                                         {return YappingTypes.YBODY;}
    {DOT}                                           {yybegin(AFTER_YSCOPE); return YappingTypes.DOT; }
     // pending scope - if we encounter another . we are still parsing path. otherwise we are parsing a new item.
    {COMMENT}                                       {yybegin(PENDING_YSCOPE); return YappingTypes.COMMENT;}
    {WHITESPACE}                                    {yybegin(PENDING_YSCOPE); return TokenType.WHITE_SPACE;}
}
<BEFORE_JSCOPE> {
    [:jletterdigit:]+                               {return YappingTypes.JBODY;}
    // encountered a scope - we may now have whitespace
    {DOT}                                         {yybegin(AFTER_JSCOPE); return YappingTypes.DOT; }
    // pending slash - if we encounter another / we are still parsing file path. otherwise we are parsing a new item.
    {COMMENT}                                       {yybegin(PENDING_JSCOPE); return YappingTypes.COMMENT;}
    {WHITESPACE}                                    {yybegin(PENDING_JSCOPE); return TokenType.WHITE_SPACE;}
    // other valid tokens are covered in DEFAULT 2
}
<AFTER_SLASH, AFTER_JSCOPE, PENDING_JSCOPE, PENDING_SLASH, AFTER_YSCOPE, PENDING_YSCOPE> {
    // after or pending a scope separator: comments and or whitespace will stay in the same state
    {WHITESPACE}                                    {return TokenType.WHITE_SPACE;}
    {COMMENT}                                       {return YappingTypes.COMMENT;}
}
<AFTER_JSCOPE, AFTER_SLASH, AFTER_YSCOPE> {
    // if have another token that can be used in the path, then use it
    // after REGEX or LITERAL are parsed. Will fall back to BEFORE_(SCOPE|SLASH)
    {REGEX_QUOTE}                                   {yybegin(REGEX);}
    {LITERAL_QUOTE}                                 {yybegin(LITERAL);}
}
<AFTER_SLASH> {
    // file//asdf is fine
    {SLASH}                                         {return YappingTypes.SLASH;}
    {FNAME}                                         {yybegin(BEFORE_SLASH); return YappingTypes.FNAME;}
    // however we do require a name at the end, a dangling / is invalid (and can cause confusion)
    // e.g.        @my/folder/
    //             123  # resolves to my/folder/123
    //             @my/folder/  # resolves to my/folder
}
<AFTER_YSCOPE> {
    {YNAME}                                         {yybegin(BEFORE_YSCOPE); return YappingTypes.YNAME;}
    {NATURAL}                                       {yybegin(BEFORE_YSCOPE); return YappingTypes.NATURAL;}
}
<AFTER_JSCOPE> {
    // identifier.. is not valid
    //{SCOPE}                                         {return TokenType.BAD_CHARACTER;}
    // after jscope first char should be a jletter (or regex/literal)
    [:jletter:][:jletterdigit:]*                    {yybegin(BEFORE_JSCOPE); return YappingTypes.JNAME;}
    // everything else is treated as a bad character, cannot have a java path that ends in '.'
}
<PENDING_SLASH> {
    // before a path separator, comments and whitespaces separate to next item
    {SLASH}                                     {yybegin(AFTER_SLASH); return YappingTypes.SLASH; }
    // other valid tokens are covered in DEFAULT 1
}
<PENDING_YSCOPE> {
    {DOT}                                         {yybegin(AFTER_YSCOPE); return YappingTypes.DOT; }
}
<PENDING_JSCOPE> {
    {DOT}                                         {yybegin(AFTER_JSCOPE); return YappingTypes.DOT; }
}
<LITERAL> {
    // escaped quote in string
    \\\"                                            {}
    // end of quote
    {LITERAL_QUOTE}                                 {
                                                        yybegin(getContext());
                                                        return YappingTypes.LITERAL;
                                                    }
    // body: everything except " and \
    [^\"\\]+                                        {}
    // body: everything \. except \"
    \\[^\"]                                         {}
    <<EOF>>                                         { throw new Error("EOF while parsing string"); }
}
<REGEX> {
    // escaped
    \\\`                                            { yybegin(REGEX); }
    \\\[                                            { yybegin(REGEX); }
    \[                                              { yybegin(REGEX_CLASS); }
    // end of regex, transition back to INITIAL
    {REGEX_QUOTE}                                   { yybegin(getContext()); return YappingTypes.REGEX; }
    // body: everything except `, \, and [
    [^\\\`\[]+                                      {}
    // body: everything \. except \` and \[
    \\[^\`\[]                                       {}
    <<EOF>>                                         { throw new Error("EOF while parsing `regex`"); }
}
<REGEX_CLASS> {
    // escaped end of char class
    \\\]                                            {}
    // end of char class, transition back to REGEX
    \]                                              { yybegin(REGEX); }
    // body: everything except ] and \
    [^\\\]]+                                        {}
    // body: everything \. except \]
    \\[^\]]                                         {}
    <<EOF>>                                         { throw new Error("EOF while parsing `regex`"); }
}

[^]                                                 { return TokenType.BAD_CHARACTER; }

