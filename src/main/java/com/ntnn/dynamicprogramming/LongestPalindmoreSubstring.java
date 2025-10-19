package com.ntnn.dynamicprogramming;

public class LongestPalindmoreSubstring {
  public static String longestPalindrome(String s) {
    int start = 0;
    int end = 0;
    char[] arr = s.toCharArray();
    int i = 0;
    while (i < arr.length) {
      int left = i;
      int right = i;
      while (right + 1 < arr.length && arr[right] == arr[right + 1]) {
        right++;
      }
      i = right + 1;
      while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
        left--;
        right++;
      }
      if (right - left > end - start) {
        start = left;
        end = right;
      }
    }
    return s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
  }
}
