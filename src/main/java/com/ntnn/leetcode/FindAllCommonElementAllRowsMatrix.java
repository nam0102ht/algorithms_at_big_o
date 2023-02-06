package com.ntnn.leetcode;

import java.util.*;

public class FindAllCommonElementAllRowsMatrix {

    public static void printElementInAllRows(int mat[][]) {

        int M = mat.length;
        int N = mat[0].length;
        Map<Integer, Integer> mp = new HashMap<>();

        Vector<Integer> v = new Vector<Integer>();
        // initialize 1st row elements with value 1
        for (int j = 0; j < N; j++)
            mp.put(mat[0][j], 1);

        // traverse the matrix
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // If element is present in the map and
                // is not duplicated in current row.
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i) {
                    // we increment count of the element
                    // in map by 1
                    mp.put(mat[i][j], i + 1);

                    // If this is last row
                    if (i == M - 1)
                        v.add(mat[i][j]);
                    // System.out.print(mat[i][j] + " ");
                }
            }
        }
        Collections.sort(v);
        for (int i = 0; i < v.size(); i++) {
            //get(i) method fetches the element from index i
            System.out.print(v.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }

}
