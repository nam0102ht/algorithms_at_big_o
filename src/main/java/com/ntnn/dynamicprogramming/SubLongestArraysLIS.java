package com.ntnn.dynamicprogramming;

import java.util.*;

public class SubLongestArraysLIS {

    public static int binarySearch(ArrayList<Integer> ls, int key) {
        int low = 0;
        int high = ls.size() - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (ls.get(mid) == key) {
                return mid;
            } else if (ls.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();
        int len = 1;
        lis.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > lis.get(len-1)){
                lis.add(nums[i]);
                len = len+1;
            }
            else{
                lis.set(binarySearch(lis, nums[i]),nums[i]);
            }
        }
        return len;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int[] arr1 = java.util.Arrays.stream(s1.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(lengthOfLIS(arr1));
    }
}
