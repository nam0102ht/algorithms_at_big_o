package com.ntnn.bitmap;

import java.util.Scanner;

public class MatteyMultiplication {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int q = sc.nextInt();
        while (q--> 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            boolean flag = false;
            for (int i = (int) (Math.log(m) / Math.log(2)); i >= 0; i--) {
                if ((m & (1L << i)) != 0) {
                    if (flag) {
                        System.out.print(" + (" + n + "<<" + i + ")");
                    } else {
                        System.out.print("(" + n + "<<" + i + ")");
                        flag = true;
                    }
                }
            }
        }
    }
}
