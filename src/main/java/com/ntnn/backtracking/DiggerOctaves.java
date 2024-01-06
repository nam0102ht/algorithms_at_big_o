package com.ntnn.backtracking;

import java.util.*;

public class DiggerOctaves {
  private static void util(char[][] v, Set<String> path, Set<Set<String>> ret,
                           boolean[][] visit, int i, int j, int n) {
    if (i < 0 || j < 0 || i >= v.length || j >= v[i].length)
      return;

    if (n == 0) {
      ret.add(new HashSet<>(path));
      return;
    }

    if (!visit[i][j] && v[i][j] != '.') {
      visit[i][j] = true;
      path.add(i + " " + j);

      int[] dx = {1 , 0 , -1 , 0};
      int[] dy = {0 , 1 , 0 , -1};

      for (int k = 0; k < 4; k++) {
        util(v, path, ret, visit, i + dx[k], j + dy[k], n - 1);
      }


      path.remove(i + " " + j);
      visit[i][j] = false;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    while (n-- > 0) {
      int t = scanner.nextInt();
      char[][] v = new char[t][t];
      boolean[][] visit = new boolean[t][t];

      for (int i = 0; i < t; i++) {
        String x = scanner.next();
        for (int j = 0; j < x.length(); j++) {
          v[i][j] = x.charAt(j);
        }
      }

      Set<String> path = new HashSet<>();
      Set<Set<String>> ret = new HashSet<>();

      for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
          util(v, path, ret, visit, i, j, 8);
        }
      }

      System.out.println(ret.size());
    }
  }
}
