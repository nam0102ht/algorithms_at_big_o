package com.ntnn.leetcode;

import java.util.Scanner;

public class ReverseLinkedListRecursive {
    Node head;
    static Node temp;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /*this method will return the  head of the reversed linked list */

    Node recursiveReverse(Node curr, Node prev) {
        if (head == null) return null;
        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;
            /* Update next to prev node */
            curr.next = prev;
            return head;
        }
        /* Save curr->next node for recursive call */
        Node next1 = curr.next;
        /* and update next ..*/
        curr.next = prev;
        recursiveReverse(next1, curr);
        return head;
    }

    public void push(int new_data) {
        Node temp = head;
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public void print() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ReverseLinkedListRecursive obj = new ReverseLinkedListRecursive();
        int no = in.nextInt();

        for (int i = 0; i < no; i++) {
            obj.push(in.nextInt());
        }

//        int pos = in.nextInt();
        obj.recursiveReverse(obj.head, null);
        obj.print();
    }
}
