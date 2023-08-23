// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.hostilerobot.yapping.parser.YappingTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.hostilerobot.yapping.parser.psi.*;

public class YappingContainedSegmentImpl extends ASTWrapperPsiElement implements YappingContainedSegment {

  public YappingContainedSegmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitContainedSegment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YappingList getList() {
    return findChildByClass(YappingList.class);
  }

  @Override
  @Nullable
  public YappingMap getMap() {
    return findChildByClass(YappingMap.class);
  }

  @Override
  @Nullable
  public YappingPrecedence getPrecedence() {
    return findChildByClass(YappingPrecedence.class);
  }

}
