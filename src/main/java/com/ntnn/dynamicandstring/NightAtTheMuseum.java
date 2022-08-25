package com.ntnn.dynamicandstring;

import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char[] arr = text.toCharArray();
        char start = 'a';
        long sum = 0;
        for (int i=0; i<arr.length;i++) {
            long l1 = Math.abs((int) arr[i] - (int) start);
            long l2 = 26 - l1;
            sum += Math.min(l1, l2);
            start = arr[i];
        }
        System.out.println(sum);
    }
}
