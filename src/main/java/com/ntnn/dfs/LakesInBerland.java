package com.ntnn.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class LakesInBerland {
    static boolean isOk = false;
    static int ans = 0;
    static int n = 0;
    static int m = 0;
    static int k = 0;
    static int s = 0;
    static boolean visited[][] = new boolean[n][m];
    static String[] str = new String[n];


    static class Node {
        int x;
        int y;
        int z;

        Node() {}
    }

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static void dfsLake(int x, int y) {
        if (x == 0 || y == 0 || x == n - 1 || y == m - 1) isOk = false;
        visited[x][y] = true;
        ans++;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && !visited[xx][yy] && str[xx].charAt(yy) == '.') {
                dfsLake(xx, yy);
            }
        }
    }

    static void dfsLand(int x, int y) {
        char[] v = str[x].toCharArray();
        v[y] = '*';
        str[x] = String.valueOf(v);
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (str[xx].charAt(yy) == '.') {
                dfsLand(xx, yy);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        Node[] listNode = new Node[1001];
        visited = new boolean[n][m];
        int l = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && str[i].charAt(j) == '.') {
                    isOk = true;
                    ans = 0;
                    dfsLake(i, j);
                    if (isOk) {
                        listNode[l] = new Node();
                        listNode[l].x = i;
                        listNode[l].y = j;
                        listNode[l++].z = ans;
                    }
                }
            }
        }
        listNode = Arrays.copyOf(listNode, l);
        Arrays.sort(listNode, (a, b) -> Integer.compare(b.z, a.z));

        int sum = 0;
        for (int i = k; i < l; i++) {
            sum += listNode[i].z;
            dfsLand(listNode[i].x, listNode[i].y);
        }
        System.out.println(sum);
        for (int i = 0; i < n; i++) {
            System.out.println(str[i]);
        }
    }
}
