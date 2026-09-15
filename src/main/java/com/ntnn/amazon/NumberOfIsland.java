package com.ntnn.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIsland {

//  Given an m x n grid containing:
//
//      '1' = land
//      '0' = water
//
//  return the number of islands. Land is connected horizontally or vertically, not diagonally.
//
//      Example:
//
//      [
//      ['1','1','0','0','0'],
//      ['1','1','0','0','0'],
//      ['0','0','1','0','0'],
//      ['0','0','0','1','1']
//      ]
//
//  Output:
//
//      3
//
//  Implement:
//
//  int numIslands(char[][] grid)

  private static final int[][] DIRECTIONS = {
      {-1, 0}, // up
      {1, 0},  // down
      {0, -1}, // left
      {0, 1}   // right
  };

  public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}

    };

    System.out.println(numIslands(grid));
  }

  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islands = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == '1') {
          islands++;
          bfs(grid, rows, cols, row, col);
        }
      }
    }
    return islands;
  }


  public static void bfs(char[][] grid, int rows, int cols, int startRow, int startCol) {
    Deque<int[]> deque = new ArrayDeque<>();
    deque.offer(new int[] {startRow, startCol});
    grid[startRow][startCol] = '0';
    while (!deque.isEmpty()) {
      int[] current = deque.poll();
      int row = current[0];
      int col = current[0];

      for (int[] dir : DIRECTIONS) {
        int nextRow = row + dir[0];
        int nextCol = col + dir[1];

        if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || grid[nextRow][nextCol] != '1') {
          continue;
        }
        // Mark before enqueueing to prevent duplicates.
        grid[nextRow][nextCol] = '0';
        deque.offer(new int[]{nextRow, nextCol});
      }
    }
  }
}
