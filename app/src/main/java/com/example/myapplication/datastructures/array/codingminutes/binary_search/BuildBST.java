package com.example.myapplication.datastructures.array.codingminutes.binary_search;

import com.example.myapplication.datastructures.array.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.datastructures.array.codingminutes.binary_tree.BuildBinaryTree;

public class BuildBST {

    public static void main(String[] args) {
        BinaryNode root = null;
        int[] a = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int data : a) {
            root = insert(root, data);
        }
        BuildBinaryTree.printLevelOrder(root);
        printInOrder(root);

        int key = 7;
        boolean searchResult = search(root, key);
        System.out.println(searchResult);

        delete(root,key);
        printInOrder(root);
    }

    static BinaryNode insert(BinaryNode root, int data) {
        //base case
        if (root == null) {
            return new BinaryNode(data);
        }
        //recursive case
        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static void printInOrder(BinaryNode root) {
        //base case
        if (root == null) {
            return;
        }

        //recursive case
        printInOrder(root.left);
        System.out.print(root.data + ", ");
        printInOrder(root.right);
    }

    static boolean search(BinaryNode root, int key) {
        //base case
        if (root == null) {
            return false;
        }
        //recursive case
        if (key == root.data) {
            return true;
        }
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    static BinaryNode delete(BinaryNode root, int key) {
        //base case
        if (root == null) {
            return null;
        } else if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete((root.right), key);
        } else {
            //current node matches with key

            //0 children/no leaf nodes- which means we going to delete the leaf node
            if (root.left == null && root.right == null) {
                root = null;
            }
            //1 child, that is right child
            else if (root.left == null) {
                root = root.right;
            }
            //1 child, that is left child
            else if (root.right == null) {
                root = root.left;
            } else {
                //Node  we are going to delete has 2 children
                BinaryNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
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
}
