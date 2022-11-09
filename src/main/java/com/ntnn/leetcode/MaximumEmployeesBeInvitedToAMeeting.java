package com.ntnn.leetcode;

import java.util.*;

public class MaximumEmployeesBeInvitedToAMeeting {
    public int maximumInvitations(int[] favorite) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < favorite.length; i++) {
            graph.add(new ArrayList<>());
        }

        int answer = 0;

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < favorite.length; i++) {
            if (i == favorite[favorite[i]]) {
                if (i < favorite[i]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(favorite[i]);
                    pairs.add(pair);
                }
            } else {
                graph.get(favorite[i]).add(i);
            }
        }

        List<Integer> visited = new ArrayList<>();
        for (List<Integer> pair: pairs) {
            answer += dfs(graph, pair.get(0), visited) + dfs(graph, pair.get(1), visited);
        }

        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> round = new HashMap<>();

        int rnd = 1;

        int circleMax = 0;

        for (int i = 0; i < favorite.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (round.getOrDefault(i, 0) != 0) {
                continue;
            }

            int cnt = 1;
            int j = i;
            while (counter.get(i) != null) {
                counter.put(j, cnt);
                round.put(j, rnd);
                j = favorite[j];
                cnt++;
            }
            if (round.getOrDefault(j, 0) == rnd) {
                circleMax = Math.max(circleMax, cnt - counter.get(j));
            }
            rnd++;
        }
        return Math.max(circleMax, answer);
    }

    private int dfs(List<List<Integer>> graph, int node, List<Integer> visited) {
        visited.add(node);
        int max = 0;
        for (int neighbor: graph.get(node)) {
            max = Math.max(max, dfs(graph, neighbor, visited));
        }
        return max + 1;
    }


//    public int maximumInvitations(int[] favorite) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for(int i=0; i< favorite.length; i++) {
//            List<Integer> lst = map.getOrDefault(i, new ArrayList<>());
//            lst.add(favorite[i]);
//            map.put(i, lst);
//        }
//
//        return findLongestPath(map);
//    }
//
//    private void dfs(Integer node, Map<Integer, List<Integer>> map, List<Integer> visited, Map<Integer, Integer> path) {
//        visited.add(node);
//        for(int i=0; i<map.get(node).size(); i++) {
//            int temp = map.get(node).get(i);
//            if(!visited.contains(temp)) dfs(temp, map, visited, path);
//            int p = path.getOrDefault(node, 0);
//            path.put(node, Math.max(p, 1 + path.getOrDefault(temp, 0)));
//        }
//    }
//    private int findLongestPath(Map<Integer, List<Integer>> map){
//
//        // Visited array to know if the node
//        // has been visited previously or not
//        List<Integer> visited = new ArrayList<>();
//        Map<Integer, Integer> path = new HashMap<>();
//
//        // Call DFS for every unvisited vertex\
//        for (int s : map.keySet()) {
//            if (!visited.contains(s)) dfs(s, map, visited, path);
//        }
//
//        int ans = 0;
//
//        // Traverse and find the maximum of all dp[i]
//        for (int s : path.keySet()) {
//            ans = Math.max(ans, path.get(s));
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        String[] str = "1,0,0,2,1,4,7,8,9,6,7,10,8".split(",");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        MaximumEmployeesBeInvitedToAMeeting max = new MaximumEmployeesBeInvitedToAMeeting();
        System.out.println(max.maximumInvitations(arr));
    }
}
