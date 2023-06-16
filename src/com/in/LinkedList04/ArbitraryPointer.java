package com.in.LinkedList04;

class Node {
    int data;
    Node next, arb;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.arb = null;
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

    public void setRandomPointers(Node head, Node[] randomPointers) {
        Node current = head;
        int i = 0;
        while (current != null) {
            current.arb = randomPointers[i++];
            current = current.next;
        }
    }

    public Node copyLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        // Create new nodes and insert them between the original nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Set random pointers of the new nodes
        current = head;
        while (current != null) {
            current.next.arb = (current.arb != null) ? current.arb.next : null;
            current = current.next.next;
        }

        // Separate the original and copied linked lists
        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;

        while (original != null && copy != null) {
            original.next = (original.next != null) ? original.next.next : null;
            copy.next = (copy.next != null) ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }

    public void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node: " + current.data);
            if (current.arb != null) {
                System.out.print(", Random Pointer: " + current.arb.data);
            }
            System.out.println();
            current = current.next;
        }
    }
}

public class ArbitraryPointer {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        Node[] randomPointers = new Node[5];
        randomPointers[0] = list.head.next.next; // Node 2
        randomPointers[1] = list.head.next.next.next.next; // Node 5
        randomPointers[2] = list.head.next; // Node 1
        randomPointers[3] = list.head.next.next.next; // Node 4
        randomPointers[4] = list.head.next.next; // Node 3

        list.setRandomPointers(list.head, randomPointers);

        System.out.println("Original linked list:");
        list.display(list.head);

        Node copyHead = list.copyLinkedList(list.head);

        System.out.println("\nCopied linked list:");
        list.display(copyHead);
    }
}
