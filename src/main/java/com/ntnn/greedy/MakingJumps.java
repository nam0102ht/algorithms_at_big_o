package com.ntnn.greedy;

import java.util.*;
public class MakingJumps {
  static int n;
  static int Answer;
  static int sum;
  static int[][] Matrix;
  static int SR, SC;
  static int[] drow = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dcol = {1, 2, 2, 1, -1, -2, -2, -1};

  // matrix[r][c] = 2 is visited
  // matrix[r][c] = 1 is belong to the chess and it is not visited

  static void dfs(int row, int col, int cnt) {
    for (int i = 0; i < 8; i++) {
      int r = row + drow[i];
      int c = col + dcol[i];

      if (r >= 0 && r < n && c >= 0 && c < 10 && Matrix[r][c] == 1) {
        Matrix[r][c] = 2;
        dfs(r, c, cnt + 1);
        Matrix[r][c] = 0;
      }
    }

    if (cnt > Answer)
      Answer = cnt;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tc = 0;
    while (true) {
      n = scanner.nextInt();
      if (n == 0)
        break;

      tc++;
      Answer = sum = 0;
      Matrix = new int[10][10];

      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          Matrix[i][j] = 0;
        }
      }

      int zero, number;
      for (int i = 0; i < n; i++) {
        zero = scanner.nextInt();
        number = scanner.nextInt();
        sum += number; // count total squares

        if (i == 0) {
          SR = 0;
          SC = zero;
        }

        for (int j = 0; j < number; j++) {
          Matrix[i][j + zero] = 0;
        }
      }

      Matrix[SR][SC] = 2;
      dfs(SR, SC, 1);

      Answer = sum - Answer;

      System.out.print("Case " + tc + ", " + Answer);
      if (Answer == 1)
        System.out.println(" square can not be reached.");
      else
        System.out.println(" squares can not be reached.");
    }
  }
}
