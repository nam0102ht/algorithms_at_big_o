package com.ntnn.midterm;

import java.util.*;

public class PalindromicSeries {
  public static boolean isPallan(int n) {
    List<Character> v = new ArrayList<>();
    List<Character> v1 = new ArrayList<>();
    List<Character> v2 = new ArrayList<>();
    int count = 0;

    while (n > 0) {
      int x = n % 10;
      n = n / 10;
      count = count + x;
      v.add((char) (97 + x));
    }

    Collections.reverse(v);
    int j = 0;
    int i = 0;

    while (i < count) {
      if (j < v.size()) {
        v1.add(v.get(j));
        j++;
      }
      i++;

      if (j == v.size()) {
        j = 0;
      }
    }

    for (int k = 0; k < count; k++) {
      v2.add(v1.get(k));
    }

    Collections.reverse(v1);

    for (int k = 0; k < count; k++) {
      if (v1.get(k) != v2.get(k)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    /*
    * input
    * 4
    * 61
    * 10101
    * 1998
    * 1234567
    * */
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while(n-->0) {
      int x = sc.nextInt();
      System.out.println(isPallan(x) ? "YES" : "NO");
    }
  }
}
