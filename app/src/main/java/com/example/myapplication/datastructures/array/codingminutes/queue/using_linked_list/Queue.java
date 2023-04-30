package com.example.myapplication.datastructures.array.codingminutes.queue.using_linked_list;

public class Queue {

    Node head;
    Node tail;

    public Queue() {
        head = tail = null;
    }

    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int getFront() {
        return head.data;
    }

    public void print() {
        System.out.println();
        Node current = head;
        while (current != null) {
            System.out.println(current.data + ", ");
            current = current.next;
        }
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

}
