// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingList extends PsiElement {

  @NotNull
  List<YappingBoundedData> getBoundedDataList();

  @NotNull
  List<YappingSpacing> getSpacingList();

}
