package com.example.myapplication.datastructures

import android.util.Log
import java.util.*

fun main(){
    createDoublyLinkedList()
}

/** WHAT IS DOUBLY LINKED LIST
 * Its a list that linked, it linked with next and previous nodes. first node is called HEAD and last node is called TAIL
 * Every node has 3 things, one is data and second is next node pointer and third node is previous node pointer in the list.
 * In doubly liked list the TAIL node always point to NULL
 * PREPEND - O(1)
 * APPEND  - O(1)
 * LOOKUP  - O(n)
 * INSERT  - O(n)
 * DELETE  - O(n)
 *
 *     Singly                    Vs                      Doubly
 *
 *     1. Simple to implement                            1. fairly complex to implement
 *     2. Less memory needed because no extra node       2. More memory needed to hold previous node
 *     3. Efficient and Faster                           3. Less efficient
 *     4. it travers from front to back                  4. it travers from front to back and back to front
 *
 * */

//Downside of doubly linked list is need to hold extra memory.

class MyDoublyLinkedList(value:Int){
    private var head: Node1?=null
    private var prev: Node1?=null
    private var tail: Node1?=head
    var length = 1;

    fun append(value: Int){
        var newNode = Node1(value)
        newNode.prev = this.tail
        tail?.next = newNode
        length++

    }

    fun prepend(value: Int){
        var newNode = Node1(value)
        newNode.next = this.head
        this.head?.prev = newNode
        head = newNode
        length++
    }

    fun insert(index:Int,value: Int){
        if(index>=length){
            append(value)
        }else{
            var newNode = Node1(value)
            var leaderNode = traverseThroughIndex(index-1)
            var followerNode = leaderNode?.next
            newNode.prev = leaderNode
            newNode.next = followerNode
            followerNode?.prev = newNode
        }
        length++
    }

    private fun remove(index: Int){
        if(index<=this.length){
            var leaderNode = traverseThroughIndex(index-1)
            var itemToRemove = leaderNode?.next
            leaderNode?.next = itemToRemove?.next
            itemToRemove?.next?.prev = leaderNode
            this.length++
        }
    }

   private fun traverseThroughIndex(index: Int):Node1?{
        var count =0
        var currentNode1 = this.head
        while (count!=index){
            currentNode1 = currentNode1?.next
            count++
        }
        return currentNode1
    }

    fun printList():IntArray{
        var list = IntArray(length)
        var currentNode:Node1? = head
        var i=0
        while (currentNode!=null){
            list[i] = currentNode.value
            currentNode = currentNode.next
            i++
        }
        return  list
    }
}

class Node1(value:Int){
    var next: Node1? =null
    var prev: Node1?=null
    var value = value
}

private fun createDoublyLinkedList(){
    val doublyLinkedList = MyDoublyLinkedList(4)
    doublyLinkedList.append(5)
    doublyLinkedList.append(2)
    doublyLinkedList.prepend(3)
    doublyLinkedList.prepend(1)
    println("List: ${doublyLinkedList.printList().contentToString()}")
}