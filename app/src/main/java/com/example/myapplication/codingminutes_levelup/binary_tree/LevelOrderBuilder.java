package com.example.myapplication.codingminutes_levelup.binary_tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Level Order Builder
 * ------------------
 * <p>
 * Input:
 * 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * <p>
 * Output:
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 *    /
 *   7
 */
public class LevelOrderBuilder {
    public static void main(String[] args) {
        Node root = levelOrderBuild();
       LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static Node levelOrderBuild() {
        Queue<Node> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        //read the root node data
        int rootData = scanner.nextInt();
        //create a root node
        Node root = new Node(rootData);
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            //read next 2 numbers from the input
            int leftData = scanner.nextInt();
            int rightData = scanner.nextInt();

            if (currentNode != null) {
                if (leftData != -1) {
                    currentNode.left = new Node(leftData);
                    queue.add(currentNode.left);
                }
                if (rightData != -1) {
                    currentNode.right = new Node(rightData);
                    queue.add(currentNode.right);
                }
            }
        }

        return root;
    }
}
