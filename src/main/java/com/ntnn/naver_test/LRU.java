package com.ntnn.naver_test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRU {

    /*
     * Complete the 'getMinimumSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY requests
     *  2. INTEGER k
     */

    static class ListNode {
        String val;
        ListNode next;
        ListNode prev;

        ListNode() {}

        ListNode(String val) {
            this.val = val;
        }

        ListNode(String val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    static class LruCache {
        Map<String, ListNode> index = new HashMap<>();

        ListNode head;
        ListNode tail;

        int size;
        int capacity;

        public LruCache(int cap) {
            this.capacity = cap;
            this.size = 0;
            this.head = new ListNode();
            this.tail = new ListNode();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void add(String val) {
            if (index.containsKey(val)) {
                return;
            }

            if (size == capacity) {
                remove(tail.prev);
            }

            ListNode node = new ListNode(val);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            ++size;
            index.put(val, node);
        }

        public void remove(String val) {
            ListNode node = index.get(val);
            if (node == null) return;
            remove(node);
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            --size;
            index.remove(node.val);
        }

        public boolean contains(String val) {
            if (index.containsKey(val)) {
                ListNode node = index.get(val);
                remove(node);
                add(val);
                return true;
            }


            return false;
        }

    }

    public static int getMinimumSize(List<String> requests, int k) {
        int l = 1;
        int r = requests.size();

        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hit = stimulate(requests, mid);
            if (hit >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static int stimulate(List<String> requests, int mid) {
        LruCache cache = new LruCache(mid);
        int hit = 0;

        for (String req : requests) {
            if (cache.contains(req)) {
                ++hit;
            } else {
                cache.add(req);
            }
        }

        return hit;
    }

}
