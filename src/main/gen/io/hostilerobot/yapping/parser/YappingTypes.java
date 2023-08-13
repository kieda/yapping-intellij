// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.hostilerobot.yapping.token.YappingElementType;
import io.hostilerobot.yapping.token.YappingTokenType;
import io.hostilerobot.yapping.parser.psi.impl.*;

public interface YappingTypes {

  IElementType FPATH = new YappingElementType("FPATH");
  IElementType ITEM = new YappingElementType("ITEM");
  IElementType JPATH = new YappingElementType("JPATH");
  IElementType YSEGMENT = new YappingElementType("YSEGMENT");

  IElementType COMMENT = new YappingTokenType("COMMENT");
  IElementType DOT = new YappingTokenType("DOT");
  IElementType FNAME = new YappingTokenType("FNAME");
  IElementType FPATH_START = new YappingTokenType("FPATH_START");
  IElementType JBODY = new YappingTokenType("JBODY");
  IElementType JNAME = new YappingTokenType("JNAME");
  IElementType JPATH_START = new YappingTokenType("JPATH_START");
  IElementType LITERAL = new YappingTokenType("LITERAL");
  IElementType NATURAL = new YappingTokenType("NATURAL");
  IElementType REGEX = new YappingTokenType("REGEX");
  IElementType SLASH = new YappingTokenType("SLASH");
  IElementType WHITESPACE = new YappingTokenType("WHITESPACE");
  IElementType YBODY = new YappingTokenType("YBODY");
  IElementType YNAME = new YappingTokenType("YNAME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == FPATH) {
        return new YappingFpathImpl(node);
      }
      else if (type == ITEM) {
        return new YappingItemImpl(node);
      }
      else if (type == JPATH) {
        return new YappingJpathImpl(node);
      }
      else if (type == YSEGMENT) {
        return new YappingYsegmentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
