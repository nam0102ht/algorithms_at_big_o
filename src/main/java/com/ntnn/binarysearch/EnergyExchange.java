package com.ntnn.binarysearch;

import java.util.Scanner;

public class EnergyExchange {
    public static boolean condition(int[] arr, double val, int k) {
        double lo = 0, up = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < val)
                lo += val - arr[i];
            else
                up += arr[i] - val;
        }

        return up - (up * k) / 100.0 >= lo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        double left = 0;
        double right = 1e3;
        for (int i = 0; i < 100; i++) {
            double mid = left + (right - left) / 2;
            if (condition(arr, mid, k))
                left = mid;
            else
                right = mid;
        }
        System.out.printf("%.9f\n", left);
    }
}
