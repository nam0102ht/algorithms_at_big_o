package com.ntnn.topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class AnswerTheBoss {

    static class Employee {
        int index;
        int rank;

        Employee(int index, int rank) {
            this.index = index;
            this.rank = rank;
        }
    }

    static Scanner in;
    static PrintWriter out;

    static void dfs(int u, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> topoOrder) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, topoOrder);
            }
        }

        topoOrder.add(u);
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);

        int t = in.nextInt();

        for (int testNumber = 1; testNumber <= t; testNumber++) {
            solveTest(testNumber);
        }

        out.close();
    }

    static ArrayList<Integer> topoSort(List<List<Integer>> adj) {
        ArrayList<Integer> topoOrder = new ArrayList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];

        for (int u = 0; u < n; u++) {
            if (!visited[u]) {
                dfs(u, adj, visited, topoOrder);
            }
        }

        Collections.reverse(topoOrder);

        return topoOrder;
    }

    static void solveTest(int testNumber) {
        int n = in.nextInt();
        int r = in.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[n];

        for (int u = 0; u < n; u++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < r; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(v).add(u);
            ++inDeg[u];
        }

        ArrayList<Integer> topoOrder = topoSort(adj);
        int[] rank = new int[n];

        for (int u : topoOrder) {
            if (inDeg[u] == 0) {
                rank[u] = 1;
            }
            for (int v : adj.get(u)) {
                rank[v] = Math.max(rank[v], rank[u] + 1);
            }
        }

        ArrayList<Employee> employees = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            employees.add(new Employee(u, rank[u]));
        }

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                if (e1.rank == e2.rank) {
                    return Integer.compare(e1.index, e2.index);
                }
                return Integer.compare(e1.rank, e2.rank);
            }
        });


        out.println("Scenario #" + testNumber + ":");

        for (Employee e : employees) {
            out.println(e.rank + " " + e.index);
        }
    }


}
