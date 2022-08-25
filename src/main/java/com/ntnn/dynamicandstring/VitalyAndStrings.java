package com.ntnn.dynamicandstring;

import java.util.Scanner;

public class VitalyAndStrings {
    public static void main(String[] args) {
        // find the string has value lager than S and smaller than T
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        String zstr = "";

        if (s1.length() != s2.length()) {
            System.out.print("No such string");
            return;
        }
        for(int i = s1.length() - 1; i >= 0; i--) {
            char ch = s1.charAt(i);
            if(ch == 'z') {
                zstr += 'a';
            } else {
                break;
            }
        }
        int index = s1.length() - zstr.length() - 1;
        String ans = s1.substring(0, index) + (char)(s1.charAt(index) + 1) + zstr;
        if (s2.equals(ans)) {
            System.out.println("No such string");
            return;
        }
        System.out.println(ans);
    }
}
