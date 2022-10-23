package com.ntnn.final_example;

import java.util.*;

public class TestOfAmazone {
    public static boolean dfs(Map<String, List<String>> graph, Map<String, String> pred, List<String> visited, List<String> path, String start, String destination) {
        if (start.equals(destination)) {
            System.out.println(Arrays.toString(path.toArray()));
            return true;
        }
        visited.add(start);
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited.contains(graph.get(start).get(i))) {
                path.add(graph.get(start).get(i));
                pred.put(graph.get(start).get(i), start);
                dfs(graph, pred, visited, path, graph.get(start).get(i), destination);
                path.remove(graph.get(start).get(i));
            }
        }
        return false;
    }

    public static boolean bfs(Map<String, List<String>> graph, Map<String, String> pred, String start, String destination) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        pred.put(start, null);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                if(!pred.containsKey(graph.get(cur).get(i))) {
                    pred.put(graph.get(cur).get(i), cur);
                    queue.add(graph.get(cur).get(i));
                    if (graph.get(cur).get(i).equals(destination)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static List<String> getPath(Map<String, String> parents, String endNodeName) {
        List<String> path = new ArrayList<>();
        String node = endNodeName;
        while (node != null) {
            path.add(0, node);
            String parent = parents.get(node);
            node = parent;
        }
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> graph = new HashMap<>();
        while(true) {
            String str = sc.nextLine();
            if (str.equals("00")) break;
            String u = str.split(" ")[0];
            String v = str.split(" ")[1];
            List<String> setA = graph.getOrDefault(u, new ArrayList<>());
            setA.add(v);
            graph.put(u, setA);
            List<String> setB = graph.getOrDefault(v, new ArrayList<>());
            setB.add(u);
            graph.put(v, setB);
        }
        graph.forEach((v, k) -> {
            System.out.println(v + " : " + Arrays.toString(k.toArray()));
        });
        List<String> visited = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, String> pred = new HashMap<>();
        String start = sc.nextLine();
        String dest = sc.nextLine();
        path.add(start);
        //initial map contains value
        if(bfs(graph, pred, start, dest)) {
            List<String> lst = getPath(pred, dest);
            for (String s : lst) {
                System.out.print(s + ",");
            }
        } else {
            System.out.println("Not found");
        }

    }
}
