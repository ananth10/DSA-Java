package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

public class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
