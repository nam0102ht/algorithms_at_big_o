package com.ntnn.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class ClustersCount {
  /* You are given an m × n grid representing a data center.

    Each cell contains:

    * 0 — an inactive server
    * 1 — an active server

    Two active servers belong to the same cluster if they are connected horizontally or vertically. Diagonal connections do not count.

    For example:
    1 1 0 0 0
    1 1 0 0 0
    0 0 1 0 0
    0 0 0 1 1
  * */

  /*
    1. What algorithm would you use?
      I would solve this using a graph traversal, either BFS or DFS. I treat each active server,
      meaning each cell with value 1, as a node.
      Two nodes are connected when they are adjacent horizontally or vertically.
    2. Why would you choose it?
      I scan the entire grid. Whenever I find a 1 that I have not visited yet,
      that means I have discovered a new cluster, so I increment the cluster count and run BFS or DFS from that cell to mark
      every connected active server as visited.
    3. I start at (0,0).
      From there I can reach (0,1), (1,0), and (1,1), so those four cells form the first cluster.
      Then I continue scanning. The next unvisited 1 is (2,2). It has no horizontally or vertically connected active neighbors,
      so that is the second cluster.
      Finally, I find (3,3), which is connected to (3,4), so those form the third cluster.
      Therefore the answer is 3.
      I would probably choose BFS here because the constraints allow up to 1000 x 1000,
      which is one million cells. A recursive DFS could risk a stack overflow if there is one very large connected cluster.
      BFS uses an explicit queue, so it is safer in Java for this input size.
      The time complexity is O(m * n) because every cell is visited at most once.
      The space complexity is O(m * n) in the worst case for the visited structure and BFS queue.
      If I am allowed to modify the input grid, I can mark visited cells by changing 1 to 0, which removes the need for a
      separate visited array.
  * */

  public static void main(String[] args) {
    int[][] grid = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1}
    };
    System.out.println("Clusters count active is: " + countClusters(grid));
  }

  public static int countClusters(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    int[][] direction = new int[][] {
        {-1, 0}, // UP
        {1, 0},  // DOWN
        {0, -1}, // LEFT
        {0, 1}   // RIGHT
    };

    int count = 0;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1) {
          count++;

          Queue<int[]> queue = new LinkedList<>();
          queue.offer(new int[]{r, c});

          // Mark it visited
          grid[r][c] = 0;

          while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : direction) {
              int newRow = curr[0] + dir[0];
              int newCol = curr[1] + dir[1];
              if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                grid[newRow][newCol] = 0;
                queue.offer(new int[]{newRow, newCol});
              }
            }
          }
        }
      }
    }
    return count;
  }

}
