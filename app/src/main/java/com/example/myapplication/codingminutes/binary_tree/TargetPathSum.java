package com.example.myapplication.codingminutes.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class TargetPathSum {
    static List<List<Integer>> result = new ArrayList<>();
    static List<List<Integer>> result1 = new ArrayList<>();

    public static void main(String[] args) {
        BinaryNode root = createTree();
        int targetSum = 22;
        ArrayList<Integer> pathList = new ArrayList<>();
        targetPathSum(root, targetSum, 0, pathList);
        System.out.println("Target Paths:" + result);
        pathList.clear();
        findPathSum(root, pathList, targetSum);
        System.out.println("Target Paths:" + result1);

    }

    static void targetPathSum(BinaryNode root, int targetSum, int currentSum, List<Integer> pathList) {
        //base case
        if (root == null) {
            return;
        }

        //recursive case
        //we reached the leaf node, so time to check targetSum with current sum :)
        if (root.left == null && root.right == null) {
            if (targetSum == currentSum + root.data) {
                //add node value to path list
                pathList.add(root.data);
                //add founded path to result list
                result.add(new ArrayList<>(pathList));
                //remove from the path list
                pathList.remove(pathList.size() - 1);
            }
        }

        if (root.left != null) {
            pathList.add(root.data);
            targetPathSum(root.left, targetSum, currentSum + root.data, pathList);
            pathList.remove(pathList.size() - 1);
        }

        if (root.right != null) {
            pathList.add(root.data);
            targetPathSum(root.right, targetSum, currentSum + root.data, pathList);
            pathList.remove(pathList.size() - 1);
        }
    }


    //another but simple approach

    static void findPathSum(BinaryNode root, List<Integer> path, int remainingSum) {
        //base case
        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null && remainingSum == root.data) {
            result1.add(new ArrayList<>(path));
        }
        findPathSum(root.left, path, remainingSum - root.data);
        findPathSum(root.right, path, remainingSum - root.data);
        path.remove(path.size() - 1);
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(5);
        BinaryNode two = new BinaryNode(4);
        BinaryNode three = new BinaryNode(8);
        BinaryNode four = new BinaryNode(11);
        BinaryNode five = new BinaryNode(13);
        BinaryNode six = new BinaryNode(4);
        BinaryNode seven = new BinaryNode(7);
        BinaryNode eight = new BinaryNode(2);
        BinaryNode nine = new BinaryNode(5);
        BinaryNode ten = new BinaryNode(1);

        one.left = two;
        one.right = three;
        two.left = four;
        four.left = seven;
        four.right = eight;
        three.left = five;
        three.right = six;
        six.left = nine;
        six.right = ten;


        return one;
    }
}
