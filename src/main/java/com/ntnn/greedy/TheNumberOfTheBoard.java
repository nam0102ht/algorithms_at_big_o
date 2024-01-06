package com.ntnn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class TheNumberOfTheBoard {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long k = scanner.nextLong();
    String s = scanner.next();

    long sum = 0;
    char[] arr = s.toCharArray();
    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      sum += (arr[i] - '0');
    }

    if (sum >= k) {
      System.out.println("0");
      return;
    }

    long mm = k - sum;
    long smm = 0;
    long ans = 0;

    for (int i = 0; i < arr.length; i++) {
      smm += (9 - (arr[i] - '0'));
      if (smm >= mm) {
        ans = i;
        break;
      }
    }

    System.out.println(ans + 1);
  }
}