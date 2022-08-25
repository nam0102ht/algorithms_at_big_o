package com.ntnn.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class GukiZAndContest {
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<n;i++) {
            hash.put(i, Integer.parseInt(str[i]));
        }
        List<Map.Entry<Integer, Integer>> lst = hash.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).collect(Collectors.toList());
        int last = n;
        int ans = 0;
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();
        System.out.println(Arrays.toString(lst.toArray()));
        for (int i = 0; i < lst.size(); i++) {
            Map.Entry<Integer, Integer> entry = lst.get(i);
            if(entry.getValue() != last) {
                last = entry.getValue();
                ans = i + 1;
            }
            if (ans == 0) ans++;
            result.add(Map.entry(entry.getKey(), ans));
        }
        result = result.stream().sorted((a, b) -> Integer.compare(b.getKey(), a.getKey())).collect(Collectors.toList());
        String res = "";
        for (int i = 0; i < result.size(); i++) {
            res = String.join(" ", String.valueOf(result.get(i).getValue()), res);
        }
        System.out.println(res);
    }
}
