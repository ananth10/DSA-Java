package com.example.myapplication.codingminutes_levelup.linkedlist;


public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    int size = 0;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    Node<T> getHead() {
        return head;
    }

    void createLinkedList(T data) {
        Node<T> node = new Node<>(data);
        this.head = node;
        this.tail = node;
    }

    synchronized void insert(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        size++;
    }

    void printList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + ",");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    synchronized Node<T> search(T value) {
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

    synchronized boolean isPresent(T value) {
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

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    synchronized void insertAt(int index, T value) {
        Node<T> node = new Node<>(value);
        Node<T> currentNode = head;
        int count = 1;
        if (currentNode == null || index >= size) {
            insert(value);
            return;
        }

        Node<T> tempNode = null;
        while (currentNode.next != null) {
            if (count == index) {
                tempNode = currentNode;
                break;
            }
            currentNode = currentNode.next;
            count++;
        }
        if (tempNode != null) {
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    synchronized Node<T> delete() {
        if (head == null) {
            throw new RuntimeException("No items to delete");
        }
        Node<T> currentNode = head;
        Node<T> previousNode = head;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = null;
        return currentNode;
    }

    void insertAtHead(T value) {
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
    }

}
