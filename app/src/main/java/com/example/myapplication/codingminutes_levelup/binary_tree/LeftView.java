package com.example.myapplication.codingminutes_levelup.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Left View
 * -----------
 * Given a binary tree, print left view of it.
 * Left view of binary tree is set of nodes that are visible where a tree visited from the left side
 * INPUT:
 * 1
 * 2    3
 * 4   5
 * <p>
 * OUTPUT:
 * 1 2 4
 * <p>
 * INPUT:
 * <p>
 * 1
 * 2    3
 * 4      6
 * 5
 * OUTPUT:
 * 1 2 4 5
 */


public class LeftView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.left.right.right = new Node(5);

        leftView(root);
        List<Integer> list = leftView1(root);
        System.out.println("Result:" + list);
    }


    //using the level order traversal
    static void leftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isFirstElement = false;
        System.out.print(root.data + " ");
        while (!queue.isEmpty()) {
            Node top = queue.poll();

            if (top == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                isFirstElement = true;
            } else {
                if (isFirstElement) {
                    System.out.print(top.data + " ");
                    isFirstElement = false;
                }
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
        }
    }


    //using level order approach but different logic

    static int maxLevel = 0;

    static List<Integer> leftView1(Node root) {
        maxLevel = 0;
        List<Integer> list = new ArrayList<>();
        leftViewUtil(root, list, 1);
        return list;
    }

    static void leftViewUtil(Node root, List<Integer> list, int level) {
        //base case
        if (root == null) {
            return;
        }
        //recursive case
        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        leftViewUtil(root.left, list, level + 1);
        leftViewUtil(root.right, list, level + 1);
    }
}
