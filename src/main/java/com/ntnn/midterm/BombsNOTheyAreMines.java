package com.ntnn.midterm;

import java.util.*;

public class BombsNOTheyAreMines {

    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,-1,1};

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValid(int i,int j, int r, int c)
    {
        return i>=0 && i<r && j>=0 && j<c;
    }

    private static int bfs(boolean[][] bombs, Point start, Point end, int r, int c) {
        Queue<Point> q = new LinkedList<>();
        Queue<Integer> cost = new LinkedList<>();
        q.add(start);
        cost.add(0);
        Point s;
        int res = 0;
        boolean[][] taken = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                taken[i][j] = false;
            }
        }
        taken[start.x][start.y] = true;
        while(!q.isEmpty()) {
            s = q.poll();
            res = cost.poll();
            if (s.x == end.x && s.y == end.y) {
                return res;
            }
            for (int i = 0; i < 4; i++) {
                int tempx = s.x + xx[i];
                int tempy = s.y + yy[i];
                if (isValid(tempx, tempy, r, c) && !taken[tempx][tempy] && !bombs[tempx][tempy]) {
                    q.add(new Point(tempx, tempy));
                    taken[tempx][tempy] = true;
                    cost.add(res+1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            if (str.contains("0 0")) break;
            int r = Integer.parseInt(str.split(" ")[0]);
            int c = Integer.parseInt(str.split(" ")[1]);
            int rows = Integer.parseInt(sc.nextLine());
            boolean[][] bombs = new boolean[r][c];
            for (int i = 0; i < rows; i++) {
                String str2 = sc.nextLine();
                int id = Integer.parseInt(str2.split(" ")[0]);
                int value2 = Integer.parseInt(str2.split(" ")[1]);
                for (int j = 0; j < value2; j++) {
                    bombs[id][Integer.parseInt(str2.split(" ")[j+2])] = true;
                }
            }
            int[] start =Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point pstart = new Point(start[0], start[1]);
            int[] end =Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point pend = new Point(end[0], end[1]);
            System.out.println(bfs(bombs, pstart, pend, r, c));
        }
    }
}
