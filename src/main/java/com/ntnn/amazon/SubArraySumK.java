package com.ntnn.amazon;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
//  Amazon Coding Mock #11 — Subarray Sum Equals K
//  This time we’ll practice the prefix sum pattern you mentioned earlier.
//
//  Given an integer array nums and an integer k, return the number of contiguous subarrays whose sum equals k.
//
//  Example:
//
//  nums = [1, 1, 1]
//  k = 2
//  Output: 2
//
//  Because there are two valid subarrays:
//
//      [1, 1, 1]
//      -----       indices 0..1 → sum = 2
//      -----    indices 1..2 → sum = 2
//
//  Another example:
//
//  nums = [1, 2, 3]
//  k = 3
//  Output: 2
//      [1,2] → 3
//      [3]   → 3
//
//  Implement:
//
//  int subarraySum(int[] nums, int k)
//
//  Interview questions
//
//  1. What is the brute-force solution and its complexity?
//  2. Can sliding window solve this if nums may contain negative numbers? Why or why not?
//  3. What does prefixSum[i] represent?
//  4. Suppose the current prefix sum is currentSum. What previous prefix sum must exist for the subarray between them to have sum k?
//  5. Why do we need a HashMap<sum, frequency> rather than just a HashSet?
//  6. Why should we initially put 0 → 1 into the HashMap?
//  7. What are the optimized time and space complexities?
//
//  The critical relationship you’ll eventually need is:
//
//  previousPrefix + k = currentPrefix
//
//  But derive it yourself first.
//
//  Start with questions 1 and 2 only.
//  Subarray sum = K
//        ↓
//  Prefix Sum + HashMap
//        ↓
//  currentPrefix - previousPrefix = K
//        ↓
//  previousPrefix = currentPrefix - K
//        ↓
//  look up (currentPrefix - K)

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 1};
    int k = 2;
    System.out.println("Sub array: " + subarraySum(nums, k));
  }

  public static int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    int prefixSum = 0;
    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      int needed = prefixSum - k;
      count += prefixCount.getOrDefault(needed, 0);
      prefixCount.put(
          prefixSum,
          prefixCount.getOrDefault(prefixSum, 0) + 1
      );
    }
    return count;
  }
}
