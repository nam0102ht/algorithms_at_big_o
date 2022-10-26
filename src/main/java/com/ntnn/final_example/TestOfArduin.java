package com.ntnn.final_example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestOfArduin {
    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x && (mid == left || arr[mid-1] < x)) {
                return mid;
            } else if (x > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {4, 3, 6, 5, 8, 9, 12};
        List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (binarySearch(arr, arr[i] + arr[j]) != -1) {
                    System.out.println(arr[i] + " " + arr[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
