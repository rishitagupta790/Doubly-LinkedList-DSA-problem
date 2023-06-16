package com.in.LinkedList03;

class Node {
    int data;
    Node next;
    Node bottom;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
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

    public Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null;
        return result;
    }

    public Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = flatten(head.next);

        head = merge(head, head.next);

        return head;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            Node temp = current;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.bottom;
            }
            System.out.println();
            current = current.next;
        }
    }
}

public class FlattenedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.insert(5);
        list.insert(10);
        list.insert(19);
        list.insert(28);

        list.head.bottom = new Node(7);
        list.head.bottom.bottom = new Node(8);
        list.head.bottom.bottom.bottom = new Node(30);

        list.head.next = new Node(8);
        list.head.next.bottom = new Node(20);

        list.head.next.next = new Node(10);

        list.head.next.next.bottom = new Node(20);
        list.head.next.next.bottom.bottom = new Node(22);
        list.head.next.next.bottom.bottom.bottom = new Node(50);

        System.out.println("Original list:");
        list.display();

        Node flattenedList = list.flatten(list.head);

        System.out.println("\nFlattened list:");
        Node current = flattenedList;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.bottom;
        }
    }
}
