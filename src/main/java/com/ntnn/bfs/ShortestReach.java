package com.ntnn.bfs;

import java.util.*;

public class ShortestReach {
    static void bfs(Vector<Vector<Integer>> g, int s) {

        int n = g.size();

        int[] dist = new int[g.size()];

        for (int i = 0; i < n; i++) {
            dist[i] = n;
        }

        dist[s] = 0;

        boolean[] used = new boolean[g.size()];
        Arrays.fill(used, false);

        Vector<Integer> queue = new Vector<>();

        queue.add(s);
        used[s] = true;

        for (int i = 0; i < queue.size(); i++) {
            queue.get(i);

            int v = queue.get(i);

            for (int u : g.get(v)) {
                if (!used[u]) {
                    used[u] = true;
                    dist[u] = dist[v] + 1;
                    queue.add(u);
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != 0) {
                if (dist[i] == n) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print((dist[i] * 6) + " ");
                }
            }
        }

    }

    public static void main(String[] args) {

        Vector<Vector<Integer>> g = new Vector<Vector<Integer>>();

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            for (int c = 0; c < n; c++) {
                g.add(new Vector<>());
            }

            int m = in.nextInt();
            for (int k = 0; k < m; k++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                g.get(a).add(b);
                g.get(b).add(a);
            }

            int s = in.nextInt() - 1;
            bfs(g,s);
            g.clear();
            System.out.println();
        }

    }
}
