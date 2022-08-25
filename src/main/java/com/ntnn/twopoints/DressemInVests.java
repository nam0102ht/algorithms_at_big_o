package com.ntnn.twopoints;
import java.util.*;

public class DressemInVests {
    public static void main(String ...args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        int[] lens = java.util.Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr1 = java.util.Arrays.stream(s3.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = java.util.Arrays.stream(s4.split(" ")).mapToInt(Integer::parseInt).toArray();

        int l = 0;
        int r = 0;
        List<String> lst = new ArrayList<>();
        while(l < lens[0] && r < lens[1]) {
            int sm = arr1[l] - lens[2];
            int bg = arr1[l] + lens[3];
            if (sm <= arr2[r] && bg >= arr2[r]) {
                lst.add((l+1) + " " + (r+1));
                l++;
                r++;
            } else if(sm > arr2[r]) {
                r++;
            } else if(bg < arr2[r]) {
                l++;
            }
        }
        System.out.println(lst.size());
        lst.forEach(System.out::println);
    }
}
