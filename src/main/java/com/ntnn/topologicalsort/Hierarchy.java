package com.ntnn.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hierarchy {
    private static int n, m;
    private static List<List<Integer>> adj;
    private static boolean[] visit;
    private static int[] parent;

    private static void topoSort(int t, List<Integer> topo) {
        visit[t] = true;
        for (int i = 0; i < adj.get(t).size(); i++) {
            int node = adj.get(t).get(i);
            if (!visit[node]) {
                topoSort(node, topo);
            }
        }
        topo.add(t);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int x = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                int y = scanner.nextInt();
                adj.get(i).add(y);
            }
        }

        visit = new boolean[n + 1];
        List<Integer> topo = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                topoSort(i, topo);
            }
        }

        parent = new int[n + 1];
        int p = 0;
        for (int i = n - 1; i >= 0; i--) {
            parent[topo.get(i)] = p;
            p = topo.get(i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
