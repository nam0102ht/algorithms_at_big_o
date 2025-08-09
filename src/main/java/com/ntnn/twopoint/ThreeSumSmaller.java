package com.ntnn.twopoint;

import java.util.Arrays;

public class ThreeSumSmaller {
  public static int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      count += searchPair(nums, target - nums[i], i);
    }
    return count;
  }

  public static int searchPair(int[] nums, int targetSum, int first) {
    int count = 0;
    int start = first + 1;
    int end = nums.length - 1;
    while (start < end) {
      if (nums[start] + nums[end] < targetSum) {
        //we found the a triplet
        //since arr[end] >= arr[start], therefore, we can replace arr[end]
        //by any number between start and end to get a sum less than the targetSum
        count += end - start;
        start++;
      } else {
        //we need a pair with a smaller sum
        end--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {-2,0,1,3};
    int target = 2;
    System.out.println(threeSumSmaller(arr, target));
  }
}
