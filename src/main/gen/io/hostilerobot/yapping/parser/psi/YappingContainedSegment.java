// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YappingContainedSegment extends PsiElement {

  @Nullable
  YappingList getList();

  @Nullable
  YappingMap getMap();

  @Nullable
  YappingPrecedence getPrecedence();

}
