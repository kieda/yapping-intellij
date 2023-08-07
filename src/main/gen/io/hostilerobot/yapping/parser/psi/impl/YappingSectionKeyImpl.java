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

public class YappingSectionKeyImpl extends ASTWrapperPsiElement implements YappingSectionKey {

  public YappingSectionKeyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitSectionKey(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YappingBaseData getBaseData() {
    return findChildByClass(YappingBaseData.class);
  }

  @Override
  @Nullable
  public YappingCproperties getCproperties() {
    return findChildByClass(YappingCproperties.class);
  }

  @Override
  @Nullable
  public YappingJscopeSegment getJscopeSegment() {
    return findChildByClass(YappingJscopeSegment.class);
  }

  @Override
  @Nullable
  public YappingList getList() {
    return findChildByClass(YappingList.class);
  }

  @Override
  @Nullable
  public YappingScope getScope() {
    return findChildByClass(YappingScope.class);
  }

}
