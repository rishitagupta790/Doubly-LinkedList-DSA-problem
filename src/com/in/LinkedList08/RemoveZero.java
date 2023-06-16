package com.in.LinkedList08;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveZero {
    public ListNode removeZeroSumSublists(ListNode head) {
        // Create a dummy node to handle the case where the entire list sums to zero
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use a hashmap to track the cumulative sum and its corresponding node
        Map<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        ListNode current = dummy;

        while (current != null) {
            sum += current.val;

            if (map.containsKey(sum)) {
                // Found a subarray with zero sum
                ListNode start = map.get(sum).next;
                int subarraySum = sum;

                // Remove the nodes between the start and current node
                while (start != current) {
                    subarraySum += start.val;
                    map.remove(subarraySum);
                    start = start.next;
                }

                // Update the next pointer of the previous node
                map.get(sum).next = current.next;
            } else {
                // Store the current cumulative sum and node in the hashmap
                map.put(sum, current);
            }

            current = current.next;
        }

        return dummy.next;
    }

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveZero solution = new RemoveZero();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(-3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(1);

        System.out.print("Original List 1: ");
        solution.display(head1);

        ListNode result1 = solution.removeZeroSumSublists(head1);

        System.out.print("Modified List 1: ");
        solution.display(result1);
    }
}
