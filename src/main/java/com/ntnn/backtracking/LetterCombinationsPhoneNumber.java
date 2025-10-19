package com.ntnn.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
  private static final Map<Character, String> phoneMap = Map.of(
      '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
      '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
  );

  public static List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits == null || digits.isEmpty()) return res;
    backtrack(digits, 0, new StringBuilder(), res);
    return res;
  }

  private static void backtrack(String digits, int index, StringBuilder path, List<String> res) {
    if(index == digits.length()) {
      res.add(path.toString());
      return;
    }

    String letters = phoneMap.get(digits.charAt(index));
    for (char c : letters.toCharArray()) {
      path.append(c);
      backtrack(digits, index + 1, path, res);
      path.deleteCharAt(path.length() - 1); // backtrack
    }
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
}
