package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

import java.util.ArrayList;
import java.util.List;

public class BSTCreation {

    public static void main(String[] args) {
        Node root = null;
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int key : arr) {
            root = createBST(root, key);
        }
        inOrderTraversal(root);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("SS:" + list.size());
        System.out.println("SS:" + list);
        list.add(3, 5);
        System.out.println("SS:" + list);

        boolean result = search(root, 1);
        System.out.println("Search result:" + result);
    }

    public static Node createBST(Node root, int key) {
        //base case
        if (root == null) {
            return new Node(key);
        }
        //recursive case
        if (key < root.data) {
            root.left = createBST(root.left, key);
        } else {
            root.right = createBST(root.right, key);
        }

        return root;
    }


    public static void inOrderTraversal(Node root) {
        //base case
        if (root == null) {
            return;
        }
        //recursive case
        inOrderTraversal(root.left);
        System.out.print(root.data + ", ");
        inOrderTraversal(root.right);
    }

   public static boolean search(Node root, int key) {
        //base case
        if (root == null) {
            return false;
        }
        //recursive case
        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

}
