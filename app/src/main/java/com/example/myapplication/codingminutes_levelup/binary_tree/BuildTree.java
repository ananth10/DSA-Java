package com.example.myapplication.codingminutes_levelup.binary_tree;

import java.util.Scanner;

public class BuildTree {

    public static Scanner scanner = new Scanner(System.in);

    static Node buildTree() {
        int data = scanner.nextInt();
        if (data == -1) {
            return null;
        }
        Node node = new Node(data);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }
}
