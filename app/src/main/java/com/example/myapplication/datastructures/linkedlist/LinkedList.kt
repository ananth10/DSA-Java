package com.example.myapplication.datastructures.linkedlist

import com.google.gson.Gson


/**
 * 1. Add - front
 * 2. Add -end
 * 3. Add - middle
 * 4. Delete - front
 * 5. Delete - end
 * 6. Delete - middle
 * 7. print elements
 * */
class LinkedList {
    var startNode: Node? = null
    var endNode: Node? = null
    var count: Int = 0

    fun printLinkedListItems() {
        if (startNode == null) {
            return
        }
        var currentNode = startNode
        println("${currentNode?.data}")
        while (currentNode?.nextNode != null) {
            currentNode = currentNode.nextNode
            println("${currentNode?.data}")
        }
        return
    }

    fun addFront(data: Int) {
        val newNode = Node(data)
        if (startNode == null) {
            startNode = newNode
            endNode = newNode
            count++
        } else {
            startNode?.prevNode = newNode
            newNode.nextNode = startNode
            newNode.prevNode = null
            startNode = newNode
            count++
        }
    }

    fun addEnd(data: Int) {
        val newNode = Node(data)
        if (startNode == null) {
            startNode = newNode
            endNode = newNode
            count++
        } else {
            endNode?.nextNode = newNode
            newNode.prevNode = endNode
            newNode.nextNode = null
            endNode = newNode
            count++
        }
    }

    fun addAfterGivenNode(data: Int, givenNodeData: Int) {
        var givenNodeCheck = searchNodeByData(givenNodeData)
        if (givenNodeCheck != null) {
            val newNode = Node(data)
            if (givenNodeCheck == endNode) {
                addEnd(data)
                return
            }
            val temp = givenNodeCheck.nextNode
            givenNodeCheck.nextNode = newNode
            newNode.nextNode = temp
            newNode.prevNode = givenNodeCheck
            count++
        }
        return
    }

    private fun searchNodeByData(data: Int): Node? {
        if (startNode == null) {
            return null
        }
        var currentNode = startNode
        while (currentNode?.nextNode != null || currentNode == endNode) {
            if (currentNode?.data == data) {
                return currentNode
            }
            currentNode = currentNode?.nextNode
        }
        return null
    }

    fun deleteFront(): Node? {
        if (startNode == null) {
            return null
        }
        val tempNode = startNode?.nextNode
        val deletedNode = startNode
        tempNode?.prevNode = null
        startNode = tempNode
        count--
        return deletedNode
    }

    fun deleteEnd(): Node? {
        if (startNode == null) {
            return null
        }
        val endNodePrevNode = endNode?.prevNode
        val deletedNode = endNode
        endNodePrevNode?.nextNode = null
        endNode = endNodePrevNode
        count--
        return deletedNode
    }

    fun deleteNodeBySearch(data:Int){
        val isGivenNodeAvailable = searchNodeByData(data) ?: return
        if(startNode==isGivenNodeAvailable){
            deleteFront()
            return
        }
        if(endNode==isGivenNodeAvailable){
            deleteEnd()
            return
        }
        val previousNode = isGivenNodeAvailable.prevNode
        val nextNode = isGivenNodeAvailable.nextNode
        previousNode?.nextNode = nextNode
        nextNode?.prevNode =  previousNode
    }

    fun getSize() = count
}