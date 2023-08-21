package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import static com.example.myapplication.codingminutes_levelup.binary_search_tree.BSTCreation.createBST;

import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

/**
 * Closet BST
 * -----------
 * Find the closet value in the BST for given target value
 * 8
 * 3    10
 * 1   6     14
 * 4  7    13
 * <p>
 * Target value: 16
 * <p>
 * OUTPUT: 14
 */
public class ClosestBST {

    public static void main(String[] args) {
        create();
    }

    static void create() {
        Node root = null;
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int key : arr) {
            root = createBST(root, key);
        }
        int target = 16;
        Node closestValue = findClosest(root, target);
        System.out.println("Closet Node :" + closestValue.data);
    }

    private static Node findClosest(Node root, int target) {
        int minSoFar = Integer.MAX_VALUE;
        Node currentNode = root;
        Node minNode = root;
        while (currentNode != null) {
            int diff = Math.abs(currentNode.data - target);
            if(diff==target){
                return currentNode;
            }
            if (diff < minSoFar) {
                minSoFar = diff;
                minNode = currentNode;
            }
            if (target < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return minNode;
    }
}
