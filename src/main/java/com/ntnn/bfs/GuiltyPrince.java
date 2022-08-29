package com.ntnn.bfs;

import java.util.*;

public class GuiltyPrince {
    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(String[] arr, Coordinate s) {
        Queue<Coordinate> queue = new LinkedList<>();
        int n = arr.length;
        int m = arr[0].length();
        boolean[][] visited = new boolean[arr.length][arr[0].length()];
        queue.add(s);
        visited[s.x][s.y] = true;
        int[] dx = {-1,1,0,0}; // direction by vertx
        int[] dy = {0,0,-1,1}; // direction by verty
        while (!queue.isEmpty()) {
            Coordinate selected_node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempx = selected_node.x + dx[i];
                int tempy = selected_node.y + dy[i];
                if (isValid(tempx, tempy, arr, n, m) && !visited[tempx][tempy]) {
                    visited[tempx][tempy] = true;
                    queue.add(new Coordinate(tempx, tempy));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                if(visited[i][j]) count++;
            }
        }
        return count;
    }

    public static boolean isValid(int row, int col, String[] matrix, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row].charAt(col) == '.';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int h = 1;
        while (T-- > 0) {
            int[] lens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = lens[0];
            int n = lens[1];
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String brr = sc.nextLine();
                arr[i] = brr;
            }

            int cnt = 0;
            //List contains 2 coordinate of matrix entries
            ArrayList<Integer> coordinates = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j].charAt(k) == '@') {
                        cnt++;
                        coordinates.add(j);
                        coordinates.add(k);
                    }
                }
            }
            int rowSource = coordinates.get(0);
            int colSource = coordinates.get(1);
            Coordinate coordinate = new Coordinate(rowSource, colSource);
            System.out.println("Case "+ h + ": " +bfs(arr, coordinate));

            coordinates.clear();
            h++;
        }
    }
}
