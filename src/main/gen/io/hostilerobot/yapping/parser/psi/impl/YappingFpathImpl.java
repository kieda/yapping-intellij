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

public class YappingFPathImpl extends ASTWrapperPsiElement implements YappingFPath {

  public YappingFPathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitFPath(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YappingList> getListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingList.class);
  }

  @Override
  @NotNull
  public List<YappingMap> getMapList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingMap.class);
  }

  @Override
  @NotNull
  public List<YappingPrecedence> getPrecedenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingPrecedence.class);
  }

}
