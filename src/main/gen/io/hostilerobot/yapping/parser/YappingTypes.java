// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.hostilerobot.yapping.parser.token.YappingElementType;
import io.hostilerobot.yapping.parser.token.YappingTokenType;
import io.hostilerobot.yapping.parser.psi.impl.*;

public interface YappingTypes {

  IElementType APROPERTIES = new YappingElementType("APROPERTIES");
  IElementType BASE_DATA = new YappingElementType("BASE_DATA");
  IElementType CPROPERTIES = new YappingElementType("CPROPERTIES");
  IElementType FPATH = new YappingElementType("FPATH");
  IElementType FRACTION = new YappingElementType("FRACTION");
  IElementType FSCOPE_SEGMENT = new YappingElementType("FSCOPE_SEGMENT");
  IElementType INDEX_RESOLUTION = new YappingElementType("INDEX_RESOLUTION");
  IElementType INTEGER = new YappingElementType("INTEGER");
  IElementType JPATH = new YappingElementType("JPATH");
  IElementType JSCOPE_SEGMENT = new YappingElementType("JSCOPE_SEGMENT");
  IElementType LIST = new YappingElementType("LIST");
  IElementType LPROPERTIES = new YappingElementType("LPROPERTIES");
  IElementType MAP = new YappingElementType("MAP");
  IElementType MPROPERTIES = new YappingElementType("MPROPERTIES");
  IElementType PAIR = new YappingElementType("PAIR");
  IElementType RPROPERTIES = new YappingElementType("RPROPERTIES");
  IElementType SCOPE = new YappingElementType("SCOPE");
  IElementType SECTION_BODY = new YappingElementType("SECTION_BODY");
  IElementType SECTION_DATA = new YappingElementType("SECTION_DATA");
  IElementType SECTION_KEY = new YappingElementType("SECTION_KEY");

  IElementType DECIMAL = new YappingTokenType("DECIMAL");
  IElementType DOT = new YappingTokenType("DOT");
  IElementType FNAME = new YappingTokenType("FNAME");
  IElementType FPATH_START = new YappingTokenType("FPATH_START");
  IElementType FRACTION_SEP = new YappingTokenType("FRACTION_SEP");
  IElementType JPATH_START = new YappingTokenType("JPATH_START");
  IElementType LIST_END = new YappingTokenType("LIST_END");
  IElementType LIST_ITEM_SEP = new YappingTokenType("LIST_ITEM_SEP");
  IElementType LIST_START = new YappingTokenType("LIST_START");
  IElementType LITERAL = new YappingTokenType("LITERAL");
  IElementType MAP_END = new YappingTokenType("MAP_END");
  IElementType MAP_START = new YappingTokenType("MAP_START");
  IElementType MINUS = new YappingTokenType("MINUS");
  IElementType NAME = new YappingTokenType("NAME");
  IElementType NATURAL = new YappingTokenType("NATURAL");
  IElementType PAIR_SEP = new YappingTokenType("PAIR_SEP");
  IElementType PLUS = new YappingTokenType("PLUS");
  IElementType PROPERTIES_END = new YappingTokenType("PROPERTIES_END");
  IElementType PROPERTIES_SEP = new YappingTokenType("PROPERTIES_SEP");
  IElementType REGEX = new YappingTokenType("REGEX");
  IElementType SLASH = new YappingTokenType("SLASH");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == APROPERTIES) {
        return new YappingApropertiesImpl(node);
      }
      else if (type == BASE_DATA) {
        return new YappingBaseDataImpl(node);
      }
      else if (type == CPROPERTIES) {
        return new YappingCpropertiesImpl(node);
      }
      else if (type == FPATH) {
        return new YappingFpathImpl(node);
      }
      else if (type == FRACTION) {
        return new YappingFractionImpl(node);
      }
      else if (type == FSCOPE_SEGMENT) {
        return new YappingFscopeSegmentImpl(node);
      }
      else if (type == INDEX_RESOLUTION) {
        return new YappingIndexResolutionImpl(node);
      }
      else if (type == INTEGER) {
        return new YappingIntegerImpl(node);
      }
      else if (type == JPATH) {
        return new YappingJpathImpl(node);
      }
      else if (type == JSCOPE_SEGMENT) {
        return new YappingJscopeSegmentImpl(node);
      }
      else if (type == LIST) {
        return new YappingListImpl(node);
      }
      else if (type == LPROPERTIES) {
        return new YappingLpropertiesImpl(node);
      }
      else if (type == MAP) {
        return new YappingMapImpl(node);
      }
      else if (type == MPROPERTIES) {
        return new YappingMpropertiesImpl(node);
      }
      else if (type == PAIR) {
        return new YappingPairImpl(node);
      }
      else if (type == RPROPERTIES) {
        return new YappingRpropertiesImpl(node);
      }
      else if (type == SCOPE) {
        return new YappingScopeImpl(node);
      }
      else if (type == SECTION_BODY) {
        return new YappingSectionBodyImpl(node);
      }
      else if (type == SECTION_DATA) {
        return new YappingSectionDataImpl(node);
      }
      else if (type == SECTION_KEY) {
        return new YappingSectionKeyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
