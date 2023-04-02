package com.example.myapplication.datastructures.stack


fun main() {
    val stack = Stack(2)
    stack.add(1)
    stack.add(10)
    println(stack.array.joinToString(","))
    val removed = stack.remove()
    println(removed)
    println(stack.array.joinToString(","))
}

class Stack(arrayLength: Int) {
    var top = -1
    val array = arrayOfNulls<Int>(arrayLength).toMutableList()
    var length = arrayLength

    fun add(value: Int): String {
        if (top >= length - 1) {
            return "Not able to add $value to the stack"
        }
        top++
        array[top] = value
        return array.joinToString(",")
    }

    fun remove():Int{
        if(top==-1){
            return -1
        }
        var removedItem = array[top]
        array.removeAt(top)
        top--
        return removedItem?:0
    }
}