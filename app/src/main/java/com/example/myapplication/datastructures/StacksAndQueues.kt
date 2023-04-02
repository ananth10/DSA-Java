package com.example.myapplication.datastructures

import com.google.gson.Gson

fun main(){
//    doStackOperations()
//    doStackOperation1()
    doQueueOperation()
}

/**
 * STACK
 * - Stack is a data structure which can be accessed like LAST IN FIRST OUT(LIFO)
 * - e.g stack of plates and each plates stacked on top of another plate and we can only access top of plate
 * - Lookup -> O(n)
 * - Pop -> O(1)
 * - Push -> O(1)
 * - Peek -> O(1)
 *
 * - It can be implemented using Array and LinkedList
 * */

/**
 * QUEUES
 * -Queue is data structure which can be accessed like FIRST IN FIRST OUT(FIFO)
 * - e.g uber, lyft and printer like first one will get a priority
 * - Lookup -> O(n)
 * - Enqueue -> O(1)
 * - Dequeue -> O(1)
 * - Peek -> O(1)
 *
 * - It can be implemented using Array and LinkedList
 *       Stack             Vs             Queue
 *  -Pop - it takes out last person          Dequeue - it takes ou first person
 * */

class Node3(value: Int){
    var next: Node3? =null
    var value = value
}

class Stack(var top :Node3?=null, var bottom:Node3?=null, var length:Int=0){

    fun peek():Node3?{
      return top;
    }

    fun push(value:Int){
        var newNode = Node3(value)
        if(this.length==0){
            this.top = newNode
            this.bottom = newNode
        }else{
            var holdingPointer1 = this.top
            this.top = newNode
            this.top?.next = holdingPointer1
        }
        this.length++
    }

    fun pop(){
        if(this.top!=null){
            if(this.top==this.bottom){
                this.bottom=null
            }
            var holdingPointer = this.top
            this.top = holdingPointer?.next
            this.length--
        }
    }


}

fun doStackOperations(){
    var stack = Stack()
    stack.peek()
    stack.push(10)
    stack.push(12)
    stack.pop()
    stack.pop()
    println(Gson().toJson(stack))
}

class StackImplementationUsingArray(){
    private var array = arrayOfNulls<Int>(10)
    fun peek(): Int? {
        if(array.isNotEmpty()) {
            return array[array.size - 1]
        }
        return null
    }

    fun push(value:Int){
        if(array.isEmpty()){
            array[0] = value
        }else{
            array[array.size-1] = value
        }
    }
}

fun doStackOperation1(){

    var stackImplementationUsingArray = StackImplementationUsingArray()
    stackImplementationUsingArray.peek()
    stackImplementationUsingArray.push(9)
    println(Gson().toJson(stackImplementationUsingArray))
}


class Queue(var first:Node3?=null,var last:Node3?=null,var length:Int=0){


    fun peek():Node3?{
      return first
    }

    fun enqueue(value: Int){  var newNode = Node3(value)
        if(length==0){
            this.first = newNode
            this.last = newNode
        }else{
            this.last?.next = newNode
            this.last = newNode
        }
        this.length++
    }

    fun dequeue(){

        if(this.first!=null){
            if(this.first==this.last){
                this.last==null
            }
            this.first = this.first?.next
            this.length--
        }
    }
}

fun doQueueOperation(){
    var queue = Queue()
    queue.enqueue(10)
    queue.enqueue(20)
    queue.peek()
    queue.dequeue()
    println(Gson().toJson(queue))
}