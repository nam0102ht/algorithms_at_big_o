package com.ntnn.twopoints;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AliceBobAndChocolate {
    static boolean arraySortedOrNot(Integer[] arr, int n)
    {

        // Array has one or no element
        if (n == 0 || n == 1)
            return true;

        for (int i = 1; i < n; i++)

            // Unsorted pair found
            if (Integer.compare(arr[i-1], arr[i]) > 0)
                return false;

        // No unsorted pair found
        return true;
    }
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        String line2 = sc.nextLine();
        int[] arr1 = java.util.Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).toArray();

        int i=0;
        int j=n-1;
        int A=arr1[i], B=arr1[j];
        int ca=0,cb=0;
        while(true)
        {
            if(A>B)
            {
                B+=arr1[--j];
                cb++;
            }
            else if(B>=A)
            {
                A+=arr1[++i];
                ca++;
            }
            if(i>j)break;
        }
        System.out.println(ca + " "+ cb);
    }
}
