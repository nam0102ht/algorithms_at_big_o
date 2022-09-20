package com.ntnn.heap;

import java.util.*;

public class RestaurantRating {
    static class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(new MaxComparator());
        int output = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (arr[0] == 1) {
                total++;
                if (arr[1] > output) {
                    pq.add(arr[1]);
                } else {
                    pqMax.add(arr[1]);
                }
            } else if (arr[0] == 2) {
                if (total > 2) {
                    while (pq.size() > total / 3)
                        pqMax.add(pq.remove());
                    while (pq.size() < total / 3)
                        pq.add(pqMax.remove());
                    output = pq.peek();
                    System.out.println(output);
                }
                else {
                    System.out.println("No reviews yet");
                }
            }
        }
    }
}
