package com.example.myapplication.codingminutes_levelup.linkedlist;

public class MyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void createLinkedList(T data) {
        Node<T> node = new Node<>(data);
        this.head = node;
        this.tail = node;
    }

    void insert(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }

    void printList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + ",");
            currentNode = currentNode.next;
        }
    }

    Node<T> search(T value) {
        Node<T> currentNode = head;
        if (value instanceof Integer) {
            while (currentNode != null) {
                if (currentNode.data == value) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            }
        } else if (value instanceof String) {
            while (currentNode != null) {
                if (currentNode.data.equals(value)) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    boolean isPresent(T value) {
        Node<T> currentNode = head;
        if (value instanceof Integer) {
            while (currentNode != null) {
                if (currentNode.data == value) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        } else if (value instanceof String) {
            while (currentNode != null) {
                if (currentNode.data.equals(value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }


}
