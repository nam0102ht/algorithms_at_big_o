package com.ntnn.binarysearch;

import java.util.Scanner;

public class MonkeyAndTheOiledBamboo {
    public static boolean simulate(int[] arr, int strength) {
        int previous = 0;
        for (int i = 0; i < arr.length; i++) {
            int distance = arr[i]-previous;
            if (distance > strength) {
                return false;
            }
            if (distance == strength) {
                strength--;
            }
            previous = arr[i];
        }
        return true;
    }

    public static int binSearch(int[] arr, int lo, int hi, int best) {
        if (lo > hi) {
            return best;
        }

        int m = (lo+hi)/2;
        boolean isPossible = simulate(arr, m);
        if (isPossible) {
            return binSearch(arr, lo, m-1, m);
        }
        else {
            return binSearch(arr,m+1, hi, best);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int c = 1;
        while(T-->0) {
            int n  = sc.nextInt();
            int[] arr = new int[n];
            int r  = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Case "+ c + ": "+ binSearch(arr, arr[0], arr[n - 1], r));
            c++;
        }
    }
}
