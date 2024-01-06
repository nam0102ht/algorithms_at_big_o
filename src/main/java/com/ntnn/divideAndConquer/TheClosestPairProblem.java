package com.ntnn.divideAndConquer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TheClosestPairProblem {
  static class Point {
    double x;
    double y;
    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static double distance(Point a, Point b) {
    return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
  }

  static double divide(Point[] arr, int low, int high) {
    if (low >= high) return 99999;
    int mid = (low + high) / 2;
    double min_left = divide(arr, low, mid);
    double min_right = divide(arr, mid + 1, high);
    return combine(arr, low, mid, high, min_left, min_right);
  }

  static double combine(Point[] a, int low, int mid, int high, double min_left, double min_right) {
    double d = Math.min(min_left, min_right);
    double line = (a[mid].x + a[mid + 1].x) * 0.5;
    double min_D = d;

    for (int i = mid + 1; i <= high && a[i].x < line + d; i++) {
      for (int j = mid; j >= low && a[j].x > line - d; j--) {
        double temp = distance(a[i], a[j]);
        if (temp < min_D) min_D = temp;
      }
    }

    return min_D;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int N = scanner.nextInt();
      if (N == 0) break;

      Point[] points = new Point[N];
      for (int i = 0; i < N; i++) {
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        points[i] = new Point(x, y);
      }

      Arrays.sort(points, Comparator.comparingDouble(a -> a.x));

      double dis = divide(points, 0, N - 1);

      if (dis >= 10000.0) {
        System.out.println("INFINITY");
      } else {
        System.out.printf("%.4f\n", dis);
      }
    }

  }
}
