package com.ntnn.leetcode;

import java.util.*;

public class CheckWhetherUndirectedGraphTreeNot {
    private int vertexCount;
    private static LinkedList<Integer>[] adj;

    CheckWhetherUndirectedGraphTreeNot(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isValidIndex(int i) {
        // no check here
        return true;
    }

    private boolean isCyclic(int v, boolean[] visited, int parent) {
        // marked first node is visited
        visited[v] = true;
        Integer i;
        // Recur for all the vertices adjacent to this vertex
        for (Integer integer : adj[v]) {
            i = integer;

            // If an adj is not visited, then recursive for that
            if (!visited[i]) {
                if (isCyclic(i, visited, v)) return true;
            }
            // If an adj is visited and not parent of current vertex, then there is a cycle.
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    // isTree when and only when there is no cycle and all of adjs are connected
    public boolean isTree() {
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;

        if (isCyclic(0, visited, -1))
            return false;
        for (int u = 0; u < vertexCount; u++)
            if (!visited[u])
                return false;

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes from the input.
        int noOfNodes =  sc.nextInt();
        // Get the number of edges from the input.
        int noOfEdges = sc.nextInt();

        CheckWhetherUndirectedGraphTreeNot graph = new CheckWhetherUndirectedGraphTreeNot(noOfNodes);
        // Adding edges to the graph
        for (int i = 0; i <noOfEdges; ++i) {
            graph.addEdge(sc.nextInt(),sc.nextInt());
        }
        if (graph.isTree()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
