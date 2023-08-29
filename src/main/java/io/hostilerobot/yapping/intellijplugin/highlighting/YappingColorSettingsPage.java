package io.hostilerobot.yapping.intellijplugin.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class YappingColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Separators//Dot", YappingHighlighter.DOT),
            new AttributesDescriptor("Separators//Slash", YappingHighlighter.SLASH),
            new AttributesDescriptor("Separators//Colon", YappingHighlighter.COLON),
            new AttributesDescriptor("Separators//Comma", YappingHighlighter.COMMA),
            new AttributesDescriptor("Numbers//Sign", YappingHighlighter.SIGN),
            new AttributesDescriptor("Numbers//Quotient", YappingHighlighter.AND),
            new AttributesDescriptor("Numbers//Natural", YappingHighlighter.NATURAL),
            new AttributesDescriptor("File path//Path start", YappingHighlighter.FILE_PATH_START),
            new AttributesDescriptor("File path//File name", YappingHighlighter.FNAME),
            new AttributesDescriptor("Java path//Path start", YappingHighlighter.JAVA_PATH_START),
            new AttributesDescriptor("Java path//Java name", YappingHighlighter.JNAME),
            new AttributesDescriptor("Java path//Java body", YappingHighlighter.JBODY),
            new AttributesDescriptor("Paths//Literal", YappingHighlighter.LITERAL),
            new AttributesDescriptor("Paths//Regex", YappingHighlighter.REGEX),
            new AttributesDescriptor("Yapping path//Yapping name", YappingHighlighter.YNAME),
            new AttributesDescriptor("Yapping path//Yapping body", YappingHighlighter.YBODY),
            new AttributesDescriptor("Braces//Map", YappingHighlighter.MAP_BRACES),
            new AttributesDescriptor("Braces//List", YappingHighlighter.LIST_BRACKETS),
            new AttributesDescriptor("Braces//Precedence", YappingHighlighter.PRECEDENCE_PARENS),
            new AttributesDescriptor("Operators//Equals", YappingHighlighter.EQUALS),
            new AttributesDescriptor("Operators//Left transition", YappingHighlighter.TRANSLATE_L),
            new AttributesDescriptor("Operators//Right transition", YappingHighlighter.TRANSLATE_R),
            new AttributesDescriptor("Comments//Line comment", YappingHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Bad character", YappingHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new YappingHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
               demo = 123.0
               state1 -> state2
                      -> state3
                      <- property
               val = 500.`~/2`
               import: # import declaration 
                    @path.to.my.[JavaClass, Value]
                    !file/path/{a = b, c = d}there/(evaluate: MyFile).yap
                    !file/"liter/ally a strange file name&".yap
                    !files-with-dashes->"wow"
               in: 
                    a-quotient = 3 & 3/4
                    aNegative = -3 & -1/2
               end:
               """;
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Yapping";
    }

}
