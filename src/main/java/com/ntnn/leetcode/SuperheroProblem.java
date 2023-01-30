package com.ntnn.leetcode;

import java.util.*;

public class SuperheroProblem {
    static int min(int x, int y, int z)
    {
        if (x < y)
            return Math.min(x, z);
        else
            return Math.min(y, z);
    }
    public static int minJump(int n)
    {
        /* Declare an array to store the minimum jumps. */
        /* Initialise the base condition */
        /* Fill in the array to find Minimum Jumps from a certain distance */
        if (n<=1) return 0;
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 0;
        for(int i=2; i<= n; i++) {
            f[i] = 1 + min(minJump(n-1), minJump((int) n/2), minJump((int) n/3));
        }
        return f[f.length -1];
    }

    public static void main (String args[])
    {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        if(distance>0){
            System.out.println(minJump(distance));
        }
        else {
            System.out.println("Distance should be a positive integer");
        }

    }
}
