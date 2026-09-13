package com.ntnn.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

//  Given a string s, return the length of the longest substring without repeating characters.
//
//  Input:
//  s = "abcabcbb"
//  Output:
//      3
//  Reason:
//      "abc" has no duplicate characters.
//
//  Another example:
//
//  Input:
//  s = "pwwkew"
//  Output:
//      3
//  Longest valid substring:
//      "wke"
//
//  Implement:
//
//  int lengthOfLongestSubstring(String s)
//
//  Interview questions
//
//1. What is the brute-force approach and its complexity?
//      2. Is this a fixed-size or variable-size sliding window?
//      3. What condition makes the current window invalid?
//      4. When the window becomes invalid, what should left do?
//      5. Would you use a HashSet or HashMap? Why?
//      6. What are the optimized time and space complexities?

  public static void main(String[] args) {
    String s = "pwwkew";
    System.out.printf("Length of Longest Substring: %d", lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int left = 0;
    int maxLength = 0;
    Set<Character> window = new HashSet<>();
    for (int right = 0; right < n; right++) {
      char current = s.charAt(right);
      while (window.contains(current)) {
        window.remove(s.charAt(left));
        left++;
      }
      window.add(current);
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }
}
