package com.ntnn.greedy;

import java.util.*;

public class RomaAndChangingSigns {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long k = scanner.nextLong();

    long[] a = new long[(int) n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextLong();
    }

    for (int i = 0; i < n && k > 0; i++) {
      if (a[i] < 0) {
        a[i] = Math.abs(a[i]);
        k--;
      } else {
        break;
      }
    }
    
    Arrays.sort(a);

    if (k % 2 == 1) {
      a[0] = Math.abs(a[0]);
    }

    long count = 0;
    for (int i = 0; i < n; i++) {
      count += a[i];
    }

    System.out.println(count);

  }
}
