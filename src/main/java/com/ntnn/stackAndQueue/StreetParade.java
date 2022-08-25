package com.ntnn.stackAndQueue;
import java.util.*;

public class StreetParade {
    public static void check(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int start = 1;
        boolean result = true;
        for(int i=0; i< arr.length; i++) {
            while(!stack.isEmpty() && stack.peek() == start) {
                stack.pop();
                start += 1;
            }
            if (arr[i] == start) {
                start +=1;
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                result = false;
                break;
            } else {
                stack.add(arr[i]);
            }
        }
        System.out.println(result ? "yes" : "no");
    }
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String line;
        int[] arr;
        while(true) {
            n = Integer.parseInt(sc.nextLine());
            if (n == 0) {
                break;
            }
            line = sc.nextLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();;
            check(arr);
        }

    }
}
