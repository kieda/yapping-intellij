// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import io.hostilerobot.yapping.parser.grammar.RecursiveListAccessible;
import io.hostilerobot.yapping.parser.grammar.ListAccessible;

public class YappingVisitor extends PsiElementVisitor {

  public void visitInteger(@NotNull YappingInteger o) {
    visitPsiElement(o);
  }

  public void visitList(@NotNull YappingList o) {
    visitListAccessible(o);
  }

  public void visitMap(@NotNull YappingMap o) {
    visitListAccessible(o);
  }

  public void visitPairBounded(@NotNull YappingPairBounded o) {
    visitPsiElement(o);
  }

  public void visitPairExpr(@NotNull YappingPairExpr o) {
    visitPsiElement(o);
  }

  public void visitPrecedence(@NotNull YappingPrecedence o) {
    visitPsiElement(o);
  }

  public void visitProperties(@NotNull YappingProperties o) {
    visitRecursiveListAccessible(o);
  }

  public void visitQuotient(@NotNull YappingQuotient o) {
    visitPsiElement(o);
  }

  public void visitReal(@NotNull YappingReal o) {
    visitPsiElement(o);
  }

  public void visitTransitionLBounded(@NotNull YappingTransitionLBounded o) {
    visitPsiElement(o);
  }

  public void visitTransitionLExpr(@NotNull YappingTransitionLExpr o) {
    visitPsiElement(o);
  }

  public void visitTransitionRBounded(@NotNull YappingTransitionRBounded o) {
    visitPsiElement(o);
  }

  public void visitTransitionRExpr(@NotNull YappingTransitionRExpr o) {
    visitPsiElement(o);
  }

  public void visitFPath(@NotNull YappingFPath o) {
    visitPsiElement(o);
  }

  public void visitJPath(@NotNull YappingJPath o) {
    visitPsiElement(o);
  }

  public void visitYPath1(@NotNull YappingYPath1 o) {
    visitPsiElement(o);
  }

  public void visitYSegmentMulti(@NotNull YappingYSegmentMulti o) {
    visitPsiElement(o);
  }

  public void visitListAccessible(@NotNull ListAccessible o) {
    visitElement(o);
  }

  public void visitRecursiveListAccessible(@NotNull RecursiveListAccessible o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
