package com.example.myapplication.datastructures.array.codingminutes.graph;

import java.util.Arrays;
import java.util.List;

public class FindStar {
    public static void main(String[] args) {
        List<List<Integer>> graphs = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(4, 2)
        );

        //1 2
        //2 3
        //4 2
        int starNode = findStarNode(graphs);
        System.out.println("STAR NODE::"+starNode);
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    static int findStarNode(List<List<Integer>> graphs) {
        Pair p1 = new Pair(graphs.get(0).get(0), graphs.get(0).get(1));
        Pair p2 = new Pair(graphs.get(1).get(0), graphs.get(1).get(1));

        System.out.println("P1:" + p1);
        System.out.println("P2:" + p2);

        if (p1.first == p2.first) {
            return p1.first;
        } else if (p1.first == p2.second) {
            return p1.first;
        } else if (p1.second == p2.first) {
            return p1.second;
        } else {
            return p1.second;
        }
    }
}
