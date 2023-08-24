package com.example.myapplication.codingminutes_levelup.binary_search_tree;

import com.example.myapplication.codingminutes_levelup.binary_tree.Node;

/**
 * Lowest Common Ancestor(LCA)
 * ---------------------------
 * Given a Binary Search Tree and values of two nodes that lie inside the tree, find the Lowest Common Ancestor (LCA).
 * <p>
 * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
 * <p>
 * You may assume that both the values exist in the tree and are unique.
 * <p>
 * 5
 * 2   12
 * -4 3 9  21
 * 19  25
 * <p>
 * INPUT:
 * Node 9 and Node 25
 * OUTPUT:
 * 12
 * <p>
 * LCA ofr 9 and 25 is 12
 * <p>
 * e.g
 * LCA for 3 and 9 is 5
 * LCA for 9 and 12 is 12
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(-4);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);

        Node lca = lowestCommonAncestor(root,9,25);
        System.out.println("Result:"+lca.data);
    }

    static Node lowestCommonAncestor(Node root, int a, int b) {
        //base case
        if (root == null) {
            return null;
        }
        //recursive case
        if (root.data == a || root.data == b) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);

        if (left != null && right != null) { //when left and right nodes are not null which means both nodes comes under a single parent
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
