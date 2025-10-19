package com.ntnn.matrix;

import java.util.Arrays;

public class GameOfLife {
  // Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
  // Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
  public static void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] swap = new boolean[m][n];
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        int live = 0;
        int dead = 0;
        for (int dr = -1; dr <= 1; dr++) {
          for (int dc = -1; dc <= 1; dc++) {
            if (dc == 0 && dr == 0) {
              continue;
            }
            int nrow = r + dr;
            int ncol = c + dc;
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
              if (board[nrow][ncol] == 0)
                dead++;
              else
                live++;
            }
          }
        }
        if (board[r][c] == 0) {
          if (live == 3)
            swap[r][c] = true;
        } else {
          if (live < 2 || live > 3)
            swap[r][c] = true;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (swap[i][j])
          board[i][j] = 1 - board[i][j];
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    gameOfLife(matrix);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }

  }
}
