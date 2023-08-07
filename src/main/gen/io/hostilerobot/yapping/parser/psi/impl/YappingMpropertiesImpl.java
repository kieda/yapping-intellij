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

public class YappingMpropertiesImpl extends ASTWrapperPsiElement implements YappingMproperties {

  public YappingMpropertiesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitMproperties(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YappingSectionBody> getSectionBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingSectionBody.class);
  }

  @Override
  @NotNull
  public List<YappingSectionKey> getSectionKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingSectionKey.class);
  }

}
