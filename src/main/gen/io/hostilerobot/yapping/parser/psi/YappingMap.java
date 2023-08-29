// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.hostilerobot.yapping.parser.grammar.ListAccessible;
import com.intellij.psi.tree.IElementType;

public interface YappingMap extends ListAccessible {

  @NotNull
  List<YappingPairBounded> getPairBoundedList();

  boolean isElementType(IElementType type);

}
