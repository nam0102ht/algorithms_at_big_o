package com.ntnn.string;

public class StringCompression {

    public static String compression(String str) {

        StringBuilder res = new StringBuilder();

        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.toCharArray()[i] == str.toCharArray()[i + 1]) {
                count++;
            } else {
                res.append(String.valueOf(str.toCharArray()[i]) + count);
                count = 1;
            }
        }

        return res.toString().length() < str.length() ? res.toString() : str;
    }
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compression(str));
    }
}
