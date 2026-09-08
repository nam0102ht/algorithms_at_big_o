package com.ntnn.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

  public static List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    if (s == null || s.isEmpty()) return result;

    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];

    for (int end = 0; end < n; end++) {
      for (int start = 0; start <= end; start++) {
        if (s.charAt(start) == s.charAt(end)
            && (end - start < 2 || isPalindrome[start + 1][end - 1])) {
          isPalindrome[start][end] = true;
        }
      }
    }

    backtrack(s, 0, new ArrayList<>(), result, isPalindrome);
    return result;
  }

  private static void backtrack(String s, int index, List<String> path,
                                List<List<String>> result, boolean[][] isPalindrome) {
    if (index == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int end = index; end < s.length(); end++) {
      if (!isPalindrome[index][end]) continue;
      path.add(s.substring(index, end + 1));
      backtrack(s, end + 1, path, result, isPalindrome);
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(partition("aab"));
  }
}
