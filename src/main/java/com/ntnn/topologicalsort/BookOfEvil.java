package com.ntnn.topologicalsort;

import java.util.*;

// Question meaning: There are n points, (n-1) edges, and m ghosts.
// Find how many points exist so that the distance from this point to each ghost does not exceed d.
// Solution: Find the farthest distance between two ghosts
// (similar to the diameter of a tree, with ghosts at both ends of the diameter,
// set to A and B). If the distance from a certain point to A and B is not more than d,
// then the remaining ghosts must also be Will not exceed d. So first find the farthest endpoints A and B,
// and then find the distance from each point to A and B, divided into da[ ] and db[ ] respectively.
// If da[i] and db[i] do not exceed d , then point i meets the requirements
class BookOfEvil {
    static class Node {
        int v, next;

        Node(int a, int b) {
            v = a;
            next = b;
        }
    }

    static Node[] e;
    static int[] head, da, db, ghost;
    static int n, m, d, cnt, A, B, mmax;

    static void dfs1(int s, int fa, int deep) {
        if (ghost[s] != 0 && deep > mmax) {
            A = s;
            mmax = deep;
        }
        for (int i = head[s]; i != -1; i = e[i].next) {
            int v = e[i].v;
            if (v == fa) continue;
            dfs1(v, s, deep + 1);
        }
    }

    static void dfs2(int s, int fa, int[] d, int deep) {
        d[s] = deep;
        if (d == da && ghost[s] != 0 && mmax < deep) {
            B = s;
            mmax = deep;
        }
        for (int i = head[s]; i != -1; i = e[i].next) {
            int v = e[i].v;
            if (v == fa) continue;
            dfs2(v, s, d, deep + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxn = 100005;
        e = new Node[maxn << 1];
        head = new int[maxn];
        da = new int[maxn];
        db = new int[maxn];
        ghost = new int[maxn];
        cnt = 0;
        mmax = 0;

        Arrays.fill(head, -1);

        n = scanner.nextInt();
        m = scanner.nextInt();
        d = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            ghost[x] = 1;
        }

        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            e[++cnt] = new Node(v, head[u]);
            head[u] = cnt;
            e[++cnt] = new Node(u, head[v]);
            head[v] = cnt;
        }

        mmax = 0;
        dfs1(1, -1, 0);
        mmax = 0;
        dfs2(A, -1, da, 0);
        dfs2(B, -1, db, 0);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (da[i] <= d && db[i] <= d) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}