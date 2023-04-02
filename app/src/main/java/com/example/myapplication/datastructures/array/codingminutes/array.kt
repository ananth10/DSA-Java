package com.example.myapplication.datastructures.array.codingminutes

fun main(){
    val array = arrayOfNulls<Int>(100)
    array[0]=1

    println("ARRAY::${array.joinToString(",")}")

    printArray(array)
}

fun printArray(array:Array<Int?>){
    println("PRINT ARRAY::${array.joinToString(",")}")
}