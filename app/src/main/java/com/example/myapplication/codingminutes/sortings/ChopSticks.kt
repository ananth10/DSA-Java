package com.example.myapplication.codingminutes.sortings

import kotlin.text.Typography.times

fun main(){
    val array = intArrayOf(1,3,3,9,4)
    val diff = 2
    val result = chopSticks(array,diff)
    println("RESULT:$result")
}

fun chopSticks(array: IntArray,diff:Int):Int{
    val sortedArray = array.sortedArray()
    var count = 0
    for (i in 0 until sortedArray.size-1){
        if(sortedArray[i+1]-sortedArray[i]<=diff && sortedArray[i+1]-sortedArray[i]!=0){
            println("${sortedArray[i]},${sortedArray[i+1]}")
            count++
        }
    }
    return count
}