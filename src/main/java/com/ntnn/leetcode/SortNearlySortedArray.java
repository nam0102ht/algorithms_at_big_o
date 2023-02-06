package com.ntnn.leetcode;

import java.util.*;

public class SortNearlySortedArray {
    private static void sortArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        // min heap
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>();
        // if there are less than k + 1 elements present in
        // the array
        int minCount = Math.min(arr.length, k + 1);
        // add first k + 1 items to the min heap
        for (int i = 0; i < minCount; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        // here even if size=k then n will be n=k,so i<n
        // works fine
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
