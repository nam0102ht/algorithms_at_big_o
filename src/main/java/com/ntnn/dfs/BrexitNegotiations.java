package com.ntnn.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


// solution: Find the longest meeting (longest path)
public class BrexitNegotiations {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> in = new ArrayList<>(n);
    List<Long> weights = new ArrayList<>(n);
    List<List<Integer>> adjList = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      in.add(0);
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      int ei = scanner.nextInt();
      int di = scanner.nextInt();
      weights.add((long) ei);
      while (di-- > 0) {
        int bi = scanner.nextInt();
        bi--;
        adjList.get(i).add(bi);
        in.set(bi, in.get(bi) + 1);
      }
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      if (in.get(i) == 0) {
        pq.add(new Pair(weights.get(i), i));
      }
    }

    long longest = Integer.MIN_VALUE;
    long seen = n - 1;

    while (!pq.isEmpty()) {
      Pair u = pq.poll();
      if ((u.first + seen) > longest) {
        longest = u.first + seen;
      }
      seen--;
      for (int v : adjList.get((int) u.second)) {
        in.set(v, in.get(v) - 1);
        if (in.get(v) == 0) {
          pq.add(new Pair(weights.get(v), v));
        }
      }
    }

    System.out.println(longest);
  }

  static class Pair implements Comparable<Pair> {
    long first;
    long second;

    Pair(long first, long second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(Pair other) {
      return Long.compare(this.first, other.first);
    }
  }

}
