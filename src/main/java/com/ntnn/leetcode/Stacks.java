package com.ntnn.leetcode;

import java.util.*;

public class Stacks {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        sort(stack);
    }

    // Method to sort the elements of the stack in ascending order
    static void sort(Stack<Integer> stack) {
        // Write your code here
        stack.sort((a, b) -> a.compareTo(b));
        System.out.println(stack);
    }
}
