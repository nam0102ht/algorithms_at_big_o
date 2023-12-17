package com.ntnn.topologicalsort;

import java.util.*;

public class Beverages {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = 1;

        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int[] cnt = new int[100];
            List<List<Integer>> egs = new ArrayList<>();
            Map<String, Integer> mp = new HashMap<>();
            List<String> name = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                egs.add(new ArrayList<>());
            }

            int num = 0;
            for (int i = 0; i < N; i++) {
                String chs = scanner.next();
                mp.put(chs, num);
                name.add(chs);
                num++;
            }

            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                String chs = scanner.next();
                String chs2 = scanner.next();
                int a = mp.get(chs);
                int b = mp.get(chs2);
                egs.get(a).add(b);
                cnt[b]++;
            }

            topological(cases, N, cnt, egs, name);
            cases++;
        }
    }

    private static void topological(int cases, int N, int[] cnt, List<List<Integer>> egs, List<String> name) {
        List<Integer> res = new ArrayList<>();
        int top = -1, cur, b;
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> Integer.compare(y.first, x.first));

        for (int i = 0; i < N; i++) {
            if (cnt[i] == 0) {
                q.add(new Pair(-1 * i, i));
            }
        }

        for (int i = 0; i < N; i++) {
            cur = q.peek().second;
            q.poll();
            res.add(cur);

            for (int j = 0; j < egs.get(cur).size(); j++) {
                b = egs.get(cur).get(j);
                cnt[b]--;
                if (cnt[b] == 0) {
                    q.add(new Pair(-1 * b, b));
                }
            }
        }

        System.out.printf("Case #%d: Dilbert should drink beverages in this order: ", cases);
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(name.get(res.get(i)));
        }
        System.out.println(".\n");
    }
}
