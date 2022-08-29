package com.ntnn.bfs;

import java.util.*;

public class KefaAndPark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph g = new graph(n);
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            g.addEdge(x - 1, y - 1, true);
        }
        g.dfs(0, a, m, 0);
        System.out.println(g.sol);
    }

    static class graph {
        int v;
        LinkedList<Integer>[] ll;
        int sol;
        boolean[] visited;
        int[] dist;
        int[] parent;

        public graph(int v) {
            this.v = v;
            ll = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                ll[i] = new LinkedList<>();
            }
            visited = new boolean[v];
            dist = new int[v];
            parent = new int[v];


        }

        public void addEdge(int u, int v, boolean x) {
            ll[u].add(v);
            if (x) ll[v].add(u);

        }

        void dfs(int src, int[] a, int m, int x) {
            int count = x;
            visited[src] = true;

            if (a[src] == 1) {
                if (count < m) count++;
                else return;
            } else count = 0;


            if (ll[src].size() == 1 && src != 0) {
                sol++;
                return;
            }

            for (int w : ll[src]) {

                if (!visited[w]) {
                    dfs(w, a, m, count);
                }
            }
        }
    }
}