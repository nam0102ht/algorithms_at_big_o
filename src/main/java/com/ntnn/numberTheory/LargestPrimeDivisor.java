package com.ntnn.numberTheory;

import java.util.*;
public class LargestPrimeDivisor {
  private static final int n = 10000001; // within sqrt of 1e14
  private static List<Integer> primes;
  private static BitSet isPrime;

  private static void sieve() {
    primes = new ArrayList<>();
    isPrime = new BitSet(n);
    isPrime.set(0, n, true);
    isPrime.set(0, false);
    isPrime.set(1, false);
    for (long i = 2; i < n; i++) {
      if (isPrime.get((int) i)) {
        primes.add((int) i);
        for (long j = i * i; j < n; j += i) {
          isPrime.set((int) j, false);
        }
      }
    }
  }

  public static void main(String[] args) {
    sieve();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      long v = scanner.nextLong();
      if (v == 0) {
        break;
      }
      v = Math.abs(v);
      if (v <= n && isPrime.get((int) v)) {
        System.out.println("-1");
      } else {
        long largest = 0;
        int cnt = 0;
        long cur = v;
        for (int i = 0; i < primes.size() && primes.get(i) <= Math.sqrt(v); i++) {
          if (cur % primes.get(i) == 0) {
            cnt++;
            largest = primes.get(i);
            while (cur % primes.get(i) == 0) {
              cur /= primes.get(i);
            }
          }
        }
        if (cur != 1) {
          largest = cur;
          cnt++;
        }
        if (cnt > 1) {
          System.out.println(largest);
        } else {
          System.out.println("-1");
        }
      }
    }
  }
}
