package com.ntnn.dynamicprogramming;


/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
* */

public class PalindromicSubstrings {

    public int countSubstringsTopDown(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int gap=0; gap<n; gap++) {
            for (int i=0, j=gap; i<n && j<n; i++, j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = b;
                } else {
                    if(b && dp[i+1][j-1]){
                        dp[i][j]= true;
                    }
                }
                if (dp[i][j]) count++;
            }
        }
        return count;
    }

    public int countSubstringsBottomUp(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd
            int left = i;
            int right = i;
            result += countTimePalindromic(s, left, right);

            // even
            left = i;
            right = i + 1;
            result += countTimePalindromic(s, left, right);
        }
        return result;
    }

    private int countTimePalindromic(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();

        System.out.println(palindromicSubstrings.countSubstringsBottomUp("abc"));
        System.out.println(palindromicSubstrings.countSubstringsBottomUp("aaa"));


        System.out.println(palindromicSubstrings.countSubstringsTopDown("abc"));
        System.out.println(palindromicSubstrings.countSubstringsTopDown("aaa"));
    }
}
