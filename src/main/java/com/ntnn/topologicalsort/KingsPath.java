package com.ntnn.topologicalsort;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KingsPath {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int x1, y1, x2, y2;
        x1 = sc.nextInt();
        y1 = sc.nextInt();

        x2 = sc.nextInt();
        y2 = sc.nextInt();

        int n = sc.nextInt();

        Map<String, Long> dist = new HashMap<>();
        Set<String> allow = new HashSet<>();
        Set<String> vis = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j <= b; j++) {
                allow.add(k + "," + j);
            }
        }

        allow.add(x1 + "," + y1);
        allow.add(x2 + "," + y2);

        Queue<Pair> q = new ArrayDeque<>();
        dist.put(x1 + "," + y1, 0L);
        q.add(new Pair(x1, y1));

        int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] dy = {-1, 0, 1, -1, 0, 1, 1, -1};

        while (!q.isEmpty()) {
            Pair u = q.poll();

            for (int i = 0; i < 8; i++) {
                int x = u.first + dx[i];
                int y = u.second + dy[i];

                String obj = x + "," + y;

                boolean isAllow = allow.contains(obj);

                if (isAllow && !vis.contains(obj)) {
                    if (!dist.containsKey(obj) || dist.get(obj) > dist.get(u.first + "," + u.second) + 1) {
                        dist.put(obj, dist.get(u.first + "," + u.second) + 1L);
                        q.add(new Pair(x, y));
                    }
                }
            }

            vis.add(u.first + "," + u.second);
        }

        if (vis.contains(x2 + "," + y2)) {
            System.out.println(dist.get(x2 + "," + y2));
        } else {
            System.out.println(-1);
        }
    }

}