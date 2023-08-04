package com.example.myapplication.codingminutes_levelup.linkedlist;


/**
 * K-Reverse
 * -----------
 * Given a linked list, write a function to reverse every k nodes(where k is an input to the function)
 * Input:
 * 1->2->3->4->5->6->-7>-8>null
 * k = 3
 * <p>
 * 3->2->1->6->5->4->8->7->null
 */
public class KReverse {
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
        int k = 3;
        list.printList();
        Node<Integer> head = kReverse(list.getHead(), k);
        System.out.println("Result:" + head);
    }

    //brute for approach
    static Node<Integer> kReverse(Node<Integer> head, int k) {
        //Base case
        if (head == null) {
            return null;
        }

        //Recursive case
        Node<Integer> currentNode = head;
        Node<Integer> prevNode = null;
        Node<Integer> tempNode = null;
        int count = 1;
        while (currentNode != null && count <= k) {
            tempNode = currentNode.next; //store next node in temp,
            currentNode.next = prevNode; //current node next points to previous node
            prevNode = currentNode; //current node became previous
            currentNode = tempNode; //temp node became current node
            count++;
        }
        if (tempNode != null) {
            head.next = kReverse(tempNode, k);
        }
        return prevNode;
    }
}
