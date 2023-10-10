package com.ntnn.dynamicprogramming;

public class InterleavingString {

    public static boolean interleaving(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        if ((n + m) != s3.length()) return false;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i-1][j];
                } else if (s1.charAt(i - 1) != s3.charAt(i + j - 1)
                        && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = (dp[i][j-1] || dp[i-1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(interleaving("aaccaa", "aaccaa", "aaccaaaaccaa"));
    }
}