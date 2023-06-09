package com.example.myapplication.codingminutes.binary_search;

import com.example.myapplication.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.codingminutes.binary_tree.BuildBinaryTree;
import com.example.myapplication.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.codingminutes.binary_tree.BuildBinaryTree;

public class IsBst {

    public static void main(String[] args) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        BinaryNode root = createTree();
        BuildBinaryTree.printLevelOrder(root);
        boolean result = isBst(root, min, max);
        System.out.println("Is BST: " + result);
    }

    static boolean isBst(BinaryNode root, int min, int max) {
        //if node is null then considered as valid bst
        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }
        return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(1);
        BinaryNode two = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode four = new BinaryNode(4);
        BinaryNode five = new BinaryNode(5);
        BinaryNode six = new BinaryNode(6);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;

        return one;
    }
}
