// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: Yapping.flex

package io.hostilerobot.yapping.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import io.hostilerobot.yapping.parser.YappingTypes;import java.util.ArrayDeque;import java.util.Deque;


class YappingLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int LITERAL = 2;
  public static final int REGEX = 4;
  public static final int REGEX_CLASS = 6;
  public static final int BEFORE_SLASH = 8;
  public static final int AFTER_SLASH = 10;
  public static final int PENDING_SLASH = 12;
  public static final int BEFORE_JSCOPE = 14;
  public static final int AFTER_JSCOPE = 16;
  public static final int PENDING_JSCOPE = 18;
  public static final int BEFORE_YSCOPE = 20;
  public static final int AFTER_YSCOPE = 22;
  public static final int PENDING_YSCOPE = 24;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\41\u1f00\1\u0100\1\u2f00\1\u3000\1\u0100\1\u3100\1\u3200"+
    "\1\u3300\1\u3400\1\u3500\1\u3600\1\u3700\1\u3800\1\u3900\1\u0100"+
    "\1\u3a00\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u4000\1\u4100"+
    "\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700\1\u4800\1\u4900"+
    "\1\u4a00\1\u4b00\1\u4c00\1\u4d00\1\u1f00\1\u4e00\1\u4f00\1\u5000"+
    "\1\u5100\3\u0100\1\u5200\1\u5300\1\u5400\12\u1f00\4\u0100\1\u5500"+
    "\17\u1f00\2\u0100\1\u5600\41\u1f00\2\u0100\1\u5700\1\u5800\2\u1f00"+
    "\1\u5900\1\u5a00\27\u0100\1\u5b00\4\u0100\1\u5c00\1\u5d00\42\u1f00"+
    "\1\u0100\1\u5e00\1\u5f00\11\u1f00\1\u6000\24\u1f00\1\u6100\1\u6200"+
    "\1\u1f00\1\u6300\1\u6400\1\u6500\1\u6600\2\u1f00\1\u6700\5\u1f00"+
    "\1\u6800\1\u6900\1\u6a00\5\u1f00\1\u6b00\1\u6c00\2\u1f00\1\u6d00"+
    "\1\u1f00\1\u6e00\14\u1f00\1\u6f00\4\u1f00\246\u0100\1\u7000\20\u0100"+
    "\1\u7100\1\u7200\25\u0100\1\u7300\34\u0100\1\u7400\14\u1f00\2\u0100"+
    "\1\u7500\5\u1f00\23\u0100\1\u7600\u0aec\u1f00\1\u7700\1\u7800\u02fe\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\1\1\4\16\0\4\3"+
    "\1\1\1\5\1\6\1\7\1\10\11\3\1\11\1\12"+
    "\12\13\6\3\1\14\32\10\1\15\1\16\1\17\1\3"+
    "\1\10\1\20\32\10\4\3\41\0\2\3\4\10\4\3"+
    "\1\10\2\3\1\0\7\3\1\10\4\3\1\10\5\3"+
    "\27\10\1\3\37\10\1\3\u01ca\10\4\3\14\10\16\3"+
    "\5\10\7\3\1\10\1\3\1\10\21\3\160\0\5\10"+
    "\1\3\2\10\2\3\4\10\1\3\1\10\6\3\1\10"+
    "\1\3\3\10\1\3\1\10\1\3\24\10\1\3\123\10"+
    "\1\3\213\10\1\3\5\0\2\3\246\10\1\3\46\10"+
    "\2\3\1\10\6\3\51\10\6\3\1\10\1\3\55\0"+
    "\1\3\1\0\1\3\2\0\1\3\2\0\1\3\1\0"+
    "\10\3\33\10\4\3\4\10\15\3\6\0\5\3\1\10"+
    "\4\3\13\0\1\3\1\0\3\3\53\10\37\0\4\3"+
    "\2\10\1\0\143\10\1\3\1\10\10\0\1\3\6\0"+
    "\2\10\2\0\1\3\4\0\2\10\12\0\3\10\2\3"+
    "\1\10\17\3\1\0\1\10\1\0\36\10\33\0\2\3"+
    "\131\10\13\0\1\10\16\3\12\0\41\10\11\0\2\10"+
    "\4\3\1\10\2\3\1\0\30\10\4\0\1\10\11\0"+
    "\1\10\3\0\1\10\5\0\22\3\31\10\3\0\4\3"+
    "\13\10\65\3\25\10\1\3\22\10\13\3\61\0\66\10"+
    "\3\0\1\10\22\0\1\10\7\0\12\10\2\0\2\3"+
    "\12\0\1\3\20\10\3\0\1\3\10\10\2\3\2\10"+
    "\2\3\26\10\1\3\7\10\1\3\1\10\3\3\4\10"+
    "\2\3\1\0\1\10\7\0\2\3\2\0\2\3\3\0"+
    "\1\10\10\3\1\0\4\3\2\10\1\3\3\10\2\0"+
    "\2\3\12\0\4\10\7\3\2\10\1\3\1\0\2\3"+
    "\3\0\1\3\6\10\4\3\2\10\2\3\26\10\1\3"+
    "\7\10\1\3\2\10\1\3\2\10\1\3\2\10\2\3"+
    "\1\0\1\3\5\0\4\3\2\0\2\3\3\0\3\3"+
    "\1\0\7\3\4\10\1\3\1\10\7\3\14\0\3\10"+
    "\1\0\13\3\3\0\1\3\11\10\1\3\3\10\1\3"+
    "\26\10\1\3\7\10\1\3\2\10\1\3\5\10\2\3"+
    "\1\0\1\10\10\0\1\3\3\0\1\3\3\0\2\3"+
    "\1\10\17\3\2\10\2\0\2\3\12\0\1\3\1\10"+
    "\7\3\1\10\6\0\1\3\3\0\1\3\10\10\2\3"+
    "\2\10\2\3\26\10\1\3\7\10\1\3\2\10\1\3"+
    "\5\10\2\3\1\0\1\10\7\0\2\3\2\0\2\3"+
    "\3\0\7\3\3\0\4\3\2\10\1\3\3\10\2\0"+
    "\2\3\12\0\1\3\1\10\20\3\1\0\1\10\1\3"+
    "\6\10\3\3\3\10\1\3\4\10\3\3\2\10\1\3"+
    "\1\10\1\3\2\10\3\3\2\10\3\3\3\10\3\3"+
    "\14\10\4\3\5\0\3\3\3\0\1\3\4\0\2\3"+
    "\1\10\6\3\1\0\16\3\12\0\11\3\1\10\6\3"+
    "\5\0\10\10\1\3\3\10\1\3\27\10\1\3\20\10"+
    "\3\3\1\10\7\0\1\3\3\0\1\3\4\0\7\3"+
    "\2\0\1\3\3\10\5\3\2\10\2\0\2\3\12\0"+
    "\20\3\1\10\3\0\1\3\10\10\1\3\3\10\1\3"+
    "\27\10\1\3\12\10\1\3\5\10\2\3\1\0\1\10"+
    "\7\0\1\3\3\0\1\3\4\0\7\3\2\0\7\3"+
    "\1\10\1\3\2\10\2\0\2\3\12\0\1\3\2\10"+
    "\15\3\4\0\11\10\1\3\3\10\1\3\51\10\2\0"+
    "\1\10\7\0\1\3\3\0\1\3\4\0\1\10\5\3"+
    "\3\10\1\0\7\3\3\10\2\0\2\3\12\0\12\3"+
    "\6\10\1\3\3\0\1\3\22\10\3\3\30\10\1\3"+
    "\11\10\1\3\1\10\2\3\7\10\3\3\1\0\4\3"+
    "\6\0\1\3\1\0\1\3\10\0\6\3\12\0\2\3"+
    "\2\0\15\3\60\10\1\0\2\10\7\0\4\3\10\10"+
    "\10\0\1\3\12\0\47\3\2\10\1\3\1\10\1\3"+
    "\5\10\1\3\30\10\1\3\1\10\1\3\12\10\1\0"+
    "\2\10\11\0\1\10\2\3\5\10\1\3\1\10\1\3"+
    "\6\0\2\3\12\0\2\3\4\10\40\3\1\10\27\3"+
    "\2\0\6\3\12\0\13\3\1\0\1\3\1\0\1\3"+
    "\1\0\4\3\2\0\10\10\1\3\44\10\4\3\24\0"+
    "\1\3\2\0\5\10\13\0\1\3\44\0\11\3\1\0"+
    "\71\3\53\10\24\0\1\10\12\0\6\3\6\10\4\0"+
    "\4\10\3\0\1\10\3\0\2\10\7\0\3\10\4\0"+
    "\15\10\14\0\1\10\17\0\2\3\46\10\1\3\1\10"+
    "\5\3\1\10\2\3\53\10\1\3\115\10\1\3\4\10"+
    "\2\3\7\10\1\3\1\10\1\3\4\10\2\3\51\10"+
    "\1\3\4\10\2\3\41\10\1\3\4\10\2\3\7\10"+
    "\1\3\1\10\1\3\4\10\2\3\17\10\1\3\71\10"+
    "\1\3\4\10\2\3\103\10\2\3\3\0\40\3\20\10"+
    "\20\3\126\10\2\3\6\10\3\3\u016c\10\2\3\21\10"+
    "\1\3\32\10\5\3\113\10\3\3\13\10\7\3\15\10"+
    "\1\3\4\10\3\0\13\3\22\10\3\0\13\3\22\10"+
    "\2\0\14\3\15\10\1\3\3\10\1\3\2\0\14\3"+
    "\64\10\40\0\3\3\1\10\3\3\2\10\1\0\2\3"+
    "\12\0\41\3\4\0\1\3\12\0\6\3\131\10\7\3"+
    "\5\10\2\0\42\10\1\0\1\10\5\3\106\10\12\3"+
    "\37\10\1\3\14\0\4\3\14\0\12\3\12\0\36\10"+
    "\2\3\5\10\13\3\54\10\4\3\32\10\6\3\12\0"+
    "\46\3\27\10\5\0\4\3\65\10\12\0\1\3\35\0"+
    "\2\3\13\0\6\3\12\0\15\3\1\10\10\3\16\0"+
    "\1\3\2\0\77\3\5\0\57\10\21\0\7\10\4\3"+
    "\12\0\21\3\11\0\14\3\3\0\36\10\15\0\2\10"+
    "\12\0\54\10\16\0\14\3\44\10\24\0\10\3\12\0"+
    "\3\3\3\10\12\0\44\10\2\3\11\10\7\3\53\10"+
    "\2\3\3\10\20\3\3\0\1\3\25\0\4\10\1\0"+
    "\6\10\1\0\2\10\3\0\1\10\5\3\300\10\72\0"+
    "\1\3\5\0\26\10\2\3\6\10\2\3\46\10\2\3"+
    "\6\10\2\3\10\10\1\3\1\10\1\3\1\10\1\3"+
    "\1\10\1\3\37\10\2\3\65\10\1\3\7\10\1\3"+
    "\1\10\3\3\3\10\1\3\7\10\3\3\4\10\2\3"+
    "\6\10\4\3\15\10\5\3\3\10\1\3\7\10\16\3"+
    "\5\0\32\3\5\0\20\3\2\10\23\3\1\10\13\3"+
    "\5\0\1\3\12\0\1\3\1\10\15\3\1\10\20\3"+
    "\15\10\3\3\40\10\20\3\15\0\4\3\1\0\3\3"+
    "\14\0\21\3\1\10\4\3\1\10\2\3\12\10\1\3"+
    "\1\10\3\3\5\10\6\3\1\10\1\3\1\10\1\3"+
    "\1\10\1\3\4\10\1\3\13\10\2\3\4\10\5\3"+
    "\5\10\4\3\1\10\21\3\51\10\u0177\3\57\10\1\3"+
    "\57\10\1\3\205\10\6\3\4\10\3\0\2\10\14\3"+
    "\46\10\1\3\1\10\5\3\1\10\2\3\70\10\7\3"+
    "\1\10\17\3\1\0\27\10\11\3\7\10\1\3\7\10"+
    "\1\3\7\10\1\3\7\10\1\3\7\10\1\3\7\10"+
    "\1\3\7\10\1\3\7\10\1\3\40\0\57\3\1\10"+
    "\325\3\3\10\31\3\11\10\6\0\1\3\5\10\2\3"+
    "\5\10\4\3\126\10\2\3\2\0\2\3\3\10\1\3"+
    "\132\10\1\3\4\10\5\3\53\10\1\3\136\10\21\3"+
    "\40\10\60\3\320\10\100\3\375\10\3\3\215\10\103\3"+
    "\56\10\2\3\15\10\3\3\20\10\12\0\2\10\24\3"+
    "\57\10\1\0\4\3\12\0\1\3\37\10\2\0\120\10"+
    "\2\0\45\3\11\10\2\3\147\10\2\3\65\10\2\3"+
    "\11\10\52\3\15\10\1\0\3\10\1\0\4\10\1\0"+
    "\27\10\5\0\4\3\1\0\13\3\1\10\7\3\64\10"+
    "\14\3\2\0\62\10\22\0\12\3\12\0\6\3\22\0"+
    "\6\10\3\3\1\10\1\3\2\10\13\0\34\10\10\0"+
    "\2\3\27\10\15\0\14\3\35\10\3\3\4\0\57\10"+
    "\16\0\16\3\1\10\12\0\6\3\5\10\1\0\12\10"+
    "\12\0\5\10\1\3\51\10\16\0\11\3\3\10\1\0"+
    "\10\10\2\0\2\3\12\0\6\3\27\10\3\3\1\10"+
    "\3\0\62\10\1\0\1\10\3\0\2\10\2\0\5\10"+
    "\2\0\1\10\1\0\1\10\30\3\3\10\2\3\13\10"+
    "\5\0\2\3\3\10\2\0\12\3\6\10\2\3\6\10"+
    "\2\3\6\10\11\3\7\10\1\3\7\10\1\3\53\10"+
    "\1\3\16\10\6\3\163\10\10\0\1\3\2\0\2\3"+
    "\12\0\6\3\244\10\14\3\27\10\4\3\61\10\4\3"+
    "\156\10\2\3\152\10\46\3\7\10\14\3\5\10\5\3"+
    "\1\10\1\0\12\10\1\3\15\10\1\3\5\10\1\3"+
    "\1\10\1\3\2\10\1\3\2\10\1\3\154\10\41\3"+
    "\153\10\22\3\100\10\2\3\66\10\50\3\15\10\3\3"+
    "\20\0\20\3\20\0\3\3\2\10\30\3\3\10\31\3"+
    "\1\10\6\3\5\10\1\3\207\10\2\3\1\0\4\3"+
    "\1\10\13\3\12\0\7\3\32\10\4\3\1\10\1\3"+
    "\32\10\13\3\131\10\3\3\6\10\2\3\6\10\2\3"+
    "\6\10\2\3\3\10\3\3\2\10\3\3\2\10\22\3"+
    "\3\0\4\3\14\10\1\3\32\10\1\3\23\10\1\3"+
    "\2\10\1\3\17\10\2\3\16\10\42\3\173\10\105\3"+
    "\65\10\210\3\1\0\202\3\35\10\3\3\61\10\17\3"+
    "\1\0\37\3\40\10\15\3\36\10\5\3\46\10\5\0"+
    "\5\3\36\10\2\3\44\10\4\3\10\10\1\3\5\10"+
    "\52\3\236\10\2\3\12\0\6\3\44\10\4\3\44\10"+
    "\4\3\50\10\10\3\64\10\234\3\67\10\11\3\26\10"+
    "\12\3\10\10\230\3\6\10\2\3\1\10\1\3\54\10"+
    "\1\3\2\10\3\3\1\10\2\3\27\10\12\3\27\10"+
    "\11\3\37\10\101\3\23\10\1\3\2\10\12\3\26\10"+
    "\12\3\32\10\106\3\70\10\6\3\2\10\100\3\1\10"+
    "\3\0\1\3\2\0\5\3\4\0\4\10\1\3\3\10"+
    "\1\3\35\10\2\3\3\0\4\3\1\0\40\3\35\10"+
    "\3\3\35\10\43\3\10\10\1\3\34\10\2\0\31\3"+
    "\66\10\12\3\26\10\12\3\23\10\15\3\22\10\156\3"+
    "\111\10\67\3\63\10\15\3\63\10\15\3\44\10\4\0"+
    "\10\3\12\0\u0146\3\52\10\1\3\2\0\3\3\2\10"+
    "\116\3\35\10\12\3\1\10\10\3\26\10\13\0\137\3"+
    "\25\10\33\3\27\10\11\3\3\0\65\10\17\0\37\3"+
    "\12\0\17\3\4\0\55\10\13\0\2\3\1\0\17\3"+
    "\1\0\2\3\31\10\7\3\12\0\6\3\3\0\44\10"+
    "\16\0\1\3\12\0\4\3\1\10\2\0\1\10\10\3"+
    "\43\10\1\0\2\3\1\10\11\3\3\0\60\10\16\0"+
    "\4\10\4\3\4\0\1\3\14\0\1\10\1\3\1\10"+
    "\43\3\22\10\1\3\31\10\14\0\6\3\1\0\101\3"+
    "\7\10\1\3\1\10\1\3\4\10\1\3\17\10\1\3"+
    "\12\10\7\3\57\10\14\0\5\3\12\0\6\3\4\0"+
    "\1\3\10\10\2\3\2\10\2\3\26\10\1\3\7\10"+
    "\1\3\2\10\1\3\5\10\1\3\2\0\1\10\7\0"+
    "\2\3\2\0\2\3\3\0\2\3\1\10\6\3\1\0"+
    "\5\3\5\10\2\0\2\3\7\0\3\3\5\0\213\3"+
    "\65\10\22\0\4\10\5\3\12\0\4\3\1\0\3\10"+
    "\36\3\60\10\24\0\2\10\1\3\1\10\10\3\12\0"+
    "\246\3\57\10\7\0\2\3\11\0\27\3\4\10\2\0"+
    "\42\3\60\10\21\0\3\3\1\10\13\3\12\0\46\3"+
    "\53\10\15\0\1\10\7\3\12\0\66\3\33\10\2\3"+
    "\17\0\4\3\12\0\306\3\54\10\17\0\145\3\100\10"+
    "\12\0\25\3\10\10\2\3\1\10\2\3\10\10\1\3"+
    "\2\10\1\3\30\10\6\0\1\3\2\0\2\3\4\0"+
    "\1\10\1\0\1\10\2\0\14\3\12\0\106\3\10\10"+
    "\2\3\47\10\7\0\2\3\7\0\1\10\1\3\1\10"+
    "\1\0\33\3\1\10\12\0\50\10\7\0\1\10\4\0"+
    "\10\3\1\0\10\3\1\10\13\0\56\10\20\0\3\3"+
    "\1\10\42\3\71\10\7\3\11\10\1\3\45\10\10\0"+
    "\1\3\10\0\1\10\17\3\12\0\30\3\36\10\2\3"+
    "\26\0\1\3\16\0\111\3\7\10\1\3\2\10\1\3"+
    "\46\10\6\0\3\3\1\0\1\3\2\0\1\3\7\0"+
    "\1\10\1\0\10\3\12\0\6\3\6\10\1\3\2\10"+
    "\1\3\40\10\5\0\1\3\2\0\1\3\5\0\1\10"+
    "\7\3\12\0\u0136\3\23\10\4\0\271\3\1\10\54\3"+
    "\4\10\37\3\232\10\146\3\157\10\21\3\304\10\274\3"+
    "\57\10\1\3\11\0\307\3\107\10\271\3\71\10\7\3"+
    "\37\10\1\3\12\0\146\3\36\10\2\3\5\0\13\3"+
    "\60\10\7\0\11\3\4\10\14\3\12\0\11\3\25\10"+
    "\5\3\23\10\260\3\100\10\200\3\113\10\4\3\1\0"+
    "\1\10\67\0\7\3\4\0\15\10\100\3\2\10\1\3"+
    "\1\10\1\0\13\3\2\0\16\3\370\10\10\3\326\10"+
    "\52\3\11\10\367\3\37\10\61\3\3\10\21\3\4\10"+
    "\10\3\u018c\10\4\3\153\10\5\3\15\10\3\3\11\10"+
    "\7\3\12\10\3\3\2\0\1\3\4\0\301\3\5\0"+
    "\3\3\26\0\2\3\7\0\36\3\4\0\224\3\3\0"+
    "\273\3\125\10\1\3\107\10\1\3\2\10\2\3\1\10"+
    "\2\3\2\10\2\3\4\10\1\3\14\10\1\3\1\10"+
    "\1\3\7\10\1\3\101\10\1\3\4\10\2\3\10\10"+
    "\1\3\7\10\1\3\34\10\1\3\4\10\1\3\5\10"+
    "\1\3\1\10\3\3\7\10\1\3\u0154\10\2\3\31\10"+
    "\1\3\31\10\1\3\37\10\1\3\31\10\1\3\37\10"+
    "\1\3\31\10\1\3\37\10\1\3\31\10\1\3\37\10"+
    "\1\3\31\10\1\3\10\10\2\3\151\0\4\3\62\0"+
    "\10\3\1\0\16\3\1\0\26\3\5\0\1\3\17\0"+
    "\120\3\7\0\1\3\21\0\2\3\7\0\1\3\2\0"+
    "\1\3\5\0\325\3\55\10\3\3\7\0\7\10\2\3"+
    "\12\0\4\3\1\10\u0171\3\54\10\16\0\5\3\306\10"+
    "\13\3\7\0\51\3\104\10\7\0\1\10\4\3\12\0"+
    "\u0156\3\1\10\117\3\4\10\1\3\33\10\1\3\2\10"+
    "\1\3\1\10\2\3\1\10\1\3\12\10\1\3\4\10"+
    "\1\3\1\10\1\3\1\10\6\3\1\10\4\3\1\10"+
    "\1\3\1\10\1\3\1\10\1\3\3\10\1\3\2\10"+
    "\1\3\1\10\2\3\1\10\1\3\1\10\1\3\1\10"+
    "\1\3\1\10\1\3\1\10\1\3\2\10\1\3\1\10"+
    "\2\3\4\10\1\3\7\10\1\3\4\10\1\3\4\10"+
    "\1\3\1\10\1\3\12\10\1\3\21\10\5\3\3\10"+
    "\1\3\5\10\1\3\21\10\u0134\3\12\0\6\3\336\10"+
    "\42\3\65\10\13\3\336\10\2\3\u0182\10\16\3\u0131\10"+
    "\37\3\36\10\342\3\113\10\266\3\1\0\36\3\140\0"+
    "\200\3\360\0\20\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[30976];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\15\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\6\1\12\1\14\1\6"+
    "\1\15\1\12\1\16\1\17\2\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\27\1\30\1\31\1\32\1\33"+
    "\2\34\1\35\1\36\1\37\1\40\1\41\2\5\1\12"+
    "\2\22\2\30\2\35";

  private static int [] zzUnpackAction() {
    int [] result = new int[63];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\21\0\42\0\63\0\104\0\125\0\146\0\167"+
    "\0\210\0\231\0\252\0\273\0\314\0\335\0\356\0\377"+
    "\0\356\0\356\0\u0110\0\356\0\u0121\0\356\0\356\0\u0132"+
    "\0\356\0\u0143\0\u0154\0\356\0\u0165\0\356\0\u0176\0\356"+
    "\0\u0187\0\356\0\u0198\0\356\0\u01a9\0\356\0\u01ba\0\356"+
    "\0\u01cb\0\356\0\u01dc\0\u01ed\0\356\0\u01fe\0\u020f\0\356"+
    "\0\u0220\0\u0231\0\356\0\u0242\0\u0253\0\u0264\0\356\0\u0275"+
    "\0\356\0\356\0\u0286\0\356\0\u0297\0\356\0\u02a8";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[63];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\16\2\17\1\16\1\20\1\21\1\22\1\23\1\16"+
    "\2\24\1\25\1\26\3\16\1\27\6\30\1\31\7\30"+
    "\1\32\2\30\15\33\1\34\1\35\1\33\1\36\16\37"+
    "\1\32\1\40\1\37\1\41\2\42\1\41\1\43\1\21"+
    "\1\44\1\45\2\41\1\46\1\41\1\26\3\41\1\40"+
    "\1\47\2\17\1\47\1\20\1\24\1\44\1\23\2\47"+
    "\1\50\1\47\1\24\3\47\1\40\1\16\2\17\1\16"+
    "\1\20\1\21\1\22\1\23\1\16\1\24\1\46\1\25"+
    "\1\26\3\16\1\27\1\51\2\52\1\24\1\53\1\21"+
    "\1\44\1\54\1\51\1\55\1\24\1\51\1\26\3\24"+
    "\1\40\1\24\2\17\1\24\1\20\1\24\1\44\1\23"+
    "\1\56\7\24\1\40\1\16\2\17\1\16\1\20\1\21"+
    "\1\22\1\23\1\16\1\55\1\24\1\25\1\26\3\16"+
    "\1\27\1\57\2\60\1\57\1\61\1\21\1\44\1\62"+
    "\1\57\1\63\1\24\1\64\1\26\3\57\1\40\1\65"+
    "\2\17\1\65\1\20\1\24\1\44\1\23\1\65\2\24"+
    "\1\66\1\24\3\65\1\40\1\24\2\17\1\24\1\20"+
    "\1\21\1\24\1\23\1\24\1\63\2\24\1\26\4\24"+
    "\1\16\2\0\1\16\4\0\1\16\4\0\3\16\24\0"+
    "\1\17\16\0\2\23\1\67\1\23\1\70\14\23\13\0"+
    "\1\25\5\0\6\30\1\0\7\30\1\0\2\30\21\71"+
    "\15\33\2\0\1\33\1\0\15\71\1\40\2\71\1\40"+
    "\16\37\2\0\1\37\1\41\2\0\1\41\4\0\2\41"+
    "\1\0\1\41\1\0\3\41\3\0\1\42\16\0\2\45"+
    "\1\72\1\45\1\73\14\45\1\47\2\0\1\47\4\0"+
    "\2\47\1\0\1\47\1\0\3\47\1\0\1\51\7\0"+
    "\1\51\2\0\1\51\7\0\1\52\16\0\2\54\1\74"+
    "\1\54\1\75\14\54\1\56\7\0\1\56\2\0\1\56"+
    "\5\0\1\57\2\0\1\57\4\0\1\57\2\0\1\57"+
    "\1\0\3\57\3\0\1\60\16\0\2\62\1\76\1\62"+
    "\1\77\14\62\1\57\2\0\1\57\4\0\1\57\2\0"+
    "\1\64\1\0\3\57\1\0\1\65\2\0\1\65\4\0"+
    "\1\65\4\0\3\65\14\0\1\66\7\0\1\67\20\0"+
    "\1\72\20\0\1\74\20\0\1\76\16\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[697];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\15\0\1\1\1\11\1\1\2\11\1\1\1\11\1\1"+
    "\2\11\1\1\1\11\2\1\1\11\1\1\1\11\1\1"+
    "\1\11\1\1\1\11\1\1\1\11\1\1\1\11\1\1"+
    "\1\11\1\1\1\11\2\1\1\11\2\1\1\11\2\1"+
    "\1\11\3\1\1\11\1\1\2\11\1\1\1\11\1\1"+
    "\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[63];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
// we want to handle java paths !com.user.Plugin
// different from file paths @file/user/pugin.yap
// different from YAPPING paths { ... }.my-value.3.length
Deque<Integer> CONTEXT = new ArrayDeque<>();
final int GLOBAL = YYINITIAL;
private void pushContext(int state) {
    CONTEXT.push(state);
}
private int getContext() {
    if(CONTEXT.isEmpty())
        return GLOBAL;
    return CONTEXT.peek();
}
private void popContext() {
    if(!CONTEXT.isEmpty())
        CONTEXT.pop();
}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  YappingLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL.charAt(zzMarkedPosL) == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL.charAt(zzMarkedPosL) == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case LITERAL: {
              throw new Error("EOF while parsing string");
            }  // fall though
            case 64: break;
            case REGEX: {
              throw new Error("EOF while parsing `regex`");
            }  // fall though
            case 65: break;
            case REGEX_CLASS: {
              throw new Error("EOF while parsing `regex`");
            }  // fall though
            case 66: break;
            default:
        return null;
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(AFTER_YSCOPE);
                                                        return YappingTypes.YNAME;
            }
          // fall through
          case 34: break;
          case 2:
            { return TokenType.WHITE_SPACE;
            }
          // fall through
          case 35: break;
          case 3:
            { pushContext(BEFORE_JSCOPE);
                                                        yybegin(AFTER_JSCOPE);
                                                        return YappingTypes.JPATH_START;
            }
          // fall through
          case 36: break;
          case 4:
            { // we are encountering a new literal
                                                        popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(LITERAL);
            }
          // fall through
          case 37: break;
          case 5:
            { return YappingTypes.COMMENT;
            }
          // fall through
          case 38: break;
          case 6:
            { return TokenType.BAD_CHARACTER;
            }
          // fall through
          case 39: break;
          case 7:
            { popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(YYINITIAL);
                                                        return YappingTypes.NATURAL;
            }
          // fall through
          case 40: break;
          case 8:
            { /* fall back to BEFORE_SLASH when we're done parsing regex or literal */
                                                        pushContext(BEFORE_SLASH);
                                                        yybegin(AFTER_SLASH);
                                                        return YappingTypes.FPATH_START;
            }
          // fall through
          case 41: break;
          case 9:
            { popContext();
                                                        pushContext(BEFORE_YSCOPE);
                                                        yybegin(REGEX);
            }
          // fall through
          case 42: break;
          case 10:
            { 
            }
          // fall through
          case 43: break;
          case 11:
            { yybegin(getContext());
                                                        return YappingTypes.LITERAL;
            }
          // fall through
          case 44: break;
          case 12:
            { yybegin(REGEX_CLASS);
            }
          // fall through
          case 45: break;
          case 13:
            { yybegin(getContext()); return YappingTypes.REGEX;
            }
          // fall through
          case 46: break;
          case 14:
            { yybegin(REGEX);
            }
          // fall through
          case 47: break;
          case 15:
            { return YappingTypes.FNAME;
            }
          // fall through
          case 48: break;
          case 16:
            { yybegin(PENDING_SLASH); return TokenType.WHITE_SPACE;
            }
          // fall through
          case 49: break;
          case 17:
            { yybegin(LITERAL);
            }
          // fall through
          case 50: break;
          case 18:
            { yybegin(PENDING_SLASH); return YappingTypes.COMMENT;
            }
          // fall through
          case 51: break;
          case 19:
            { yybegin(AFTER_SLASH); return YappingTypes.SLASH;
            }
          // fall through
          case 52: break;
          case 20:
            { yybegin(BEFORE_SLASH); return YappingTypes.FNAME;
            }
          // fall through
          case 53: break;
          case 21:
            { return YappingTypes.SLASH;
            }
          // fall through
          case 54: break;
          case 22:
            { return YappingTypes.JBODY;
            }
          // fall through
          case 55: break;
          case 23:
            { yybegin(PENDING_JSCOPE); return TokenType.WHITE_SPACE;
            }
          // fall through
          case 56: break;
          case 24:
            { yybegin(PENDING_JSCOPE); return YappingTypes.COMMENT;
            }
          // fall through
          case 57: break;
          case 25:
            { yybegin(AFTER_JSCOPE); return YappingTypes.DOT;
            }
          // fall through
          case 58: break;
          case 26:
            { yybegin(BEFORE_JSCOPE); return YappingTypes.JNAME;
            }
          // fall through
          case 59: break;
          case 27:
            { return YappingTypes.YBODY;
            }
          // fall through
          case 60: break;
          case 28:
            { yybegin(PENDING_YSCOPE); return TokenType.WHITE_SPACE;
            }
          // fall through
          case 61: break;
          case 29:
            { yybegin(PENDING_YSCOPE); return YappingTypes.COMMENT;
            }
          // fall through
          case 62: break;
          case 30:
            { yybegin(AFTER_YSCOPE); return YappingTypes.DOT;
            }
          // fall through
          case 63: break;
          case 31:
            { return YappingTypes.NATURAL;
            }
          // fall through
          case 64: break;
          case 32:
            { yybegin(BEFORE_YSCOPE); return YappingTypes.YNAME;
            }
          // fall through
          case 65: break;
          case 33:
            { yybegin(BEFORE_YSCOPE); return YappingTypes.NATURAL;
            }
          // fall through
          case 66: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
