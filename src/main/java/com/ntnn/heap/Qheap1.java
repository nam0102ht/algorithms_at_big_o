package com.ntnn.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Qheap1 {
    public static void main(String[] args) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        long n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            long[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (arr[0] == 1L) {
                queue.add(arr[1]);
            } else if (arr[0] == 2L) {
                queue.remove(arr[1]);
            } else if (arr[0] == 3L) {
                System.out.println(queue.peek());
            }
        }
    }
}
