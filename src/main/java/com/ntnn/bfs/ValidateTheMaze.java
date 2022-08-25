package com.ntnn.bfs;

import java.util.*;

public class ValidateTheMaze {
    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean bfs(String[] arr, Coordinate s, Coordinate d) {
        Queue<Coordinate> queue = new LinkedList<>();
        int n = arr.length;
        int m = arr[0].length();
        boolean[][] visited = new boolean[arr.length][arr[0].length()];
        queue.add(s);
        visited[s.x][s.y] = true;
        int[] dx = {-1,1,0,0}; // direction by vertx
        int[] dy = {0,0,-1,1}; // direction by verty
        whileLoop:
        while (!queue.isEmpty()) {
            Coordinate selected_node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempx = selected_node.x + dx[i];
                int tempy = selected_node.y + dy[i];
                if (isValid(tempx, tempy, arr, n, m) && !visited[tempx][tempy]) {
                    visited[tempx][tempy] = true;
                    if (tempx == d.x && tempy == d.y) break whileLoop;
                    queue.add(new Coordinate(tempx, tempy));
                }
            }
        }
        if (visited[d.x][d.y]) return true;
        return false;
    }

    public static boolean isValid(int row, int col, String[] matrix, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && matrix[row].charAt(col) == '.';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int[] lens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = lens[0];
            int m = lens[1];
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
                    if ((j == 0 || j == n - 1 || k == 0 || k == m - 1) && arr[j].charAt(k) == '.') {
                        cnt++;
                        coordinates.add(j);
                        coordinates.add(k);
                    }
                }
            }
            if (cnt == 2) {
                int rowSource = coordinates.get(0);
                int colSource = coordinates.get(1);
                int rowDes = coordinates.get(2);
                int colDes = coordinates.get(3);
                Coordinate coordinate = new Coordinate(rowSource, colSource);
                Coordinate coordinateDes = new Coordinate(rowDes, colDes);
                System.out.println(bfs(arr, coordinate, coordinateDes) ? "valid" : "invalid");

            } else {
                System.out.println("invalid");
            }
            coordinates.clear();
        }
    }
}
