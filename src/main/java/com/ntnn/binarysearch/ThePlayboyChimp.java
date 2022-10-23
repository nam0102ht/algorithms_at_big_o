package com.ntnn.binarysearch;

import java.util.Scanner;

public class ThePlayboyChimp {
    public static long low_bounder(int[] arr, int left, int right, int m, boolean f) {
        long ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (f) {
                if (arr[mid] >= m) right = mid - 1;
                else {
                    ans = arr[mid];
                    left = mid + 1;
                }
            } else {
                if (arr[mid] <= m) left = mid + 1;
                else {
                    ans = arr[mid];
                    right = mid - 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(q-->0)
        {
            int x = sc.nextInt();
            long a = low_bounder(arr, 0, arr.length - 1, x,true);
            long b = low_bounder(arr, 0, arr.length - 1, x,false);
            sb.append(((a!=-1)? a:"X") + " " + ((b!=-1)? b:"X") + "\n");

        }
        System.out.print(sb);
    }
}
