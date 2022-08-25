package com.ntnn.stackAndQueue;
import java.util.*;

public class MassOfMolecule {
    public static int operator(String str) {
        HashMap<String, Integer> map = new HashMap<>() {{
            put("C", 12);
            put("O", 16);
            put("H", 1);
            put("(", 0);
            put(")", -1);
        }};
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length;i++) {
            if(chars[i] == '(') {
                stack.add(map.get(chars[i] + ""));
            } else if (chars[i] == ')') {
                int v = map.get(chars[i] + "");
                int total = 0;
                while(v != 0 && !stack.isEmpty()) {
                    v = stack.pop();
                    if(v != 0) total += v;
                }
                stack.add(total);
            } else if (map.containsKey(chars[i] + "")){
                stack.add(map.get(chars[i]+""));
            } else {
                int v = stack.pop();
                stack.add(v * Integer.parseInt(chars[i] + ""));
            }
        }

        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(operator(str));
    }
}
