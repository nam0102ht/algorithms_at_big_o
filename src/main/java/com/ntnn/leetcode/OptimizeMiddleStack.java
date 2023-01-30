package com.ntnn.leetcode;

import java.util.*;

public class OptimizeMiddleStack {
    class Node {
        Node prev;
        int data;
        Node next;
        Node(int d) {
            data = d;
        }
    }

    /* This is the basic structure of a stack that will reference to two nodes which are 'head' and the 'mid' */

    class StackNode {
        Node head;
        Node mid;
        int count;
    }

    /* The method will create an object of class StackNode and create a new stack */

    StackNode implementStackUsingLinkedlist() {
        StackNode stack = new StackNode();
        stack.count = 0;
        return stack;
    }

    void push(StackNode node, int new_data)
    {
        //Write your code here
        Node new_node = new Node(new_data);
        if (node.count == 0) {
            node.head = new_node;
            node.mid = new_node;
            node.count++;
            return;
        }
        node.head.next = new_node;
        new_node.prev = node.head;

        node.head = node.head.next;
        if (node.count % 2 != 0) {
            node.mid = node.mid.next;
        }
        node.count++;
    }

    int pop(StackNode stack) {

        //write your code here
        int data = -1;
        /* Stack underflow */
        if (stack.count == 0) {
            return -1;
        }

        if (stack.count != 0) {
            if (stack.count == 1) {
                stack.head = null;
                stack.mid = null;
            }
            else {
                data = stack.head.data;
                stack.head = stack.head.prev;
                stack.head.next = null;
                if (stack.count % 2 == 0) {
                    stack.mid = stack.mid.prev;
                }
            }
            stack.count--;
        }
        return data;
    }


    int middleElement(StackNode stack) {
        //write your code here
        if (stack.count == 0) {
            return -1;
        }
        return stack.mid.data;
    }


    public static void main(String args[]) {
        OptimizeMiddleStack obj = new OptimizeMiddleStack();
        StackNode stack = obj.implementStackUsingLinkedlist();
        Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        for (int i = 0; i < n; i++) {
            obj.push(stack, in .nextInt());

        }
        if (stack.count == 0) {
            System.out.println("The stack is empty");
            return;
        }
        System.out.println(obj.pop(stack) + "");
        System.out.println(obj.middleElement(stack) + "");
        Deque<Integer> queue = new LinkedList<>();

    }
}
