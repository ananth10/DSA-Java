package com.example.myapplication.datastructures.array.codingminutes.graph;

import com.example.myapplication.datastructures.graphs.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList02 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("London");
        cities.add("Paris");
        cities.add( "New York");

        Graph g = new Graph(cities);
        g.addEdge("Delhi", "London" , true);
        g.addEdge("New York","London", true);
        g.addEdge("Delhi","Paris" , true);
        g.addEdge("Paris","New York" , true);

        g.printAll();

    }

    static class GraphNode {
        String name;
        List<String> neighbors;

        public GraphNode(String name) {
            this.name = name;
            neighbors = new ArrayList<>();
        }
    }

    static class Graph {
        HashMap<String, GraphNode> map;

        public Graph(List<String> cities) {
            map = new HashMap<>();
            for (String city : cities) {
                map.put(city, new GraphNode(city));
            }
        }

        public void addEdge(String src, String tar, boolean undirected) {
            map.get(src).neighbors.add(tar);
            if (undirected) {
                map.get(tar).neighbors.add(src);
            }
        }

        public void printAll() {
            for (Map.Entry<String, GraphNode> pair : map.entrySet()) {
                String city = pair.getKey();
                System.out.print(city + "-->");
                for (String nbrs : pair.getValue().neighbors) {
                    System.out.print(nbrs + ", ");
                }
                System.out.println();
            }
        }
    }
}
