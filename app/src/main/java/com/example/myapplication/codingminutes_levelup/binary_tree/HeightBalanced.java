package com.example.myapplication.codingminutes_levelup.binary_tree;



/**
 * Height Balanced
 * ---------------
 * Given a binary tree, check if it is height balanced.
 * <p>
 * A non-binary tree T is balanced if
 * ->Left subtree of T is balanced
 * ->Right subtree of T is balanced
 * and The difference between height of left subtree and right subtree is not more than 1.
 * <p>
 * INPUT:  1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 * /
 * 7
 * <p>
 * OUTPUT: True
 */
public class HeightBalanced {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
//        root.left.right.right = new Node(8);
//        root.left.right.right.left = new Node(9);
        LevelOrderTraversal.levelOrderTraversal(root);
        Pair pair = isHeightBalancedTree(root);
        System.out.println("Is balanced tree:" + pair.isBalanced);
    }

    private static Pair isHeightBalancedTree(Node root) {
        Pair pair = new Pair();
        //base case
        if (root == null) {
            pair.setHeight(0);
            pair.setBalanced(true);
            return pair;
        }
        //recursive case
        Pair left = isHeightBalancedTree(root.left);
        Pair right = isHeightBalancedTree(root.right);
        pair.setHeight(1 + (Math.max(left.height, right.height)));
        int diff = Math.abs(left.height - right.height);
        pair.setBalanced(diff <= 1 && (left.isBalanced && right.isBalanced));
        return pair;
    }

    static private class Pair {
        int height;
        boolean isBalanced = false;

        public void setHeight(int height) {
            this.height = height;
        }

        public void setBalanced(boolean balanced) {
            isBalanced = balanced;
        }
    }
}
