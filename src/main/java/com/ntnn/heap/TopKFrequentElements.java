package com.ntnn.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[k];

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int i:map.keySet()){
            queue.add(i);
        }
        for(int i=0; i<k; i++){
            ans[i]=queue.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));

    }
}
