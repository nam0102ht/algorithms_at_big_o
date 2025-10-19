package com.ntnn.matrix;

import java.util.Arrays;

public class RotateImage {
  /*
  * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
  * Output: [[7,4,1],[8,5,2],[9,6,3]]
  */

  public static void rotate(int[][] matrix) {
    transpose(matrix);
    reflect(matrix);
  }

  public static void transpose(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < matrix[0].length; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
  }

  public static void reflect(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n / 2; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = tmp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
    rotate(matrix);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }
}
