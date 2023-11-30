package com.ntnn.dynamicprogramming;

/*
* Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.
* */

import java.util.Arrays;

public class CountSquareSubmatricesAllOnes {
    public static int countSquaresShortest(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
                count += dp[i][j];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return count;
    }

    public static int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[Math.min(m, m)][m * n];
        int count = 0;
        for (int i =0; i< n; i++) {
            for (int j =0; j< m; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    dp[0][i*m + j] = 1;
                }
            }
        }
        if (count == 0) return 0;

        for (int i = 0; i < dp.length - 1; i++) {
            int levelCount = 0;
            int index = 0;
            for (int k = 0; k < n - 1; k++) {
                for (int l = 0; l < m -1; l++) {
                    int j = k * m + l;
                    if (dp[i][j] == 1 &&
                            dp[i][j + 1] == 1 &&
                            dp[i][j + m] == 1 &&
                            dp[i][j + m + 1] == 1
                    ) {
                        levelCount++;
                        dp[i + 1][index] = 1;
                    }
                    index++;
                }
            }
            if (levelCount == 0) break;
            count += levelCount;
            n--;
            m--;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSquaresShortest(new int[][] {{0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}}));
    }
}
