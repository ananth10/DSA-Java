package com.example.myapplication.datastructures.array.codingminutes.binary_search;

import com.example.myapplication.datastructures.array.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.datastructures.array.codingminutes.binary_tree.BuildBinaryTree;


public class MirrorBST {
    public static void main(String[] args){
        BinaryNode root = createTree();
        BuildBinaryTree.printLevelOrder(root);
        BinaryNode mirrored = mirrorTree(root);
        BuildBinaryTree.printLevelOrder(mirrored);
    }

    static BinaryNode mirrorTree(BinaryNode root){
        //base case
        if(root==null){
            return null;
        }
        BinaryNode temp;
        mirrorTree(root.left);
        mirrorTree(root.right);

        temp = root.left;
        root.left = root.right;
        root.right = temp;

        System.out.println("LEFT:"+root.left+"RIGHT:"+root.right);

        return root;
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(1);
        BinaryNode two = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode four = new BinaryNode(4);
        BinaryNode five = new BinaryNode(5);
        BinaryNode six = new BinaryNode(6);
        BinaryNode seven = new BinaryNode(7);

        one.left = three;
        one.right = two;
        two.left = five;
        two.right = four;

        return one;
    }
}
