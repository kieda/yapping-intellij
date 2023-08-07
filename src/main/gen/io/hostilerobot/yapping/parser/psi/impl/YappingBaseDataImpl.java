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

public class YappingBaseDataImpl extends ASTWrapperPsiElement implements YappingBaseData {

  public YappingBaseDataImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitBaseData(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YappingFraction getFraction() {
    return findChildByClass(YappingFraction.class);
  }

  @Override
  @Nullable
  public YappingInteger getInteger() {
    return findChildByClass(YappingInteger.class);
  }

  @Override
  @Nullable
  public YappingList getList() {
    return findChildByClass(YappingList.class);
  }

}
