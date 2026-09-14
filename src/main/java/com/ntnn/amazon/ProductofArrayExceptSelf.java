package com.ntnn.amazon;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
//  For LeetCode #238 — Product of Array Except Self, the clean solution is to use prefix product + suffix product and avoid division.
//  For:
//
//  nums = [1, 2, 3, 4]
//
//  First store the product of everything to the left of each index:
//
//  index:   0   1   2   3
//  nums:    1   2   3   4
//  prefix:  1   1   2   6
//
//  For example, at index 3, the left product is:
//
//      1 * 2 * 3 = 6
//
//  Then walk backward while maintaining the product of everything to the right:
//
//  right = 1
//  i = 3:
//  answer[3] = 6 * 1 = 6
//  right = 1 * 4 = 4
//  i = 2:
//  answer[2] = 2 * 4 = 8
//  right = 4 * 3 = 12
//  i = 1:
//  answer[1] = 1 * 12 = 12
//  right = 12 * 2 = 24
//  i = 0:
//  answer[0] = 1 * 24 = 24
//
//  So: [24, 12, 8, 6]
//
  public static void main(String[] args) {
    System.out.print("Product of Array is self: " + Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
  }

  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    // Prefix products
    answer[0] = 1;

    for (int i = 1; i < n; i++) {
      answer[i] = answer[i - 1] * nums[i - 1];
    }

    // Suffix products
    int rightProduct = 1;

    for (int i = n - 1; i >= 0; i--) {
      answer[i] = answer[i] * rightProduct;
      rightProduct *= nums[i];
    }

    return answer;
  }
}
