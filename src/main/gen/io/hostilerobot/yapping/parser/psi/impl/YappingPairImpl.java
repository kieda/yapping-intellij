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

public class YappingPairImpl extends ASTWrapperPsiElement implements YappingPair {

  public YappingPairImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YappingBaseData> getBaseDataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingBaseData.class);
  }

  @Override
  @Nullable
  public YappingPair getPair() {
    return findChildByClass(YappingPair.class);
  }

  @Override
  @NotNull
  public List<YappingTransitionL> getTransitionLList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingTransitionL.class);
  }

  @Override
  @NotNull
  public List<YappingTransitionR> getTransitionRList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingTransitionR.class);
  }

}