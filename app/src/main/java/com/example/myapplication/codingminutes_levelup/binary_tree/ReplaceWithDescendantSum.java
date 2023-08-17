package com.example.myapplication.codingminutes_levelup.binary_tree;

/**
 * Replace with Sum
 * -----------------
 *Given a binary tree replace every node by sum of all its descendants, leave leaf nodes intact
 *
 * INPUT:  1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 *    /
 *   7
 * OUTPUT:
 * 28
 * / \
 * 16    6
 * / \     \
 *4   7      6
 *    /
 *   7
 * */
public class ReplaceWithDescendantSum {
    public static void main(String[] args){
        Node root = LevelOrderBuilder.levelOrderBuild();
        replaceWithDescendant(root);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    private static int replaceWithDescendant(Node root) {
        //base case
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.data;
        }
        //recursive case
        int currentRootData = root.data;
        int leftSum = replaceWithDescendant(root.left);
        int rightSum = replaceWithDescendant(root.right);
        root.data = leftSum+rightSum;
        return root.data+currentRootData;
    }
}
