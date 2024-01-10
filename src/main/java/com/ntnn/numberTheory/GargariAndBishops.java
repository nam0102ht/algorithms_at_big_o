package com.ntnn.numberTheory;

import java.util.*;

public class GargariAndBishops {
  static final int N = 3001;
  static int n, g[][], x, y, xx, yy;
  static long[] dp1, dp2;
  static long sol1 = -1, sol2 = -1;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    g = new int[N][N];
    dp1 = new long[2 * N];
    dp2 = new long[2 * N];

    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        g[i][j] = scanner.nextInt();
        dp1[i + j] += g[i][j];
        dp2[i - j + n] += g[i][j];
      }
    }

    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        long v = dp1[i + j] + dp2[i - j + n] - g[i][j];
        if ((i + j) % 2 == 1) {
          if (v > sol2) {
            sol2 = v;
            xx = i;
            yy = j;
          }
        } else {
          if (v > sol1) {
            sol1 = v;
            x = i;
            y = j;
          }
        }
      }
    }

    System.out.println(sol1 + sol2);
    System.out.println(x + " " + y + " " + xx + " " + yy);
  }
}
