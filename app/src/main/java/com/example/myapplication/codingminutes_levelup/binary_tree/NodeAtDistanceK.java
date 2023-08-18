package com.example.myapplication.codingminutes_levelup.binary_tree;

/**
 * Nodes at distance K
 * -------------------
 * Given a binary tree, and a target node T. find all nodes distance k from given node,
 * where K is also an integer
 * INPUT: 1 2 3 4 5 -1 6 -1 -1 7 8 -1 -1 -1 -1 9 10 -1 -1 -1 -1
 * 1
 * / \
 * 2   3
 * / \   \
 * 4  5   6
 * /  \
 * 7    8
 * /  \
 * 9    10
 */
public class NodeAtDistanceK {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.left.right.right.left = new Node(9);
        root.left.right.right.right = new Node(10);

        Node target = root.left.right;
        int k = 2;
        nodeAtDistanceK(root, target, k);
    }

    //helper function to print node with k distance
    static void printKLevel(Node root, int k) {
        //base case
        if (root == null) {
            return;
        }
        //recursive case
        if (k == 0) {
            System.out.print(root.data + ", ");
            return;
        }
        printKLevel(root.left, k - 1);
        printKLevel(root.right, k - 1);

    }

    static int nodeAtDistanceK(Node root, Node target, int k) {
        //base case
        if (root == null) {
            return -1;
        }
        //recursive case

        //if we reach target node
        if (root == target) {
            printKLevel(root, k);
            return 0;
        }

        //other case is either target node present in left or right
        int DL = nodeAtDistanceK(root.left, target, k); //left sub tree

        if (DL != -1) {
            //2 cases (whether need to print current root node or call on right subtree)

            //1. print the current node
            if (DL + 1 == k) {
                System.out.println(root.data);
            } else {// print somenodes in the right sub tree
                printKLevel(root.right, k - 2 - DL);
            }
            return DL + 1; //1 unit from the root to right node
        }


        int DR = nodeAtDistanceK(root.right, target, k); //right sub tree

        if (DR != -1) {
            //2 cases (whether need to print current root node or call on left subtree)

            //1. print the current node
            if (DR + 1 == k) {
                System.out.println(root.data);
            } else {// print somenodes in the left sub tree
                printKLevel(root.left, k - 2 - DR);
            }
            return DR + 1; //1 unit from the root to right node
        }
        return -1;
    }
}
