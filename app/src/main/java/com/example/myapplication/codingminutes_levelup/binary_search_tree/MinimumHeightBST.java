package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import com.example.myapplication.codingminutes_levelup.binary_tree.LevelOrderTraversal;
import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

/**
 * Minimum Height BST
 * -----------------
 * <p>
 * Given a sorted array, construct a BST of minimum height
 * <p>
 * INPUT: 1 2 3 4 5 6 7 8
 * <p>
 * OUTPUT
 * 4
 * 2    6
 * 1  3  5  7
 * 8
 */
public class MinimumHeightBST {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = sortedBST(arr, 0, arr.length - 1);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    private static Node sortedBST(int[] arr, int start, int end) {
        //base case
        if (start > end) {
            return null;
        }

        //recursive case
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedBST(arr, start, mid - 1);
        root.right = sortedBST(arr, mid + 1, end);

        return root;
    }
}
