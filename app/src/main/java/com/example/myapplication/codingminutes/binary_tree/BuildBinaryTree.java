package com.example.myapplication.codingminutes.binary_tree;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildBinaryTree {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int[] array = {1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1};
//        BinaryNode node = buildBinaryTree(array, 0);
//        System.out.println(new Gson().toJson(node));
//        printPreorder(node);
        BinaryNode root = buildTree();
        System.out.println(new Gson().toJson(root));
        System.out.println("\n PREORDER\n");
        printPreorder(root);
        System.out.println("\nINORDER\n");
        printInOrder(root);
        System.out.println("\nPOSTORDER\n");
        printPostOrder(root);

        System.out.println("\nLEVEL ORDER\n");
        printLevelOrder(root);
        System.out.println("\nLEVEL TREE\n");
//        1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1
    }

    //Preorder build of the Tree Root, Left and Right tree
    static BinaryNode buildBinaryTree(int[] array, int i) {
        if (i >= array.length || array[i] == -1) {
            return null;
        }
        BinaryNode node = new BinaryNode(array[i]);
        node.left = buildBinaryTree(array, i + 1);
        System.out.println("LEFT:" + (i + 1) + ":" + array[i + 1]);
        node.right = buildBinaryTree(array, i + 1);
        System.out.println("RIGHT:" + (i + 1) + ":" + array[i + 1]);

        return node;
    }

    public static BinaryNode buildTree() {
        int d = scanner.nextInt();
        if (d == -1) {
            return null;
        }
        BinaryNode n = new BinaryNode(d);
        n.left = buildTree();
        n.right = buildTree();
        return n;
    }

    static void printPreorder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ", ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    static void printInOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + ", ");
        printInOrder(root.right);
    }

    static void printPostOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + ", ");
    }

    public static void printLevelOrder(BinaryNode node) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while (!queue.isEmpty()) {
            BinaryNode temp = queue.peek();
            if (temp == null) {
                System.out.println();
                queue.remove();
                //insert new null for next level
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                queue.remove(); //remove parent
                System.out.print(temp.data);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
}
