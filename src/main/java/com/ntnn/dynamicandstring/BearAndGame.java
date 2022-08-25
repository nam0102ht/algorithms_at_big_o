package com.ntnn.dynamicandstring;

import java.util.ArrayList;
import java.util.Scanner;

public class BearAndGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int k;
        for(int i=0; i<n; i++) {
            k = sc.nextInt();
            list.add(k);
        }
        int count = 0;
        if(list.get(0) > 15) {
            System.out.println("15");
            return;
        }
        for(int i=0; i<list.size() - 1; i++) {
            if ((list.get(i+1) - list.get(i)) <= 15) {
                count++;
            } else {
                System.out.println(list.get(i) + 15);
                return;
            }
        }
        int value = list.get(count) + 15;
        System.out.println(value > 90 ? 90 : value);
    }
}
