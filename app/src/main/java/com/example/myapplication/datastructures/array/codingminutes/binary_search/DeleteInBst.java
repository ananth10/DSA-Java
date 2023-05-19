package com.example.myapplication.datastructures.array.codingminutes.binary_search;

import com.example.myapplication.datastructures.array.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.datastructures.array.codingminutes.binary_tree.BuildBinaryTree;
import com.google.gson.Gson;

public class DeleteInBst {

    public static void main(String[] args) {
        BinaryNode root = createTree();
        BuildBinaryTree.printLevelOrder(root);
        int key = 9;
        BinaryNode result = deleteInBst(root, key);
        BuildBinaryTree.printLevelOrder(result);
        System.out.println(new Gson().toJson(result));
    }

    static BinaryNode deleteInBst(BinaryNode root, int key) {
        //base case
        if (root == null) {
            return null;
        } else if (key < root.data) {
            root.left = deleteInBst(root.left, key);
        } else if (key > root.data) {
            root.right = deleteInBst(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                BinaryNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = deleteInBst(root.right, temp.data);
            }
        }


        return root;
    }

    static BinaryNode findMin(BinaryNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(7);
        BinaryNode two = new BinaryNode(5);
        BinaryNode three = new BinaryNode(9);
        BinaryNode four = new BinaryNode(3);
        BinaryNode five = new BinaryNode(6);
        BinaryNode six = new BinaryNode(8);
        BinaryNode seven = new BinaryNode(10);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        return one;
    }
}
