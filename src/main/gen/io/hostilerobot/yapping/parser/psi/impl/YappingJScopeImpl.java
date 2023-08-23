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

public class YappingJScopeImpl extends ASTWrapperPsiElement implements YappingJScope {

  public YappingJScopeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitJScope(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YappingJScope getJScope() {
    return findChildByClass(YappingJScope.class);
  }

  @Override
  @NotNull
  public YappingJScopeSegment getJScopeSegment() {
    return findNotNullChildByClass(YappingJScopeSegment.class);
  }

  @Override
  @NotNull
  public List<YappingSpacing> getSpacingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingSpacing.class);
  }

}
