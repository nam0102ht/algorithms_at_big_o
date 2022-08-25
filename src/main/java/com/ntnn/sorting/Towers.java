package com.ntnn.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class Towers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int l = n;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<n-1;i++) {
            if(arr[i] == arr[i+1]) {
                if(hash.containsKey(arr[i])) {
                    hash.put(arr[i], hash.get(arr[i]) + 1);
                } else{
                    hash.put(arr[i], 2);
                }
                l--;
            }
        }
        List<Map.Entry<Integer, Integer>> lst = hash.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).collect(Collectors.toList());
        System.out.println(lst.get(0).getValue() + " " + l);
    }
}
