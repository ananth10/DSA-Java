package com.example.myapplication.codingminutes.binary_tree;

import java.util.Scanner;

public class HeightOfTree {

    public static void main(String[] args) {
     BinaryNode root = BuildBinaryTree.buildTree();
     int height = heightOfTree(root);
        System.out.println(height);
    }

    static int heightOfTree(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        int h1 = heightOfTree(node.left);
        int h2 = heightOfTree(node.right);

        return 1 + Math.max(h1, h2);
    }
}
