package com.example.myapplication.datastructures.array.codingminutes.binary_tree;

import android.util.Pair;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthLevel {

    public static void main(String[] args) {
        BinaryNode root = BuildBinaryTree.buildTree();
        System.out.println(new Gson().toJson(root));
        int k = 1;
        List<Integer> levels = printKthLevel(root, k);
        System.out.println(levels);
    }

    static ArrayList<Integer> printKthLevel(BinaryNode root, int k) {
        int level = 0;
        int flag = 0;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> list = new ArrayList<>();


        while (!queue.isEmpty()) {
            //calculate number of nodes in the current level
            int size = queue.size();
            while (size > 0) {
                size--;
                BinaryNode temp = queue.poll();

                if (k == level) {
                    flag = 1;
                    list.add(temp.data);
                } else {
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }


            level++;
            if (flag == 1) {
                break;
            }
        }
        return list;
    }
}
