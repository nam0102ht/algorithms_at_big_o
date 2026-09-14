package com.ntnn.amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheNode {
//  Pattern: Data Structure Design — HashMap + Doubly Linked List
//  Difficulty: Medium
//  Target complexity: get() O(1), put() O(1)
//
//  Design a Least Recently Used (LRU) Cache with a fixed capacity.
//
//  It must support:
//
//  int get(int key)
//  void put(int key, int value)
//
//  Example:
//
//  LRUCache cache = new LRUCache(2);
//  put(1, 10)
//  put(2, 20)
//  get(1)       → 10
//  put(3, 30)   → evicts key 2
//  get(2)       → -1
//  get(3)       → 30
//
//  After:
//
//  put(1,10)
//  put(2,20)
//  get(1)
//
//  the usage order is:
//
//  Most Recent              Least Recent
//    1          →              2
//
//  Therefore:
//
//  put(3,30)
//
//  must evict 2.
//
//  Interview Question 1
//
//  Suppose you implement the cache using only:
//
//  HashMap<Integer, Integer>
//
//  You can already perform:
//
//  get(key) → O(1)
//  put(key) → O(1)
//
//  So why is a HashMap alone not sufficient to implement an LRU Cache with all required operations in O(1)?
//
//  What additional information/data structure do we need?
  static class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> cache;
  // Dummy nodes simplify insert/remove logic

  private final Node head;
  private final Node tail;

  public LRUCacheNode(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }
    // Access makes this node the most recently used
    moveToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node existing = cache.get(key);
    if (existing != null) {
      existing.value = value;
      // Updating also counts as recent usage
      moveToFront(existing);
      return;
    }
    Node newNode = new Node(key, value);
    cache.put(key, newNode);
    addToFront(newNode);
    if (cache.size() > capacity) {
      Node leastRecentlyUsed = removeLast();
      cache.remove(leastRecentlyUsed.key);
    }
  }

  // Add immediately after head

  private void addToFront(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void moveToFront(Node node) {
    removeNode(node);
    addToFront(node);
  }

  // Node before tail is least recently used
  private Node removeLast() {
    Node node = tail.prev;
    removeNode(node);
    return node;
  }

  public static void main(String[] args) {
    LRUCacheNode cache = new LRUCacheNode(2);
    cache.put(1, 10);
    cache.put(2, 20);
    System.out.println(cache.get(1)); // 10
    cache.put(3, 30); // evicts key 2
    System.out.println(cache.get(2)); // -1
    System.out.println(cache.get(3)); // 30
    cache.put(4, 40); // evicts key 1
    System.out.println(cache.get(1)); // -1
    System.out.println(cache.get(3)); // 30
    System.out.println(cache.get(4)); // 40

  }
}
