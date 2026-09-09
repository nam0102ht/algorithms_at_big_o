package com.ntnn.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFSWithState {
  /*
  * You are given an m × n grid representing a warehouse.

    Each cell is one of:

    * 0 — empty cell
    * 1 — blocked cell
    * 2 — starting position
    * 3 — destination

    You may move up, down, left, or right.

    Normally, you cannot move through blocked cells (1).

    However, you are allowed to remove at most one blocked cell during the journey.

    Return the minimum number of steps needed to reach the destination.

    If the destination cannot be reached, return -1.
    Example:
    grid =
        0 0 0
        1 1 0
        0 0 0
        0 1 1
        0 0 0

        k = 1
  */

    static record State(int row, int col, int breaksUsed, int distance) {}

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 0}
        };
        int k = 1;
        System.out.println("Shortest path: " + shortestPath(grid, k));
    }

    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] visited = new boolean[n][m][k + 1];
        Deque<State> queue = new ArrayDeque<>();
        int[][] direction = new int[][] {
                {-1, 0}, // UP
                {1, 0},  // DOWN
                {0, -1}, // LEFT
                {0, 1}   // RIGHT
        };
        queue.offer(new State(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.row() == n - 1 && current.col() == m - 1) {
                return current.distance();
            }

            for (int[] dir : direction) {

                int nr = current.row() + dir[0];
                int nc = current.col() + dir[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (grid[nr][nc] == 0) {
                    if (!visited[nr][nc][current.breaksUsed()]) {
                        visited[nr][nc][current.breaksUsed()] = true;
                        queue.offer(new State(
                                nr,
                                nc,
                                current.breaksUsed(),
                                current.distance() + 1
                        ));
                    }

                } else if (grid[nr][nc] == 1 && current.breaksUsed() == 0) {

                    if (!visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;

                        queue.offer(new State(
                                nr,
                                nc,
                                1,
                                current.distance() + 1
                        ));
                    }
                }
            }
        }
        return -1;
    }
}
