package com.example.myapplication.datastructures.array.codingminutes.chars_strings

import com.example.myapplication.max

fun main(){
    val array = arrayOf("hi","bye","hello","ananthababu","welcome","cool")
    val result = findLargestString(array)
    println(result)
}

private fun findLargestString(array: Array<String>):String{
    var largestString=""

    for(i in array.indices){
        var current = array[i].length
        val large = largestString.length
        if(current>large){
            largestString = array[i]
        }
    }
    return largestString
}