// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.hostilerobot.yapping.parser.grammar.RecursiveListAccessible;
import com.intellij.psi.tree.IElementType;

public interface YappingProperties extends RecursiveListAccessible {

  @NotNull
  List<YappingInteger> getIntegerList();

  @NotNull
  List<YappingList> getListList();

  @NotNull
  List<YappingMap> getMapList();

  @NotNull
  List<YappingPairExpr> getPairExprList();

  @NotNull
  List<YappingPrecedence> getPrecedenceList();

  @Nullable
  YappingProperties getProperties();

  @NotNull
  List<YappingQuotient> getQuotientList();

  @NotNull
  List<YappingReal> getRealList();

  @NotNull
  List<YappingTransitionLExpr> getTransitionLExprList();

  @NotNull
  List<YappingTransitionRExpr> getTransitionRExprList();

  @NotNull
  List<YappingFPath> getFPathList();

  @NotNull
  List<YappingJPath> getJPathList();

  @NotNull
  List<YappingYPath1> getYPath1List();

  @NotNull
  List<YappingYSegmentMulti> getYSegmentMultiList();

  boolean isRecursiveType(IElementType type);

  boolean isElementType(IElementType type);

}
