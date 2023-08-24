package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import com.example.myapplication.codingminutes_levelup.binary_tree.LevelOrderTraversal;
import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

/**
 * Shortest Tree Path
 * -------------------
 * Given a Binary Search Tree and values of two nodes that lie inside the tree, find the Shortest Path Length between the two nodes.
 * 10
 * 4    15
 * 2   5 13  22
 * 1        14
 * <p>
 * INPUT:
 * Root node, 2,13
 * <p>
 * OUTPUT:
 * 4
 */
public class ShortestTreePath {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.left.left = new Node(1);
        root.right.left = new Node(13);
        root.right.right = new Node(22);
        root.right.left.right = new Node(14);

        LevelOrderTraversal.levelOrderTraversal(root);
        int a = 2;
        int b = 13;
        int level = shortestTreePath(root, a, b);
        System.out.println("ShortestPath:" + level);
    }

    static Node lowestCommonAncestor(Node root, int a, int b) {
        //base case
        if (root == null) {
            return null;
        }

        if (root.data == a || root.data == b) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    static int shortestTreePath(Node root, int a, int b) {
        Node lca = lowestCommonAncestor(root, a, b);

        int l1 = search(lca, a, 0);
        int l2 = search(lca, b, 0);
        System.out.println("L1:" + l1);
        System.out.println("L2:" + l2);
        return l1 + l2;
    }

    static int search(Node root, int key, int level) {
        //base case
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return level;
        }
        int leftLevel = search(root.left, key, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }
        return search(root.right, key, level + 1);
    }
}
