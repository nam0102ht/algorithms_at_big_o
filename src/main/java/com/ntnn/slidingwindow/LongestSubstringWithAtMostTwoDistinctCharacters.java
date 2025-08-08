package com.ntnn.slidingwindow;
public class LongestSubstringWithAtMostTwoDistinctCharacters {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int[] freq = new int[256]; // ASCII table
    int distinct = 0, start = 0, maxLength = 0;

    for (int end = 0; end < s.length(); end++) {
      char endChar = s.charAt(end);
      if (freq[endChar]++ == 0) distinct++; // first occurrence

      while (distinct > 2) {
        char startChar = s.charAt(start++);
        if (--freq[startChar] == 0) distinct--;
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }
    return maxLength;
  }
}
