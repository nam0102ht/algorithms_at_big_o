package com.ntnn.leetcode;

import java.util.*;

public class FindKthLargestElementStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int stream[] = new int[n];
        for (int i = 0; i < n; i++) {
            stream[i] = sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {

            // If size of priority
            // queue is less than k
            if (pq.size() < k)
                pq.add(stream[i]);
            else {
                if (stream[i] > pq.peek()) {
                    pq.remove();
                    pq.add(stream[i]);
                }
            }

            // If size is less than k
            if (pq.size() < k)
                ans[i] = -1;
            else
                ans[i] = pq.peek();
        }

        for (int i=0; i< n; i++) {
            if (ans[i] == -1) {
                System.out.println("None");
            } else {
                System.out.println(k + " largest number is "+ans[i]);
            }
        }
    }
}
