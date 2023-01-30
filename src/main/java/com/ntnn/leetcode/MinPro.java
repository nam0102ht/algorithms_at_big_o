package com.ntnn.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class MinPro {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        while (n-- > 0) {
//            long[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
//            long a = arr[0];
//            long b = arr[1];
//            long x = arr[2];
//            long y = arr[3];
//            long t = arr[4];
//            if (t > a && t > b) {
//                System.out.println(x * y);
//            } else if (t == a && t == b) {
//                long f = t - (a - x);
//                System.out.println(f);
//                System.out.println((a - (t - f)) * (b - f));
//            } else {
//                if (x - y > 1) {
//                    System.out.println(a * (b - t));
//                } else {
//                    System.out.println(b * (a - t));
//                }
//            }
//        }

        int n1 = 0, n2 = 1, n3, i, count = 10;
        System.out.print(n1 + " " + n2);
        for (i = 2; i < count; ++i) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}
