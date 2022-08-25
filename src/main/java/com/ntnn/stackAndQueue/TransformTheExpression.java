package com.ntnn.stackAndQueue;
import java.util.*;

public class TransformTheExpression {
    public static String operator(String str) {
        String res = "";
        List<String> operators = Arrays.asList("+", "-", "*", "/", "^", "(", ")");
        Stack<String> stack = new Stack();
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length;i++) {
            if(!operators.contains(String.valueOf(chars[i]))) {
                res += chars[i];
            } else if(chars[i] == ')') {
                res += stack.pop();
            } else if(chars[i]  != '(') {
                stack.add(String.valueOf(chars[i]));
            }
        }
        return res;
    }

    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = new String[n];
        for(int i=0; i<n;i++) {
            str[i] = sc.nextLine();
        }
        int i = 0;
        while(i<n) {
            System.out.println(operator(str[i]));
            i++;
        }
    }
}
