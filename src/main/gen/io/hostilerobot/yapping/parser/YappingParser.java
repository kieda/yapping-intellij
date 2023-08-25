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
  // yPath1|jPath|fPath // paths. final path is a two part or more yapping segment
  //     |ySegmentMulti  // single yapping segment (not a path)
  //     |Precedence // (x)
  //     |Map|List   // composite data
  //     |REAL|QUOTIENT|INTEGER  // primitive - numbers
  //     |REGEX|LITERAL|YNAME
  public static boolean BaseData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseData")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_DATA, "<base data>");
    r = yPath1(b, l + 1);
    if (!r) r = jPath(b, l + 1);
    if (!r) r = fPath(b, l + 1);
    if (!r) r = ySegmentMulti(b, l + 1);
    if (!r) r = Precedence(b, l + 1);
    if (!r) r = Map(b, l + 1);
    if (!r) r = List(b, l + 1);
    if (!r) r = REAL(b, l + 1);
    if (!r) r = QUOTIENT(b, l + 1);
    if (!r) r = INTEGER(b, l + 1);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, YNAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PairBounded|TransitionLBounded|TransitionRBounded|Properties|BaseData
  public static boolean BoundedData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoundedData")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOUNDED_DATA, "<bounded data>");
    r = PairBounded(b, l + 1);
    if (!r) r = TransitionLBounded(b, l + 1);
    if (!r) r = TransitionRBounded(b, l + 1);
    if (!r) r = Properties(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NATURAL DOT NATURAL
  public static boolean DECIMAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DECIMAL")) return false;
    if (!nextTokenIs(b, NATURAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NATURAL, DOT, NATURAL);
    exit_section_(b, m, DECIMAL, r);
    return r;
  }

  /* ********************************************************** */
  // (SIGN spacing)? NATURAL
  public static boolean INTEGER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER, "<integer>");
    r = INTEGER_0(b, l + 1);
    r = r && consumeToken(b, NATURAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (SIGN spacing)?
  private static boolean INTEGER_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER_0")) return false;
    INTEGER_0_0(b, l + 1);
    return true;
  }

  // SIGN spacing
  private static boolean INTEGER_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SIGN(b, l + 1);
    r = r && spacing(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (LIST_START LIST_END) // []
  //     // [a[, b]*]
  //     | LIST_START spacing BoundedData (spacing LIST_SEP spacing BoundedData)* spacing LIST_END
  public static boolean List(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "List")) return false;
    if (!nextTokenIs(b, LIST_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = List_0(b, l + 1);
    if (!r) r = List_1(b, l + 1);
    exit_section_(b, m, LIST, r);
    return r;
  }

  // LIST_START LIST_END
  private static boolean List_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "List_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LIST_START, LIST_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // LIST_START spacing BoundedData (spacing LIST_SEP spacing BoundedData)* spacing LIST_END
  private static boolean List_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "List_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LIST_START);
    r = r && spacing(b, l + 1);
    r = r && BoundedData(b, l + 1);
    r = r && List_1_3(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, LIST_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // (spacing LIST_SEP spacing BoundedData)*
  private static boolean List_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "List_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!List_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "List_1_3", c)) break;
    }
    return true;
  }

  // spacing LIST_SEP spacing BoundedData
  private static boolean List_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "List_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spacing(b, l + 1);
    r = r && consumeToken(b, LIST_SEP);
    r = r && spacing(b, l + 1);
    r = r && BoundedData(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (MAP_START spacing MAP_END) // {}
  //     // { a = b[, c = d]* }
  //     | (MAP_START spacing PairBounded (spacing LIST_SEP spacing PairBounded)* spacing MAP_END)
  public static boolean Map(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Map")) return false;
    if (!nextTokenIs(b, MAP_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Map_0(b, l + 1);
    if (!r) r = Map_1(b, l + 1);
    exit_section_(b, m, MAP, r);
    return r;
  }

  // MAP_START spacing MAP_END
  private static boolean Map_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Map_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MAP_START);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, MAP_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // MAP_START spacing PairBounded (spacing LIST_SEP spacing PairBounded)* spacing MAP_END
  private static boolean Map_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Map_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MAP_START);
    r = r && spacing(b, l + 1);
    r = r && PairBounded(b, l + 1);
    r = r && Map_1_3(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, MAP_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // (spacing LIST_SEP spacing PairBounded)*
  private static boolean Map_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Map_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Map_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Map_1_3", c)) break;
    }
    return true;
  }

  // spacing LIST_SEP spacing PairBounded
  private static boolean Map_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Map_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spacing(b, l + 1);
    r = r && consumeToken(b, LIST_SEP);
    r = r && spacing(b, l + 1);
    r = r && PairBounded(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PairExpr|TransitionLExpr|TransitionRExpr|BaseData
  public static boolean Pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR, "<pair>");
    r = PairExpr(b, l + 1);
    if (!r) r = TransitionLExpr(b, l + 1);
    if (!r) r = TransitionRExpr(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (TransitionLExpr|TransitionRExpr|BaseData) spacing PAIR_SEP spacing BoundedData
  public static boolean PairBounded(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PairBounded")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR_BOUNDED, "<pair bounded>");
    r = PairBounded_0(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, PAIR_SEP);
    r = r && spacing(b, l + 1);
    r = r && BoundedData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TransitionLExpr|TransitionRExpr|BaseData
  private static boolean PairBounded_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PairBounded_0")) return false;
    boolean r;
    r = TransitionLExpr(b, l + 1);
    if (!r) r = TransitionRExpr(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (TransitionLExpr|TransitionRExpr|BaseData) spacing PAIR_SEP spacing Pair
  public static boolean PairExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PairExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR_EXPR, "<pair expr>");
    r = PairExpr_0(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, PAIR_SEP);
    r = r && spacing(b, l + 1);
    r = r && Pair(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TransitionLExpr|TransitionRExpr|BaseData
  private static boolean PairExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PairExpr_0")) return false;
    boolean r;
    r = TransitionLExpr(b, l + 1);
    if (!r) r = TransitionRExpr(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PRECEDENCE_START spacing BoundedData spacing PRECEDENCE_END
  public static boolean Precedence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Precedence")) return false;
    if (!nextTokenIs(b, PRECEDENCE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PRECEDENCE_START);
    r = r && spacing(b, l + 1);
    r = r && BoundedData(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, PRECEDENCE_END);
    exit_section_(b, m, PRECEDENCE, r);
    return r;
  }

  /* ********************************************************** */
  // BaseData spacing PROPERTY_SEP (yapping_)?
  public static boolean Properties(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Properties")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES, "<properties>");
    r = BaseData(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, PROPERTY_SEP);
    r = r && Properties_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (yapping_)?
  private static boolean Properties_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Properties_3")) return false;
    Properties_3_0(b, l + 1);
    return true;
  }

  // (yapping_)
  private static boolean Properties_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Properties_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = yapping_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (INTEGER spacing AND spacing)? INTEGER spacing SLASH spacing NATURAL
  public static boolean QUOTIENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QUOTIENT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUOTIENT, "<quotient>");
    r = QUOTIENT_0(b, l + 1);
    r = r && INTEGER(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, SLASH);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, NATURAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (INTEGER spacing AND spacing)?
  private static boolean QUOTIENT_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QUOTIENT_0")) return false;
    QUOTIENT_0_0(b, l + 1);
    return true;
  }

  // INTEGER spacing AND spacing
  private static boolean QUOTIENT_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QUOTIENT_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INTEGER(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, AND);
    r = r && spacing(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (SIGN spacing)? DECIMAL
  public static boolean REAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REAL")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL, "<real>");
    r = REAL_0(b, l + 1);
    r = r && DECIMAL(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (SIGN spacing)?
  private static boolean REAL_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REAL_0")) return false;
    REAL_0_0(b, l + 1);
    return true;
  }

  // SIGN spacing
  private static boolean REAL_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "REAL_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SIGN(b, l + 1);
    r = r && spacing(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS|MINUS
  public static boolean SIGN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIGN")) return false;
    if (!nextTokenIs(b, "<sign>", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIGN, "<sign>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Pair|TransitionLExpr|TransitionRExpr|BaseData
  public static boolean SectionData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SectionData")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SECTION_DATA, "<section data>");
    r = Pair(b, l + 1);
    if (!r) r = TransitionLExpr(b, l + 1);
    if (!r) r = TransitionRExpr(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (TransitionRExpr|BaseData) spacing TRANSITION_SEP_L spacing BoundedData
  public static boolean TransitionLBounded(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TransitionLBounded")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRANSITION_L_BOUNDED, "<transition l bounded>");
    r = TransitionLBounded_0(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, TRANSITION_SEP_L);
    r = r && spacing(b, l + 1);
    r = r && BoundedData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TransitionRExpr|BaseData
  private static boolean TransitionLBounded_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TransitionLBounded_0")) return false;
    boolean r;
    r = TransitionRExpr(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (TransitionRExpr|BaseData) spacing TRANSITION_SEP_L spacing Pair
  public static boolean TransitionLExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TransitionLExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRANSITION_L_EXPR, "<transition l expr>");
    r = TransitionLExpr_0(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, TRANSITION_SEP_L);
    r = r && spacing(b, l + 1);
    r = r && Pair(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TransitionRExpr|BaseData
  private static boolean TransitionLExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TransitionLExpr_0")) return false;
    boolean r;
    r = TransitionRExpr(b, l + 1);
    if (!r) r = BaseData(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // BaseData spacing TRANSITION_SEP_R spacing BoundedData
  public static boolean TransitionRBounded(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TransitionRBounded")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRANSITION_R_BOUNDED, "<transition r bounded>");
    r = BaseData(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, TRANSITION_SEP_R);
    r = r && spacing(b, l + 1);
    r = r && BoundedData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BaseData spacing TRANSITION_SEP_R spacing Pair
  public static boolean TransitionRExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TransitionRExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRANSITION_R_EXPR, "<transition r expr>");
    r = BaseData(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, TRANSITION_SEP_R);
    r = r && spacing(b, l + 1);
    r = r && Pair(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // REGEX|LITERAL|List|Map|Precedence
  public static boolean containedSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containedSegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINED_SEGMENT, "<contained segment>");
    r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = List(b, l + 1);
    if (!r) r = Map(b, l + 1);
    if (!r) r = Precedence(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FPATH_START spacing fScope
  public static boolean fPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fPath")) return false;
    if (!nextTokenIs(b, FPATH_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FPATH_START);
    r = r && spacing(b, l + 1);
    r = r && fScope(b, l + 1);
    exit_section_(b, m, F_PATH, r);
    return r;
  }

  /* ********************************************************** */
  // fScopeSegment (spacing SLASH spacing fScope)?
  public static boolean fScope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fScope")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, F_SCOPE, "<f scope>");
    r = fScopeSegment(b, l + 1);
    r = r && fScope_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (spacing SLASH spacing fScope)?
  private static boolean fScope_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fScope_1")) return false;
    fScope_1_0(b, l + 1);
    return true;
  }

  // spacing SLASH spacing fScope
  private static boolean fScope_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fScope_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spacing(b, l + 1);
    r = r && consumeToken(b, SLASH);
    r = r && spacing(b, l + 1);
    r = r && fScope(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fSegmentMulti | fSegmentSingle
  public static boolean fScopeSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fScopeSegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, F_SCOPE_SEGMENT, "<f scope segment>");
    r = fSegmentMulti(b, l + 1);
    if (!r) r = fSegmentSingle(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // containedSegment fSegmentInclFName?
  public static boolean fSegmentExclFName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentExclFName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, F_SEGMENT_EXCL_F_NAME, "<f segment excl f name>");
    r = containedSegment(b, l + 1);
    r = r && fSegmentExclFName_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fSegmentInclFName?
  private static boolean fSegmentExclFName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentExclFName_1")) return false;
    fSegmentInclFName(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (FNAME (fSegmentExclFName?))
  //         | fSegmentExclFName
  public static boolean fSegmentInclFName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentInclFName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, F_SEGMENT_INCL_F_NAME, "<f segment incl f name>");
    r = fSegmentInclFName_0(b, l + 1);
    if (!r) r = fSegmentExclFName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FNAME (fSegmentExclFName?)
  private static boolean fSegmentInclFName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentInclFName_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FNAME);
    r = r && fSegmentInclFName_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fSegmentExclFName?
  private static boolean fSegmentInclFName_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentInclFName_0_1")) return false;
    fSegmentExclFName(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (containedSegment fSegmentInclFName)
  //         | (FNAME fSegmentExclFName)
  public static boolean fSegmentMulti(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentMulti")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, F_SEGMENT_MULTI, "<f segment multi>");
    r = fSegmentMulti_0(b, l + 1);
    if (!r) r = fSegmentMulti_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // containedSegment fSegmentInclFName
  private static boolean fSegmentMulti_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentMulti_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = containedSegment(b, l + 1);
    r = r && fSegmentInclFName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FNAME fSegmentExclFName
  private static boolean fSegmentMulti_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentMulti_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FNAME);
    r = r && fSegmentExclFName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FNAME | containedSegment
  public static boolean fSegmentSingle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fSegmentSingle")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, F_SEGMENT_SINGLE, "<f segment single>");
    r = consumeToken(b, FNAME);
    if (!r) r = containedSegment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SectionData
  //     |COMMENT|WHITESPACE
  public static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM, "<item>");
    r = SectionData(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, WHITESPACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // JPATH_START spacing jScope
  public static boolean jPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jPath")) return false;
    if (!nextTokenIs(b, JPATH_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JPATH_START);
    r = r && spacing(b, l + 1);
    r = r && jScope(b, l + 1);
    exit_section_(b, m, J_PATH, r);
    return r;
  }

  /* ********************************************************** */
  // jScopeSegment (spacing DOT spacing jScope)?
  public static boolean jScope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jScope")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, J_SCOPE, "<j scope>");
    r = jScopeSegment(b, l + 1);
    r = r && jScope_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (spacing DOT spacing jScope)?
  private static boolean jScope_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jScope_1")) return false;
    jScope_1_0(b, l + 1);
    return true;
  }

  // spacing DOT spacing jScope
  private static boolean jScope_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jScope_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spacing(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && spacing(b, l + 1);
    r = r && jScope(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // jSegmentMulti|jSegmentSingle
  public static boolean jScopeSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jScopeSegment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, J_SCOPE_SEGMENT, "<j scope segment>");
    r = jSegmentMulti(b, l + 1);
    if (!r) r = jSegmentSingle(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // containedSegment jSegmentInclJBody?
  public static boolean jSegmentExclJBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentExclJBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, J_SEGMENT_EXCL_J_BODY, "<j segment excl j body>");
    r = containedSegment(b, l + 1);
    r = r && jSegmentExclJBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // jSegmentInclJBody?
  private static boolean jSegmentExclJBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentExclJBody_1")) return false;
    jSegmentInclJBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (JBODY jSegmentExclJBody?)
  //             | jSegmentExclJBody
  public static boolean jSegmentInclJBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentInclJBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, J_SEGMENT_INCL_J_BODY, "<j segment incl j body>");
    r = jSegmentInclJBody_0(b, l + 1);
    if (!r) r = jSegmentExclJBody(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // JBODY jSegmentExclJBody?
  private static boolean jSegmentInclJBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentInclJBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JBODY);
    r = r && jSegmentInclJBody_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // jSegmentExclJBody?
  private static boolean jSegmentInclJBody_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentInclJBody_0_1")) return false;
    jSegmentExclJBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (JNAME jSegmentExclJBody)
  //         | (containedSegment jSegmentInclJBody)
  public static boolean jSegmentMulti(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentMulti")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, J_SEGMENT_MULTI, "<j segment multi>");
    r = jSegmentMulti_0(b, l + 1);
    if (!r) r = jSegmentMulti_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // JNAME jSegmentExclJBody
  private static boolean jSegmentMulti_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentMulti_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JNAME);
    r = r && jSegmentExclJBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // containedSegment jSegmentInclJBody
  private static boolean jSegmentMulti_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentMulti_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = containedSegment(b, l + 1);
    r = r && jSegmentInclJBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // JNAME | containedSegment
  public static boolean jSegmentSingle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jSegmentSingle")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, J_SEGMENT_SINGLE, "<j segment single>");
    r = consumeToken(b, JNAME);
    if (!r) r = containedSegment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (WHITESPACE|COMMENT)*
  public static boolean spacing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spacing")) return false;
    Marker m = enter_section_(b, l, _NONE_, SPACING, "<spacing>");
    while (true) {
      int c = current_position_(b);
      if (!spacing_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "spacing", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
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
  // ((NATURAL spacing DOT spacing ySegmentExclNat) (spacing DOT spacing yPathRest)?)
  //         | (ySegmentExclNat spacing DOT spacing yPathRest)
  public static boolean yPath1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPath1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, Y_PATH_1, "<y path 1>");
    r = yPath1_0(b, l + 1);
    if (!r) r = yPath1_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NATURAL spacing DOT spacing ySegmentExclNat) (spacing DOT spacing yPathRest)?
  private static boolean yPath1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPath1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = yPath1_0_0(b, l + 1);
    r = r && yPath1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NATURAL spacing DOT spacing ySegmentExclNat
  private static boolean yPath1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPath1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NATURAL);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && spacing(b, l + 1);
    r = r && ySegmentExclNat(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (spacing DOT spacing yPathRest)?
  private static boolean yPath1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPath1_0_1")) return false;
    yPath1_0_1_0(b, l + 1);
    return true;
  }

  // spacing DOT spacing yPathRest
  private static boolean yPath1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPath1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spacing(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && spacing(b, l + 1);
    r = r && yPathRest(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ySegmentExclNat spacing DOT spacing yPathRest
  private static boolean yPath1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPath1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ySegmentExclNat(b, l + 1);
    r = r && spacing(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && spacing(b, l + 1);
    r = r && yPathRest(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (ySegmentMulti|containedSegment|YNAME|NATURAL) (spacing DOT spacing yPathRest)?
  public static boolean yPathRest(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPathRest")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, Y_PATH_REST, "<y path rest>");
    r = yPathRest_0(b, l + 1);
    r = r && yPathRest_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ySegmentMulti|containedSegment|YNAME|NATURAL
  private static boolean yPathRest_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPathRest_0")) return false;
    boolean r;
    r = ySegmentMulti(b, l + 1);
    if (!r) r = containedSegment(b, l + 1);
    if (!r) r = consumeToken(b, YNAME);
    if (!r) r = consumeToken(b, NATURAL);
    return r;
  }

  // (spacing DOT spacing yPathRest)?
  private static boolean yPathRest_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPathRest_1")) return false;
    yPathRest_1_0(b, l + 1);
    return true;
  }

  // spacing DOT spacing yPathRest
  private static boolean yPathRest_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yPathRest_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = spacing(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && spacing(b, l + 1);
    r = r && yPathRest(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ySegmentMulti | YNAME | containedSegment
  public static boolean ySegmentExclNat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentExclNat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, Y_SEGMENT_EXCL_NAT, "<y segment excl nat>");
    r = ySegmentMulti(b, l + 1);
    if (!r) r = consumeToken(b, YNAME);
    if (!r) r = containedSegment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // containedSegment ySegmentInclVals?
  public static boolean ySegmentExclVals(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentExclVals")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, Y_SEGMENT_EXCL_VALS, "<y segment excl vals>");
    r = containedSegment(b, l + 1);
    r = r && ySegmentExclVals_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ySegmentInclVals?
  private static boolean ySegmentExclVals_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentExclVals_1")) return false;
    ySegmentInclVals(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ((NATURAL|YBODY) ySegmentExclVals?)
  //         | ySegmentExclVals
  public static boolean ySegmentInclVals(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentInclVals")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, Y_SEGMENT_INCL_VALS, "<y segment incl vals>");
    r = ySegmentInclVals_0(b, l + 1);
    if (!r) r = ySegmentExclVals(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NATURAL|YBODY) ySegmentExclVals?
  private static boolean ySegmentInclVals_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentInclVals_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ySegmentInclVals_0_0(b, l + 1);
    r = r && ySegmentInclVals_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NATURAL|YBODY
  private static boolean ySegmentInclVals_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentInclVals_0_0")) return false;
    boolean r;
    r = consumeToken(b, NATURAL);
    if (!r) r = consumeToken(b, YBODY);
    return r;
  }

  // ySegmentExclVals?
  private static boolean ySegmentInclVals_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentInclVals_0_1")) return false;
    ySegmentExclVals(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (containedSegment ySegmentInclVals)
  //         | ((YNAME|NATURAL) ySegmentExclVals)
  public static boolean ySegmentMulti(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentMulti")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, Y_SEGMENT_MULTI, "<y segment multi>");
    r = ySegmentMulti_0(b, l + 1);
    if (!r) r = ySegmentMulti_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // containedSegment ySegmentInclVals
  private static boolean ySegmentMulti_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentMulti_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = containedSegment(b, l + 1);
    r = r && ySegmentInclVals(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (YNAME|NATURAL) ySegmentExclVals
  private static boolean ySegmentMulti_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentMulti_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ySegmentMulti_1_0(b, l + 1);
    r = r && ySegmentExclVals(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YNAME|NATURAL
  private static boolean ySegmentMulti_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ySegmentMulti_1_0")) return false;
    boolean r;
    r = consumeToken(b, YNAME);
    if (!r) r = consumeToken(b, NATURAL);
    return r;
  }

  /* ********************************************************** */
  // yapping_?
  static boolean yapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yapping")) return false;
    yapping_(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Properties|(item yapping_?)
  public static boolean yapping_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yapping_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YAPPING_, "<yapping>");
    r = Properties(b, l + 1);
    if (!r) r = yapping__1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // item yapping_?
  private static boolean yapping__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yapping__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item(b, l + 1);
    r = r && yapping__1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // yapping_?
  private static boolean yapping__1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yapping__1_1")) return false;
    yapping_(b, l + 1);
    return true;
  }

}
