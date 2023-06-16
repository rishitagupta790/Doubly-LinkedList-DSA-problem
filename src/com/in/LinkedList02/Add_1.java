package com.in.LinkedList02;

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

    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void addOne() {
        reverse();

        Node current = head;
        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            current = current.next;
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }

        reverse();
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

public class Add_1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);

        System.out.print("Original list: ");
        list.display();

        list.addOne();

        System.out.print("List after adding 1: ");
        list.display();
    }
}

