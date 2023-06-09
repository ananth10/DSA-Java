package com.example.myapplication.codingminutes.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildLevelOrderTree {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryNode levelRoot = buildLevelOrderTree();
        // 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
//        BinaryNode levelRoot1 = buildLevelOrderTree1();
        printLevelOrder(levelRoot);

    }

    static BinaryNode buildLevelOrderTree() {
        int[] arr = {1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1};
        int pos = 0;
        int n = arr.length;
        int leftChildPos = 0, rightChildPos = 0;
        Queue<BinaryNode> queue = new LinkedList<>();
        BinaryNode root = new BinaryNode(arr[pos]);
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode temp = queue.peek();
            queue.remove();
            leftChildPos = pos * 2 + 1;
            rightChildPos = pos * 2 + 2;
            if (leftChildPos < n && rightChildPos < n) {
                if (temp != null) {
                    if (arr[leftChildPos] != -1) {
                        temp.left = new BinaryNode(arr[leftChildPos]);
                        queue.add(temp.left);
                    }
                    if (arr[rightChildPos] != -1) {
                        temp.right = new BinaryNode(arr[rightChildPos]);
                        queue.add(temp.right);
                    }
                }
            }
            pos++;
        }
        return root;
    }

    static BinaryNode buildLevelOrderTree1() {
        int data = scanner.nextInt();
        Queue<BinaryNode> queue = new LinkedList<>();
        BinaryNode root = new BinaryNode(data);
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode temp = queue.peek();
            queue.remove();
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            if (temp != null) {
                if (c1 != -1) {
                    temp.left = new BinaryNode(c1);
                    queue.add(temp.left);
                }
                if (c2 != -1) {
                    temp.right = new BinaryNode(c2);
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    static void printLevelOrder(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            BinaryNode temp = queue.peek();
            if (temp == null) {
                System.out.println();
                queue.remove();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(temp.data + "");
                queue.remove();
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
