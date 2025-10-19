package com.ntnn.dynamicprogramming;

public class InterleavingString {

  public static boolean interleaving(String s1, String s2, String s3) {
    int n = s1.length();
    int m = s2.length();
    if (n + m != s3.length()) {
      return false;
    }
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
    }
    for (int i = 1; i < m; i++) {
      dp[0][i] = dp[0][i-1] && s2.charAt(i - 1) == s3.charAt(i - 1);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        dp[i][j] = (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(interleaving("aaccaa", "aaccaa", "aaccaaaaccaa"));
  }
}