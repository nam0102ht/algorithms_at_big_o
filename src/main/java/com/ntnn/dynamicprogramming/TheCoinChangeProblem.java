package com.ntnn.dynamicprogramming;

import java.io.*;
import java.util.*;

public class TheCoinChangeProblem {
    public static long getWays(int n, List<Long> c) {
        // Write your code here
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (long i=0; i<c.size(); i++) {
            for (long j = c.get(Integer.parseInt(String.valueOf(i))); j <= n; j++) {
                table[(int) j] += table[(int) (j - c.get(Integer.parseInt(String.valueOf(i))))];
            }
        }
        return table[n];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getWays(10, Arrays.asList(2l, 5l, 3l, 6l)));
    }
}
