// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingPair extends PsiElement {

  @Nullable
  YappingAproperties getAproperties();

  @NotNull
  List<YappingBaseData> getBaseDataList();

  @Nullable
  YappingPair getPair();

  @Nullable
  YappingRproperties getRproperties();

}
