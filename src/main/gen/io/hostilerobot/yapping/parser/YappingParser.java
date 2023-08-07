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
    return SIGN(b, l + 1);
  }

  /* ********************************************************** */
  // PROPERTIES_SEP? MPROPERTIES PROPERTIES_SEP?
  public static boolean APROPERTIES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "APROPERTIES")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APROPERTIES, "<aproperties>");
    r = APROPERTIES_0(b, l + 1);
    r = r && MPROPERTIES(b, l + 1);
    r = r && APROPERTIES_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PROPERTIES_SEP?
  private static boolean APROPERTIES_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "APROPERTIES_0")) return false;
    consumeToken(b, PROPERTIES_SEP);
    return true;
  }

  // PROPERTIES_SEP?
  private static boolean APROPERTIES_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "APROPERTIES_2")) return false;
    consumeToken(b, PROPERTIES_SEP);
    return true;
  }

  /* ********************************************************** */
  // LIST|PRIMITIVE
  public static boolean BASE_DATA(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BASE_DATA")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_DATA, "<base data>");
    r = LIST(b, l + 1);
    if (!r) r = PRIMITIVE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PROPERTIES_SEP MPROPERTIES PROPERTIES_SEP
  public static boolean CPROPERTIES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CPROPERTIES")) return false;
    if (!nextTokenIs(b, PROPERTIES_SEP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTIES_SEP);
    r = r && MPROPERTIES(b, l + 1);
    r = r && consumeToken(b, PROPERTIES_SEP);
    exit_section_(b, m, CPROPERTIES, r);
    return r;
  }

  /* ********************************************************** */
  // ()
  static boolean EMPTY(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // FPATH_START FSCOPE
  public static boolean FPATH(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FPATH")) return false;
    if (!nextTokenIs(b, FPATH_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPATH_START);
    r = r && FSCOPE(b, l + 1);
    exit_section_(b, m, FPATH, r);
    return r;
  }

  /* ********************************************************** */
  // (SIGN? NATURAL)? SIGN? NATURAL FRACTION_SEP NATURAL
  public static boolean FRACTION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FRACTION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FRACTION, "<fraction>");
    r = FRACTION_0(b, l + 1);
    r = r && FRACTION_1(b, l + 1);
    r = r && consumeTokens(b, 0, NATURAL, FRACTION_SEP, NATURAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (SIGN? NATURAL)?
  private static boolean FRACTION_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FRACTION_0")) return false;
    FRACTION_0_0(b, l + 1);
    return true;
  }

  // SIGN? NATURAL
  private static boolean FRACTION_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FRACTION_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FRACTION_0_0_0(b, l + 1);
    r = r && consumeToken(b, NATURAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // SIGN?
  private static boolean FRACTION_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FRACTION_0_0_0")) return false;
    SIGN(b, l + 1);
    return true;
  }

  // SIGN?
  private static boolean FRACTION_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FRACTION_1")) return false;
    SIGN(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FSCOPE_SEGMENT (SLASH FSCOPE)?
  static boolean FSCOPE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FSCOPE_SEGMENT(b, l + 1);
    r = r && FSCOPE_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SLASH FSCOPE)?
  private static boolean FSCOPE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_1")) return false;
    FSCOPE_1_0(b, l + 1);
    return true;
  }

  // SLASH FSCOPE
  private static boolean FSCOPE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLASH);
    r = r && FSCOPE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (REGEX|FNAME|LITERAL)+
  public static boolean FSCOPE_SEGMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FSCOPE_SEGMENT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FSCOPE_SEGMENT, "<fscope segment>");
    r = FSCOPE_SEGMENT_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FSCOPE_SEGMENT_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FSCOPE_SEGMENT", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
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
  // NATURAL REGEX_EXPECTED
  public static boolean INDEX_RESOLUTION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDEX_RESOLUTION")) return false;
    if (!nextTokenIs(b, NATURAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NATURAL);
    r = r && REGEX_EXPECTED(b, l + 1);
    exit_section_(b, m, INDEX_RESOLUTION, r);
    return r;
  }

  /* ********************************************************** */
  // SIGN? NATURAL
  public static boolean INTEGER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER, "<integer>");
    r = INTEGER_0(b, l + 1);
    r = r && consumeToken(b, NATURAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SIGN?
  private static boolean INTEGER_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER_0")) return false;
    SIGN(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // JPATH_START JSCOPE
  public static boolean JPATH(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JPATH")) return false;
    if (!nextTokenIs(b, JPATH_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JPATH_START);
    r = r && JSCOPE(b, l + 1);
    exit_section_(b, m, JPATH, r);
    return r;
  }

  /* ********************************************************** */
  // JSCOPE_SEGMENT (DOT JSCOPE)?
  static boolean JSCOPE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JSCOPE_SEGMENT(b, l + 1);
    r = r && JSCOPE_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT JSCOPE)?
  private static boolean JSCOPE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_1")) return false;
    JSCOPE_1_0(b, l + 1);
    return true;
  }

  // DOT JSCOPE
  private static boolean JSCOPE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && JSCOPE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // JSCOPE_STR (JSCOPE_STR|NATURAL)*
  public static boolean JSCOPE_SEGMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_SEGMENT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSCOPE_SEGMENT, "<jscope segment>");
    r = JSCOPE_STR(b, l + 1);
    r = r && JSCOPE_SEGMENT_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (JSCOPE_STR|NATURAL)*
  private static boolean JSCOPE_SEGMENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_SEGMENT_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!JSCOPE_SEGMENT_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "JSCOPE_SEGMENT_1", c)) break;
    }
    return true;
  }

  // JSCOPE_STR|NATURAL
  private static boolean JSCOPE_SEGMENT_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_SEGMENT_1_0")) return false;
    boolean r;
    r = JSCOPE_STR(b, l + 1);
    if (!r) r = consumeToken(b, NATURAL);
    return r;
  }

  /* ********************************************************** */
  // REGEX|NAME|LITERAL
  static boolean JSCOPE_STR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JSCOPE_STR")) return false;
    boolean r;
    r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, LITERAL);
    return r;
  }

  /* ********************************************************** */
  // LIST_START LIST_END
  //     | LIST_START LIST_DATA (LIST_ITEM_SEP LIST_DATA)* LIST_END
  public static boolean LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIST")) return false;
    if (!nextTokenIs(b, LIST_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, LIST_START, LIST_END);
    if (!r) r = LIST_1(b, l + 1);
    exit_section_(b, m, LIST, r);
    return r;
  }

  // LIST_START LIST_DATA (LIST_ITEM_SEP LIST_DATA)* LIST_END
  private static boolean LIST_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIST_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LIST_START);
    r = r && LIST_DATA(b, l + 1);
    r = r && LIST_1_2(b, l + 1);
    r = r && consumeToken(b, LIST_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LIST_ITEM_SEP LIST_DATA)*
  private static boolean LIST_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIST_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LIST_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LIST_1_2", c)) break;
    }
    return true;
  }

  // LIST_ITEM_SEP LIST_DATA
  private static boolean LIST_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIST_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LIST_ITEM_SEP);
    r = r && LIST_DATA(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BASE_DATA|APROPERTIES|PAIR
  static boolean LIST_DATA(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIST_DATA")) return false;
    boolean r;
    r = BASE_DATA(b, l + 1);
    if (!r) r = APROPERTIES(b, l + 1);
    if (!r) r = PAIR(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PROPERTIES_SEP MPROPERTIES PROPERTIES_SEP?
  public static boolean LPROPERTIES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LPROPERTIES")) return false;
    if (!nextTokenIs(b, PROPERTIES_SEP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTIES_SEP);
    r = r && MPROPERTIES(b, l + 1);
    r = r && LPROPERTIES_2(b, l + 1);
    exit_section_(b, m, LPROPERTIES, r);
    return r;
  }

  // PROPERTIES_SEP?
  private static boolean LPROPERTIES_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LPROPERTIES_2")) return false;
    consumeToken(b, PROPERTIES_SEP);
    return true;
  }

  /* ********************************************************** */
  // MAP_START
  //         MAP_END
  public static boolean MAP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MAP")) return false;
    if (!nextTokenIs(b, MAP_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MAP_START, MAP_END);
    exit_section_(b, m, MAP, r);
    return r;
  }

  /* ********************************************************** */
  // (SECTION_KEY PROPERTIES_SEP SECTION_BODY)+
  public static boolean MPROPERTIES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MPROPERTIES")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MPROPERTIES, "<mproperties>");
    r = MPROPERTIES_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!MPROPERTIES_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MPROPERTIES", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SECTION_KEY PROPERTIES_SEP SECTION_BODY
  private static boolean MPROPERTIES_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MPROPERTIES_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SECTION_KEY(b, l + 1);
    r = r && consumeToken(b, PROPERTIES_SEP);
    r = r && SECTION_BODY(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NATURAL REGEX_EXPECTED|REGEX NAT_ALLOWED|EMPTY
  static boolean NAT_ALLOWED(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NAT_ALLOWED")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NAT_ALLOWED_0(b, l + 1);
    if (!r) r = NAT_ALLOWED_1(b, l + 1);
    if (!r) r = EMPTY(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NATURAL REGEX_EXPECTED
  private static boolean NAT_ALLOWED_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NAT_ALLOWED_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NATURAL);
    r = r && REGEX_EXPECTED(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // REGEX NAT_ALLOWED
  private static boolean NAT_ALLOWED_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NAT_ALLOWED_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REGEX);
    r = r && NAT_ALLOWED(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PAIR_KEY_DATA PAIR_SEP PAIR_VAL_DATA
  public static boolean PAIR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PAIR")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR, "<pair>");
    r = PAIR_KEY_DATA(b, l + 1);
    r = r && consumeToken(b, PAIR_SEP);
    r = r && PAIR_VAL_DATA(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RPROPERTIES|BASE_DATA
  static boolean PAIR_KEY_DATA(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PAIR_KEY_DATA")) return false;
    boolean r;
    r = RPROPERTIES(b, l + 1);
    if (!r) r = BASE_DATA(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LIST_DATA
  static boolean PAIR_VAL_DATA(PsiBuilder b, int l) {
    return LIST_DATA(b, l + 1);
  }

  /* ********************************************************** */
  // DECIMAL|INTEGER|REGEX|NAME|LITERAL|FRACTION
  static boolean PRIMITIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PRIMITIVE")) return false;
    boolean r;
    r = consumeToken(b, DECIMAL);
    if (!r) r = INTEGER(b, l + 1);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = FRACTION(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // REGEX NAT_ALLOWED|EMPTY
  static boolean REGEX_EXPECTED(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REGEX_EXPECTED")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = REGEX_EXPECTED_0(b, l + 1);
    if (!r) r = EMPTY(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // REGEX NAT_ALLOWED
  private static boolean REGEX_EXPECTED_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REGEX_EXPECTED_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REGEX);
    r = r && NAT_ALLOWED(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTIES_SEP? MPROPERTIES PROPERTIES_END
  public static boolean RPROPERTIES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RPROPERTIES")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RPROPERTIES, "<rproperties>");
    r = RPROPERTIES_0(b, l + 1);
    r = r && MPROPERTIES(b, l + 1);
    r = r && consumeToken(b, PROPERTIES_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PROPERTIES_SEP?
  private static boolean RPROPERTIES_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RPROPERTIES_0")) return false;
    consumeToken(b, PROPERTIES_SEP);
    return true;
  }

  /* ********************************************************** */
  // DOT (JSCOPE_SEGMENT | INDEX_RESOLUTION)\
  public static boolean SCOPE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCOPE")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && SCOPE_1(b, l + 1);
    exit_section_(b, m, SCOPE, r);
    return r;
  }

  // JSCOPE_SEGMENT | INDEX_RESOLUTION
  private static boolean SCOPE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCOPE_1")) return false;
    boolean r;
    r = JSCOPE_SEGMENT(b, l + 1);
    if (!r) r = INDEX_RESOLUTION(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SECTION_DATA*
  public static boolean SECTION_BODY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SECTION_BODY")) return false;
    Marker m = enter_section_(b, l, _NONE_, SECTION_BODY, "<section body>");
    while (true) {
      int c = current_position_(b);
      if (!SECTION_DATA(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SECTION_BODY", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // BASE_DATA|CPROPERTIES|PAIR
  public static boolean SECTION_DATA(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SECTION_DATA")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SECTION_DATA, "<section data>");
    r = BASE_DATA(b, l + 1);
    if (!r) r = CPROPERTIES(b, l + 1);
    if (!r) r = PAIR(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (BASE_DATA|CPROPERTIES) SCOPE|LIST|JSCOPE_SEGMENT
  public static boolean SECTION_KEY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SECTION_KEY")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SECTION_KEY, "<section key>");
    r = SECTION_KEY_0(b, l + 1);
    if (!r) r = LIST(b, l + 1);
    if (!r) r = JSCOPE_SEGMENT(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BASE_DATA|CPROPERTIES) SCOPE
  private static boolean SECTION_KEY_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SECTION_KEY_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SECTION_KEY_0_0(b, l + 1);
    r = r && SCOPE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BASE_DATA|CPROPERTIES
  private static boolean SECTION_KEY_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SECTION_KEY_0_0")) return false;
    boolean r;
    r = BASE_DATA(b, l + 1);
    if (!r) r = CPROPERTIES(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PLUS|MINUS
  static boolean SIGN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIGN")) return false;
    if (!nextTokenIs(b, "", MINUS, PLUS)) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

}
