// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingPairBounded extends PsiElement {

  @Nullable
  YappingBaseData getBaseData();

  @NotNull
  YappingBoundedData getBoundedData();

  @Nullable
  YappingTransitionLExpr getTransitionLExpr();

  @Nullable
  YappingTransitionRExpr getTransitionRExpr();

  @NotNull
  List<YappingSpacing> getSpacingList();

}
