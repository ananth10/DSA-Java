package com.example.myapplication.codingminutes_levelup.linkedlist;

public class IterativeReverseLinkedList {

    public static void main(String[] args){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.printList();
        Node<Integer> newHead = reverseLinkedList(list.getHead());
        System.out.println(newHead);
    }

    static Node<Integer> reverseLinkedList(Node<Integer> head){
        Node<Integer> currentNode = head;
        Node<Integer> prevNode = null;
        Node<Integer> tempNode;

        while (currentNode!=null){
            //store current node next to temp
            tempNode = currentNode.next;
            //then current node next point to prevNode
            currentNode.next = prevNode;
            //then prevNode became current node
            prevNode = currentNode;
            //then tempNode became current node
            currentNode = tempNode;
        }
        head = prevNode;//finally last node point to head
      return head;
    }
}
