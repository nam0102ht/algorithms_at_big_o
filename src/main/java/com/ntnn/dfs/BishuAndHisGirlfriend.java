package com.ntnn.dfs;

import java.util.*;


public class BishuAndHisGirlfriend {
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    static int n = 1005;
    static boolean[] visited = new boolean[n];
    static int[] dist = new int[n];

    static void dfs(int s, int d) {
        dist[s] = d;
        visited[s] = true;
        for (Integer v: graph.get(s)) {
            if (!visited[v]) {
                dfs(v, d + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            List<Integer> lst = new ArrayList<>();
            graph.put(i, lst);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<Integer> adj = new ArrayList<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            adj.add(i, sc.nextInt() - 1);
        }
        dist = new int[n];
        Arrays.fill(dist, -1);
        visited = new boolean[dist.length];
        Arrays.fill(visited, false);
        dfs(0, 0);

        int res = Integer.MAX_VALUE;
        int id = Integer.MAX_VALUE;
        for (int i = 0; i < q; i++) {
            if (dist[adj.get(i)]  < res || (dist[adj.get(i)] == res && adj.get(i) < id)){
                res = dist[adj.get(i)];
                id = adj.get(i) + 1;
            }
        }
        System.out.println(id);
    }
}
