package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public static void main(String[] args) {
        BinaryNode root = createTree();
        int result = minDepth(root);
        System.out.println("min depth of tree is :" + result);
    }

    static int minDepth(BinaryNode root) {
        int res = Integer.MAX_VALUE;
        int d = 1;
        Queue<NodePair> queue = new LinkedList<>();
        queue.add(new NodePair(root, d));

        while (!queue.isEmpty()) {
            NodePair pair = queue.poll();
            if (pair != null) {
                d = 1 + pair.distance;
                if (pair.node.left == null && pair.node.right == null) {
                    res = Math.min(res, pair.distance);
                }
                if (pair.node.left != null) {
                    queue.add(new NodePair(pair.node.left, d));
                }
                if (pair.node.right != null) {
                    queue.add(new NodePair(pair.node.right, d));
                }
            }

        }

        return res;
    }

    static class NodePair {
        BinaryNode node;
        int distance;

        public NodePair(BinaryNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static BinaryNode createTree() {
        BinaryNode one = new BinaryNode(2);
        BinaryNode two = new BinaryNode(7);
        BinaryNode three = new BinaryNode(5);
        BinaryNode four = new BinaryNode(9);
        BinaryNode five = new BinaryNode(11);
        BinaryNode six = new BinaryNode(4);
        BinaryNode seven = new BinaryNode(1);

        one.left = two;
        one.right = three;
        two.right = four;
        four.left = five;
        four.right = six;
        three.right = seven;

        return one;
    }
}
