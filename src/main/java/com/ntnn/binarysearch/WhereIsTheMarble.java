package com.ntnn.binarysearch;

import java.util.*;

public class WhereIsTheMarble {
    public static int low_bound(int[] arr, int left, int right, int x) {
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
        Scanner sc = new Scanner(System.in);
        int T = 1;
        while (true) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            if (n == 0 && q == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("CASE# " + T + ":");
            int k = 0;
            int num = 0;
            Arrays.sort(arr);
            while (q-- > 0) {
                k = sc.nextInt();
                num = low_bound(arr, 0, n - 1, k);
                int res = num + 1;
                if (res == 0) {
                    System.out.println("" + k + " not found");
                } else {
                    System.out.println("" + k + " found at " + (num+1));
                }
            }
            T++;
        }
    }
}
