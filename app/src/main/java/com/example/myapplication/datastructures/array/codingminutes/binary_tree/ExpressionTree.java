package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

public class ExpressionTree {

    public static void main(String[] args) {
        StringNode root = createTree();
        int result = evalTree(root);
        System.out.println("Eval Tree: " + result);
    }

    static int evalTree(StringNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        if (!isOperationSymbol(root.data)) {
            return Integer.parseInt(root.data);
        }

        if (root.data.equals("+")) {
            return evalTree(root.left) + evalTree(root.right);
        }

        if (root.data.equals("-")) {
            return evalTree(root.left) - evalTree(root.right);
        }

        if (root.data.equals("*")) {
            return evalTree(root.left) * evalTree(root.right);
        }

        if (root.data.equals("/")) {
            return evalTree(root.left) * evalTree(root.right);
        }
        return 0;
    }

    static boolean isOperationSymbol(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
    }

    static StringNode createTree() {
        StringNode one = new StringNode("+");
        StringNode two = new StringNode("3");
        StringNode three = new StringNode("*");
        StringNode four = new StringNode("+");
        StringNode five = new StringNode("5");
        StringNode six = new StringNode("9");
        StringNode seven = new StringNode("2");

        one.left = two;
        one.right = three;
        three.left = four;
        three.right = seven;
        four.left = five;
        four.right = six;

        return one;
    }

    static class StringNode {
        String data;
        StringNode left;
        StringNode right;

        public StringNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
