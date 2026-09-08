package com.ntnn.amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ProcessPackagesMultiSourceBfs {
  /*
  * Amazon operates a warehouse represented by an m × n grid.

    Each cell contains:

    * 0 — an empty location
    * 1 — a package waiting to be processed
    * 2 — an active processing station

    Every minute, an active processing station processes all packages directly adjacent to it: up, down, left, and right.

    Once a package is processed, it becomes an active processing station and can process adjacent packages in the next minute.
    Example:
    2 1 1
    1 1 0
    0 1 1
  * */

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };
    System.out.println("Process packages count is: " + processPackages(grid));
  }

  public static int processPackages(int[][] grid) {
    /*
    *  Normal BFS
        ↓
      One source
        ↓
      queue initially = [source]
      Multi-Source BFS
        ↓
      Multiple sources
        ↓
      queue initially = [source1, source2, source3, ...]
    * */
    int n = grid.length;
    int m = grid[0].length;
    Deque<List<Integer>> queue = new ArrayDeque<>();
    int totalPackages = 0;
    // Initialize the queue with all active processing stations and count total packages
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < m; c++) {
        if (grid[r][c] == 2) {
          queue.offer(List.of(r, c));;
        } else if (grid[r][c] == 1) {
          totalPackages++;
        }
      }
    }
    if (totalPackages == 0) {
      return 0; // No packages to process
    }

    int minutes = 0;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean processedThisMinute = false;
      for (int i = 0; i < size; i++) {
        List<Integer> current = queue.poll();
        for (int[] dir : directions) {
          int newRow = current.get(0) + dir[0];
          int newCol = current.get(1) + dir[1];
          if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
            grid[newRow][newCol] = 2; // Process the package
            queue.offer(List.of(newRow, newCol));
            totalPackages--;
            processedThisMinute = true;
          }
        }
      }
      if (processedThisMinute) {
        minutes++;
      }
    }
    return totalPackages == 0 ? minutes : -1; // Return -1 if some packages can never be reached
  }
}
