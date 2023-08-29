// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingPrecedence extends PsiElement {

  @Nullable
  YappingInteger getInteger();

  @Nullable
  YappingList getList();

  @Nullable
  YappingMap getMap();

  @Nullable
  YappingPairBounded getPairBounded();

  @Nullable
  YappingPrecedence getPrecedence();

  @Nullable
  YappingProperties getProperties();

  @Nullable
  YappingQuotient getQuotient();

  @Nullable
  YappingReal getReal();

  @Nullable
  YappingTransitionLBounded getTransitionLBounded();

  @Nullable
  YappingTransitionRBounded getTransitionRBounded();

  @Nullable
  YappingFPath getFPath();

  @Nullable
  YappingJPath getJPath();

  @Nullable
  YappingYPath1 getYPath1();

  @Nullable
  YappingYSegmentMulti getYSegmentMulti();

}
