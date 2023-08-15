package com.example.myapplication.codingminutes_levelup.binary_tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Traversal
 * ---------------------
 * Print a binary tree using a level order traversal
 * Input;
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 * /
 * 7
 * <p>
 * Output:
 * 1
 * 2,3
 * 4,5,6
 * 7
 * <p>
 * use below input
 * 1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node root = BuildTree.buildTree();
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); //added null to detect level ends

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (top == null) {
                if (!queue.isEmpty()) { //add null if queue is not empty which means tree traversal not yet completed
                    queue.add(null);
                }
                System.out.println();
            } else {
                System.out.print(top.data + ", ");
                Node left = top.left;
                Node right = top.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
        }
    }
}
