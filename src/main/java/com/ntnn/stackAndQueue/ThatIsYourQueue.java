package com.ntnn.stackAndQueue;

import java.util.*;

public class ThatIsYourQueue {
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        int caseNo = 1;
        while (true) {
            int population = sc.nextInt();
            int command = sc.nextInt();
            if (population == 0 && command == 0) {
                break;
            }

            ArrayList<Integer> arr = new ArrayList<>();
            int minimum = Math.min(population, command);
            for (int i = 1; i <= minimum; i++) {
                arr.add(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Case " + (caseNo++) + ":\n");
            for (int i = 0; i < command; i++) {
                int current = 0;
                if (sc.next().equals("N")) {
                    current = arr.remove(0);
                    arr.add(current);
                    sb.append(current + "\n");
                } else {
                    current = sc.nextInt();
                    if (arr.contains(current)) {
                        arr.remove(arr.indexOf(current));
                    }
                    arr.add(current);
                }

            }
            System.out.print(sb.toString());
        }
        sc.close();
    }
}
