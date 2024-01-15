package com.ntnn.numberTheory;

import java.util.*;

public class SendATable {
  private static int[] p = new int[5500];
  private static int pt = 0;

  private static void sieve() {
    boolean[] mark = new boolean[32767];
    for (int i = 2; i < 32767; i++) {
      if (!mark[i]) {
        p[pt++] = i;
        for (int j = i + i; j < 32767; j += i) {
          mark[j] = true;
        }
      }
    }
  }

  private static int sol(int n) {
    int a, b, i;
    a = 1;
    b = n;
    for (i = 0; i < pt && p[i] * p[i] <= n; i++) {
      if (n % p[i] == 0) {
        a *= p[i] - 1;
        b /= p[i];
        n /= p[i];
        while (n % p[i] == 0)
          n /= p[i];
      }
    }
    if (n != 1)
      a *= n - 1;
    b /= n;
    return a * b;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;
    sieve();
    int[] dp = new int[50001];
    dp[1] = 1;
    for (int i = 2; i <= 50000; i++)
      dp[i] = dp[i - 1] + sol(i) * 2;
    while (scanner.hasNextInt()) {
      n = scanner.nextInt();
      if (n == 0)
        break;
      System.out.println(dp[n]);
    }
  }
}
