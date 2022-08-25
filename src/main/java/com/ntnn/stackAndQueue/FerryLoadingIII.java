package com.ntnn.stackAndQueue;

import java.util.*;

public class FerryLoadingIII {

    static class Car {
        int time;
        String position;
        Car(int time, String position) {
            this.time = time;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        start();
    }

    public static void helper(List<Car> map, int t, int n) {
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            Car entry = map.get(i);
            if (entry.position.equals("left")) {
                left.add(entry.time);
            } else {
                right.add(entry.time);
            }
        }

        int curSide = 0;
        int curTime = 0;
        int waiting = (left.isEmpty() ? 1 : 0) + (right.isEmpty() ? 1 : 0);
        int curNext = 0;

        while (waiting !=0) {
            curSide = 0;

        }

    }


    private static void start() {
        Scanner in = new Scanner(System.in);

        int cas = in.nextInt();

        while (cas-- != 0) {
            int n = in.nextInt();
            int t = in.nextInt();
            int m = in.nextInt();
            List<Car> map = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int key = in.nextInt();
                String value = in.next();
                map.add(new Car(key, value));
            }
            helper(map, t, n);
        }
    }
}
