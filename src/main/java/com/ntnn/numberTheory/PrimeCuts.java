package com.ntnn.numberTheory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeCuts {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    SieveOfEratosthenes soe = new SieveOfEratosthenes(1000);
    boolean[] arr = soe.getArray();
    arr[1] = true;
    int[] agg = new int[1001];
    for (int i = 1; i < agg.length; i++) {
      agg[i] += agg[i - 1];
      if (arr[i]) agg[i]++;
    }

    while (true) {
      int n = in.nextInt();
      int c = in.nextInt();
      int startIndex = (agg[n] % 2 == 0) ? (agg[n] / 2) : (agg[n] / 2 + 1);
      startIndex -= (c - 1);
      startIndex = startIndex > 0 ? startIndex : 1;
      int endIndex = startIndex + ((agg[n] % 2 == 0) ? (2 * c - 1) : (2 * c - 2));
      endIndex = Math.min(endIndex, n);

      System.out.print(n + " " + c + ":");
      int index = 0;
      for (int i = 1; i <= n; i++) {

        if (arr[i]) {
          index++;
          if (index >= startIndex && index <= endIndex) {
            System.out.print(" " + i);
          }
        }
      }
      System.out.println();
      System.out.println();
    }
  }

  public static class SieveOfEratosthenes {
    private boolean[] a;

    public SieveOfEratosthenes(int N) {
      a = new boolean[N + 1];
      for (int i = 0; i <= N; i++) {
        a[i] = true;
      }
      a[0] = false;
      a[1] = false;

      int root = (int) Math.sqrt(N);
      for (int i = 2; i <= root; i++) {
        for (int j = 2 * i; j <= N; j += i) {
          a[j] = false;
        }
      }
    }

    public boolean[] getArray() {
      return a;
    }

    public boolean isPrime(int n) {
      return a[n];
    }

    public List<Integer> getPrimes() {
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 1; i < a.length; i++) {
        if (a[i]) {
          list.add(i);
        }
      }
      return list;
    }
  }

  public static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream));
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (Exception e) {
          System.exit(0);
        }
      }
      return tokenizer.nextToken();
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}