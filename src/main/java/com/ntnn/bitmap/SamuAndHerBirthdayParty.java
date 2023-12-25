package com.ntnn.bitmap;

import java.util.Arrays;
import java.util.Scanner;

public class SamuAndHerBirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n, k, mask, res = 11;
            n = scanner.nextInt();
            k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                String str = scanner.next();
                arr[i] = Integer.parseInt(str, 2);
            }
            Arrays.sort(arr);
            for (int i = 1; i < (1 << k); ++i) {
                mask = i;
                for (int a : arr) {
                    if ((mask & a) == 0) {
                        mask = 0;
                        break;
                    }
                }
                if (mask != 0) {
                    res = Math.min(res, Integer.bitCount(mask));
                }
            }
            System.out.println(res);
        }
    }
}
