package com.ntnn.numberTheory;

import java.util.*;

public class IrreducibleBasicFractions {
  private static final int N = 40000;
  private static List<Integer> primes;
  private static void sieve(){
    primes = new ArrayList<>();
    BitSet isPrime = new BitSet(N);
    isPrime.set(0, N, true);
    isPrime.set(0, false);
    isPrime.set(1, false);
    for (int i = 2; i < N; i++) {
      if (isPrime.get(i)) {
        primes.add(i);
        for (long j = (long) i * i; j < N; j += i) {
          isPrime.set((int) j, false);
        }
      }
    }
  }

  private static int eulerPhi(int n) {
    int ans = n; // itself
    for (int idx = 0; primes.get(idx) * primes.get(idx) <= n; idx++) {
      if (n % primes.get(idx) == 0) {
        ans -= ans / primes.get(idx);
      }
      while (n % primes.get(idx) == 0) {
        n /= primes.get(idx);
      }
    }
    if (n != 1) {
      ans -= ans / n;
    }
    return ans;
  }

  public static void main(String[] args) {
    sieve();
    Scanner scanner = new Scanner(System.in);
    int n;
    while ((n = scanner.nextInt()) != 0) {
      System.out.println(eulerPhi(n));
    }
  }
}
