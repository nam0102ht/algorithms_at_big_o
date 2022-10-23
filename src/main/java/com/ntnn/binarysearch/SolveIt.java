package com.ntnn.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class SolveIt {
    private static final double eps = 1e-8;

    public static double f(double x, int p, int q, int r, int s, int t, int u) {
        return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u;
    }

    static double bisection(int p, int q, int r, int s, int t, int u) {
        double a = 0, b = 1;
        while (a + eps < b) {
            double c = (a + b) / 2;
            if (f(c, p, q, r, s, t, u) * f(a, p, q, r, s, t, u) <= 0) b = c;
            else a = c;
        }
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        int p, q, r, s, t, u = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (f(0, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]) * f(1, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]) > 0) {
                System.out.println("No solution");
            } else System.out.printf("%.4f\n", bisection(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
        }
    }
}
