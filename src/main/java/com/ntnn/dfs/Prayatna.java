package com.ntnn.dfs;

import java.util.*;

class Prayatna {
    static boolean[] visited;
    static List<List<Integer>> graph;
    static int count = 0;

    static void dfs(int s) {
        visited[s] = true;
        for(int i=0; i<graph.get(s).size();i++) {
            int v = graph.get(s).get(i);
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            graph = new ArrayList<>();
            visited = new boolean[n];
            count = 0;
            for(int j=0; j<n; j++) {
                graph.add(j, new ArrayList<>());
            }
            for(int i =0; i<m ;i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            for(int j=0;j<n; j++) {
                if(!visited[j]) {
                    dfs(j);
                    count++;
                }
            }
            System.out.println(count == 0 ? n : count);
        }
    }
}