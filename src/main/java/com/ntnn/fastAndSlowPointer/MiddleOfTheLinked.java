package com.ntnn.fastAndSlowPointer;

public class MiddleOfTheLinked {

  class ListNode {
    int x;
    ListNode next;
    ListNode(int x) {
      this.x = x;
      next = null;
    }
  }

  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
