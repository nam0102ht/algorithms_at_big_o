package com.ntnn.dynamicprogramming;

public class MinimalPathSum {
  /*
  *  Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
  *  Output: 7
  * */

  public static int minPathSum(int[][] grid) {
    // Fill first grow
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 1; i < m; i++) {
      grid[0][i] += grid[0][i - 1];
    }
    for (int i = 1; i < m; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
      }
    }
    return grid[n - 1][m - 1];
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
    System.out.println(minPathSum(grid));
  }
}
