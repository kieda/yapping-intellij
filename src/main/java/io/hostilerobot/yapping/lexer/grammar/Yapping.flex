package io.hostilerobot.yapping.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import io.hostilerobot.yapping.parser.YappingTypes;import java.nio.file.Path;import java.util.ArrayDeque;import java.util.Deque;import com.intellij.lexer.FlexLexer;

%%

%class YappingLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
//%cup
%debug
%char
%line
%column
%{

enum PathContext{
      FILE(AFTER_SLASH, BEFORE_SLASH),
      JAVA(AFTER_JSCOPE, BEFORE_JSCOPE),
      YAPPING(YYINITIAL, YYINITIAL);
      private final int fallback;
      private final int initialState;
      PathContext(int initialState, int fallback) {
          this.initialState = initialState;
          this.fallback = fallback;
      }
}
// we want to handle java paths !com.user.Plugin
// different from file paths @file/user/pugin.yap
// different from YAPPING paths { ... }.my-value.3.length
//Deque<Integer> CONTEXT = new ArrayDeque<>();
private Deque<PathContext> context = new ArrayDeque<>();
{
  // top level is all yapping
  // this item should be here throughout all lexing
  context.push(PathContext.YAPPING);
}

private String getStateName(int state) {
    switch(state) {
        case AFTER_JSCOPE: return "AFTER_JSCOPE";
        case AFTER_SLASH: return "AFTER_SLASH";
        case BEFORE_JSCOPE: return "BEFORE_JSCOPE";
        case BEFORE_SLASH: return "BEFORE_SLASH";
        case PENDING_JSCOPE: return "PENDING_JSCOPE";
        case PENDING_SLASH: return "PENDING_SLASH";
        case LITERAL: return "LITERAL";
        case REGEX: return "REGEX";
        case REGEX_CLASS: return "REGEX_CLASS";
        case YYINITIAL: return "YYINITIAL";
        default: return "ERROR_UNKNOWN_STATE";
    }
}

private void debugCurrentState(String methodName) {
    System.out.println(
        methodName + ": " + getStateName(yystate()) + ": " + context
    );
}

private int getCurrentFallback() {
    debugCurrentState("getCurrentFallback");
    return context.peek().fallback;
}
// file path interrupts the current segment and starts a new one that's file
// @asdf!asdf asdf!asdf !asdf !asdf
private void startNewFilePath() {
    debugCurrentState("START startNewFilePath");
    endCurrentPath();
    context.push(PathContext.FILE);
    yybegin(PathContext.FILE.initialState);
    debugCurrentState("END startNewFilePath");
}
private void startNewJavaPath() {
    debugCurrentState("START startNewJavaPath");
    endCurrentPath();
    context.push(PathContext.JAVA);
    yybegin(PathContext.JAVA.initialState);
    debugCurrentState("END startNewJavaPath");
}

// new path that starts with a regex
private void startNewYappingPathRegexStart() {
    debugCurrentState("START startNewYappingPathRegexStart");
    endCurrentPath();
    yybegin(REGEX);
    debugCurrentState("END startNewYappingPathRegexStart");
}
// new path that starts with a literal
// !asdf "asdf"
//       ^
private void startNewYappingPathLiteralStart() {
    debugCurrentState("START startNewYappingPathLiteralStart");
    endCurrentPath();
    yybegin(LITERAL);
    debugCurrentState("END startNewYappingPathLiteralStart");
}

// open parentheses on a new yapping path, e.g. [ ( {
// asdf ( .. )
//      ^
// !asdf ( .. )
//       ^
private void startNewYappingPathOpenStart() {
    debugCurrentState("START startNewYappingPathOpenStart");
    startNewYappingPath();
    context.push(PathContext.YAPPING);
    debugCurrentState("END startNewYappingPathOpenStart");
}

// asdf asdf
//      ^
// !asdf asdf
//       ^
// !asdf=asdf
//      ^
// @asdf, asdf
//      ^
private void startNewYappingPath() {
    debugCurrentState("START startNewYappingPath");
    endCurrentPath();
    yybegin(YYINITIAL);
    debugCurrentState("END startNewYappingPath");
}

// ends the current segment
private void endCurrentPath() {
    // encounter a start of a new yapping segment after PENDING
    if(context.size() > 1 && context.peek() != PathContext.YAPPING) {
        // !asdf.asdf asdf
        // [F, Y]     [Y]
        context.pop();
        if(context.peek() != PathContext.YAPPING) {
            // should never happen but we check anyway
            throw new IllegalStateException("Expected YAPPING instead found " + context.peek());
        }
    }
}

private void openYappingSegment() {
    debugCurrentState("START openYappingSegment");
    // encounter a (, {, or [ while in a segment
    context.push(PathContext.YAPPING);
    if(yystate() != PathContext.YAPPING.initialState) {
        yybegin(PathContext.YAPPING.initialState);
    }
    debugCurrentState("END openYappingSegment");
}
private void closeCurrentSegment() {
    debugCurrentState("START closeCurrentSegment");
    // encounter ), ], or }
    if(context.size() > 1 && context.peek() == PathContext.YAPPING) {
        context.pop();
        // !sadf[asdf]
        //           ^
        // sadf[[asdf]]
        //           ^^
        PathContext contextResult = context.peek();
        yybegin(contextResult.fallback);
    } else if(context.size() > 2 && context.peek() != PathContext.YAPPING) {
        // !sa/df[!asdf]as/df
        //             ^
        context.pop(); // stop the current java or file path
        // context.size() > 1
        if(context.peek() != PathContext.YAPPING) {
            // should never happen but we check anyway
            throw new IllegalStateException("Expected YAPPING instead found " + context.peek());
        }
        // remove this context - it corresponds to the opening brace which has now just ended
        context.pop();
        // context.size() > 0

        PathContext contextResult = context.peek();
        // we return to this context
        yybegin(contextResult.fallback);
    } else {
        // will only occur if we have a sequence with
        // sadf] or !asdf]
        if(context.size() > 1) {
            context.pop();
        }
        yybegin(PathContext.YAPPING.fallback);
    }
    // todo - should we throw if we encounter mismatched segments?
    //        ex: asdf)asdf
    //        currently we just fall back to YAPPING and let the parser deal with it
    debugCurrentState("END closeCurrentSegment");
}

private static String zzToPrintable(CharSequence cs) {
    return zzToPrintable(cs.toString());
}
%}

%eof{  return;
%eof}
LineTerminator = \r|\n|\r\n
//InputCharacter = [^\r\n\t\f\ \#]
WHITESPACE     = ({LineTerminator} | [ \t\f])+
COMMENT        = "#"[^\r\n]*{LineTerminator}?

FNAMECHAR      = [^\/\"\`\!\@\,\r\n\t\f\=\-\:\;\ \#\[\]\(\)\{\}\<\>]
// permit hyphens in file names, but stop short of "->"
// (asf-adf-)/
// (asf-adf)->
// (asf-adf-)->
// last segment matches - but not ->
// ({FNAMECHAR}|\-)+ "->"
// ({FNAMECHAR}|\-)+ "-----"->
FNAME          = !(!(({FNAMECHAR}|\-)+)|(({FNAMECHAR}|\-) "->"))
//({FNAMECHAR}|(\-({FNAMECHAR}|\-)))+ (!(!\-|{TRANSITION_SEP_R}))?
// !{FNAMECHAR} = a [\/\"\`\!\@\r\n\t\f\-\ \#\[\]\(\)\{\}\<\>] [^]*
//
YBODYCHAR      = //[[{FNAMECHAR}] && [^\&\+\'\$\|\~\*\^\%\\\?\%\.]]
    [^\/\"\`\!\@\,\r\n\t\f\=\-\:\;\ \#\[\]\(\)\{\}\<\>\&\+\'\$\|\~\*\^\%\\\?\%\.]
YFIRSTCHAR     = //[{YFIRSTCHAR} && [^0-9]]
    [^\/\"\`\!\@\,\r\n\t\f\=\-\:\;\ \#\[\]\(\)\{\}\<\>\&\+\'\$\|\~\*\^\%\\\?\%\.0-9]
//YFIRSTCHAR     = [^\/\"\'\`\!\@\r\n\t\f\ \#\[\]\(\)\{\}\<\>\:\&\+\;\|\=\,\~\*\^\%\\\?\%\.[0-9]]
//YBODYCHAR      = [^\/\"\'\`\!\@\r\n\t\f\ \#\[\]\(\)\{\}\<\>\:\&\-\+\;\|\=\,\~\*\^\%\\\?\%\.]
YBODY          = ({YBODYCHAR})+    // asdf10hij
YNAME          = {YFIRSTCHAR}({YBODYCHAR}*) // sadfasdf asdf10
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
//  %state BEFORE_YSCOPE, AFTER_YSCOPE, PENDING_YSCOPE

%%

// we have found a new identifier.

// DEFAULT 1: new identifier stops previous path
<PENDING_SLASH, PENDING_JSCOPE> {
    {LITERAL_QUOTE}                                 {
                                                        // we are encountering a new literal
                                                        startNewYappingPathLiteralStart();
                                                    }
    {REGEX_QUOTE}                                   {
                                                        startNewYappingPathRegexStart();
                                                    }
    {YNAME}                                         {
                                                        startNewYappingPath();
                                                        return YappingTypes.YNAME;
                                                    }
    {NATURAL}                                       {
                                                        startNewYappingPath();
                                                        return YappingTypes.NATURAL;
                                                    }
    {MAP_START}                                     {
                                                        startNewYappingPathOpenStart();
                                                        return YappingTypes.MAP_START;
                                                    }
    {MAP_END}                                       {
                                                        closeCurrentSegment();
                                                        return YappingTypes.MAP_END;
                                                    }
    {LIST_START}                                    {
                                                        startNewYappingPathOpenStart();
                                                        return YappingTypes.LIST_START;
                                                    }
    {LIST_END}                                      {
                                                        closeCurrentSegment();
                                                        return YappingTypes.LIST_END;
                                                    }
    {PRECEDENCE_START}                              {
                                                        startNewYappingPathOpenStart();
                                                        return YappingTypes.PRECEDENCE_START;
                                                    }
    {PRECEDENCE_END}                                {
                                                        closeCurrentSegment();
                                                        return YappingTypes.PRECEDENCE_END;
                                                    }
}

// DEFAULT 2: new java|file path stops previous path
//            and binary operators: items that may end the current path
<YYINITIAL, PENDING_SLASH, BEFORE_SLASH, PENDING_JSCOPE, BEFORE_JSCOPE> {
    {FPATH_START}                                   {
                                                        /* fall back to BEFORE_SLASH when we're done parsing regex or literal */
                                                        startNewFilePath();
                                                        return YappingTypes.FPATH_START;
                                                    }
    {JPATH_START}                                   {
                                                        startNewJavaPath();
                                                        return YappingTypes.JPATH_START;
                                                    }
    {TRANSITION_SEP_L}                              {
                                                        startNewYappingPath();
                                                        return YappingTypes.TRANSITION_SEP_L;
                                                    }
    {TRANSITION_SEP_R}                              {
                                                        startNewYappingPath();
                                                        return YappingTypes.TRANSITION_SEP_R;
                                                    }
    {PAIR_SEP}                                      {
                                                        startNewYappingPath();
                                                        return YappingTypes.PAIR_SEP;
                                                    }
    {LIST_SEP}                                      {
                                                        startNewYappingPath();
                                                        return YappingTypes.LIST_SEP;
                                                    }
    {PROPERTY_SEP}                                  {
                                                        startNewYappingPath();
                                                        return YappingTypes.PROPERTY_SEP;
                                                    }
}
// DEFAULT 3: whitespace, comments, etc in yapping context
<YYINITIAL> {
    {COMMENT}                                       { return YappingTypes.COMMENT; }
    {WHITESPACE}                                    { return TokenType.WHITE_SPACE; }
    // parts in yapping paths
    {YNAME}                                         { return YappingTypes.YNAME; }
    {NATURAL}                                       { return YappingTypes.NATURAL; }
    {YBODY}                                         { return YappingTypes.YBODY; }
    {DOT}                                           { return YappingTypes.DOT; }
    {SLASH}                                         { return YappingTypes.SLASH; }
}
// DEFAULT 4: items in a path that can be followed by . or /
<YYINITIAL, BEFORE_SLASH, BEFORE_JSCOPE, AFTER_JSCOPE, AFTER_SLASH> {
    // if have another token that can be used in the path, then use it
    // after REGEX or LITERAL are parsed. Will fall back to BEFORE_(SCOPE|SLASH)
    {REGEX_QUOTE}                                   {yybegin(REGEX);}
    {LITERAL_QUOTE}                                 {yybegin(LITERAL);}
    {MAP_START}                                     {
                                                        openYappingSegment();
                                                        return YappingTypes.MAP_START;
                                                    }
    {MAP_END}                                       {
                                                        closeCurrentSegment();
                                                        return YappingTypes.MAP_END;
                                                    }
    {LIST_START}                                    {
                                                        openYappingSegment();
                                                        return YappingTypes.LIST_START;
                                                    }
    {LIST_END}                                      {
                                                        closeCurrentSegment();
                                                        return YappingTypes.LIST_END;
                                                    }
    {PRECEDENCE_START}                              {
                                                        openYappingSegment();
                                                        return YappingTypes.PRECEDENCE_START;
                                                    }
    {PRECEDENCE_END}                                {
                                                        closeCurrentSegment();
                                                        return YappingTypes.PRECEDENCE_END;
                                                    }
}
// DEFAULT 5: items that may be in a file path but not in a java path/yapping path
<YYINITIAL, BEFORE_JSCOPE, PENDING_JSCOPE, PENDING_SLASH> {
    {AND}                                           {
                                                        startNewYappingPath();
                                                        return YappingTypes.AND;
                                                    }
    {PLUS}                                          {
                                                        startNewYappingPath();
                                                        return YappingTypes.PLUS;
                                                    }
    {MINUS}                                         {
                                                        startNewYappingPath();
                                                        return YappingTypes.MINUS;
                                                    }

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
<BEFORE_JSCOPE> {
    [:jletterdigit:]+                               {return YappingTypes.JBODY;}
    // encountered a scope - we may now have whitespace
    {DOT}                                           {yybegin(AFTER_JSCOPE); return YappingTypes.DOT; }
    // pending slash - if we encounter another / we are still parsing file path. otherwise we are parsing a new item.
    {COMMENT}                                       {yybegin(PENDING_JSCOPE); return YappingTypes.COMMENT;}
    {WHITESPACE}                                    {yybegin(PENDING_JSCOPE); return TokenType.WHITE_SPACE;}
    // other valid tokens are covered in DEFAULT 2
}
<AFTER_SLASH, AFTER_JSCOPE, PENDING_JSCOPE, PENDING_SLASH> {
    // after or pending a scope separator: comments and or whitespace will stay in the same state
    {WHITESPACE}                                    {return TokenType.WHITE_SPACE;}
    {COMMENT}                                       {return YappingTypes.COMMENT;}
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
<AFTER_JSCOPE> {
    // identifier.. is not valid
    //{SCOPE}                                         {return TokenType.BAD_CHARACTER;}
    // after jscope first char should be a jletter (or regex/literal)
    [:jletter:][:jletterdigit:]*                    {yybegin(BEFORE_JSCOPE); return YappingTypes.JNAME;}
    // everything else is treated as a bad character, cannot have a java path that ends in '.'
}
<PENDING_SLASH> {
    // before a path separator, comments and whitespaces separate to next item
    {SLASH}                                         {yybegin(AFTER_SLASH); return YappingTypes.SLASH; }
    // other valid tokens are covered in DEFAULT 1
}
<PENDING_JSCOPE> {
    {DOT}                                           {yybegin(AFTER_JSCOPE); return YappingTypes.DOT; }
}
<LITERAL> {
    // escaped quote in string
    \\\"                                            {}
    // end of quote
    {LITERAL_QUOTE}                                 {
                                                        yybegin(getCurrentFallback());
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
    {REGEX_QUOTE}                                   { yybegin(getCurrentFallback()); return YappingTypes.REGEX; }
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

