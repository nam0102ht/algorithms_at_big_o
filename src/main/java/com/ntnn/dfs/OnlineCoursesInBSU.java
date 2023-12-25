package com.ntnn.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineCoursesInBSU {
  static int cyc;
  static List<Integer> st;
  static int[] color;
  static List<Integer>[] adj;

  static void dfs(int s) {
    if (color[s] == 0) {
      color[s] = 1;

      for (int e : adj[s])
        dfs(e);

      color[s] = 2;
      st.add(s);
    } else if (color[s] == 1) {
      System.out.println("-1");
      return;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n, m, u, v;
    n = scanner.nextInt();
    m = scanner.nextInt();

    int[] a = new int[m];
    for (int i = 0; i < m; i++)
      a[i] = scanner.nextInt();

    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++)
      adj[i] = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      int k = scanner.nextInt();
      for (int j = 0; j < k; j++) {
        u = scanner.nextInt();
        adj[i].add(u);
      }
    }

    color = new int[n + 1];
    st = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      if (color[a[i]] == 0)
        dfs(a[i]);
    }

    System.out.println(st.size());
    for (int i = 0; i < st.size(); i++)
      System.out.print(st.get(i) + " ");
  }
}