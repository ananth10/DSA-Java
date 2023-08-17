package com.example.myapplication.codingminutes_levelup.binary_tree;

import static com.example.myapplication.codingminutes_levelup.binary_tree.DiameterOfTree.height;

/**
 * Height Of Tree
 * --------------
 * <p>
 * Given a root node and find the height of tree
 * <p>
 * INPUT:  1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 * /
 * 7
 */
public class HeightOfTree {

    public static void main(String[] args) {
        Node root = LevelOrderBuilder.levelOrderBuild();
        int height = heightOfTree(root);
        System.out.println("Height:" + height);
    }

    private static int heightOfTree(Node root) {
        //base case
        if (root == null) {
            return 0;
        }
        //recursive case
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
