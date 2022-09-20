package com.ntnn.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MonkAndMultiplication {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            heap.add(k);
            if(heap.size() < 3) {
                System.out.println(-1);
            } else {
                int a = heap.poll();
                int b =  heap.poll();
                int c = heap.poll();
                System.out.println(a*b*c);
                heap.add(a);
                heap.add(b);
                heap.add(c);
            }
        }
    }
}
