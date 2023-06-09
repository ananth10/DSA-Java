package com.example.myapplication.codingminutes.binary_tree;

public class BinaryNode {
    public int data;
    public BinaryNode left;
    public BinaryNode right;

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
