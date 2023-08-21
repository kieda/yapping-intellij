// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingBoundedData extends PsiElement {

  @Nullable
  YappingBaseData getBaseData();

  @Nullable
  YappingPairBounded getPairBounded();

  @Nullable
  YappingProperties getProperties();

  @Nullable
  YappingTransitionLBounded getTransitionLBounded();

  @Nullable
  YappingTransitionRBounded getTransitionRBounded();

}
