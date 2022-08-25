package com.ntnn.dynamicandstring;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/*
* According to rules of the Berland fashion, a jacket should be fastened by all the buttons except only one, but not necessarily it should be the last one. Also if the jacket has only one button, it should be fastened, so the jacket will not swinging open.

You are given a jacket with n buttons. Determine if it is fastened in a right way.

Input
The first line contains integer n (1≤n≤1000) — the number of buttons on the jacket.

The second line contains n integers ai (0≤ai≤1). The number ai=0 if the i-th button is not fastened. Otherwise ai=1.

Output
In the only line print the word “YES” if the jacket is fastened in a right way. Otherwise print the word “NO”.

Examples
Input
3
1 0 1
Output
YES
Input
3
1 0 0
Output
NO
* */

public class FashionInBerland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int k;
        for (int i=0; i < n; i++) {
            k = scanner.nextInt();
            list.add(k);
        }
        AtomicInteger ato  = new AtomicInteger();
        if (list.size() == 1) {
            if(list.get(0) == 1) {
                System.out.println("YES");
                return;
            } else {
                System.out.println("NO");
                return;
            }
        }
        list.forEach(v -> {
            if (v.equals(0)) {
                ato.incrementAndGet();
            }
        });
        if (ato.intValue() == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
