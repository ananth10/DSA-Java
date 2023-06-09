package com.example.myapplication.codingminutes.graph;

import java.util.ArrayList;

public class AdjacencyList01 {

    public static void main(String[] args){
       Graph graph = new Graph(6);
       graph.addEdges(0,1,true);
       graph.addEdges(0,4,true);
       graph.addEdges(2,1,true);
       graph.addEdges(3,4,true);
       graph.addEdges(4,5,true);
       graph.addEdges(2,3,true);
       graph.addEdges(3,5,true);
       graph.printAdjList();
    }

    static class Graph{
        int V;
        ArrayList<ArrayList<Integer>> list;

        public Graph(int v){
            this.V = v;
            list = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                list.add(new ArrayList<>());
            }
        }

        void addEdges(int i, int j, boolean undirected) {
            list.get(i).add(j);
            if (undirected) {
                list.get(j).add(i);
            }
        }

        void printAdjList(){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i+"-->");
                for (int j = 0; j < list.get(i).size(); j++) {
                    System.out.print(list.get(i).get(j)+", ");
                }
                System.out.println();
            }
        }
    }

}
