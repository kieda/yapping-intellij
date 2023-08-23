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

public class YappingYSegmentExclNatImpl extends ASTWrapperPsiElement implements YappingYSegmentExclNat {

  public YappingYSegmentExclNatImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitYSegmentExclNat(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YappingContainedSegment getContainedSegment() {
    return findChildByClass(YappingContainedSegment.class);
  }

  @Override
  @Nullable
  public YappingYSegmentMulti getYSegmentMulti() {
    return findChildByClass(YappingYSegmentMulti.class);
  }

}
