package com.ntnn.heap;

/*
* A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored)
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumDeletionToMakeFrequenciesUnique {

    // priority queue
    public static int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.addAll(map.values());
        int count = 0;
        while (heap.size() > 1) {
            int top = heap.poll();
            if (heap.peek() != null && heap.peek() == top && top != 0) {
                count++;
                heap.add(top - 1);
            }
        }
        return count;
    }

    // greedy
    public static int minDeletionsGreedy(String s) {
        int[] frequencies = new int[26];
        Arrays.fill(frequencies, 0);
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            frequencies[s.charAt(i) - 'a']++;
        }
        int top = 0;
        for (int i=0; i<frequencies.length; i++) {
            int curFreq = frequencies[i];
            while (curFreq > 0 && visited.contains(curFreq)) {
                curFreq--;
                top++;
            }
            visited.add(curFreq);
        }
        return top;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionsGreedy("aab"));
        System.out.println(minDeletionsGreedy("aaabbbcc"));
        System.out.println(minDeletionsGreedy("ceabaacb"));
    }
}
