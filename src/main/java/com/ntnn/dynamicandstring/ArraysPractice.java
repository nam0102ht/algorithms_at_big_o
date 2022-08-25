package com.ntnn.dynamicandstring;

import java.util.Scanner;

public class ArraysPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        int[] lengths = java.util.Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] positions = java.util.Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr1 = java.util.Arrays.stream(s3.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = java.util.Arrays.stream(s4.split(" ")).mapToInt(Integer::parseInt).toArray();

        if(arr1[positions[0] - 1] < arr2[lengths[1] - positions[1]]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
