package com.ntnn.midterm;

import java.util.Scanner;

public class ExaminationPapers {
  static final int MOD = (int) 1e9 + 7;

  public static void main(String[] args) {
    /* 3
     * 2
     * 4
     * 6
     */
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      long n = scan.nextLong();
      solve(2, n);
    }
  }

  private static void solve(long a, long b) {
    long result = 1;
    while (b > 0) {
      if (b % 2 == 1) {
        result = (result * a) % MOD;
      }
      b /= 2;
      a = (a * a) % MOD;
    }
    System.out.println((result - 1));
  }
}
