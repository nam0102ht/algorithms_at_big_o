package com.ntnn.map;

import java.util.*;

/*s = "abcde"
    words = ["a", "bb", "acd", "ace"]

    Initialization

    "a" → needs 'a' → bucket['a'] = [("a", i=0)]

    "bb" → needs 'b' → bucket['b'] = [("bb", i=0)]

    "acd" → needs 'a' → bucket['a'] = [("a", i=0), ("acd", i=0)]

    "ace" → needs 'a' → bucket['a'] = [("a", i=0), ("acd", i=0), ("ace", i=0)]

    Scan s:

    See 'a': bucket['a'] has 3 items.

    "a" → i=1 → end reached → count++.

    "acd" → i=1 → next needed 'c' → move to bucket['c'].

    "ace" → i=1 → next needed 'c' → move to bucket['c'].

    See 'b': bucket['b'] has "bb".

    "bb" → i=1 → next needed 'b' → stays in bucket['b'].

    See 'c': bucket['c'] has "acd" and "ace".

    "acd" → i=2 → next 'd' → move to bucket['d'].

    "ace" → i=2 → next 'e' → move to bucket['e'].

    See 'd': bucket['d'] has "acd".

    "acd" → i=3 → end → count++.

    See 'e': bucket['e'] has "ace".

    "ace" → i=3 → end → count++.

    Done → count = 3.

 * */

public class SubsequenceCounter {
    static class Node {
        final String w;
        int i; // next index to match

        Node(String w, int i) {
            this.w = w;
            this.i = i;
        }
    }

    public int numMatchingSubseq(String s, List<String> words) {
        Map<Character, Queue<Node>> buckets = new HashMap<>();
        // also a bucket for "completed" words
        Queue<Node> done = new ArrayDeque<>();
        // save all char of word s in the buckets
        for (String word : words) {
            if (word.isEmpty()) {
                done.add(new Node("", 0));
                continue;
            }
            char[] arr = word.toCharArray();
            buckets.computeIfAbsent(arr[0], k -> new LinkedList<>()).add(new Node(word, 0));
        }

        for (char c : s.toCharArray()) {
            Queue<Node> q = buckets.getOrDefault(c, new ArrayDeque<>());
            int size = q.size(); // only process the ones waiting for this char *now*
            for (int k = 0; k < size; k++) {
                Node node = q.poll();
                node.i++; // matched this char
                if (node.i == node.w.length()) {
                    done.add(node); // completed one word
                } else {
                    char next = node.w.charAt(node.i);
                    buckets.computeIfAbsent(next, x -> new ArrayDeque<>()).add(node);
                }
            }
        }
        return done.size();
    }

    public static void main(String[] args) {
        String s = "abcde";
        List<String> strs = Arrays.asList("a", "bb", "acd", "ace");
        SubsequenceCounter subsequenceCounter = new SubsequenceCounter();
        System.out.println(subsequenceCounter.numMatchingSubseq(s, strs)); // 3
    }
}
