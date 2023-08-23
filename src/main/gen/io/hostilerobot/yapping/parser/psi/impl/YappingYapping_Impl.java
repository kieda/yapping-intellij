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

public class YappingYapping_Impl extends ASTWrapperPsiElement implements YappingYapping_ {

  public YappingYapping_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitYapping_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YappingProperties getProperties() {
    return findChildByClass(YappingProperties.class);
  }

  @Override
  @Nullable
  public YappingItem getItem() {
    return findChildByClass(YappingItem.class);
  }

  @Override
  @Nullable
  public YappingYapping_ getYapping_() {
    return findChildByClass(YappingYapping_.class);
  }

}
