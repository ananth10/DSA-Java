package com.example.myapplication.codingminutes.binary_search;

import static com.example.myapplication.codingminutes.binary_search.BuildBST.insert;

import com.example.myapplication.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.codingminutes.binary_tree.BinaryNode;

public class PrintInRange {
    public static void main(String[] args) {
        BinaryNode root = null;
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int data : arr) {
            root = BuildBST.insert(root, data);
        }
        BuildBST.printInOrder(root);
        int k1 = 5;
        int k2 = 12;
        System.out.println("Range B/W K1 and K2 :");
        printInRange(root, k1, k2);
    }

    static void printInRange(BinaryNode root, int k1, int k2) {
        //base case
        if (root == null) {
            return;
        }
        //if root data lies between k1 and k2
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + ", ");
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }
}
