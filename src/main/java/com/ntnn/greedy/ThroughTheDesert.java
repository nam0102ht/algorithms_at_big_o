package com.ntnn.greedy;

import java.util.Scanner;

class ThroughTheDesert {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      if (s.equals("0 Fuel consumption 0")) {
        break;
      }

      double res = 0.0, cur = 0.0;
      int x = 0, y, n = 0, leak = 0;

      do {
        String cmd;
        String[] parts = s.split(" ");
        y = Integer.parseInt(parts[0]);
        cmd = parts[1];

        cur += leak * (y - x);
        cur += n * (y - x) / 100.0;
        res = Math.max(res, cur);

        if (cmd.equals("Goal")) {
          break;
        } else if (cmd.equals("Mechanic")) {
          leak = 0;
        } else if (cmd.equals("Gas") && parts[2].equals("station")) {
          cur = 0.0;
        } else if (cmd.equals("Leak")) {
          leak++;
        } else if (cmd.equals("Fuel")) {
          n = Integer.parseInt(parts[3]);
        }

        x = y;
      } while (scanner.hasNextLine() && !(s = scanner.nextLine()).isEmpty());

      System.out.printf("%.3f\n", res);
    }

    scanner.close();
  }
}
