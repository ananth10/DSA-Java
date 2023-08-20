package com.example.myapplication.codingminutes_levelup.binary_tree;

/**
 * SiblingsSwap
 * -----------
 * Determine if a binary tree can be converted to another by doing any number of swaps of children!
 * For example, consider the following examples.
 * Input:
 * 2 binary tree
 * <p>
 * OUTPUT:
 * true
 * The tree on the left can be converted into tree on the right by swapping siblings.
 */
public class SiblingsSwap {
    public static void main(String[] args) {
        Node root1 = new Node(6);
        root1.left = new Node(3);
        root1.right = new Node(8);
        root1.left.left = new Node(1);
        root1.left.right = new Node(7);
        root1.right.left = new Node(4);
        root1.right.left.left = new Node(7);
        root1.right.left.right = new Node(1);
        root1.right.right = new Node(2);
        root1.right.right.right = new Node(3);

        LevelOrderTraversal.levelOrderTraversal(root1);
        System.out.println("*****************************");
        Node root2 = new Node(6);
        root2.left = new Node(8);
        root2.right = new Node(3);
        root2.left.left = new Node(2);
        root2.left.right = new Node(4);
        root2.left.left.left = new Node(3);
        root2.left.right.left = new Node(1);
        root2.left.right.right = new Node(7);
        root2.right.left = new Node(7);
        root2.right.right = new Node(1);
        LevelOrderTraversal.levelOrderTraversal(root2);

        System.out.println("Result:" + isEqual(root1, root2));
    }

    static boolean isEqual(Node root1, Node root2) {
        //base case
        if (root1 == root2) {
            return true;
        }
        //recursive case
        return (root1 != null && root2 != null) && (root1.data == root2.data) && (isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right) || isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left));

    }
}
