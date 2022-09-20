package com.ntnn.dijisktra;

import java.util.*;

public class TrafficNetwork {
    private static int[] dist;
    private static int size;
    private static List<List<TravellingCost.Node>> graph;
    static class Node implements Comparable<TravellingCost.Node> {
        public Integer id;
        public Integer dist;
        Node(Integer id, Integer dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(TravellingCost.Node other) {
            return this.dist.compareTo(other.dist);
        }
    }
    public static void Dijkstra(int src) {
        PriorityQueue<TravellingCost.Node> heap = new PriorityQueue<>();
        dist = new int[1050];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        heap.add(new TravellingCost.Node(src, 0));
        while (!heap.isEmpty()) {
            TravellingCost.Node top = heap.poll();
            int u = top.id;
            int v = top.dist;
            for (int i = 0; i < graph.get(u).size(); i++) {
                TravellingCost.Node neighbor = graph.get(u).get(i);
                if ( v + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = v + neighbor.dist;
                    heap.add(new TravellingCost.Node(neighbor.id, dist[neighbor.id]));
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
            graph.get(u).add(new TravellingCost.Node(v, k));
            graph.get(v).add(new TravellingCost.Node(u, k));
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
