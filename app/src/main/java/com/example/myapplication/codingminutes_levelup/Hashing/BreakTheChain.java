package com.example.myapplication.codingminutes_levelup.Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Break the chain!
 * ---------------
 * Given a linked list which contains a cycle,
 * build a hashing based algorithm to break the cycle and return the head of the linked list,
 * the last node should point to NULL after breaking the cycle.
 * <p>
 * Note - it is not guaranteed that each element of the linked node is unique,
 * so decide hashing key accordingly.
 * <p>
 * Input
 * Head of the linked List
 * <p>
 * Output
 * Head of the linked list after breaking the cycle
 * <p>
 * Hint :
 * You may use node address as the key.
 */
public class BreakTheChain {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;


        System.out.println(breakChain(head));
    }

    private static Node breakChain(Node head) {
        Map<Node, Boolean> map = new HashMap<>();
        Node currentNode = head;
        Node prev;
        while (true) {
            map.put(currentNode, true);
            prev = currentNode;
            currentNode = currentNode.next;
            if (map.containsKey(currentNode)) {
                break;
            }
        }
        prev.next = null;
        return head;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
