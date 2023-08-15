package com.example.myapplication.codingminutes_levelup.binary_tree;

/**
 * Diameter of Tree
 * ----------------
 * <p>
 * Find the diameter of the binary tree, diameter is defined as the largest distance
 * between any two nodes of the tree.
 * <p>
 * Input: 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
 * 1
 * / \
 * 2    3
 * / \     \
 * 4   5      6
 * /
 * 7
 */
public class DiameterOfTree {
    public static void main(String[] args) {
        Node root = LevelOrderBuilder.levelOrderBuild();
        int diameter = findDiameter(root);
        System.out.println("Diameter is : " + diameter);
        System.out.println("optimized Diameter is : " + diameter(root).diameter);
    }

    private static int findDiameter(Node root) {
        //base case
        if (root == null) {
            return 0;
        }

        //recursive case
        int D1 = height(root.left) + height(root.right);
        int D2 = findDiameter(root.left);
        int D3 = findDiameter(root.right);

        return Math.max(D1, Math.max(D2, D3));
    }

    static int height(Node root) {
        //base case
        if (root == null) {
            return 0;
        }

        //recursive case
        int H1 = height(root.left);
        int H2 = height(root.right);

        return 1 + Math.max(H1, H2);
    }

    //optimized solution
    private static class Pair {
        int height;
        int diameter;

        public void setHeight(int height) {
            this.height = height;
        }

        public void setDiameter(int diameter) {
            this.diameter = diameter;
        }
    }

    static Pair diameter(Node root) {
        Pair pair = new Pair();
        //base case
        if (root == null) {
            pair.setHeight(0);
            pair.setDiameter(0);
            return pair;
        }
        //recursive case
        Pair left = diameter(root.left);
        Pair right = diameter(root.right);
        pair.setHeight(1 + Math.max(left.height, right.height));

        int D1 = left.height + right.height;
        int D2 = left.diameter;
        int D3 = right.diameter;

        pair.setDiameter(Math.max(D1, Math.max(D2, D3)));
        return pair;
    }
}
