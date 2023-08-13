package com.example.myapplication.codingminutes_levelup.linkedlist;

import java.util.Objects;

/**
 * Detect Cycle in a Linked List
 * -----------------------------
 * <p>
 * Yes, a Linked List may contain a Cycle! See this example below, where the last node instead of pointing to a NULL points to some middle node of the linked list.
 * Your task is to write a function, that returns true/false depending upon whether the linked contains a cycle or not!
 */
public class ContainsCycle {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);

        Node<Integer> head = list.getHead();
        Node<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        System.out.println(temp);
        boolean result = isContainsCycle(list.getHead());
        System.out.println("Result:" + result);
    }

    private static boolean isContainsCycle(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while (slow != null && fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data==fast.data) {
                return true;
            }
        }
        return false;
    }
}
