package com.ntnn.fastAndSlowPointer;

public class LinkedListCycle2 {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    ListNode tortoise = head;
    ListNode hare = head;

    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;

      if (tortoise == hare) {
        break;
      }
    }

    if (hare == null || hare.next == null) {
      return null;
    }

    hare = head;

    while (tortoise != hare) {
      tortoise = tortoise.next;
      hare = hare.next;
    }

    // Return the node where the cycle begins
    return tortoise;

  }
}
