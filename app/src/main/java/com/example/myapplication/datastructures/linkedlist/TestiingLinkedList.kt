package com.example.myapplication.datastructures.linkedlist

fun main(){
    val linkedList = LinkedList()
    linkedList.addFront(3)
    linkedList.addFront(2)
    linkedList.addFront(1)
    linkedList.addAfterGivenNode(4,3)
    linkedList.addAfterGivenNode(5,4)
//    linkedList.addAfterGivenNode(7,6)
//    linkedList.addAfterGivenNode(4,3)
//    linkedList.addAfterGivenNode(2,1)
    println("Size::${linkedList.getSize()}")
    linkedList.printLinkedListItems()
    linkedList.deleteNodeBySearch(4)
    println("Size::${linkedList.getSize()}")
    linkedList.printLinkedListItems()

}