package com.ntnn.midterm;

import java.util.*;
import java.io.*;

public class OliverAndTheGame {
  static int N;
  static int Q;
  static List<List<Integer>> graph;
  static int[] startTime;
  static int[] endTime;
  static int t;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    startTime = new int[N + 1];
    endTime = new int[N + 1];
    visited = new boolean[N + 1];
    t = 0;
    dfs(1);

    Q = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (Q-- > 0) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (type == 0) {
        if (startTime[x] <= startTime[y] && endTime[x] >= endTime[y]) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      } else {
        if (startTime[x] >= startTime[y] && endTime[x] <= endTime[y]) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }
    System.out.print(sb);
  }

  private static void dfs(int s) {
    t++;
    visited[s] = true;
    startTime[s] = t;
    for (int neighbor : graph.get(s)) {
      if (!visited[neighbor]) {
        dfs(neighbor);
      }
    }
    endTime[s] = t;
  }
}
