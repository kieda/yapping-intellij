// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.hostilerobot.yapping.parser.grammar.ListAccessible;

public interface YappingList extends ListAccessible {

  @NotNull
  List<YappingInteger> getIntegerList();

  @NotNull
  List<YappingList> getListList();

  @NotNull
  List<YappingMap> getMapList();

  @NotNull
  List<YappingPairBounded> getPairBoundedList();

  @NotNull
  List<YappingPrecedence> getPrecedenceList();

  @NotNull
  List<YappingProperties> getPropertiesList();

  @NotNull
  List<YappingQuotient> getQuotientList();

  @NotNull
  List<YappingReal> getRealList();

  @NotNull
  List<YappingTransitionLBounded> getTransitionLBoundedList();

  @NotNull
  List<YappingTransitionRBounded> getTransitionRBoundedList();

  @NotNull
  List<YappingFPath> getFPathList();

  @NotNull
  List<YappingJPath> getJPathList();

  @NotNull
  List<YappingYPath1> getYPath1List();

  @NotNull
  List<YappingYSegmentMulti> getYSegmentMultiList();

  boolean isElement(PsiElement element);

}
