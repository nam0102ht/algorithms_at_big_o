package com.ntnn.dynamicandstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passwords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int k = Integer.parseInt(str.split(" ")[1]);
        List<String> lst = new ArrayList<>();

        String h;
        for(int i=0; i<n; i++) {
            h = sc.nextLine();
            lst.add(h);
        }
        String password = sc.nextLine();

        int boro = 0;
        int choto = 0;
        for(String s : lst) {
            if (s.length() < password.length()) {
                choto++;
            } else if (s.length() > password.length()){
                boro++;
            }
        }
        int best=(choto*1)+((choto/k)*5)+1;
        int worst=(n-boro-1)+ (((n-boro-1)/k)*5) +1;
        System.out.println(best + " "+ worst);
    }
}
