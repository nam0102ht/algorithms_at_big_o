package com.ntnn.cycleSort;

public class CycleSort {
  public static void cycleSort(int[] a) {
    final int n = a.length;
    for (int start = 0; start <= n - 2; start++) {
      int item = a[start];

      // 1) Find where to put item
      int pos = start;
      for (int i = start + 1; i < n; i++) {
        if (a[i] < item) pos++;
      }
      if (pos == start) continue; // already in correct spot

      // Skip duplicate values
      while (item == a[pos]) pos++;

      // 2) Put item to its right place
      if (item != a[pos]) {
        int tmp = a[pos];
        a[pos] = item;
        item = tmp;
      }

      // 3) Rotate the rest of the cycle
      while (pos != start) {
        pos = start;
        for (int i = start + 1; i < n; i++) {
          if (a[i] < item) pos++;
        }
        while (item == a[pos]) pos++;

        if (item != a[pos]) {
          int tmp = a[pos];
          a[pos] = item;
          item = tmp;
        }
      }
    }
  }

  // quick demo
  public static void main(String[] args) {
    int[] a = {20, 40, 50, 10, 30, 20, 40};
    cycleSort(a);
    System.out.println(java.util.Arrays.toString(a)); // [10, 20, 20, 30, 40, 40, 50]
  }
}
