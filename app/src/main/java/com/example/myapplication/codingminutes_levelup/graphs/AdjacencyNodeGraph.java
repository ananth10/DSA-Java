package com.example.myapplication.codingminutes_levelup.graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyNodeGraph {


    public static void main(String[] args){
        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("London");
        cities.add("Paris");
        cities.add("New York");

        AdjacencyNodeGraph g = new AdjacencyNodeGraph(cities);
        g.addEdge("Delhi","London",false);
        g.addEdge("New York","London",false);
        g.addEdge("Delhi","Paris",false);
        g.addEdge("Paris","New York",false);

        g.printNodes();
    }

    private class Node{
        String name;
        List<String> nbrs = new ArrayList<>();

        public Node(String name){
            this.name = name;
        }
    }

    Map<String,Node> map = new HashMap<>();

    public AdjacencyNodeGraph(List<String> cities){
        for(String city:cities){
            map.put(city,new Node(city));
        }
    }

    void addEdge(String x, String y, Boolean undirected){
        map.get(x).nbrs.add(y);
        if(undirected){
            map.get(y).nbrs.add(x);
        }
    }

    void printNodes(){
        for (Map.Entry<String,Node> map : map.entrySet()){
            System.out.print(map.getKey()+"-->");
            for (int i = 0; i < map.getValue().nbrs.size(); i++) {
                System.out.print(map.getValue().nbrs.get(i)+", ");
            }
            System.out.println();
        }
    }
}
