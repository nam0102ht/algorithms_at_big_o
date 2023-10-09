package com.ntnn.string;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            System.out.println(s1[i] + " - " + t1[j]);
            if (s1[i] == t1[j]) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
