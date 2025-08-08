package com.ntnn.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//An array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].
//
//For example, consider 0-indexing:
//
//[1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
//[1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
//A subarray is a contiguous subsequence of the array.
//
//Given an integer array nums of distinct integers, return the largest subarray of nums of length k.
//
//
//
//Example 1:
//
//Input: nums = [1,4,5,2,3], k = 3
//Output: [5,2,3]
//Explanation: The subarrays of size 3 are: [1,4,5], [4,5,2], and [5,2,3].
//Of these, [5,2,3] is the largest.
//Example 2:
//
//Input: nums = [1,4,5,2,3], k = 4
//Output: [4,5,2,3]
//Explanation: The subarrays of size 4 are: [1,4,5,2], and [4,5,2,3].
//Of these, [4,5,2,3] is the largest.
//Example 3:
//
//Input: nums = [1,4,5,2,3], k = 1
//Output: [5]
public class MaximumSumSubArray {

  public static int[] largestSubarray(int[] nums, int k) {
    int n = nums.length;
    int max = nums[0], maxIndex = 0;
    for(int i = 0; i <= n - k; ++i){
      if(nums[i] > max){
        max = nums[i];
        maxIndex = i;
      }

    }

    return Arrays.copyOfRange(nums, maxIndex, maxIndex + k);
  }
  public static void main(String[] args) {

  }
}
