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
import io.hostilerobot.yapping.parser.grammar.YappingStructureUtil;
import com.intellij.psi.tree.IElementType;

public class YappingPropertiesImpl extends ASTWrapperPsiElement implements YappingProperties {

  public YappingPropertiesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitProperties(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YappingInteger> getIntegerList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingInteger.class);
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
  public List<YappingPairExpr> getPairExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingPairExpr.class);
  }

  @Override
  @NotNull
  public List<YappingPrecedence> getPrecedenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingPrecedence.class);
  }

  @Override
  @Nullable
  public YappingProperties getProperties() {
    return findChildByClass(YappingProperties.class);
  }

  @Override
  @NotNull
  public List<YappingQuotient> getQuotientList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingQuotient.class);
  }

  @Override
  @NotNull
  public List<YappingReal> getRealList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingReal.class);
  }

  @Override
  @NotNull
  public List<YappingTransitionLExpr> getTransitionLExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingTransitionLExpr.class);
  }

  @Override
  @NotNull
  public List<YappingTransitionRExpr> getTransitionRExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingTransitionRExpr.class);
  }

  @Override
  @NotNull
  public List<YappingFPath> getFPathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingFPath.class);
  }

  @Override
  @NotNull
  public List<YappingJPath> getJPathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingJPath.class);
  }

  @Override
  @NotNull
  public List<YappingYPath1> getYPath1List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingYPath1.class);
  }

  @Override
  @NotNull
  public List<YappingYSegmentMulti> getYSegmentMultiList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YappingYSegmentMulti.class);
  }

  @Override
  public boolean isRecursiveType(IElementType type) {
    return YappingStructureUtil.isRecursiveType(this, type);
  }

  @Override
  public boolean isElementType(IElementType type) {
    return YappingStructureUtil.isElementType(this, type);
  }

}
