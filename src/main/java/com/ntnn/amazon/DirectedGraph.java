package com.ntnn.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DirectedGraph {
  /*
  * Let’s move from BFS on grids to BFS on a directed graph.

    Amazon has numServices services numbered from 0 to numServices - 1.

    Some services depend on other services and therefore must be deployed in a specific order.

    A dependency:
    * [a, b]
    means:

    Service b must be deployed before service a.
    For example:
    numServices = 4

    dependencies = [
        [1, 0],
        [2, 0],
        [3, 1],
        [3, 2]
    ]
    *
    1. What graph algorithm would you use? -> I would use topological sort because we need to produce
                                              an ordering that respects dependencies.
                                              I can implement topological sort using Kahn’s algorithm,
                                              which uses BFS and in-degree counts.
                                              Topological Sort using BFS / Kahn’s Algorithm.
    2. How would you represent the graph? ->
    3. What does in-degree mean? -> In-degree = number of incoming edges into a node.
    4. Which services should initially enter the queue?
    5. After deploying a service, what happens to its dependent services?
    6. How do you detect a cycle? -> After Kahn’s algorithm finishes, if the number of processed nodes is smaller than the total number of nodes, there must be a cycle.
    7. What are the time and space complexities?
  * */
  public static void main(String[] args) {
    int numServices = 4;
    int[][] dependencies = new int[][] {
        {1, 0},
        {2, 0},
        {3, 1},
        {3, 2}
    };
    System.out.println(deploymentOrder(numServices, dependencies));
  }


  /*
  * Dependency ordering
        ↓
    Directed Graph
            ↓
    Topological Sort
            ↓
    Kahn's Algorithm
            ↓
    inDegree == 0 → Queue
            ↓
    Process node
            ↓
    Decrease neighbors' in-degree
            ↓
    Processed < V → Cycle
  *
  * */
  public static List<Integer> deploymentOrder(
      int numServices,
      int[][] dependencies) {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    // One entry per service, not per dependency.
    int[] inDegree = new int[numServices];

    // Build directed graph.
    for (int[] dependency : dependencies) {

      int service = dependency[0];
      int prerequisite = dependency[1];

      // prerequisite -> service
      graph.computeIfAbsent(
          prerequisite,
          key -> new ArrayList<>()
      ).add(service);

      inDegree[service]++;
    }

    Deque<Integer> queue = new ArrayDeque<>();

    // Services without prerequisites can be deployed immediately.
    for (int service = 0; service < numServices; service++) {
      if (inDegree[service] == 0) {
        queue.offer(service);
      }
    }

    List<Integer> result = new ArrayList<>();

    // Kahn's algorithm
    while (!queue.isEmpty()) {

      int current = queue.poll();
      result.add(current);

      for (int next :
          graph.getOrDefault(current, Collections.emptyList())) {

        inDegree[next]--;

        if (inDegree[next] == 0) {
          queue.offer(next);
        }
      }
    }

    // Not every service was processed -> cycle exists.
    if (result.size() != numServices) {
      return Collections.emptyList();
    }

    return result;
  }
}
