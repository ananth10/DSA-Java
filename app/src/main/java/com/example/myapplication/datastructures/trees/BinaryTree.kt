package com.example.myapplication.datastructures.trees

import com.google.gson.Gson
import java.lang.reflect.GenericArrayType


/**
 * BINARY TREE
 * - Each node will one have either zero or one or two nodes and each child only have one parent
 * - Each node represent certain states
 * -     Perfect Binary Tree                                    Vs                      Full Binary Tree
 *
 * - Everything filled in like all node are full
 * - sum of last level node equals to sum of all other nodes + 1
 * */

/**
 * BINARY SEARCH TREE
 * -Binary search tree is great for comparing things
 * - Level 0: 2^0 = 1 this is root or parent node
 * - Level 1: 2^1 = 2 this is first child node from parent
 * - Level 2: 2^2 = 4
 * - Level 3: 2^3 = 8
 *
 * Number of nodes = 2^h - 1 (height of tree, which mean levels)
 * log Nodes = height
 *
 * log 100 = 2 because 2^10 = 100
 *
 * Lookup O(log N)
 * Insert O(log N)
 * Delete O(log N)
 *
 * O(log N) is efficient than O(N)
 *
 *  - BINARY SEARCH RULES
 *  First - The right node of the parent node value must be increasing and The left side of parent node value must be decreasing
 *  Second - The Node will have up to 2 children nodes because this is binary tree
 *  - The advantage of binary search tree is lookup is very easy and efficient and need not iterate in linear fashion
 *
 *  -                    BALANCED     AND       UNBALANCED
 *
 *  - Lookup O(log n)                           - Lookup O(n)
 *  - Insert O(log n)                           - Insert O(n)
 *  - Delete O(log n)                           - Delete O(n)
 *
 *  HOW TO BALANCE A TREE???
 *  -> AVL AND RED TREE
 *
 *  PROS
 *  -> Better than O(n) because in average case the Big O is O(logn)
 *  -> Its Ordered element
 *  -> Flexible size
 *  CONS
 *  ->No O(1) operation
 * */

fun main(){
    doBinarySearchTreeOperation()
}

class Node(value:Int){
    var left : Node? = null
    var right:Node? =null
    var value = value
}

class BinarySearchTree(var rootNode:Node?=null){

    fun lookup(value: Int): Node? {
        if (this.rootNode == null) {
            return null
        }
        var currentNode = this.rootNode
        while (currentNode != null) {
            when {
                value < currentNode.value -> {
                    currentNode = currentNode.left
                }
                value > currentNode.value -> {
                    currentNode = currentNode.right
                }
                currentNode.value == value -> {
                    return currentNode
                }
            }
        }
        return null
    }

    fun insert(value:Int){
      var newNode = Node(value)
        if (this.rootNode==null){
            this.rootNode = newNode
        }else{
            var currentNode = this.rootNode
            while (true){
                if (currentNode != null) {
                    if(value<currentNode.value){
                        //left node
                      if(currentNode.left==null){
                          currentNode.left = newNode
                          return
                      }
                        currentNode = currentNode.left
                    }else{
                        //right node
                        if(currentNode.right==null){
                            currentNode.right = newNode
                            return
                        }
                        currentNode = currentNode.right
                    }
                }
            }
        }
    }

    fun remove(value:Int) : Node?{
      if(this.rootNode==null){
          return null
      }
      var currentNode = this.rootNode
      var parentNode:Node? = null
      while (currentNode!=null){
          when {
              value<currentNode.value -> {
                  parentNode = currentNode
                  currentNode = currentNode.left
              }
              value>currentNode.value -> {
                  parentNode = currentNode
                  currentNode = currentNode.right
              }
              currentNode.value==value -> {
                //we have match, so get to work"

                  //option 1 - No right child
                  if(currentNode.right==null){
                      if(parentNode==null){
                          this.rootNode = currentNode.left
                      }else{
                          //if parent> current value, make current left child a child of parent
                          if(currentNode.value<parentNode.value){
                              parentNode.left = currentNode.left
                          }else if(currentNode.value>parentNode.value){
                              parentNode.right = currentNode.left
                          }
                      }
                  }
                  //option 2 - Right child does not have a left child
                  else if(currentNode.right?.left==null){
                    if(parentNode==null){
                        this.rootNode = currentNode.left
                    }else{

                        currentNode.right?.left = currentNode.left

                        // if parent > current
                    }

                  }//option 3 - Right child that has a left child
                  else{

                  }
              }
          }
      }
        return null
    }

   fun breadthFirstSearch() : List<Int> {
       var currentNode = this.rootNode
       var list = mutableListOf<Int>()
       var queue = mutableListOf<Node>()
       currentNode?.let { queue.add(it) }

       while (queue.size > 0) {
           currentNode = queue.removeAt(0)
           list.add(currentNode.value)
           if (currentNode.left != null) {
              queue.add(currentNode.left!!)
           }
           if (currentNode.right != null) {
               queue.add(currentNode.right!!)
           }
       }
       return list
   }

   fun breadthFirstSearchR(queue1:List<Node>, list1:List<Int>) : List<Int>{
       var queue = mutableListOf<Node>()
       var list = mutableListOf<Int>()
       list.addAll(list1)
       queue.addAll(queue1)
       if(queue.isEmpty()){
           return list
       }

       var currentNode = queue.removeAt(0)
       list.add(currentNode.value)
       if (currentNode.left != null) {
           queue.add(currentNode.left!!)
       }
       if (currentNode.right != null) {
           queue.add(currentNode.right!!)
       }
    return breadthFirstSearchR(queue,list)
   }

    fun DFSInOrder() : List<Int>{
       return TraverseInOrder(this.rootNode, mutableListOf())
    }

    fun DFSPreOrder() : List<Int>{
        return TraversePreOrder(this.rootNode, mutableListOf())
    }

    fun DFSPostOrder() : List<Int>{
        return TraversePostOrder(this.rootNode, mutableListOf())
    }
    fun depthFirstSearch(){

    }

    fun TraverseInOrder(node:Node?,list: MutableList<Int>) : List<Int>{
        print("${node?.value}, ")
        if(node?.left!=null){
              TraverseInOrder(node.left!!,list)
        }
        node?.let { it?.value?.let { it1 -> list.add(it1) } }
       if(node?.right!=null){
            TraverseInOrder(node.right!!,list)
       }
        return list
    }

    fun TraversePreOrder(node:Node?,list: MutableList<Int>) : List<Int>{
        print("${node?.value}, ")
        if (node != null) {
            list.add(node.value)
        }
        if(node?.left!=null){
            TraversePreOrder(node.left!!,list)
        }
        if(node?.right!=null){
            TraversePreOrder(node.right!!,list)
        }
        return list
    }

    fun TraversePostOrder(node:Node?,list: MutableList<Int>) : List<Int>{
        print("${node?.value}, ")
        if(node?.left!=null){
             TraversePostOrder(node.left!!,list)
        }
        if(node?.right!=null){
             TraversePostOrder(node.right!!,list)
        }
        if (node != null) {
            list.add(node.value)
        }
        return list
    }
}

fun doBinarySearchTreeOperation(){

    var bts = BinarySearchTree(null)
    bts.insert(9)
    bts.insert(4)
    bts.insert(20)
    bts.insert(1)
    bts.insert(6)
    bts.insert(15)
    bts.insert(170)
    println(Gson().toJson(bts))
//    bts.breadthFirstSearch()
//    bts.breadthFirstSearchR(listOf(Node(0)), listOf())
    var list = bts.DFSInOrder()
    var list1 = bts.DFSPreOrder()
    var list2 = bts.DFSPostOrder()
    print("DFS InOrder: $list")
    print("DFS PreOrder: $list1")
    print("DFS PostOrder: $list2")
}