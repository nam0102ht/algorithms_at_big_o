package com.ntnn.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  // Amazon Coding Mock #10 — Two Sum
  //
  //LeetCode: #1 — Two Sum
  //Pattern: HashMap / Complement Lookup
  //Core data structure: HashMap
  //
  //Given an integer array nums and an integer target, return the indices of two numbers whose sum equals target.
  //
  //Input:
  //nums   = [2, 7, 11, 15]
  //target = 9
  //Output:
  //[0, 1]
  //
  //Because:
  //
  //nums[0] + nums[1]
  //= 2 + 7
  //= 9
  //
  //Another example:
  //
  //nums   = [3, 2, 4]
  //target = 6
  //Output:
  //[1, 2]
  //
  //Implement:
  //
  //int[] twoSum(int[] nums, int target)
  //
  //Assume exactly one valid answer exists, and you cannot use the same element twice.
  //
  //Interview questions
  //
  //1. What is the brute-force solution and its time/space complexity?
  //2. How can a HashMap reduce the time complexity?
  //3. What should the HashMap’s key and value contain?
  //4. For the current number nums[i], how do you calculate the number you need to find?
  //5. Should you check the HashMap before or after inserting nums[i]? Why?
  //6. What are the optimized time and space complexities?
  //
  //For example, with:
  //
  //nums   = [2, 7, 11, 15]
  //target = 9
  //
  //when you’re looking at 2, ask yourself:
  //
  //I have 2.
  //What number do I need to reach 9?
  //
  //Start with questions 1 and 2 only.

  public static void main(String[] args) {
    int[] nums = new int[] {2, 7, 11, 15};
    int target = 9;
    System.out.print("Two sum: " + Arrays.toString(twoSum(nums, target)));
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> prefixSum = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (prefixSum.containsKey(complement)) {
        return new int[] {prefixSum.get(complement), i};
      }
      prefixSum.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }
}
