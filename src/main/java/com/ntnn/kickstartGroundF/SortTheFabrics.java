package com.ntnn.kickstartGroundF;

import java.util.*;

public class SortTheFabrics {
    static class Fabrics {
        String C;
        Integer D;
        Integer U;

        public String getC() {
            return C;
        }

        public Integer getD() {
            return D;
        }

        public Integer getU() {
            return U;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cases = 1;
        while(n-->0) {
            int k = sc.nextInt();
            List<Fabrics> lst1 = new ArrayList<>();
            List<Fabrics> lst2 = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                Fabrics fabrics = new Fabrics();
                fabrics.C = sc.next();
                fabrics.D = sc.nextInt();
                fabrics.U = sc.nextInt();
                lst1.add(fabrics);
                lst2.add(fabrics);
            }

            Collections.sort(lst1, Comparator.comparing(Fabrics::getC).thenComparing(Fabrics::getU));

            Collections.sort(lst2, Comparator.comparing(Fabrics::getD).thenComparing(Fabrics::getU));

            int same = 0;

            for (int i = 0; i < k; i++) {
                int comparator = lst1.get(i).U.compareTo(lst2.get(i).U) == 0 ? 1 : 0;
                same += comparator;
            }

            System.out.println("Case #"+ cases + ": " + same);
            cases++;
        }
    }
}
