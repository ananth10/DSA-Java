package com.example.myapplication.codingminutes_levelup.linkedlist;

public class RecursiveReverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.printList();
        Node<Integer> node = recursiveReverse(list.getHead());
        System.out.println(node);
    }

    static Node<Integer> recursiveReverse(Node<Integer> head) {
        //base case
        if (head == null || head.next == null) { //passed head is null or last node next point to null
            return head;
        }
        //recursive case
        Node<Integer> newHeadNode = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }
}
