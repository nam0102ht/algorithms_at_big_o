package com.ntnn.leetcode;

import java.util.*;
public class FindAllSymmetricPairsArray {
    public static void symmetricPair(int[][] arr) {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // First and second elements of current pair
            int first = arr[i][0];
            int sec   = arr[i][1];

            // Look for second element of this pair in hash
            Integer val = hM.get(sec);

            // If found and value in hash matches with first
            // element of this pair, we found symmetry
            if (val != null && val == first)
                System.out.println("" + sec + " " + first + "");

            else  // Else put sec element of this pair in hash
                hM.put(first, sec);
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        symmetricPair(arr);
    }
}
