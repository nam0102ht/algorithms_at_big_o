package com.ntnn.twopoints;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class InscreasingTripletSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line2 = sc.nextLine();
        int[] nums = java.util.Arrays.stream(line2.split(",")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< nums.length; i++) {
            System.out.println(Arrays.toString(stack.stream().collect(Collectors.toList()).toArray()));
           if(!stack.empty() && nums[stack.peek()] >= nums[i]) {
               stack.pop();
           }
           if (stack.size() >= 2) {
               System.out.println(true);
               return;
           }
           System.out.println(Arrays.toString(stack.stream().collect(Collectors.toList()).toArray()));
           stack.push(i);
        }
        System.out.println(false);
    }
}
