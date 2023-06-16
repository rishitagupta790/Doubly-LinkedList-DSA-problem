package com.in.LinkedList06;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LeftShift {
    public ListNode leftShiftLinkedList(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int length = getLength(head);

        // Normalize k to be less than or equal to length
        k %= length;

        if (k == 0) {
            return head;
        }

        // Find the new head and the tail of the shifted list
        ListNode newHead = head;
        ListNode tail = head;
        for (int i = 1; i < k; i++) {
            tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;

        // Connect the original tail to the original head
        ListNode current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;

        return newHead;
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

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeftShift solution = new LeftShift();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Original List 1: ");
        solution.display(head1);

        int k1 = 2;
        ListNode shiftedHead1 = solution.leftShiftLinkedList(head1, k1);

        System.out.print("Shifted List 1: ");
        solution.display(shiftedHead1);

        // Example 2
        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(6);
        head2.next.next.next.next = new ListNode(9);

        System.out.print("Original List 2: ");
        solution.display(head2);

        int k2 = 3;
        ListNode shiftedHead2 = solution.leftShiftLinkedList(head2, k2);

        System.out.print("Shifted List 2: ");
        solution.display(shiftedHead2);
    }
}

