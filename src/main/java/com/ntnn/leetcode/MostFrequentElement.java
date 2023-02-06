package com.ntnn.leetcode;

import java.util.*;

public class MostFrequentElement {
    public static int mostFrequentElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int value  = -1;
        HashMap<Integer, Integer> count = new HashMap<>();
        // put all data into the hashmap and use function getOrDefault to count data.
        for(int i=0; i<arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> v : count.entrySet()) {
            if (max < v.getValue()) {
                max = v.getValue();
                value = v.getKey();
            }
        }
        return value;
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }
}
