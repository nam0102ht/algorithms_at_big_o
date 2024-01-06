package com.ntnn.backtracking;

import java.util.Scanner;

public class TheHammingDistanceProblem {

  private static boolean isSetBit(int i, int index) {
    return (i & (1 << index)) != 0;
  }

  private static void decimalToBinary(int i, int N) {
    StringBuilder sb = new StringBuilder();
    for (int j = N - 1; j >= 0; --j) {
      if (isSetBit(i, j)) {
        sb.append('1');
      } else {
        sb.append('0');
      }
    }
    System.out.println(sb);
  }

  private static void printSolutions(int N, int H) {
    for (int i = 0; i < (1 << N); ++i) {
      if (Integer.bitCount(i) == H) {
        decimalToBinary(i, N);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int k = 0;

    while (T-- > 0) {
      int N = scanner.nextInt();
      int H = scanner.nextInt();

      if (k > 0) {
        System.out.println();
      }

      printSolutions(N, H);
      ++k;
    }
  }
}
