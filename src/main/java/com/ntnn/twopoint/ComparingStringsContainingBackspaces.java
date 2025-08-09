package com.ntnn.twopoint;

public class ComparingStringsContainingBackspaces {
  public static boolean backspaceCompare(String s, String t) {
    int pointerOne = s.length() - 1, pointerTwo = t.length() - 1;

    while (pointerOne >= 0 || pointerTwo >= 0) {
      pointerOne = getNextChar(s, pointerOne);
      pointerTwo = getNextChar(t, pointerTwo);

      if (pointerOne < 0 && pointerTwo < 0) return true;
      if (pointerOne < 0 || pointerTwo < 0 || s.charAt(pointerOne) != t.charAt(pointerTwo)) return false;
      pointerOne--;
      pointerTwo--;
    }
    return true;
  }

  private static int getNextChar(String str, int idx) {
    int skip = 0;
    while (idx >= 0) {
      if (str.charAt(idx) == '#') skip++;
      else if (skip > 0) skip--;
      else break;
      idx--;
    }
    return idx;
  }

  public static void main(String[] args) {
    String s1 = "ab#c";
    String s2 = "ad#c";
    System.out.println(backspaceCompare(s1, s2));
  }

}
