package com.ntnn.dynamicprogramming;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

* */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
      Set<String> dict = new HashSet<>(wordDict);
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true; // base case: empty string

      for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
          if (dp[j] && dict.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }

      return dp[s.length()];
    }

  public static void main(String[] args) {
    String s = "catsandog";
    List<String> wordDict = List.of("cats","dog","sand","and","cat");
    System.out.println(wordBreak(s, wordDict));
  }
}
