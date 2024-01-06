package com.ntnn.greedy;

import java.util.*;

public class BuildingPermutation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    Arrays.sort(a);

    long result = 0;
    for (int i = 0; i < n; i++) {
      result += Math.abs(i + 1 - a[i]);
    }

    System.out.println(result);
  }
}
