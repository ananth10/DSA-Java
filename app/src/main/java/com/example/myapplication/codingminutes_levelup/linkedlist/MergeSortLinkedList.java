package com.example.myapplication.codingminutes_levelup.linkedlist;

/**
 * MergeSort LinkedList
 * ---------------------
 * Given a Linkedlist, write a function to sort the Linkedlist
 * using merge sort
 * <p>
 * Input:
 * 3->2->1->6->5->4->8->7>null
 * <p>
 * Output:
 * 1->2->3->4->5->6->7->8
 */
public class MergeSortLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(6);
        list.insert(5);
        list.insert(4);
        list.insert(8);
        list.insert(7);
        list.printList();

        Node<Integer> newHead = mergeSort(list.getHead());
        System.out.println("Result: " + newHead);
    }

    private static Node<Integer> mergeSort(Node<Integer> head) {
        //base case
        if (head == null || head.next == null) { //head.next means only single node left
            return head;
        }
        //recursive case
        Node<Integer> midNode = findMidNode(head);
        Node<Integer> a = head;
        Node<Integer> b = midNode.next;
        midNode.next = null;

        a = mergeSort(a);
        b = mergeSort(b);
        return merge(a, b);
    }

    private static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
        //base case
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node<Integer> newHead;
        if (a.data < b.data) {
            newHead = a;
            newHead.next = merge(a.next, b);
        } else {
            newHead = b;
            newHead.next = merge(a, b.next);
        }
        return newHead;
    }

    private static Node<Integer> findMidNode(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        Node<Integer> fast = head.next;
        Node<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
