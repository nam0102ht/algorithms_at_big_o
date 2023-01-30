package com.ntnn.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PrefixEvaluationSingleDigitOperand {

    public static int evaluate(int a, int b, String operator){
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return b - a;
            case "*":
                return a * b;
            case "/":
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
    public static int convert(String expression) {
        List<String> operators = Arrays.asList("+", "-", "*", "/", "^", "(", ")");
        Stack<Integer> stack = new Stack<>();
        String[] strs = expression.split(" ");
        for(int i= strs.length -1; i>=0; i--) {
            String str = strs[i];
            if(!operators.contains(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                if (str.equals("(") || str.equals(")")) continue;
                int a = stack.pop();
                int b = stack.pop();
                stack.push(evaluate(a, b, str));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String exp = "( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )";
        int res = convert(exp);
        System.out.println("Evaluation: " + convert(exp));
    }
}