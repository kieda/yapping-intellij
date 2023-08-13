// This is a generated file. Not intended for manual editing.
package io.hostilerobot.yapping.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.hostilerobot.yapping.parser.YappingTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class YappingParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return yapping(b, l + 1);
  }

  /* ********************************************************** */
  // FPATH_START spacing FSCOPE
  public static boolean FPATH(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FPATH")) return false;
    if (!nextTokenIs(b, FPATH_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPATH_START);
    r = r && spacing(b, l + 1);
    r = r && FSCOPE(b, l + 1);
    exit_section_(b, m, FPATH, r);
    return r;
  }

  /* ********************************************************** */
  // FSCOPE_SEGMENT spacing (SLASH spacing FSCOPE)?
  static boolean FSCOPE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FSCOPE_SEGMENT(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && FSCOPE_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SLASH spacing FSCOPE)?
  private static boolean FSCOPE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_2")) return false;
    FSCOPE_2_0(b, l + 1);
    return true;
  }

  // SLASH spacing FSCOPE
  private static boolean FSCOPE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLASH);
    r = r && spacing(b, l + 1);
    r = r && FSCOPE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (REGEX|FNAME|LITERAL)+
  static boolean FSCOPE_SEGMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_SEGMENT")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FSCOPE_SEGMENT_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FSCOPE_SEGMENT_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FSCOPE_SEGMENT", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // REGEX|FNAME|LITERAL
  private static boolean FSCOPE_SEGMENT_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_SEGMENT_0")) return false;
    boolean r;
    r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, FNAME);
    if (!r) r = consumeToken(b, LITERAL);
    return r;
  }

  /* ********************************************************** */
  // JPATH_START spacing JSCOPE
  public static boolean JPATH(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JPATH")) return false;
    if (!nextTokenIs(b, JPATH_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JPATH_START);
    r = r && spacing(b, l + 1);
    r = r && JSCOPE(b, l + 1);
    exit_section_(b, m, JPATH, r);
    return r;
  }

  /* ********************************************************** */
  // JSCOPE_SEGMENT spacing (DOT spacing JSCOPE)?
  static boolean JSCOPE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JSCOPE_SEGMENT(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && JSCOPE_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT spacing JSCOPE)?
  private static boolean JSCOPE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_2")) return false;
    JSCOPE_2_0(b, l + 1);
    return true;
  }

  // DOT spacing JSCOPE
  private static boolean JSCOPE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && spacing(b, l + 1);
    r = r && JSCOPE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // JBODY|JSCOPE_PART
  static boolean JSCOPE_BODY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_BODY")) return false;
    boolean r;
    r = consumeToken(b, JBODY);
    if (!r) r = JSCOPE_PART(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // REGEX|LITERAL
  static boolean JSCOPE_PART(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_PART")) return false;
    if (!nextTokenIs(b, "", LITERAL, REGEX)) return false;
    boolean r;
    r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, LITERAL);
    return r;
  }

  /* ********************************************************** */
  // JSCOPE_START JSCOPE_BODY*
  static boolean JSCOPE_SEGMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_SEGMENT")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JSCOPE_START(b, l + 1);
    r = r && JSCOPE_SEGMENT_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // JSCOPE_BODY*
  private static boolean JSCOPE_SEGMENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_SEGMENT_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!JSCOPE_BODY(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "JSCOPE_SEGMENT_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // JNAME|JSCOPE_PART
  static boolean JSCOPE_START(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_START")) return false;
    boolean r;
    r = consumeToken(b, JNAME);
    if (!r) r = JSCOPE_PART(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (NATURAL (YSEG_START YSEG_PART*)?)|(YNAME YSEG_PART*)|(YSEG_START YSEG_PART*)
  public static boolean YSEGMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YSEGMENT, "<ysegment>");
    r = YSEGMENT_0(b, l + 1);
    if (!r) r = YSEGMENT_1(b, l + 1);
    if (!r) r = YSEGMENT_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NATURAL (YSEG_START YSEG_PART*)?
  private static boolean YSEGMENT_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NATURAL);
    r = r && YSEGMENT_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (YSEG_START YSEG_PART*)?
  private static boolean YSEGMENT_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_0_1")) return false;
    YSEGMENT_0_1_0(b, l + 1);
    return true;
  }

  // YSEG_START YSEG_PART*
  private static boolean YSEGMENT_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = YSEG_START(b, l + 1);
    r = r && YSEGMENT_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YSEG_PART*
  private static boolean YSEGMENT_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_0_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!YSEG_PART(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "YSEGMENT_0_1_0_1", c)) break;
    }
    return true;
  }

  // YNAME YSEG_PART*
  private static boolean YSEGMENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YNAME);
    r = r && YSEGMENT_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YSEG_PART*
  private static boolean YSEGMENT_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!YSEG_PART(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "YSEGMENT_1_1", c)) break;
    }
    return true;
  }

  // YSEG_START YSEG_PART*
  private static boolean YSEGMENT_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = YSEG_START(b, l + 1);
    r = r && YSEGMENT_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YSEG_PART*
  private static boolean YSEGMENT_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEGMENT_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!YSEG_PART(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "YSEGMENT_2_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // YBODY|NATURAL|LITERAL|REGEX
  static boolean YSEG_PART(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEG_PART")) return false;
    boolean r;
    r = consumeToken(b, YBODY);
    if (!r) r = consumeToken(b, NATURAL);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, REGEX);
    return r;
  }

  /* ********************************************************** */
  // LITERAL|REGEX
  static boolean YSEG_START(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YSEG_START")) return false;
    if (!nextTokenIs(b, "", LITERAL, REGEX)) return false;
    boolean r;
    r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, REGEX);
    return r;
  }

  /* ********************************************************** */
  // JPATH|FPATH|YSEGMENT|COMMENT|WHITESPACE
  public static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM, "<item>");
    r = JPATH(b, l + 1);
    if (!r) r = FPATH(b, l + 1);
    if (!r) r = YSEGMENT(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, WHITESPACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (WHITESPACE|COMMENT)*
  static boolean spacing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spacing")) return false;
    while (true) {
      int c = current_position_(b);
      if (!spacing_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "spacing", c)) break;
    }
    return true;
  }

  // WHITESPACE|COMMENT
  private static boolean spacing_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spacing_0")) return false;
    boolean r;
    r = consumeToken(b, WHITESPACE);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // item*
  static boolean yapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yapping")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "yapping", c)) break;
    }
    return true;
  }

}
