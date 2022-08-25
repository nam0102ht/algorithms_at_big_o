package com.ntnn;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(true) {
            n = Integer.parseInt(sc.nextLine());
            Queue<Integer> deck = new LinkedList<>();
            Queue<Integer> ans =new LinkedList<>();
            if(n == 0) break;
            for(int i=0; i<n; i++) {
                deck.add(i+1);
            }
            String res = "";
            while (deck.size()>=2) {
                ans.offer(deck.poll());
                deck.offer(deck.poll());
            }
            while (ans.size()>0) {
                res += ans.poll();
                if (ans.size()>0) res += ", ";
            }
            System.out.println("Discarded cards: " + res);
            System.out.println("Remaining card: " + deck.poll());
        }
    }

}
