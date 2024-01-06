package com.ntnn.divideAndConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistanceInTree {
  static int N, K;
  static int[] parent;
  static long[][] dp;
  static List<List<Integer>> tree;

  public static long rec(int n, int k, int baap) {
    long ret = 0;
    if (dp[n][k] != -1) {
      return dp[n][k];
    } else if (k == 0) {
      ret = 1;
    } else {
      for (int i = 0; i < tree.get(n).size(); i++) {
        int child = tree.get(n).get(i);
        if (child != baap) {
          ret += rec(child, k - 1, n);
        }
      }
    }
    return dp[n][k] = ret;
  }

  public static void dfs(int n, int baap) {
    parent[n] = baap;
    for (int i = 0; i < tree.get(n).size(); i++) {
      int child = tree.get(n).get(i);
      if (child != baap) {
        dfs(child, n);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    K = sc.nextInt();

    parent = new int[N + 1];
    dp = new long[N + 1][K + 1];
    tree = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
      for (int j = 0; j <= K; j++) {
        dp[i][j] = -1;
      }
    }

    for (int i = 0; i < N - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    dfs(1, 0);

    long ans = 0;
    for (int n = 1; n <= N; n++) {
      long a = rec(n, K, parent[n]);
      long b = 0;
      for (int i = 0; i < tree.get(n).size(); i++) {
        int child = tree.get(n).get(i);
        if (child != parent[n]) {
          for (int x = 1; x < K; x++) {
            b += (rec(child, x - 1, n) * (rec(n, K - x, parent[n]) - rec(child, K - x - 1, n)));
          }
        }
      }
      ans += (a + 0.5 * b);
    }

    System.out.println(ans);

    sc.close();
  }
}