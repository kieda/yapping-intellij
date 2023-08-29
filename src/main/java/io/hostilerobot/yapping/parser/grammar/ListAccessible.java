package io.hostilerobot.yapping.parser.grammar;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiListLikeElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.SmartList;
import io.hostilerobot.yapping.parser.YappingTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public interface ListAccessible extends PsiListLikeElement {
    // returns true if this should be an element for the list.
    // may not apply for collapsed PSI values (e.g. section data)
    default boolean isElementType(IElementType elementType) {
        return !elementType.equals(YappingTypes.WHITESPACE) && !elementType.equals(YappingTypes.COMMENT);
    }

    default boolean isElement(PsiElement element) {
        return isElementType(YappingStructureUtil.toElementType(element));
    }

    @NotNull
    default List<? extends PsiElement> getComponents() {
        Iterable<? extends PsiElement> iterable = getIterable();
        List<PsiElement> result = null;
        for(PsiElement elem : iterable) {
            if(result == null) {
                result = new SmartList<>();
            }
            result.add(elem);
        }

        return result == null ? Collections.emptyList() : result;
    }

    // subclasses may override this so it only has one iterable instance based on this node
    default Iterable<? extends PsiElement> getIterable() {
        return new PsiListIterable(this, this::isElement);
    }

}
