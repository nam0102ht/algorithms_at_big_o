package com.ntnn.dijisktra;

import java.util.*;

public class TravellingCost {
    private static int[] dist;
    private static int size;
    private static List<List<Node>> graph;
    static class Node implements Comparable<Node> {
        public Integer id;
        public Integer dist;
        Node(Integer id, Integer dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist.compareTo(other.dist);
        }
    }
    public static void Dijkstra(int src) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        dist = new int[1050];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        heap.add(new Node(src, 0));
        while (!heap.isEmpty()) {
            Node top = heap.poll();
            int u = top.id;
            int v = top.dist;
            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if ( v + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = v + neighbor.dist;
                    heap.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int s = 0;
        graph = new ArrayList<>();
        for (int i = 0; i < 501; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int k = sc.nextInt();
            graph.get(u).add(new Node(v, k));
            graph.get(v).add(new Node(u, k));
        }
        s = sc.nextInt();
        Dijkstra(s);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int v = sc.nextInt();
            if (dist[v] != Integer.MAX_VALUE)  System.out.println(dist[v]);
            else System.out.println("NO PATH");
        }
        graph.clear();
    }
}
