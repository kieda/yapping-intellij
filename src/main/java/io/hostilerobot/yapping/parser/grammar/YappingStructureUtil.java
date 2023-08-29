package io.hostilerobot.yapping.parser.grammar;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import io.hostilerobot.yapping.parser.YappingTypes;
import io.hostilerobot.yapping.parser.psi.*;

public class YappingStructureUtil {
    public static IElementType toElementType(PsiElement element) {
        if(element instanceof ASTWrapperPsiElement wrapper) {
            return wrapper.getNode().getElementType();
        } else {
            throw new UnsupportedOperationException("non-wrapped psi element");
        }
    }
    // for properties: valid types are other elements
    public static boolean isElementType(YappingProperties properties, IElementType elementType) {
        return YappingTypes.PROPERTIES.equals(elementType);
    }
    public static boolean isRecursiveType(YappingProperties properties, IElementType elementType) {
        return YappingTypes.PROPERTIES.equals(elementType);
    }

    public static boolean isElementType(YappingMap map, IElementType elementType) {
        return elementType.equals(YappingTypes.PAIR_BOUNDED);
    }
    public static boolean isElement(YappingList list, PsiElement element) {
        IElementType elementType = toElementType(element);
        // don't add the list itself to the list of elements
        return element != list
                && !elementType.equals(YappingTypes.LIST_START)
                && !elementType.equals(YappingTypes.LIST_END)
                && !elementType.equals(YappingTypes.LIST_SEP)
                && !elementType.equals(YappingTypes.COMMENT)
                && !elementType.equals(YappingTypes.WHITESPACE)
                ;
    }
    public static boolean isElementType(YappingYPath1 ypath, IElementType elementType) {
        return !elementType.equals(YappingTypes.DOT)
                && !elementType.equals(YappingTypes.WHITESPACE)
                && !elementType.equals(YappingTypes.COMMENT)
                && !elementType.equals(YappingTypes.Y_PATH_1)
                ;
    }
    public static boolean isElementType(YappingYSegmentMulti segment, IElementType elementType) {
        return !elementType.equals(YappingTypes.DOT)
                && !elementType.equals(YappingTypes.WHITESPACE)
                && !elementType.equals(YappingTypes.COMMENT)
                && !elementType.equals(YappingTypes.Y_SEGMENT_MULTI)
                ;
    }
    public static boolean isElementType(YappingFPath fpath, IElementType elementType) {
        return !elementType.equals(YappingTypes.DOT)
                && !elementType.equals(YappingTypes.WHITESPACE)
                && !elementType.equals(YappingTypes.COMMENT)
                && !elementType.equals(YappingTypes.FPATH_START)
                && !elementType.equals(YappingTypes.F_PATH)
                ;
    }
    public static boolean isElementType(YappingJPath jpath, IElementType elementType) {
        return !elementType.equals(YappingTypes.DOT)
                && !elementType.equals(YappingTypes.WHITESPACE)
                && !elementType.equals(YappingTypes.COMMENT)
                && !elementType.equals(YappingTypes.JPATH_START)
                && !elementType.equals(YappingTypes.J_PATH)
                ;
    }
}
