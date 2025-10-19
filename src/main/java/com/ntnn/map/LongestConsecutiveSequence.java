package com.ntnn.map;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  // Input: nums = [100,4,200,1,3,2]
  // Output: 4
  public static int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int maxLength = 0;
    for (int i : nums) {
      if (!numSet.contains(i - 1)) {
        int current = i;
        int streak = 1;
        while (numSet.contains(current + 1)) {
          current++;
          streak++;
        }
        maxLength = Math.max(maxLength, streak);
      }
    }
    return maxLength;
  }
  public static void main(String[] args) {
    int[] nums = new int[] {100,4,200,1,3,2};
    System.out.println(longestConsecutive(nums));
  }
}
