package com.ntnn.dynamicandstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigSegment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> subList;
        String str;
        String[] strs;
        for(int i = 0; i< n; i++) {
            subList = new ArrayList();
            str = sc.nextLine();
            strs = str.split(" ");
            subList.add(Integer.parseInt(strs[0]));
            subList.add(Integer.parseInt(strs[1]));
            lst.add(subList);
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n;i++) {
            List<Integer> a = lst.get(i);
            max = Math.max(a.get(1), max);
            min = Math.min(a.get(0), min);
        }
        for(int i=0; i<n;i++) {
            List<Integer> a = lst.get(i);
            if (max == a.get(1) && min == a.get(0)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}
