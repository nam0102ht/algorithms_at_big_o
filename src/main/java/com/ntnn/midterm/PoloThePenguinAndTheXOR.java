package com.ntnn.midterm;

import java.util.*;

public class PoloThePenguinAndTheXOR {
  static int T;
  static int N;
  static long[] arr;
  static long[] S;
  static long[] numOnes;

  public static void main(String[] args) {
    /*
    * 1
    * 2
    * 1 2
    * */
    Scanner scan = new Scanner(System.in);
    T = scan.nextInt();
    while (T-- > 0) {
      N = scan.nextInt();
      arr = new long[N];
      for (int i = 0; i < N; i++) {
        arr[i] = scan.nextLong();
      }

      S = new long[N + 1];
      for (int i = 1; i <= N; i++) {
        S[i] = S[i - 1] ^ arr[i - 1];
      }

      numOnes = new long[32];

      long ans = 0;
      for (int r = 1; r <= N; r++) {
        long s = getSum(r);
        ans += s;
      }
      System.out.println(ans);
    }
  }

  private static long getSum(int r) {
    for (int i = 31; i >= 0; i--) {
      long bit = (S[r - 1] >> i) & 1;
      numOnes[i] += bit;
    }

    long ans = 0;
    for (int i = 31; i >= 0; i--) {
      long bit = (S[r] >> i) & 1;
      if (bit == 1) {
        ans += (r - numOnes[i]) * Math.pow(2, i);
      } else {
        ans += numOnes[i] * Math.pow(2, i);
      }
    }
    return ans;
  }
}
