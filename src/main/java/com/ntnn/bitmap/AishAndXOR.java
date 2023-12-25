package com.ntnn.bitmap;

import java.util.Scanner;

public class AishAndXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MX = 100000;
        int[] nb = new int[MX + 1];
        int[] XOR = new int[MX + 1];

        int n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            int x = scanner.nextInt();
            XOR[i] = x ^ XOR[i - 1];
            nb[i] = (x == 0) ? nb[i - 1] + 1 : nb[i - 1];
        }

        int q = scanner.nextInt();
        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println((XOR[r] ^ XOR[l - 1]) + " " + (nb[r] - nb[l - 1]));
        }
    }
}