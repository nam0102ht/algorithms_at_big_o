package com.ntnn.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class TrickyFunction {
  static class Point {
    long x;
    long y;

    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  static long dist(Point A, Point B) {
    return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
  }

  static boolean comp(Point A, Point B) {
    return A.y < B.y;
  }

  static long solve(int st, int dr, Point[] points) {
    if (st >= dr)
      return Long.MAX_VALUE;
    else if (st + 1 == dr) {
      if (points[st].y > points[dr].y)
        swap(points, st, dr);
      return dist(points[st], points[dr]);
    }

    int m = (st + dr) / 2;
    long medianX = points[m].x;
    long d1 = solve(st, m, points);
    long d2 = solve(m + 1, dr, points);
    long d = Math.min(d1, d2);

    Point[] auxiliar = new Point[points.length];
    for (int i = st; i <= dr; ++i)
      auxiliar[i] = points[i];

    int i = st, j = m + 1, k = st;

    while (i <= m && j <= dr) {
      if (auxiliar[i].y <= auxiliar[j].y)
        points[k++] = auxiliar[i++];
      else
        points[k++] = auxiliar[j++];
    }

    while (i <= m)
      points[k++] = auxiliar[i++];
    while (j <= dr)
      points[k++] = auxiliar[j++];

    int dim = 0;

    for (int x = st; x <= dr; ++x) {
      if (Math.abs(points[x].x - medianX) <= d)
        auxiliar[dim++] = points[x];
    }

    for (int x = 0; x < dim; ++x) {
      int cnt = 8;
      int j1 = x - 1;

      while (j1 >= 0 && cnt > 0) {
        d = Math.min(d, dist(auxiliar[x], auxiliar[j1]));
        j1--;
        cnt--;
      }
    }

    return d;
  }

  static long closestPair(Point[] points) {
    Arrays.sort(points, (a, b) -> Long.compare(a.x, b.x));
    return solve(0, points.length - 1, points);
  }

  public static void main(String[] args) throws IOException {
    Scanner br = new Scanner(System.in);

    int N = br.nextInt();

    Point[] points = new Point[N];
    long sum = 0;

    for (int i = 0; i < N; ++i) {
      int a = br.nextInt();
      sum += a;

      points[i] = new Point(i, sum);
    }

    System.out.println(closestPair(points));
  }

  private static void swap(Point[] points, int i, int j) {
    Point temp = points[i];
    points[i] = points[j];
    points[j] = temp;
  }
}