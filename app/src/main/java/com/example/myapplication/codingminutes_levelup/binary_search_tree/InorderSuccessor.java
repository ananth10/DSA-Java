package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import com.example.myapplication.codingminutes_levelup.binary_tree.LevelOrderTraversal;
import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

/**
 * Inorder Successor
 * ----------------
 * <p>
 * Given a BST, find the inorder successor for given target node.
 * INPUT:
 * <p>
 * 8
 * 3   10
 * 1  6     14
 * 4 7   13
 * <p>
 * TARGET = 7
 * <p>
 * OUTPUT
 * Successor of 7 is 8
 */
public class InorderSuccessor {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        LevelOrderTraversal.levelOrderTraversal(root);
        Node target1 = root.left.right.right;
        Node target2 = root.right;

        System.out.println("Successor of 7 is " + inorderSuccessor(root, target1));
        System.out.println("Successor of 10 is " + inorderSuccessor(root, target2));

    }

    private static int inorderSuccessor(Node root, Node target) {

        //case 1
        //we need to look for right side to see successor of given target and go left till find minimum
        if (target.right != null) {
            Node currentNode = target.right;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            return currentNode.data;
        }

        //case 2
        //in case right tree is null then we need to travel from root to target
        Node currentNode = root;
        Node successor = null;

        while (currentNode != null) {
            if (currentNode.data > target.data) {
                successor = currentNode;
                currentNode = currentNode.left;
            } else if (currentNode.data < target.data) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return successor.data;
    }
}
