// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingTransitionRExpr extends PsiElement {

  @NotNull
  List<YappingInteger> getIntegerList();

  @NotNull
  List<YappingList> getListList();

  @NotNull
  List<YappingMap> getMapList();

  @NotNull
  List<YappingPrecedence> getPrecedenceList();

  @NotNull
  List<YappingQuotient> getQuotientList();

  @NotNull
  List<YappingReal> getRealList();

  @Nullable
  YappingTransitionRExpr getTransitionRExpr();

  @NotNull
  List<YappingFPath> getFPathList();

  @NotNull
  List<YappingJPath> getJPathList();

  @NotNull
  List<YappingYPath1> getYPath1List();

  @NotNull
  List<YappingYSegmentMulti> getYSegmentMultiList();

}
