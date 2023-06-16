package com.in.LinkedList07;

import java.util.Arrays;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class AssendingOrder {
    public int[] nextLargerNodes(ListNode head) {
        // Calculate the length of the linked list
        int length = getLength(head);
        int[] result = new int[length];

        // Stack to store the indices of the nodes in descending order of their values
        Stack<Integer> stack = new Stack<>();

        // Traverse the linked list
        ListNode current = head;
        for (int i = 0; i < length; i++) {
            // Store the value of the current node
            int value = current.val;

            // Process all the nodes with smaller values than the current node
            while (!stack.isEmpty() && value > result[stack.peek()]) {
                int index = stack.pop();
                result[index] = value;
            }

            // Push the index of the current node to the stack
            stack.push(i);

            // Move to the next node
            current = current.next;
        }

        return result;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        AssendingOrder solution = new AssendingOrder();

        // Example
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        int[] result = solution.nextLargerNodes(head);
        System.out.println("Next Greater Nodes: " + Arrays.toString(result));
    }
}

