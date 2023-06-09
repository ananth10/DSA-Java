package com.example.myapplication.codingminutes.array

fun main(){
    val array = arrayOf(1,2,3,4,5)
    val result = reverseArray(array)
    println("RESULT::${result.joinToString(",")}")
}

fun reverseArray(array: Array<Int>): IntArray {
     var start = 0
     var end = array.size-1
    var reversedArrayList = array.toMutableList()
    while (start<end){
        reversedArrayList[start] = array[end]
        reversedArrayList[end] = array[start]
        start+=1
        end-=1
    }
    return reversedArrayList.toIntArray()
}
