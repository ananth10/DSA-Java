package com.example.myapplication.codingminutes.linkedlist;

public class LinkedList<T> {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node getBegin() {
        return head;
    }

    //add element in the front

    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
            node.next = null;
        } else {
            node.next = head;
            head = node;
        }
    }

    //add element in the back

    public void addBack(T data) {
        Node<T> node = new Node<>(data);
        if (tail == null) {
            head = tail = node;
            node.next = null;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    //insert element in the middle
    public void insert(T data, int pos) {
        if (pos == 0) {
            addFront(data);
            return;
        }
        if (pos >= getSize() - 1) {
            addBack(data);
            return;
        }
        Node<T> node = new Node<>(data);
        Node currentNode = head;
        for (int i = 1; i < pos; i++) {
            currentNode = currentNode.next;
        }
        node.next = currentNode.next;
        currentNode.next = node;

    }

    //delete element in the front
    public int deleteFront() {
        if (head == null) {
            return -1;
        }
        int deleted = (int) head.data;
        head = head.next;
        return deleted;
    }

    //delete element in the back
    public int deleteBack() {
        if (head == null) {
            return -1;
        }
        Node currentNode = head;
        Node prevNode = head;
        while (currentNode.next != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        int deleted = (int) currentNode.data;
        tail = prevNode;
        prevNode.next = null;
        System.out.println(prevNode);
        return deleted;
    }

    public int deleteAt(int pos) {
        if (pos == 0) {
            return deleteFront();
        }
        if (pos > getSize()) {
            return -1;
        }
        Node currentNode = head;
        Node prevNode = head;
        for (int i = 1; i <= pos; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        int deleted = (int) currentNode.data;
        prevNode.next = currentNode.next;
        return deleted;
    }


    //get the total node
    public int getSize() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    //print all elements from the linked list
    public void print() {
//        System.out.print("head"+head);
        System.out.print("[");
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
        System.out.print("]");
    }

    public boolean search(int key) {
        if (head == null) {
            return false;
        }
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == (Integer) key) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean searchRecursively(Node head, int key) {
        //base case
        if (head == null) {
            return false;
        }
        //recursive case
        if (head.data == (Integer) key) {
            return true;
        } else {
            return searchRecursively(head.next, key);
        }
    }


    public void reverse(){
        Node current = head;
        if(current==null)
            return;
        Node prev = null;
        tail = current;
        while (current!=null){
            //save the next node
            Node nextNode = current.next;
            //current node should point to prev
            current.next = prev;

            //then prev became current node
            prev = current;
            //then current node became next node
            current = nextNode;
        }
        head = prev;
    }
    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
