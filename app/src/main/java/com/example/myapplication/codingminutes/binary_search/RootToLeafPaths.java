package com.example.myapplication.codingminutes.binary_search;

import static com.example.myapplication.codingminutes.binary_search.BuildBST.insert;

import com.example.myapplication.codingminutes.binary_tree.BinaryNode;
import com.example.myapplication.codingminutes.binary_tree.BinaryNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
    static List<List<Integer>> allPaths = new ArrayList<>();

    public static void main(String[] args) {
        BinaryNode root = createTree();

        BuildBST.printInOrder(root);
        ArrayList<Integer> pathList = new ArrayList<>();
        rootToLeafPaths(root, pathList);
        System.out.println("ALL PATHS:" + allPaths);
    }

    static void rootToLeafPaths(BinaryNode root, List<Integer> paths) {
        //base case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(root.data);
            allPaths.add(new ArrayList<>(paths));
            paths.remove(paths.size() - 1);
            return;
        }

        //recursive case
        paths.add(root.data);
        rootToLeafPaths(root.left, paths);
        rootToLeafPaths(root.right, paths);
        //backtracking
        paths.remove(paths.size() - 1);
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(1);
        BinaryNode two = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode four = new BinaryNode(4);
        BinaryNode five = new BinaryNode(5);
        BinaryNode six = new BinaryNode(6);
        BinaryNode seven = new BinaryNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        five.left = seven;
        three.right = six;

        return one;
    }
}
