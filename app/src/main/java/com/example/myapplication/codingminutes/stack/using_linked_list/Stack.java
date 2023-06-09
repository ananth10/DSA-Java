package com.example.myapplication.codingminutes.stack.using_linked_list;


public class Stack<T> {

    private Node<T> head;

    public Stack() {
        this.head = null;
    }

    public class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

   public T getTop() {
        return head.data;
    }

    public boolean empty() {
        return head == null;
    }
}
