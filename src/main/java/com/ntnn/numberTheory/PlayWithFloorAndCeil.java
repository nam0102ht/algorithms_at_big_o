package com.ntnn.numberTheory;

import java.util.*;

public class PlayWithFloorAndCeil {
  static void gcd(long x, long y, long k) {
    long t;
    long flag = 1, la = 1, lb = 0, ra = 0, rb = 1;
    while (x % y != 0) {
      if (flag == 1) {
        la -= (x / y) * ra;
        lb -= (x / y) * rb;
      } else {
        ra -= (x / y) * la;
        rb -= (x / y) * lb;
      }
      t = x;
      x = y;
      y = t % y;
      flag = 1 - flag;
    }
    if (flag == 0)
      System.out.printf("%d %d\n", la * k / y, lb * k / y);
    else
      System.out.printf("%d %d\n", ra * k / y, rb * k / y);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t-- > 0) {
      long x = scanner.nextLong();
      long k = scanner.nextLong();
      long a, b;
      a = x / k;
      b = x / k + (x % k != 0 ? 1 : 0);
      gcd(a, b, x);
    }
  }
}
