package com.ntnn.twopoints;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int j = 0;
        int i = nums.length - 2;
        while(i >=0 && nums[i+1] <= nums[i]) i--;
        if (i>=0) {
            j = nums.length - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length -1;
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] nums, int x, int y) {
        nums[x] = nums[x] ^ nums[y] ^ (nums[y] = nums[x]);
    }
}
