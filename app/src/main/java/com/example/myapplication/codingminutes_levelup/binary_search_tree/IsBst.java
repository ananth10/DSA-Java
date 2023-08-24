package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import com.example.myapplication.codingminutes_levelup.binary_tree.LevelOrderTraversal;
import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

/**
 * Is BST tree?
 * ------------
 * Given a binary tree, check if the tree is a BST or not.
 * <p>
 * INPUT:
 * 1
 * 2   3
 * 4  5    6
 * <p>
 * INPUT:
 * 4
 * 2   5
 * 1   3   6
 * <p>
 * OUTPUT:
 * False
 */
public class IsBst {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node roo1 = new Node(4);
        roo1.left = new Node(2);
        roo1.right = new Node(5);
        roo1.left.left = new Node(1);
        roo1.left.right = new Node(3);
        roo1.right.right = new Node(6);

        LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println("*************************");
        LevelOrderTraversal.levelOrderTraversal(roo1);

        System.out.println("Is BST:" + isBst(root));
        System.out.println("Is BST:" + isBst(roo1));

        System.out.println("USING RECURSION");

        System.out.println("Is BST:" + isBstRecursion(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println("Is BST:" + isBstRecursion(roo1,Integer.MIN_VALUE,Integer.MAX_VALUE));


    }

    //iterator approach
    private static boolean isBst(Node root) {
        Node left = root.left;
        Node right = root.right;

        while (left != null && right != null) {
            if (left.data > root.data || right.data < root.data) {
                return false;
            }
            left = left.left;
            right = right.right;
        }
        return true;
    }

    //recursion approach

    static boolean isBstRecursion(Node root, int min, int max) {
        //base case
        //an empty tree is always bst
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBstRecursion(root.left, min, root.data) && isBstRecursion(root.right, root.data, max);
    }
}
