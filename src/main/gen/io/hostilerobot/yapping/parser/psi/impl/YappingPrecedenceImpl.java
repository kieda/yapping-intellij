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

public class YappingPrecedenceImpl extends ASTWrapperPsiElement implements YappingPrecedence {

  public YappingPrecedenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YappingVisitor visitor) {
    visitor.visitPrecedence(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YappingVisitor) accept((YappingVisitor)visitor);
    else super.accept(visitor);
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

  @Override
  @Nullable
  public YappingMap getMap() {
    return findChildByClass(YappingMap.class);
  }

  @Override
  @Nullable
  public YappingPairBounded getPairBounded() {
    return findChildByClass(YappingPairBounded.class);
  }

  @Override
  @Nullable
  public YappingPrecedence getPrecedence() {
    return findChildByClass(YappingPrecedence.class);
  }

  @Override
  @Nullable
  public YappingProperties getProperties() {
    return findChildByClass(YappingProperties.class);
  }

  @Override
  @Nullable
  public YappingQuotient getQuotient() {
    return findChildByClass(YappingQuotient.class);
  }

  @Override
  @Nullable
  public YappingReal getReal() {
    return findChildByClass(YappingReal.class);
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

  @Override
  @Nullable
  public YappingFPath getFPath() {
    return findChildByClass(YappingFPath.class);
  }

  @Override
  @Nullable
  public YappingJPath getJPath() {
    return findChildByClass(YappingJPath.class);
  }

  @Override
  @Nullable
  public YappingYPath1 getYPath1() {
    return findChildByClass(YappingYPath1.class);
  }

  @Override
  @Nullable
  public YappingYSegmentMulti getYSegmentMulti() {
    return findChildByClass(YappingYSegmentMulti.class);
  }

}
