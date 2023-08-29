package io.hostilerobot.yapping.parser.grammar;

import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// recursively defined list, where the last item of the list is a continuation
// of the list

// only thing defined like this is section. Here, the head of the section is the first item
// then, we return PSI elements for each section
public interface RecursiveListAccessible extends ListAccessible {
    @NotNull
    default List<? extends PsiElement> getComponents() {
        Iterable<? extends PsiElement> iterable = getIterable();
        List<PsiElement> result = null;
        for(PsiElement elem : iterable) {

            result.add(elem);
        }
        return result;
    }

    default boolean isRecursive(PsiElement lastElement) {
        return isRecursiveType(YappingStructureUtil.toElementType(lastElement));
    }

    boolean isRecursiveType(IElementType elementType);

    default Iterable<? extends PsiElement> getIterable() {
        return new PsiListIterable(this, this::isElement, this::isRecursive);
    }
}
