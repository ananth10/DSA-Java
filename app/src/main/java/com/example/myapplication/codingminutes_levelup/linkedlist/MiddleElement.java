package com.example.myapplication.codingminutes_levelup.linkedlist;

/**
 * Middle Element
 * ---------------
 * This is an easy problem! Apply runner technique to find mid-point of a given linked list in a single pass.
 * <p>
 * Input
 * Head of the Linked List is given as input.
 * 1->2->3->4->5->6->7->8
 * Output
 * 4
 */
public class MiddleElement {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);

        int middleElement = middleElement(list.getHead());
        System.out.println("Result: " + middleElement);
    }

    private static int middleElement(Node<Integer> head) {
        Node<Integer> fastRunner = head.next;
        Node<Integer> slowRunner = head;

        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        return slowRunner.data;
    }
}
