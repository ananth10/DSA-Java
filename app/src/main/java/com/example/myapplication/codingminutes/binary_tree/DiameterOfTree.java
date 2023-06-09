package com.example.myapplication.codingminutes.binary_tree;

public class DiameterOfTree {

    public static void main(String[] args) {
        BinaryNode root = BuildBinaryTree.buildTree();
        int diameter = diameter(root);
        System.out.println("diameter:" + diameter);
        NodePair pair = treeDiameter(root);
        System.out.println("diameter1:" + pair.getDiameter());
    }

    static int diameter(BinaryNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        //recursive case
        int d1 = treeHeight(root.left) + treeHeight(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    static int treeHeight(BinaryNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        int h1 = treeHeight(root.left);
        int h2 = treeHeight(root.right);

        return 1 + Math.max(h1, h2);
    }

    //optimised approach - O(n)

    static NodePair treeDiameter(BinaryNode root) {
        NodePair nodePair = new NodePair(0, 0);
        if (root == null) {
            nodePair.setHeight(0);
            nodePair.setDiameter(0);
            return nodePair;
        }
        NodePair leftPair = treeDiameter(root.left);
        NodePair rightPair = treeDiameter(root.right);


        nodePair.setHeight(Math.max(leftPair.getHeight(), rightPair.getHeight()) + 1);

        int d1 = leftPair.getHeight() + rightPair.getHeight();
        int d2 = leftPair.getDiameter();
        int d3 = rightPair.getDiameter();
        nodePair.setDiameter(Math.max(d1, Math.max(d2, d3)));
        return nodePair;
    }
}
