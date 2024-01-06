package com.ntnn.divideAndConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillTheContainers {
  public static boolean fillAllContainers(List<Integer> vessels, int m, int C) {
    int container = 1;
    int capacity = C;

    for (int i = 0; i < vessels.size(); ++i) {
      if (vessels.get(i) > C) {
        return false;
      }

      if (vessels.get(i) > capacity) {
        if (container == m) {
          return false;
        }
        container++;
        capacity = C;
      }
      capacity -= vessels.get(i);
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      List<Integer> vessels = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        vessels.add(scanner.nextInt());
      }

      int L = 1;
      int U = 1000000000;
      int C = 0;

      while (L <= U) {
        int mid = (L + U) / 2;

        if (fillAllContainers(vessels, m, mid)) {
          C = mid;
          U = mid - 1;
        } else {
          L = mid + 1;
        }
      }

      System.out.println(C);
    }

    scanner.close();
  }
}
