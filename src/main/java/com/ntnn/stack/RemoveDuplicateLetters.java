package com.ntnn.stack;

/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order
 among all possible results.



Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();
        int[] lastOccur = new int[26];

        for (int i=0; i<s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!visited.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && i < lastOccur[stack.peek() - 'a']) {
                    visited.remove(stack.pop());
                }
                stack.push(s.charAt(i));
                visited.add(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder("");
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
