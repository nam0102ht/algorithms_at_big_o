package com.ntnn.midterm;

import java.util.*;

public class TheSultansSuccessors {
  static int[][] board;
  static boolean[] col;
  static boolean[] diag1;
  static boolean[] diag2;
  static int score;
  static int sum;

  public static void backtracking(int n) {
    if (n == 8) {
      score = Math.max(score, sum);
      return;
    }

    for (int i = 0; i < 8; i++) {
      if (!col[i] && !diag1[n - i + 7] && !diag2[n + i]) {
        col[i] = true;
        diag1[n - i + 7] = true;
        diag2[n + i] = true;
        sum += board[n][i];

        backtracking(n + 1);

        col[i] = false;
        diag1[n - i + 7] = false;
        diag2[n + i] = false;
        sum -= board[n][i];
      }
    }
  }

  public static void main(String[] args) {
    /*
    * 1
    * 1   2   3   4   5   6   7   8
    * 9  10  11  12  13  14  15  16
    * 17  18  19  20  21  22  23  24
    * 25  26  27  28  29  30  31  32
    * 33  34  35  36  37  38  39  40
    * 41  42  43  44  45  46  47  48
    * 48  50  51  52  53  54  55  56
    * 57  58  59  60  61  62  63  64
    * */
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();

    col = new boolean[8];
    diag1 = new boolean[15];
    diag2 = new boolean[15];

    for (int i = 0; i < T; i++) {
      board = new int[8][8];
      for (int j = 0; j < 8; j++) {
        for (int k = 0; k < 8; k++) {
          board[j][k] = scanner.nextInt();
        }
      }

      score = -1;
      sum = 0;
      backtracking(0);
      System.out.printf("%5d\n", score);
    }
  }
}
