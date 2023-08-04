package com.example.myapplication.codingminutes_levelup.linkedlist;


/**
 * Merge 2 sorted linked list
 * -------------------------
 * <p>
 * Given 2 sorted LinkedList and merge them into new LinkedList
 * <p>
 * Input:
 * 1->5->7->10->NULL
 * 2->3->6->NULL
 * <p>
 * Output:
 * 1->2->3->5->6->7->10->NULL
 */
public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.insert(1);
        a.insert(5);
        a.insert(7);
        a.insert(10);
        a.printList();
        MyLinkedList<Integer> b = new MyLinkedList<>();
        b.insert(2);
        b.insert(3);
        b.insert(6);
        b.printList();
        Node<Integer> newHeadNode = merge(a.getHead(), b.getHead());
        System.out.println(newHeadNode);
    }

    private static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
        //base case
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        //recursive case
        Node<Integer> newHeadNode;
        if (a.data < b.data) {
            newHeadNode = a;
            newHeadNode.next = merge(a.next, b);
        } else {
            newHeadNode = b;
            newHeadNode.next = merge(a, b.next);
        }
        return newHeadNode;
    }
}
