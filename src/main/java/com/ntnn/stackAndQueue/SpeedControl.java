package com.ntnn.stackAndQueue;

import java.util.Arrays;

public class SpeedControl {

    static int solution(String s) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.toCharArray()[i] == '.') {
                right[i] = r;
            } else if (s.toCharArray()[i] == '>') {
                r = r + 1;
            }
        }

        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            if (s.toCharArray()[i] == '.') {
                left[i] = l;
            } else if (s.toCharArray()[i] == '<') {
                l = l + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = ans + left[i] + right[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(".>..."));
        System.out.println(solution(".>.<.>"));
        System.out.println(solution(">>>.<<<"));
    }
}
