package io.hostilerobot.yapping.parser.token;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.hostilerobot.yapping.intellijplugin.language.YappingLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


public class YappingTokenType extends IElementType {

    public YappingTokenType(@NotNull @NonNls String debugName) {
        super(debugName, YappingLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "YappingTokenType." + super.toString();
    }

}

//public final class YappingTokenType {
//    private YappingTokenType(){}
//    // whitespace, bad char
//    public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
//    public static final IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
//
//    // comments
//    public static final IElementType COMMENT = new YappingElementType("COMMENT");
//    // primitives
//    public static final IElementType DECIMAL = new YappingElementType("DECIMAL");  // has the form \d+.\d+
//    public static final IElementType INTEGER = new YappingElementType("INTEGER");  // has the form \d+
//    public static final IElementType REGEX = new YappingElementType("REGEX");      // has the form `regex~flags`
//    public static final IElementType NAME = new YappingElementType("NAME");        // has the form \w+
//    public static final IElementType LITERAL = new YappingElementType("LITERAL");  // has the form "[^"]*"
//    public static final IElementType FRACTION = new YappingElementType("FRACTION");// has the form INTEGER / INTEGER
//
//    // sections
//    public static final IElementType SECTION_START = new YappingElementType("SECTION_START"); // : in :name
//    public static final IElementType SECTION_SEP = new YappingElementType("SECTION_SEP");     // : in name:
//    public static final IElementType SECTION_END = new YappingElementType("SECTION_END");         // ;
//
//    // lists
//    public static final IElementType LIST_START = new YappingElementType("LIST_START"); // (
//    public static final IElementType LIST_ITEM = new YappingElementType("LIST_ITEM");   // ,
//    public static final IElementType LIST_END = new YappingElementType("LIST_END");     // )
//
//    // maps
//    public static final IElementType MAP_START = new YappingElementType("MAP_START"); // {
//    public static final IElementType MAP_SEP = new YappingElementType("MAP_SEP");     // =
//    public static final IElementType MAP_ITEM = new YappingElementType("MAP_ITEM");   // ,
//    public static final IElementType MAP_END = new YappingElementType("MAP_END");     // }
//
//    // pairs
//    public static final IElementType PAIR_SEP = new YappingElementType("PAIR_SEP");   // =
//
//    // scopes and lookups
//    public static final IElementType SCOPE = new YappingElementType("SCOPE");               // "."
//    public static final IElementType LOOKUP_BEGIN = new YappingElementType("LOOKUP_BEGIN"); // "["
//    public static final IElementType LOOKUP_END = new YappingElementType("LOOKUP_END");     // "]"
//
//    // paths. File path preceded by "!" and uses "/" as a separator
//    //        Java path preceded by "@" and uses "." as a separator
//    public static final IElementType FILE_PATH = new YappingElementType("FILE_PATH");
//    public static final IElementType JAVA_PATH = new YappingElementType("JAVA_PATH");
//}
