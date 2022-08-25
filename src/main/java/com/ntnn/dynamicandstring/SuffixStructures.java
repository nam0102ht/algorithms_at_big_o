package com.ntnn.dynamicandstring;

import java.util.*;

public class SuffixStructures {
    static boolean automaton(char[] a, char[] b) {
        int n = 0;
        for (int i = 0; i < a.length && n < b.length; i++) n += a[i] == b[n] ? 1 : 0;
        return n == b.length;
    }

    static boolean both(char[] a, char[] b){
        if (a.length == b.length) {
            return false;
        }
        HashMap<String, Integer> maps = new HashMap<>();
        for (char c : a) {
            if (maps.containsKey(String.valueOf(c))) {
                maps.put(String.valueOf(c), maps.get(String.valueOf(c)) + 1);
            } else {
                maps.put(String.valueOf(c), 1);
            }
        }
        HashMap<String, Integer> maps2 = new HashMap<>();
        for (char c : b) {
            if (maps2.containsKey(String.valueOf(c))) {
                maps2.put(String.valueOf(c), maps2.get(String.valueOf(c)) + 1);
            } else {
                maps2.put(String.valueOf(c), 1);
            }
        }
        for (char c : b) {
            if(maps.get(String.valueOf(c)) < maps2.get(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
    static boolean array(char[] a, char[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> maps = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if(automaton(chars1, chars2)) {
            System.out.println("automaton");
        } else if(array(chars1, chars2)) {
            System.out.println("array");
        } else if (both(chars1, chars2)) {
            System.out.println("both");
        } else {
            System.out.println("need tree");
        }
    }
}
