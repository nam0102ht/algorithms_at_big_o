package com.ntnn.numberTheory;

import java.util.*;

public class DynamicFrog {
  static class Data implements Comparable<Data> {
    int d;
    char kind;

    @Override
    public int compareTo(Data rhs) {
      return Integer.compare(this.d, rhs.d);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    List<Data> v = new ArrayList<>();

    for (int ti = 1; ti <= t; ++ti) {
      int n = scanner.nextInt();
      int d = scanner.nextInt();
      v.clear();
      for (int i = 0; i < n; ++i) {
        Data data = new Data();
        String str = scanner.next();
        data.kind = str.split("-")[0].toCharArray()[0];
        data.d = Integer.parseInt(str.split("-")[1]);
        v.add(data);
      }

      Collections.sort(v);
      int ans = 0;
      int cur = 0;
      int[] frog = new int[2];
      frog[0] = frog[1] = 0;

      for (int i = 0; i < n; ++i) {
        if (v.get(i).kind == 'B') {
          ans = Math.max(ans, Math.max(v.get(i).d - frog[0], v.get(i).d - frog[1]));
          frog[0] = frog[1] = v.get(i).d;
        } else {
          ans = Math.max(ans, v.get(i).d - frog[cur]);
          frog[cur] = v.get(i).d;
          cur = 1 - cur;
        }
      }

      ans = Math.max(ans, Math.max(d - frog[0], d - frog[1]));
      System.out.println("Case " + ti + ": " + ans);
    }
  }
}
