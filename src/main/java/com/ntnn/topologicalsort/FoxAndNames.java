package com.ntnn.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoxAndNames {
    private static int n;
    private static List<String> v;
    private static List<Character> res;
    private static List<List<Integer>> graph;
    private static boolean[] vis;
    private static boolean[] isAncestor;

    private static boolean isCyclic(int parent) {
        vis[parent] = true;
        isAncestor[parent] = true;

        for (int child : graph.get(parent)) {
            if ((!vis[child] && isCyclic(child)) || isAncestor[child])
                return true;
        }

        isAncestor[parent] = false;
        res.add((char) (parent + 'a'));

        return false;
    }

    private static boolean isGraphCyclic() {
        vis = new boolean[26];
        isAncestor = new boolean[26];
        for (int i = 0; i < 26; i++) {
            if (!vis[i] && isCyclic(i))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        graph = new ArrayList<>();
        res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            v.add(s);
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = v.get(i);
            int ss1 = s1.length();
            String s2 = v.get(i + 1);
            int ss2 = s2.length();
            boolean isMatch = true;
            for (int j = 0; j < Math.min(ss1, ss2); j++) {
                if (s1.charAt(j) == s2.charAt(j))
                    continue;

                isMatch = false;
                graph.get(s2.charAt(j) - 'a').add(s1.charAt(j) - 'a');
                break;
            }
            if (isMatch && ss1 > ss2) {
                System.out.println("Impossible");
                return;
            }
        }

        if (isGraphCyclic()) {
            System.out.println("Impossible");
            return;
        }

        for (int i = 0; i < 26; i++)
            System.out.print(res.get(i));

        System.out.println();
    }
}
