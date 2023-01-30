package com.ntnn.leetcode;

import java.util.*;

class Edge<T> {
    public final Node<T> n1;
    public final Node<T> n2;
    public final int weight;
    /* Note that here the edge is weighted so contains three components */
    public Edge(Node<T> n1, Node<T> n2, int weight) {
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
    }

    public boolean equals(Edge<T> e) {
        return (this.n1.equals(e.n1) && this.n2.equals(e.n2) && this.weight == e.weight);
    }
}



class Node<T> {
    private T value;
    private Set<Node<T>> neighbours = new HashSet<Node<T>>();

    public Node(T value) {
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }

}

interface MyGraph<T> {

    Set<Node<T>> getAllNodes();

    Set<Edge<T>> getAllEdges();

    Node<T> addNode(T e);

    /*
      throws exception when either of the nodes is not a member of the graph.
    */
    Edge<T> addEdge(Node<T> n1, Node<T> n2, int w) throws Exception;

    /*
      throws exception when the node is not a member of the graph.
    */
    Set<Node<T>> getAllNeighbours(Node<T> node) throws Exception;
    Set<Edge<T>> getAllOutgoingEdges(Node<T> node) throws Exception;
}


class AdjacencyList<T> implements MyGraph<T>{

    Map<Node<T>, Set<Edge<T>>> adjacencyList = new HashMap<Node<T>, Set<Edge<T>>>();

    public Set<Node<T>> getAllNodes() {
        return this.adjacencyList.keySet();
    }

    public Set<Edge<T>> getAllEdges() {
        Set<Edge<T>> edges = new HashSet<Edge<T>>();
        for(Node<T> node : this.adjacencyList.keySet()) {
            for(Edge<T> edge : this.adjacencyList.get(node)) {
                edges.add(edge);
            }
        }
        return edges;
    }

    public Node<T> addNode(T e) {
        Node<T> newNode = new Node<T>(e);
        this.adjacencyList.put(newNode, new HashSet<Edge<T>>());
        return newNode;
    }

    public Edge<T> addEdge(Node<T> n1, Node<T> n2, int w) throws Exception {
        if(!this.adjacencyList.keySet().contains(n1) || !this.adjacencyList.keySet().contains(n2)) {
            throw new Exception("At least one of the nodes not contained in this graph.");
        }
        Edge<T> edge = new Edge(n1, n2, w);
        this.adjacencyList.get(n1).add(edge);

        return edge;
    }

    public Set<Node<T>> getAllNeighbours(Node<T> node) throws Exception {
        if(this.adjacencyList.keySet().contains(node) == false) {
            throw new Exception("node not contained in this graph.");
        }
        Set<Node<T>> neighbours = new HashSet<Node<T>>();
        for(Edge<T> edge : this.adjacencyList.get(node)) {
            neighbours.add(edge.n2);
        }
        return neighbours;
    }

    public Set<Edge<T>> getAllOutgoingEdges(Node<T> node) throws Exception {
        if(this.adjacencyList.keySet().contains(node) == false) {
            throw new Exception("node not contained in this graph.");
        }
        return this.adjacencyList.get(node);
    }
}




public class DijkstrasAlgo {
    public static void main(String[] args) {
        MyGraph<String> graph = new AdjacencyList<String>();

        Node<String> c1 = graph.addNode("C1");
        Node<String> c2 = graph.addNode("C2");
        Node<String> c3 = graph.addNode("C3");
        Node<String> c4 = graph.addNode("C4");
        Node<String> c5 = graph.addNode("C5");
        try {
            graph.addEdge(c2, c1, 20);
            graph.addEdge(c1, c3, 50);
            graph.addEdge(c3, c4, 70);
            graph.addEdge(c4, c2, 100);
            graph.addEdge(c1, c4, 200);
            graph.addEdge(c3, c5, 10);
            graph.addEdge(c5, c4, 20);

            Map<Node<String>, Integer> paths = shortestPath(graph, c3);

            for (Node<String> n : paths.keySet()) {
                if(n == c2) {
                    System.out.println(n + " : " + paths.get(n));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static int maximumDistance(MyGraph<String> graph) {
        int sum = 0;
        for (Edge<String> edge : graph.getAllEdges()) {
            sum += edge.weight;
        }
        return sum + 1;
    }

    static class MyComparator<T extends Node<String>> implements Comparator<T> {
        private final Map<Node<String>, Integer> distances;

        public MyComparator(Map<Node<String>, Integer> distances) {
            this.distances = distances;
        }

        public int compare(T n1, T n2) {
            if (this.distances.get(n1) < this.distances.get(n2)) {
                return -1;
            } else if (this.distances.get(n1) > this.distances.get(n2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static void relax(Edge<String> edge, Map<Node<String>, Integer> distances) {
        //write your code here
        int possible = distances.get(edge.n1) + edge.weight;
        if (distances.get(edge.n2) > possible) {
            distances.put(edge.n2, possible);
        }
    }

    public static Map<Node<String>, Integer> shortestPath(MyGraph<String> graph, Node<String> start) throws Exception {
        /* Complete this method & return a map containing all nodes and their shortest distance from the start node (here C3)*/
        //write your code here
        Map<Node<String>, Integer> distances = new HashMap<>();
        int max  = maximumDistance(graph);
        for(Node<String> node : graph.getAllNodes()) {
            distances.put(node, max);
        }
        distances.put(start, 0);
        Node<String> nextNode = start;
        for(Edge edge : graph.getAllOutgoingEdges(nextNode)) {
            relax(edge, distances);
        }
        MyComparator<Node<String>> comparator = new MyComparator<>(distances);
        PriorityQueue<Node<String>> queue = new PriorityQueue<>(comparator);
        for(Node<String> n : graph.getAllNodes()) {
            queue.add(n);
        }

        while(queue.isEmpty() == false) {
            Node<String> dequeued = queue.poll();
            nextNode = queue.peek();
            if (nextNode != null) {
                for(Edge edge : graph.getAllOutgoingEdges(nextNode)) {
                    relax(edge, distances);
                }
            }
        }
        return distances;
    }
}
