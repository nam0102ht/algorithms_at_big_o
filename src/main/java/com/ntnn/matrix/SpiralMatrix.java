package com.ntnn.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  /*
  *  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
  *  Output: 1,2,3,6,9,8,7,4,5]
  * */

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int n = matrix.length;
    int m = matrix[0].length;
    int left = 0;
    int bottom = n - 1;
    int right = m - 1;
    int top = 0;
    while (top <= bottom && left <= right) {
      // left to right
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      top++;
      // top to bottom
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      right--;

      if (top <= bottom) {
        // right to left
        for (int j = right; j >= left ; j--) {
          result.add(matrix[bottom][j]);
        }
        bottom--;
      }
      // bottom to top
      if (left <=  right) {
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
    System.out.println(spiralOrder(matrix));
  }
}
