package com.example.myapplication.datastructures.array.codingminutes

fun main(){
    val array = intArrayOf(1,2,3,4,5)
    printAllPairs(array)
}

fun printAllPairs(array: IntArray){
    for(i in array.indices){
        for(j in i+1 until array.size){
            println("${array[i]},${array[j]}")
        }
        println()
    }
}