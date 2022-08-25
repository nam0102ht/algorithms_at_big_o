package com.ntnn.twopoints;
import java.util.*;

public class ApproximatingConstantRange {
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s3 = sc.nextLine();
        int lens = Integer.parseInt(s1);
        int[] arr1 = java.util.Arrays.stream(s3.split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> lst = new ArrayList<>();
        //initial values
        int prev = -1;
        int current = 0, next = 0;
        int prevCount = 0, currentCount = 1;

        //longest constant range length
        int longest = 1;
        int max = arr1[0];
        for(int i=0; i<lens-1;i++) {
            next = arr1[i+1];
            current = arr1[i];
            if (next == current) {
                currentCount++;
            } else if (next == prev) {
                prevCount += currentCount;
                prev = current;
                current = next;
                currentCount = 1;
            } else {

                longest = Math.max(longest, currentCount + prevCount);

                prev = current;
                prevCount = currentCount;
                current = next;
                currentCount = 1;
            }
        }

        System.out.println(Math.max(longest, currentCount + prevCount));
    }
}
