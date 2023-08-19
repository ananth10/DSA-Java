package com.example.myapplication.codingminutes_levelup.binary_tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Vertical Order Print
 * -------------------
 * Given a binary Tree, we need to print it vertically, refer the example
 * <p>
 * INPUT: 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * \  \
 * 8  9
 * <p>
 * <p>
 * OUTPUT:
 * 4
 * 2
 * 1, 5, 6
 * 3, 8
 * 7
 * 9
 */
public class VerticalOrderPrint {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        verticalOrderPrint(root);
    }

    public static void treeTraversal(Node root, int distance, Map<Integer, List<Integer>> map) {
        //base case
        if (root == null) {
            return;
        }
        //recursive case
        if (map.get(distance) != null) {
            map.get(distance).add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(distance, list);
        }
        treeTraversal(root.left, distance - 1, map);
        treeTraversal(root.right, distance + 1, map);
    }

    public static void verticalOrderPrint(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int distance = 0;
        treeTraversal(root, distance, map);

        //print vertical order
        for (Map.Entry<Integer, List<Integer>> maps : map.entrySet()) {
            List<Integer> list = maps.getValue();
//            System.out.print(key + "---->");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.println();
        }
    }
}
