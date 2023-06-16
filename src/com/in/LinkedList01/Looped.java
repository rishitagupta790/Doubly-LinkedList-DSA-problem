package com.in.LinkedList01;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void createLoop(int position) {
        if (position == 0) {
            return;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node loopNode = head;
        for (int i = 1; i < position; i++) {
            loopNode = loopNode.next;
        }

        tail.next = loopNode;
    }

    public void detectAndRemoveLoop() {
        if (head == null || head.next == null) {
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        // Detect loop using Floyd's cycle detection algorithm
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                break;
            }
        }

        // If loop exists, find the starting point of the loop
        if (slowPtr == fastPtr) {
            slowPtr = head;
            while (slowPtr.next != fastPtr.next) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }

            // Unlink the last node to remove the loop
            fastPtr.next = null;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Looped {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // Creating a loop in the linked list
        int loopPosition = 2;
        list.createLoop(loopPosition);

        System.out.print("Original list with loop: ");
        list.display();

        list.detectAndRemoveLoop();

        System.out.print("List after removing the loop: ");
        list.display();
    }
}
