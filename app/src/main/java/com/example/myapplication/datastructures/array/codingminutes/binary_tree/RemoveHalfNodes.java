package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class RemoveHalfNodes {

    public static void main(String[] args) {
        BinaryNode root = createTree();
        BinaryNode result = removeHalfNodes(root);
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(result,inOrderList);
        System.out.println(inOrderList);
    }

    static BinaryNode removeHalfNodes(BinaryNode root) {
      //base case
       if(root==null){
           return null;
       }

       //recursive case
       if(root.left!=null){
           root.left = removeHalfNodes(root.left);
       }
       if(root.right!=null){
           root.right = removeHalfNodes(root.right);
       }

       if((root.left!=null && root.right==null) || (root.left==null && root.right!=null)){
           if(root.left!=null){
               root = root.left;
           }
           if(root.right!=null){
               root = root.right;
           }
           root = removeHalfNodes(root);
       }
       return root;
    }

    static void inOrder(BinaryNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(2);
        BinaryNode two = new BinaryNode(7);
        BinaryNode three = new BinaryNode(5);
        BinaryNode four = new BinaryNode(6);
        BinaryNode five = new BinaryNode(1);
        BinaryNode six = new BinaryNode(11);
        BinaryNode seven = new BinaryNode(9);
        BinaryNode eight = new BinaryNode(4);

        one.left = two;
        one.right = three;
        two.right = four;
        four.left = five;
        four.right = six;
        three.right = seven;
        seven.left = eight;

        return one;
    }
}
