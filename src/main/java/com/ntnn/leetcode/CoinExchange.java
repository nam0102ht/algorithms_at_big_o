package com.ntnn.leetcode;

import java.util.Scanner;

public class CoinExchange {

    public static int count(int[] d, int amount) {

        int[][] V = new int[amount + 1][d.length];

        int i, j, v1, v2;

        /* Write down the base solution*/

        for (i = 0; i < d.length; i++) {
            V[0][i] = 1;
        }

        /* Fill in the rest of the matrix using recursion relation */

        for (i = 1; i < amount + 1; i++) {
            for (j = 0; j < d.length; j++) {
                // Counting the solutions by including d[j]
                if (i - d[j] >= 0) {
                    v1 = V[i - d[j]][j];
                } else {
                    v1 = 0;
                }

                // Counting the solutions by excluding d[j]
                if (j >= 1) {
                    v2 = V[i][j - 1];
                } else {
                    v2 = 0;
                }

                // count the total
                V[i][j] = v1 + v2;
            }

        }

        return V[amount][d.length - 1];

    }

    public static void main(String args[]) {

        int[] d = {1, 5, 7, 10};

        Scanner scan = new Scanner(System.in);

        int amount = scan.nextInt();

        System.out.println(count(d, amount));

        scan.close();

    }

}