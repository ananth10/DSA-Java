package com.example.myapplication.datastructures.graphs

import java.util.*
import kotlin.collections.ArrayList


/**
 *  GRAPHS - Graphs are most used data structure in computer science
 *  Graph is a set of values that related in pair wise fashion, in a graph each item called Node/Vertex and nodes are connected with edges
 *  TYPES OF GRAPHS
 *  -> Directed
 *  -> UnDirected
 *
 *  -> Weighted
 *  -> UnWeighted
 *
 *  ->Cyclic
 *  ->ACyclic
 *
 *  Graph built on top of  other data structure
 *
 *  3 ways to represent graph
 *
 *  1. Edge List
 *
 *  const graph = [[0,2],[2,3],[2,1],[1,3]]
 *
 *  2. Adjacent list
 *
 *  const graph = [[2],[2,3],[0,1,3],[1,2]]
 *
 *  3. Adjacent matrix
 *
 *
 * PROS:
 * ->
 *
 *
 * CONS:
 * ->
 * */

fun main(){

    val graphs = Graphs()
    graphs.addVertex(5)
    graphs.addVertex(54)
    graphs.addVertex(44)
    graphs.addEdge(5,54)
    graphs.addEdge(5,44)
    graphs.showConnection()
}

class Graphs {
    var numberOfNodes:Int = 0
    var adjacentList: Hashtable<Int, ArrayList<Int>> = Hashtable()

    fun addVertex(node:Int){
        adjacentList[node] = arrayListOf()
        numberOfNodes++
    }

    fun addEdge(node1:Int, node2:Int){
        adjacentList[node1]?.add(node2)
        adjacentList[node2]?.add(node1)
    }

    fun showConnection(){
        val keys: Array<Any> = adjacentList.keys.toTypedArray()
        for (key in keys) {
            println(key.toString() + " ---> " + adjacentList[key.toString().toInt()])
        }
    }
}