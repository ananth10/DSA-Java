package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public static void main(String[] args) {
        BinaryNode root = createBinaryTree();
        BuildBinaryTree.printLevelOrder(root);
        boolean result = isSymmetric(root);
        System.out.println("Is given binary tree symmetric?: " + result);
    }


    static boolean isSymmetric(BinaryNode root) {
        Queue<BinaryNode> q1 = new LinkedList<>();
        Queue<BinaryNode> q2 = new LinkedList<>();

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        q1.add(root.left);
        q2.add(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            BinaryNode f1 = q1.poll();
            BinaryNode f2 = q2.poll();

            if (q1.isEmpty() && !q2.isEmpty()) {
                return false;
            }
            if (!q1.isEmpty() && q2.isEmpty()) {
                return false;
            }
            if (f1 != null && f2 != null) {
                if (f1.left == null && f2.right != null) {
                    return false;
                }
                if (f1.left != null && f2.right == null) {
                    return false;
                }
                if (f1.data != f2.data) {
                    return false;
                }

                if (f1.left != null)
                    q1.add(f1.left);
                if (f1.right != null)
                    q1.add(f1.right);
                if (f2.right != null)
                    q2.add(f2.right);
                if (f2.left != null)
                    q2.add(f2.left);
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    static BinaryNode createBinaryTree() {
        BinaryNode one = new BinaryNode(1);
        BinaryNode two = new BinaryNode(2);
        BinaryNode two1 = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode four = new BinaryNode(4);


        one.left = two;
        two.left = three;
        two.right = four;

        one.right = two1;
        two1.left = four;
        two1.right = three;

        return one;

    }
}
