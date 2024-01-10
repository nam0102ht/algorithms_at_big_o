package com.ntnn.numberTheory;

import java.util.*;

class BoxesOfChocolates {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t, n, m, x, y, z;
    t = scanner.nextInt();
    while (t-- > 0) {
      n = scanner.nextInt();
      m = scanner.nextInt();
      int ans = 0;
      while (m-- > 0) {
        x = scanner.nextInt();
        z = 1;
        while (x-- > 0) {
          y = scanner.nextInt();
          z = (z * y) % n;
        }
        ans = (ans + z) % n;
      }
      System.out.println(ans);
    }
  }
}