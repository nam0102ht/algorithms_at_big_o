package com.ntnn.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BiggestThreeRhombusSums {
  private static final int[] DR = {1, 1, -1, -1};
  private static final int[] DC = {1, -1, -1, 1};

  public static List<Integer> getBiggestThree(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Set<Integer> distinct = new HashSet<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        distinct.add(grid[i][j]);
        int maxK = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));

        for (int k = 1; k <= maxK; k++) {
          int r = i - k;
          int c = j;
          int sum = grid[r][c];

          for (int dir = 0; dir < 4; dir++) {
            for (int step = 0; step < k; step++) {
              r += DR[dir];
              c += DC[dir];
              if (dir == 3 && step == k - 1) {
                continue;
              }
              sum += grid[r][c];
            }
          }

          distinct.add(sum);
        }
      }
    }

    List<Integer> sorted = new ArrayList<>(distinct);
    Collections.sort(sorted, Collections.reverseOrder());
    List<Integer> result = new ArrayList<>();
    for (int value : sorted) {
      if (result.size() == 3) {
        break;
      }
      result.add(value);
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] grid = {
        {3, 4, 5, 1, 3},
        {3, 3, 4, 2, 3},
        {20, 30, 200, 40, 10},
        {1, 5, 5, 4, 1},
        {4, 3, 2, 2, 5}
    };
    System.out.println(getBiggestThree(grid));
  }
}
