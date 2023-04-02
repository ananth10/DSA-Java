package com.example.myapplication.datastructures

fun main() {
    createLinkedList()
}

/** WHAT IS LINKED LIST
 * Its a list that linked, it linked with next node and first node is called HEAD and last node is called TAIL
 * Every node has 2 things one is data and second this pointer and pointer is pointing to the next node in the list
 * In singly linked list the TAIL node always point to NULL
 *
 * PREPEND - O(1)
 * APPEND  - O(1)
 * LOOKUP  - O(n)
 * INSERT  - O(n)
 * DELETE  - O(n)
 * */

/**
 * WHAT IS A POINTER
 *
 * It is reference to another place like address or object or another node
 *
 * */


class MyLinkedList() {

    private var head: Node? = null
    private var tail: Node? = head
    var length = 1


    fun append(value: Int) {
        var newNode = Node(value)
        tail?.next = newNode
        this.tail = newNode
        length++
    }

    fun prepend(value: Int) {
        var startNode = Node(value)
        startNode.next = this.head
        head = startNode
        length++
    }

    fun printList(): IntArray {
        var list = IntArray(length)
        var currentNode: Node? = head
        var i = 0
        while (currentNode != null) {
            list[i] = currentNode.value
            currentNode = currentNode.next
            i++
        }
        return list
    }

    fun insert(index: Int, value: Int) {
        if (index >= length) {
            append(value)
        } else {
            var newNode = Node(value);
            var leaderNode = traverseThroughIndex(index - 1)
            var holdingPointer = leaderNode?.next;
            leaderNode?.next = newNode
            newNode.next = holdingPointer
        }
        this.length++
    }

    private fun traverseThroughIndex(index: Int): Node? {
        var counter = 0
        var currentNode = this.head
        while (counter != index) {
            currentNode = currentNode?.next
            counter++
        }
        return currentNode
    }

    fun remove(index: Int) {
        if (index <= this.length) {
            var leaderNode = traverseThroughIndex(index - 1)
            var itemToRemove = leaderNode?.next
            leaderNode?.next = itemToRemove?.next
            this.length--
        }
    }

    fun reverse(): Node? {
        if (this.head?.next == null) {
            return this.head
        }
        // e.g list = [1,10,16,88,90]
        var first = this.head //1
        this.tail = this.head
        var second = first?.next//10

        while (second != null) {
            var temp = second.next //16//88//10
            second.next =
                first // second pointing to 1 now // 2nd iteration pointing to 10 //3rd second->16
            first = second //first element is 10 //2nd time first element is 16 //3rd first->88
            second =
                temp  //second element is 16  , so in the first iteration list is [10,16,1,88,90] // 2nd time second is 88 so [16,88,10] //3rd second->10 [88,10,16,1,90]
        }

        this.head?.next = null
        this.head = first

        return null
    }
}

class Node(value: Int) {
    var next: Node? = null
    var value = value
}

private fun createLinkedList() {

    val myLinkedList = MyLinkedList()
    myLinkedList.append(4)
    myLinkedList.append(5)
    println("append length:${myLinkedList.length}")
    myLinkedList.prepend(10)
//    myLinkedList.insert(200,99)
    println("prepend length:${myLinkedList.length}")
    println("list:${myLinkedList}")

}

