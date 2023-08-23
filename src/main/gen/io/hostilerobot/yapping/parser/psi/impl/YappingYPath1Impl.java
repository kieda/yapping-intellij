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

public class YappingYPath1Impl extends ASTWrapperPsiElement implements YappingYPath1 {

  public YappingYPath1Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitYPath1(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YappingSpacing> getSpacingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingSpacing.class);
  }

  @Override
  @Nullable
  public YappingYPathRest getYPathRest() {
    return findChildByClass(YappingYPathRest.class);
  }

  @Override
  @NotNull
  public YappingYSegmentExclNat getYSegmentExclNat() {
    return findNotNullChildByClass(YappingYSegmentExclNat.class);
  }

}
