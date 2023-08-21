// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.hostilerobot.yapping.token.YappingElementType;
import io.hostilerobot.yapping.token.YappingTokenType;
import io.hostilerobot.yapping.parser.psi.impl.*;

public interface YappingTypes {

  IElementType BASE_DATA = new YappingElementType("BASE_DATA");
  IElementType BOUNDED_DATA = new YappingElementType("BOUNDED_DATA");
  IElementType DECIMAL = new YappingElementType("DECIMAL");
  IElementType F_PATH = new YappingElementType("F_PATH");
  IElementType INTEGER = new YappingElementType("INTEGER");
  IElementType ITEM = new YappingElementType("ITEM");
  IElementType J_PATH = new YappingElementType("J_PATH");
  IElementType LIST = new YappingElementType("LIST");
  IElementType MAP = new YappingElementType("MAP");
  IElementType PAIR = new YappingElementType("PAIR");
  IElementType PAIR_BOUNDED = new YappingElementType("PAIR_BOUNDED");
  IElementType PRECEDENCE = new YappingElementType("PRECEDENCE");
  IElementType PROPERTIES = new YappingElementType("PROPERTIES");
  IElementType QUOTIENT = new YappingElementType("QUOTIENT");
  IElementType REAL = new YappingElementType("REAL");
  IElementType SECTION_DATA = new YappingElementType("SECTION_DATA");
  IElementType TRANSITION_L = new YappingElementType("TRANSITION_L");
  IElementType TRANSITION_L_BOUNDED = new YappingElementType("TRANSITION_L_BOUNDED");
  IElementType TRANSITION_R = new YappingElementType("TRANSITION_R");
  IElementType TRANSITION_R_BOUNDED = new YappingElementType("TRANSITION_R_BOUNDED");
  IElementType Y_PATH_1 = new YappingElementType("Y_PATH_1");

  IElementType AND = new YappingTokenType("AND");
  IElementType COMMENT = new YappingTokenType("COMMENT");
  IElementType DOT = new YappingTokenType("DOT");
  IElementType FNAME = new YappingTokenType("FNAME");
  IElementType FPATH_START = new YappingTokenType("FPATH_START");
  IElementType JBODY = new YappingTokenType("JBODY");
  IElementType JNAME = new YappingTokenType("JNAME");
  IElementType JPATH_START = new YappingTokenType("JPATH_START");
  IElementType LIST_END = new YappingTokenType("LIST_END");
  IElementType LIST_SEP = new YappingTokenType("LIST_SEP");
  IElementType LIST_START = new YappingTokenType("LIST_START");
  IElementType LITERAL = new YappingTokenType("LITERAL");
  IElementType MAP_END = new YappingTokenType("MAP_END");
  IElementType MAP_START = new YappingTokenType("MAP_START");
  IElementType MINUS = new YappingTokenType("MINUS");
  IElementType NATURAL = new YappingTokenType("NATURAL");
  IElementType PAIR_SEP = new YappingTokenType("PAIR_SEP");
  IElementType PLUS = new YappingTokenType("PLUS");
  IElementType PRECEDENCE_END = new YappingTokenType("PRECEDENCE_END");
  IElementType PRECEDENCE_START = new YappingTokenType("PRECEDENCE_START");
  IElementType PROPERTY_SEP = new YappingTokenType("PROPERTY_SEP");
  IElementType REGEX = new YappingTokenType("REGEX");
  IElementType SLASH = new YappingTokenType("SLASH");
  IElementType TRANSITION_SEP_L = new YappingTokenType("TRANSITION_SEP_L");
  IElementType TRANSITION_SEP_R = new YappingTokenType("TRANSITION_SEP_R");
  IElementType WHITESPACE = new YappingTokenType("WHITESPACE");
  IElementType YBODY = new YappingTokenType("YBODY");
  IElementType YNAME = new YappingTokenType("YNAME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BASE_DATA) {
        return new YappingBaseDataImpl(node);
      }
      else if (type == BOUNDED_DATA) {
        return new YappingBoundedDataImpl(node);
      }
      else if (type == DECIMAL) {
        return new YappingDecimalImpl(node);
      }
      else if (type == F_PATH) {
        return new YappingFPathImpl(node);
      }
      else if (type == INTEGER) {
        return new YappingIntegerImpl(node);
      }
      else if (type == ITEM) {
        return new YappingItemImpl(node);
      }
      else if (type == J_PATH) {
        return new YappingJPathImpl(node);
      }
      else if (type == LIST) {
        return new YappingListImpl(node);
      }
      else if (type == MAP) {
        return new YappingMapImpl(node);
      }
      else if (type == PAIR) {
        return new YappingPairImpl(node);
      }
      else if (type == PAIR_BOUNDED) {
        return new YappingPairBoundedImpl(node);
      }
      else if (type == PRECEDENCE) {
        return new YappingPrecedenceImpl(node);
      }
      else if (type == PROPERTIES) {
        return new YappingPropertiesImpl(node);
      }
      else if (type == QUOTIENT) {
        return new YappingQuotientImpl(node);
      }
      else if (type == REAL) {
        return new YappingRealImpl(node);
      }
      else if (type == SECTION_DATA) {
        return new YappingSectionDataImpl(node);
      }
      else if (type == TRANSITION_L) {
        return new YappingTransitionLImpl(node);
      }
      else if (type == TRANSITION_L_BOUNDED) {
        return new YappingTransitionLBoundedImpl(node);
      }
      else if (type == TRANSITION_R) {
        return new YappingTransitionRImpl(node);
      }
      else if (type == TRANSITION_R_BOUNDED) {
        return new YappingTransitionRBoundedImpl(node);
      }
      else if (type == Y_PATH_1) {
        return new YappingYPath1Impl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
