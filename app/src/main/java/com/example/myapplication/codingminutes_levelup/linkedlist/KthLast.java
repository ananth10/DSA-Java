package com.example.myapplication.codingminutes_levelup.linkedlist;


/**
 * Kth Last
 * ---------
 * <p>
 * Implement a function that returns the Kth last of element from the linked list, in a single pass. You can assume K will be less than / equal to length of linked list.
 * <p>
 * (Hint : Use two pointers similar to Runner Technique)
 * <p>
 * Input
 * You will get head of the linked list.
 * 1 -> 2 -> 3 -> 4 -> 5 ->6 ->7
 * K = 3
 * Output
 * 5
 */
public class KthLast {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        int k = 3;
        int kthElement = kthLast(list.getHead(), k);
        System.out.println("Result:" + kthElement);
    }

    private static int kthLast(Node<Integer> head, int k) {
        Node<Integer> h1 = head;
        Node<Integer> h2 = head;
        //forward h1 to kth move
        int count = 1;
        while (h1 != null && count <= k) {
            h1 = h1.next;
            count++;
        }
        //forward h1 and h2 until h1 reach last node
        while (h1 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }

        return h2.data;
    }
}
