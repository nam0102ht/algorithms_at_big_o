package com.ntnn.numberTheory;

import java.util.Scanner;

public class ProblemMakesProblem {
  static final long MOD = 1000000007;
  static final int NX = 2000010;
  static long[] fact;

  public static void main(String[] args) {
    initialize();

    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int cs = 1; cs <= t; cs++) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      long ans = (fact[n + k - 1] * modInverse((fact[n] * fact[k - 1]) % MOD)) % MOD;
      ans = (ans + MOD) % MOD;
      System.out.printf("Case %d: %d%n", cs, ans);
    }
    scanner.close();
  }

  static void initialize() {
    fact = new long[NX];
    fact[0] = 1;
    for (int i = 1; i < NX; i++) {
      fact[i] = (fact[i - 1] * i) % MOD;
    }
  }

  static long modInverse(long a) {
    long res = 1;
    long b = MOD - 2;
    while (b > 0) {
      if ((b & 1) == 1) {
        res = (res * a) % MOD;
      }
      a = (a * a) % MOD;
      b >>= 1;
    }
    return res;
  }
}
