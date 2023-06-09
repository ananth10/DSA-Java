package com.example.myapplication.codingminutes.linkedlist;

public class Node<T> {
    T data;
    Node next = null;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
