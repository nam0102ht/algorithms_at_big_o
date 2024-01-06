package com.ntnn.backtracking;

import java.util.Scanner;

public class SplittingNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    while(n != 0) {
      boolean addToA = true;
      int toAdd = 1;
      long a = 0;
      long b = 0;

      while (n > 0) {
        if ((n & 1) != 0) {
          if (addToA)
            a += toAdd;
          else
            b += toAdd;

          addToA = !addToA;
        }

        toAdd *= 2;
        n /= 2;
      }
      System.out.println(a + " " + b);
      n = sc.nextLong();
    }
  }
}
