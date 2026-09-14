package com.ntnn.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
//  Given an integer array nums and an integer k, return the kth largest element in the array.
//
//  Input:
//  nums = [3, 2, 1, 5, 6, 4]
//  k = 2
//  Output:
//  5
//
//  Why? If sorted conceptually:
//
//      6, 5, 4, 3, 2, 1
//      ↑
//      2nd largest
//
//  Another example:
//
//  nums = [3, 2, 3, 1, 2, 4, 5, 5, 6]
//  k = 4
//  Output: 4
//
//  Implement:
//
//  int findKthLargest(int[] nums, int k)
//
//  Constraints:
//
//      1 <= nums.length <= 100_000
//      1 <= k <= nums.length
//
//  Interview questions
//
//  1. What is the simplest solution using sorting, and what is its complexity?
//  2. If we don’t want to sort the entire array, which data structure would you use?
//  3. For finding the kth largest, would you use a min-heap or max-heap?
//  4. Why should the heap contain only k elements?
//  5. After processing all numbers, where is the kth largest element in the heap?
//  6. What are the time and space complexities?
//
//  Kth Largest
//     ↓
//  Min-Heap
//     ↓
//  Keep size K
//     ↓
//  size > K → poll smallest
//     ↓
//  After processing everything
//     ↓
//  heap.peek() = Kth Largest

  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    System.out.println("Find Kth Largest: " + findKthLargest(nums, k));
  }
  
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      heap.add(nums[i]);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    return heap.peek();
  }
}
