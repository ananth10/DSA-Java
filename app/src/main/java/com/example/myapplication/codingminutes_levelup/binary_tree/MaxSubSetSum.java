package com.example.myapplication.codingminutes_levelup.binary_tree;


/**
 * Max Sub Set Sum
 * --------------
 * <p>
 * Fina the largest sum of a subset of nodes in a binary tree, such that if a node is included in the sum then
 * its parent and children must not be included in the subset sum
 * <p>
 * INPUT: 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 *    /
 *   7
 * <p>
 * OUTPUT:
 * 18
 */
public class MaxSubSetSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        LevelOrderTraversal.levelOrderTraversal(root);
        Pair maxSum = findMaxSum(root);
        System.out.println("Max sum:"+ Math.max(maxSum.include, maxSum.exclude));
    }

    private static Pair findMaxSum(Node root) {
        Pair pair = new Pair();
        //base case
        if (root == null) {
            pair.include = 0;
            pair.exclude = 0;
            return pair;
        }

        //recursive case
        Pair left = findMaxSum(root.left);
        Pair right = findMaxSum(root.right);

        pair.include = root.data + left.exclude + right.exclude;
        pair.exclude = Math.max(left.include, left.exclude)+ Math.max(right.include, right.exclude);

        return pair;
    }

    private static class Pair {
        int include;
        int exclude;
    }
}
