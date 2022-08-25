package com.ntnn.stackAndQueue;

import java.util.*;

public class CompilersAndParsers {
    public static int result(String str) {
        Stack<String> stack = new Stack<>();
        char[] chars = str.toCharArray();
        int ans = 0;

        for(int i=0; i<chars.length;i++) {
            if(chars[i] == '<') {
                stack.add(String.valueOf(chars[i]));
            } else {
                if(stack.isEmpty()) {
                    break;
                } else {
                    stack.pop();
                    if(stack.empty()) ans = i +1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while(n-- > 0) {
            String value = scanner.nextLine();
            System.out.println(result(value));
        }
    }
}
