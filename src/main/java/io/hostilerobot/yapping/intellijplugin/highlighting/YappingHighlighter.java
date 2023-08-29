package io.hostilerobot.yapping.intellijplugin.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.hostilerobot.yapping.lexer.YappingLexerAdapter;
import io.hostilerobot.yapping.parser.YappingTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class YappingHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey DOT = createTextAttributesKey("YAPPING_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey SLASH = createTextAttributesKey("YAPPING_SLASH", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey AND = createTextAttributesKey("YAPPING_AND", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey COLON = createTextAttributesKey("YAPPING_COLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey SIGN = createTextAttributesKey("YAPPING_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey FILE_PATH_START = createTextAttributesKey("YAPPING_FILE_PATH_START", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey JAVA_PATH_START = createTextAttributesKey("YAPPING_JAVA_PATH_START", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey LITERAL = createTextAttributesKey("YAPPING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey REGEX = createTextAttributesKey("YAPPING_REGEX", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
    public static final TextAttributesKey JNAME = createTextAttributesKey("YAPPING_JNAME", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey JBODY = createTextAttributesKey("YAPPING_JBODY", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey YNAME = createTextAttributesKey("YAPPING_YNAME", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey YBODY = createTextAttributesKey("YAPPING_YBODY", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey FNAME = createTextAttributesKey("YAPPING_FNAME", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey NATURAL = createTextAttributesKey("YAPPING_NATURAL", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey MAP_BRACES = createTextAttributesKey("YAPPING_MAP_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey LIST_BRACKETS = createTextAttributesKey("YAPPING_LIST_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey PRECEDENCE_PARENS = createTextAttributesKey("YAPPING_PRECEDENCE_PARENS", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey COMMA = createTextAttributesKey("YAPPING_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey EQUALS = createTextAttributesKey("YAPPING_EQUALS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey TRANSLATE_L = createTextAttributesKey("YAPPING_TRANSLATE_L", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey TRANSLATE_R = createTextAttributesKey("YAPPING_TRANSLATE_R", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey("YAPPING_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("YAPPING_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.KEYWORD, DOT};
    public static final TextAttributesKey[] SLASH_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.KEYWORD, SLASH};
    public static final TextAttributesKey[] AND_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.METADATA, AND};
    public static final TextAttributesKey[] COLON_KEYS = new TextAttributesKey[]{COLON};
    public static final TextAttributesKey[] SIGN_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.METADATA, SIGN};
    public static final TextAttributesKey[] FILE_PATH_START_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.STATIC_METHOD, FILE_PATH_START};
    public static final TextAttributesKey[] JAVA_PATH_START_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.FUNCTION_DECLARATION, JAVA_PATH_START};
    public static final TextAttributesKey[] LITERAL_KEYS = new TextAttributesKey[]{LITERAL};
    public static final TextAttributesKey[] REGEX_KEYS = new TextAttributesKey[]{REGEX};
    public static final TextAttributesKey[] JNAME_KEYS = new TextAttributesKey[]{JNAME};
    public static final TextAttributesKey[] JBODY_KEYS = new TextAttributesKey[]{JBODY};
    public static final TextAttributesKey[] YNAME_KEYS = new TextAttributesKey[]{YNAME};
    public static final TextAttributesKey[] YBODY_KEYS = new TextAttributesKey[]{YBODY};
    public static final TextAttributesKey[] FNAME_KEYS = new TextAttributesKey[]{FNAME};
    public static final TextAttributesKey[] NATURAL_KEYS = new TextAttributesKey[]{NATURAL};
    public static final TextAttributesKey[] MAP_BRACES_KEYS = new TextAttributesKey[]{MAP_BRACES};
    public static final TextAttributesKey[] LIST_BRACKETS_KEYS = new TextAttributesKey[]{LIST_BRACKETS};
    public static final TextAttributesKey[] PRECEDENCE_PARENS_KEYS = new TextAttributesKey[]{PRECEDENCE_PARENS};
    public static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    public static final TextAttributesKey[] EQUALS_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.INSTANCE_FIELD, EQUALS};
    public static final TextAttributesKey[] TRANSLATE_L_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.INSTANCE_FIELD, TRANSLATE_L};
    public static final TextAttributesKey[] TRANSLATE_R_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.INSTANCE_FIELD, TRANSLATE_R};
    public static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    public static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new YappingLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if(tokenType.equals(YappingTypes.DOT)) { return DOT_KEYS; }
        if(tokenType.equals(YappingTypes.SLASH)) { return SLASH_KEYS; }
        if(tokenType.equals(YappingTypes.AND)) { return AND_KEYS; }
        if(tokenType.equals(YappingTypes.PROPERTY_SEP)) { return COLON_KEYS; }
        if(tokenType.equals(YappingTypes.PLUS) || tokenType.equals(YappingTypes.MINUS)) { return SIGN_KEYS; }
        if(tokenType.equals(YappingTypes.FPATH_START)) { return FILE_PATH_START_KEYS; }
        if(tokenType.equals(YappingTypes.JPATH_START)) { return JAVA_PATH_START_KEYS; }
        if(tokenType.equals(YappingTypes.LITERAL)) { return LITERAL_KEYS; }
        if(tokenType.equals(YappingTypes.REGEX)) { return REGEX_KEYS; }
        if(tokenType.equals(YappingTypes.JNAME)) { return JNAME_KEYS; }
        if(tokenType.equals(YappingTypes.JBODY)) { return JBODY_KEYS; }
        if(tokenType.equals(YappingTypes.YNAME)) { return YNAME_KEYS; }
        if(tokenType.equals(YappingTypes.YBODY)) { return YBODY_KEYS; }
        if(tokenType.equals(YappingTypes.FNAME)) { return FNAME_KEYS; }
        if(tokenType.equals(YappingTypes.NATURAL)) { return NATURAL_KEYS; }
        if(tokenType.equals(YappingTypes.MAP_START) || tokenType.equals(YappingTypes.MAP_END)) { return MAP_BRACES_KEYS; }
        if(tokenType.equals(YappingTypes.LIST_START) || tokenType.equals(YappingTypes.LIST_END)) { return LIST_BRACKETS_KEYS; }
        if(tokenType.equals(YappingTypes.PRECEDENCE_START) || tokenType.equals(YappingTypes.PRECEDENCE_END)) { return PRECEDENCE_PARENS_KEYS; }
        if(tokenType.equals(YappingTypes.LIST_SEP)) { return COMMA_KEYS; }
        if(tokenType.equals(YappingTypes.PAIR_SEP)) { return EQUALS_KEYS; }
        if(tokenType.equals(YappingTypes.TRANSITION_SEP_L)) { return TRANSLATE_L_KEYS; }
        if(tokenType.equals(YappingTypes.TRANSITION_SEP_R)) { return TRANSLATE_R_KEYS; }
        if(tokenType.equals(YappingTypes.COMMENT)) { return LINE_COMMENT_KEYS; }
        if(tokenType.equals(TokenType.BAD_CHARACTER)) { return BAD_CHARACTER_KEYS; }

        return EMPTY_KEYS;
    }
}
