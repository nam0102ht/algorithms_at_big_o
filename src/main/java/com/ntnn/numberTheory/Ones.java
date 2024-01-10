package com.ntnn.numberTheory;

import java.util.*;

public class Ones {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n, ones, c;

    while (scanner.hasNextInt()) {
      n = scanner.nextInt();
      ones = 0;
      c = 0;

      do {
        c = (c * 10 + 1) % n;
        ones++;
      } while (c != 0);

      System.out.println(ones);
    }
  }
}
