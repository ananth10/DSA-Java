package com.example.myapplication.datastructures.linkedlist

data class Node(var data1:Int) {
    var data:Int=0
    var prevNode:Node?=null
    var nextNode:Node?=null

    init {
       this.data = data1
    }
}