package com.example.myapplication.codingminutes_levelup.binary_search_tree;


import static com.example.myapplication.codingminutes_levelup.binary_search_tree.BSTCreation.createBST;

import com.example.myapplication.codingminutes_levelup.binary_tree.Node;


/**
 * Flatten The Tree
 * ---------------
 * <p>
 * Given a BST convert it to a sorted linked list, right pointer should behave as next pointer for the linked list
 * <p>
 * INPUT:
 * 4
 * 2     6
 * 1   3 5   7
 * <p>
 * OUTPUT:
 * 1->2->3->4->5->6->7
 */
public class FlattenLinkedList {
    public static void main(String[] args) {
        Node root = null;
        int[] arr = {4, 2, 6, 1, 3, 5, 7};
        for (int key : arr) {
            root = createBST(root, key);
        }

        LinkedListPair pair = treeLinkedList(root);
        print(pair.head);
    }

    private static class LinkedListPair {
        Node head;
        Node tail;

    }

    private static LinkedListPair treeLinkedList(Node root) {
        LinkedListPair llPair = new LinkedListPair();
        //base case
        if (root == null) {
            llPair.head = null;
            llPair.tail = null;
            return llPair;
        }

        //recursive case
        //case 1
        if (root.left == null && root.right == null) {
            llPair.head = root;
            llPair.tail = root;
            return llPair;
        } else if (root.left != null && root.right == null) { //case 2
            LinkedListPair pairLL = treeLinkedList(root.left);
            pairLL.tail.right = root;

            llPair.head = pairLL.head;
            llPair.tail = root;
        } else if (root.left == null) { //case 3
            LinkedListPair pairRR = treeLinkedList(root.right);
            root.right = pairRR.head;

            llPair.head = root;
            llPair.tail = pairRR.tail;
        } else { //case 4
            LinkedListPair pairLL = treeLinkedList(root.left);
            LinkedListPair pairRR = treeLinkedList(root.right);

            pairLL.tail.right = root;
            root.right = pairRR.head;

            llPair.head = pairLL.head;
            llPair.tail = pairRR.tail;

        }

        return llPair;
    }

    private static void print(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.right;
        }
    }
}
