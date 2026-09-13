package com.ntnn.amazon;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsinEveryWindowofSizeK {
  /*
  * Let’s switch to another important pattern: Sliding Window.
  * Amazon analyzes a stream of product IDs. Given an integer array products and an integer k, find the maximum number of distinct products in any contiguous window of size k.
  * Example:
  * products = [1, 2, 1, 3, 4, 2, 3]
  * k = 4
  * [1, 2, 1, 3] → 3 distinct
  * [2, 1, 3, 4] → 4 distinct
  * [1, 3, 4, 2] → 4 distinct
  * [3, 4, 2, 3] → 3 distinct
  * Pattern:
  * Fixed-size contiguous range
  *  ↓
  * SLIDING WINDOW
  *      ↓
  * Add incoming element (right)
  * Remove outgoing element (left)
  *      ↓
  * Calculate answer
  * */

  public static void main(String[] args) {
    int[] products = new int[] {1, 2, 1, 3, 4, 2, 3};
    int k = 4;
    System.out.println("Max distinct products: " + maxDistinctProducts(products, k));
  }


  public static int maxDistinctProducts(int[] products, int k) {
    int left = 0;
    int n = products.length;
    int maxDistinct = 0;
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int right = 0; right < n; right++) {
      int incoming = products[right];
      frequency.put(incoming, frequency.getOrDefault(right, 0) + 1);
      if (right - left + 1 > k) {
        int outgoing = products[left];
        frequency.put(outgoing, frequency.get(outgoing) - 1);
        if (frequency.get(outgoing) == 0) {
          frequency.remove(outgoing);
        }
        left++;

      }

      if (right - left + 1 == k) {
        maxDistinct = Math.max(maxDistinct, frequency.size());
      }
    }
    return maxDistinct;
  }
}
