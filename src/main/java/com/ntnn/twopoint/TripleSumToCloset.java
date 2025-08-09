package com.ntnn.twopoint;

import java.util.Arrays;
import java.util.Collections;

public class TripleSumToCloset {
  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2]; // Initial best guess
    for (int i = 0; i < nums.length - 2; i++) {
      int start = i + 1;
      int end = nums.length - 1;
      while (start < end) {
        int sum = nums[i] + nums[start] + nums[end];

        if (Math.abs(target - sum) < Math.abs(target - result)) {
          result = sum;
        }

        if (sum == target) {
          return target;
        }
        else if (sum < target) {
          start++;
        } else {
          end--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-1,2,1,-4};
    int target = 1;
    System.out.println(threeSumClosest(nums, target));
  }
}
