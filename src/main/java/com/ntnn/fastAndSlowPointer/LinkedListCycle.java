package com.ntnn.fastAndSlowPointer;

public class LinkedListCycle {
  class Node {
    int val;
    Node next;

    Node(int x, Node next) {
      this.val = x;
      this.next = next;
    }
  }

  public boolean isCycle(Node head) {
    if (head == null) {
      return false;
    }

    var slow = head;
    var fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }
}
