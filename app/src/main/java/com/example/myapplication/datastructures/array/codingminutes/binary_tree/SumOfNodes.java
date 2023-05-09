package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodes {
    public static void main(String[] args) {
        BinaryNode root = BuildBinaryTree.buildTree();
        int sumOfNodes = sumOfNodes(root);
        System.out.println("Sum: " + sumOfNodes);
        // 2 7 -1 9 11 -1 -1 4 -1 -1 5 -1 1 -1 -1
    }

    static int sumOfNodes(BinaryNode root) {
        int result = 0;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode temp = queue.poll();
            assert temp != null;
            result += temp.data;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return result;
    }
}
