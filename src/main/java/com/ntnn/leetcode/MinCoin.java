package com.ntnn.leetcode;

import java.util.Arrays;

public class MinCoin {
    public static void dynamic(int[] d, int amount) {
        int[][] V = new int[amount + 1][d.length + 1];

        // if amount=0 then you don't need any coin to pay for 0
        for (int j = 0; j <= d.length; j++) {
            V[0][j] = 0;
        }

        // if you are supposed to use the first coin only then you have to give so many coins, as first coin has value 1
        for (int i = 0; i <= amount; i++) {
            V[i][0] = i;
        }


        // now fill rest of the matrix.
        for (int j = 1; j <= d.length; j++) {
            for (int i = 1; i <= amount; i++) {

                // check if the coin value is less than the amount needed
                if (d[j - 1] <= i && V[i][j - 1] > V[i - d[j - 1]][j] + 1) {
                    V[i][j] = 1 + V[i - d[j - 1]][j];
                } else {
                    V[i][j] = V[i][j - 1];
                }
            }
        }
        System.out.println("Minimum number of coins used is :" + V[amount][d.length]);


        int i = amount;
        int j = d.length;
        int count14 = 0;
        while (j > 0 && i > 0) {

            if (V[i][j] == V[i][j - 1]) {
                j = j - 1;

            } else {
                if (d[j-1] == 14) {
                    count14++;
                }
                System.out.println("Picked coin  :" + d[j - 1]);
                i = i - d[j - 1];
            }

        }
        System.out.println(count14);

        while (i > 0) {
            System.out.println("Picked coin  :" + d[0]);
            i = i - 1;
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5,8,10,14};
        dynamic(coins, 291);
    }
}
