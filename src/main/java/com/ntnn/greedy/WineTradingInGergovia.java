package com.ntnn.greedy;

import java.util.*;

public class WineTradingInGergovia {
  static final int MAX = 100007;
  static long[] a;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int n = scanner.nextInt();
      if (n == 0) {
        break;
      }

      a = new long[MAX];
      for (int i = 0; i < n; i++) {
        a[i] = scanner.nextLong();
      }

      long ans = 0;
      long sum = 0;
      for (int i = 0; i < n; i++) {
        sum += a[i];
        ans += Math.abs(sum);
      }

      System.out.println(ans);
    }
  }

}
