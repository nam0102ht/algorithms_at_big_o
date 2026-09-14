package com.ntnn.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheLinkedList {
  private final int capacity;

  private final Map<Integer, Integer> cache;

  private final LinkedList<Integer> usage;

  public LRUCacheLinkedList(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.usage = new LinkedList<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    // Key becomes most recently used
    usage.remove(Integer.valueOf(key));
    usage.addFirst(key);
    return cache.get(key);
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      cache.put(key, value);
      usage.remove(Integer.valueOf(key));
      usage.addFirst(key);
      return;
    }

    if (cache.size() >= capacity) {
      int leastRecentlyUsed = usage.removeLast();
      cache.remove(leastRecentlyUsed);
    }
    cache.put(key, value);
    usage.addFirst(key);

  }

  public static void main(String[] args) {
    LRUCacheLinkedList cache = new LRUCacheLinkedList(2);
    cache.put(1, 10);
    cache.put(2, 20);
    System.out.println(cache.get(1)); // 10
    cache.put(3, 30); // evicts 2
    System.out.println(cache.get(2)); // -1
    System.out.println(cache.get(3)); // 30
  }
}
