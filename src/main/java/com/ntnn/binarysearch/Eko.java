package com.ntnn.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Eko {
    public static long upper_bound(int[] arr, long left, long right, int m) {
        long count = 0;
        while(left <= right) {
            long mid = left + (right - left) / 2;

            count = 0;

            for (int i = 0; i < arr.length; i++) {
                long diff = arr[i] - mid;

                count = count + ((diff > 0) ? diff : 0);
            }

            if (count == m) {
                return mid;
            }

            if (count < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            high = Math.max(high, arr[i]);
        }
        Arrays.sort(arr);
        System.out.println(upper_bound(arr, 0, high, m));
    }
}
