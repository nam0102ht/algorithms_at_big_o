package com.ntnn.tries;

import java.util.List;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) == strs[0].charAt(i)) {
                    return builder.toString();
                }
                builder.append(String.valueOf(str.charAt(i)));
            }
        }

        return  builder.toString();

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix((String[]) List.of("abc", "abkkkk", "abcsas").toArray()));
    }
}
