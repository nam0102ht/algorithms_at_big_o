package com.ntnn;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int[] arr = {2, 3, 45, 5, 5, 56, 6, 72};
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 0);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        map.forEach((k, v) -> {
            if (v >= 1) System.out.println(k);
        });
    }
}