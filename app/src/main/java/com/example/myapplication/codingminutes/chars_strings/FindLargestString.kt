package com.example.myapplication.codingminutes.chars_strings


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