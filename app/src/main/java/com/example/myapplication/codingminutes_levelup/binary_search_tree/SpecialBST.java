package com.example.myapplication.codingminutes_levelup.binary_search_tree;


import com.example.myapplication.codingminutes_levelup.binary_tree.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Special BST
 * -----------
 * Given a special kind of Binary Search Tree, where every node also contains a pointer to the parent node.
 * You have to find the next inorder successor of a given target node in that tree. The node class looks as below -
 * class Node
 * {
 * public:
 * int key;
 * Node *left;
 * Node *right;
 * Node *parent;
 * };
 * <p>
 * Note - You are NOT given the root of the tree. Return NULL if in-order successor doesn't exist.
 * <p>
 * <p>
 * <p>
 * Input
 *      5
 *   2     12
 * 4   3  9   21
 *          19  25
 * <p>
 * Above Tree (without Root Address)
 * Pointer to Target Node(12)
 * Output
 * <p>
 * 19
 * Hint : You can use the parent pointer to traverse up in the tree.
 * For example - Inorder Successor of 3 is going to be 5.
 */
public class SpecialBST {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.parent = root;
        root.left = new Node(2);
        root.left.parent = root;
        root.right = new Node(12);
        root.right.parent = root;
        root.left.left = new Node(4);
        root.left.left.parent = root.left;
        root.left.right = new Node(3);
        root.left.right.parent = root.left;
        root.right.left = new Node(9);
        root.right.left.parent = root.right;
        root.right.right = new Node(21);
        root.right.right.parent = root.right;
        root.right.right.left = new Node(19);
        root.right.right.left.parent = root.right.right;
        root.right.right.right = new Node(25);
        root.right.right.right.parent = root.right.right;

       levelOrderTraversal(root);

       Node target = root.right.right.right;
       Node successor = inorderSuccessor(target);
       System.out.println("Successor of "+target.data+ " is " + successor.data);

    }

    private static class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }


    private static Node inorderSuccessor(Node target){

        //case1
        if (target.right != null) {
            Node temp = target.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        Node targetParent = target.parent;
        Node temp = target;
        while (targetParent != null && targetParent.right==temp) {
            temp = targetParent;
            targetParent = targetParent.parent;
        }

        return targetParent;
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
