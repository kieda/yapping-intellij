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

public class YappingBoundedDataImpl extends ASTWrapperPsiElement implements YappingBoundedData {

  public YappingBoundedDataImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitBoundedData(this);
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
  public YappingPairBounded getPairBounded() {
    return findChildByClass(YappingPairBounded.class);
  }

  @Override
  @Nullable
  public YappingProperties getProperties() {
    return findChildByClass(YappingProperties.class);
  }

  @Override
  @Nullable
  public YappingTransitionLBounded getTransitionLBounded() {
    return findChildByClass(YappingTransitionLBounded.class);
  }

  @Override
  @Nullable
  public YappingTransitionRBounded getTransitionRBounded() {
    return findChildByClass(YappingTransitionRBounded.class);
  }

}
