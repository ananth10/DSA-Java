package com.example.myapplication.codingminutes_levelup.binary_tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Print At Level K
 * ----------------
 * <p>
 * Print all nodes at distance k from the root node
 * INPUT: 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 * /
 * 7
 *
 * OUTPUT:
 * 4,5,6
 */
public class PrintKLevel {

    public static void main(String[] args) {
//        Node root = BuildTree.buildTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        int k = 2;
        printKLevel(root, k);
    }

    private static void printKLevel(Node root, int k) {
        //base case
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + ", ");
            return;
        }
        k--;
        printKLevel(root.left, k);
        printKLevel(root.right, k);

    }
}
