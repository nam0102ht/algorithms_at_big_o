package com.ntnn.bitmap;

import java.io.IOException;
import java.util.Scanner;

public class PowerOfTwo {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-->0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        max = Math.max(max, arr[i]);
      }

      System.out.printf("max is %d \n", max);

      boolean flag = false;
      // find the power of 2
      int power = (int) (Math.log10(max) / Math.log(2));
      System.out.printf("Power is = %d \n", power);
      for (int i = 0; i <= power; i++) {
        int mask = 1 << i;
        System.out.printf("Mask is %d \n", mask);
        int mul = -1;
        for (int j = 0; j < n; j++) {
          if ((arr[j] & mask) != 0 ) {
            if (mul != -1) {
              mul = arr[j];
            } else {
              mul &= arr[j];
            }
          }
          System.out.printf("Mul is %d \n", mul);
          if (mul == mask) {
            flag = true;
            break;
          }
        }
      }

      if (flag) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
    
  }
}
