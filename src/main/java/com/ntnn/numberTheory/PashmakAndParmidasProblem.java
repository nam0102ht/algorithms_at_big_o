package com.ntnn.numberTheory;

import java.util.*;

public class PashmakAndParmidasProblem {
  static int[] arr;
  static int[] tree;
  static int n;
  static Map<Integer, Integer> cnt;
  static Map<Integer, Integer> knt;

  public static void update(int idx, int val) {
    while (idx <= n) {
      tree[idx] += val;
      idx += (idx & -idx);
    }
  }

  public static long query(int idx) {
    long val = 0;
    while (idx > 0) {
      val += tree[idx];
      idx -= (idx & -idx);
    }
    return val;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();

    arr = new int[n + 1];
    tree = new int[n + 1];
    cnt = new HashMap<>();
    knt = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      arr[i] = scanner.nextInt();
    }

    for (int i = n; i >= 1; i--) {
      int k = cnt.getOrDefault(arr[i], 0) + 1;
      cnt.put(arr[i], k);
      update(k, 1);
    }

    long ans = 0;
    for (int i = 1; i <= n; i++) {
      int k = cnt.get(arr[i]) - 1;
      update(cnt.get(arr[i]), -1);
      cnt.put(arr[i], k);
      k = knt.getOrDefault(arr[i], 0) + 1;
      knt.put(arr[i], k);
      ans += query(k - 1);
    }

    System.out.println(ans);
  }
}
