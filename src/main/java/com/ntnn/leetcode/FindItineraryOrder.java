package com.ntnn.leetcode;

import java.util.*;

public class FindItineraryOrder {
    public static void findItinerary(Map<String, String> tickets) {
        Map<String, String> updatedlist = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : tickets.entrySet())
            updatedlist.put(entry.getValue(), entry.getKey());
        String startcity = null;
        for (Map.Entry<String, String> entry : tickets.entrySet()) {
            if (!updatedlist.containsKey(entry.getKey())) {
                startcity = entry.getKey();
                break;
            }
        }
        if (startcity == null) {
            System.out.println("Invalid Input");
            return;
        }
        String dstcity = tickets.get(startcity);
        while (dstcity != null) {
            System.out.print(startcity + "->" + dstcity + "\n");
            startcity = dstcity;
            dstcity = tickets.get(dstcity);
        }
    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tickets.put(sc.next(), sc.next());
        }
        findItinerary(tickets);
    }
}
