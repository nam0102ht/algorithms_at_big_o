package com.ntnn.stackAndQueue;

import java.util.*;

public class ProcessingQueries {
    static class Data {
        long t;
        long d;
        long f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Data[] lst = new Data[arr[0]];
        for (int i = 0; i < arr[0]; i++) {
            Data data = new Data();
            int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(arr2));
            data.t = arr2[0];
            data.d = arr2[1];
            data.f = 0;
            lst[i] = data;
        }

        Queue<Long> queue = new LinkedList<>();
        long t = lst[0].t + lst[0].d;
        lst[0].f = t;
        queue.add(t);
        for (int i = 1; i < arr[0]; i++) {
            while(!queue.isEmpty() && lst[i].t >= queue.peek()) {
                queue.poll();
            }
            if(t <= lst[i].t){
                t = lst[i].t + lst[i].d;
                lst[i].f = t;
                queue.add(t);
            } else {
                if(queue.size() > arr[1]) {
                    lst[i].f = -1l;
                } else {
                    t += lst[i].d;
                    lst[i].f = t;
                    queue.add(t);
                }
            }
        }
        for (int i = 0; i < lst.length; i++) {
            System.out.print(lst[i].f + " ");
        }
    }
}
