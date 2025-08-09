package com.ntnn.twopoint;

public class SortColors {
  public void sortColors(int[] nums) {
    int left = 0, mediumLeft = 0, right = nums.length - 1;
    int pivot = 1;
    while (mediumLeft <= right) {
      if (nums[mediumLeft] < pivot) {
        swap(nums, left, mediumLeft);
        left++;
        mediumLeft++;
      } else if (nums[mediumLeft] > pivot) {
        swap(nums, mediumLeft, right);
        right--;
      } else {
        mediumLeft++;
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
