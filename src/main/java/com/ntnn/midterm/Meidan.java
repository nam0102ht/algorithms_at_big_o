package com.ntnn.midterm;

import java.util.*;

public class Meidan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numArray = new int[n];
        for (int i = 0; i < n; i++) {
            numArray[i] = sc.nextInt();
        }
        Arrays.sort(numArray);
        int middle = numArray.length/2;
        int medianValue = 0; //declare variable
        if (numArray.length%2 == 1)
            medianValue = numArray[middle];
        else
            medianValue = (numArray[middle-1] + numArray[middle]) / 2;
        System.out.println(medianValue);
    }
}
