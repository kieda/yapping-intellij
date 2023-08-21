// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingBaseData extends PsiElement {

  @Nullable
  YappingInteger getInteger();

  @Nullable
  YappingList getList();

  @Nullable
  YappingMap getMap();

  @Nullable
  YappingPrecedence getPrecedence();

  @NotNull
  List<YappingQuotient> getQuotientList();

  @Nullable
  YappingReal getReal();

  @Nullable
  YappingFPath getFPath();

  @Nullable
  YappingJPath getJPath();

  @Nullable
  YappingYPath1 getYPath1();

}
