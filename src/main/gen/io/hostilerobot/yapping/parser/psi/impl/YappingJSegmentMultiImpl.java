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

public class YappingJSegmentMultiImpl extends ASTWrapperPsiElement implements YappingJSegmentMulti {

  public YappingJSegmentMultiImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitJSegmentMulti(this);
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
  public YappingJSegmentExclJBody getJSegmentExclJBody() {
    return findChildByClass(YappingJSegmentExclJBody.class);
  }

  @Override
  @Nullable
  public YappingJSegmentInclJBody getJSegmentInclJBody() {
    return findChildByClass(YappingJSegmentInclJBody.class);
  }

}
