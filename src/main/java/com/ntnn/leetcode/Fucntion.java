package com.ntnn.leetcode;

import java.util.Scanner;

public class Fucntion {
    void function(String st) {
        if ((st == null) || (st.length() <= 1))
            System.out.println(st);
        else {
            System.out.print(st.charAt(st.length() - 1));
            function(st.substring(0, st.length() - 1));
        }
    }

    public static void main(String[] args) {
        String st = "abc d efg";
        Fucntion obj = new Fucntion();
        obj.function(st);
    }
}
