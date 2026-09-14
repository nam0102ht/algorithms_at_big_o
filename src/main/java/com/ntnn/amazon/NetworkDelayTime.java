package com.ntnn.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
  public static void main(String[] args) {
    int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    int n = 4;
    int k = 2;
    System.out.println("Network delay: " + networkDelayTime(times, n, k));
  }

  private static int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge : times) {
      int from = edge[0];
      int to = edge[1];
      int weight = edge[2];
      graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[]{to, weight});
    }
    // 2. distance[i] = shortest known distance from k to i
    int[] distance = new int[n + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[k] = 0;

    // 3. Min-heap: {distance, node}
    PriorityQueue<int[]> minHeap =
        new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    minHeap.offer(new int[]{0, k});

    // 4. Dijkstra
    while (!minHeap.isEmpty()) {
      int[] current = minHeap.poll();
      int currentDistance = current[0];
      int currentNode = current[1];

      // Ignore stale heap entries

      if (currentDistance > distance[currentNode]) {
        continue;
      }

      for (int[] edge : graph.getOrDefault(currentNode, Collections.emptyList())) {
        int nextNode = edge[0];
        int weight = edge[1];
        int newDistance = currentDistance + weight;

        // Relaxation
        if (newDistance < distance[nextNode]) {
          distance[nextNode] = newDistance;
          minHeap.offer(new int[]{
              newDistance,
              nextNode
          });
        }
      }
    }

    // 5. Find the longest shortest-path distance
    int answer = 0;
    for (int node = 1; node <= n; node++) {
      if (distance[node] == Integer.MAX_VALUE) {
        return -1;
      }
      answer = Math.max(answer, distance[node]);

    }

    return answer;
  }
}
